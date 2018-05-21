package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mvc.dao.FileDao;
import mvc.dto.Board;
import mvc.dto.Comment;
import mvc.dto.UploadFile;
import mvc.service.BoardService;
import mvc.util.Paging;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	@Autowired ServletContext context;
	
	@RequestMapping(value="/board/list.do", method=RequestMethod.GET)
	public String list(
			@RequestParam(defaultValue="0") int curPage
			, Paging search
			, Model model) {
		
//		int totalCount = boardService.getTotal();	//전체 게시글 수
		int totalCount = boardService.getTotal(search);	//검색어 적용 게시글 수

		// 페이징 생성
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search.getSearch()); // 검색어 추가
		model.addAttribute("paging", paging);

//		List list = boardService.getPagingList(paging); // 전체 게시글 조회
		List list = boardService.getSearchPagingList(paging); // 검색어 적용 게시글 조회

		model.addAttribute("list", list);

		return "board/list";
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public void write() { }

	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String writeProcess(Board board,	HttpSession session, MultipartFile file) {
		// 고유 식별자
		String uID = UUID.randomUUID().toString().split("-")[0];
		
		// 파일이 저장될 경로
		String realpath = context.getRealPath("upload");
		
		// 파일이 저장될 이름
		String stored = file.getOriginalFilename() + "_" + uID;
		
//						1. File dest = new File("경로+파일");
//						2. File dest = new File("경로", "파일");
		File dest = new File(realpath, stored);
//						System.out.println(dest);
		
		// 실제 파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// DB에 기록
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginal_filename(file.getOriginalFilename());
		uploadFile.setStored_filename(stored);
		uploadFile.setFile_size(file.getSize());
		
		// 작성자 아이디 추가
		board.setWriterid((String)session.getAttribute("writerid"));
		
		boardService.write(board, uploadFile);
		
		return "redirect:/board/list.do";
	}

	@RequestMapping(value="/board/view.do", method=RequestMethod.GET)
	public String view( Board viewBoard, Model model, HttpSession session) {
		
		// 게시글 번호가 1보다 작으면 목록으로 보내기
		if(viewBoard.getBoardno() < 1) {
			return "redirect:/board/list.do";
		}
		
		// 게시글 상세 정보 전달
		viewBoard = boardService.boardView(viewBoard);
		model.addAttribute("view", viewBoard);

		// [추천기능] 게시글번호와, 로그인아이디 담기 
		Board check = new Board();
		check.setBoardno(viewBoard.getBoardno());
		check.setWriterid((String)session.getAttribute("writerid"));
		
		// [추천기능] 추천상태 정보 전달
		model.addAttribute("recommend", boardService.recommendCheck(check));
		
		// 댓글 정보
		List commentList = boardService.getCommentList(viewBoard);
		model.addAttribute("commentList", commentList);
		
		return "board/view";
	}
	
	@RequestMapping(value="/board/boardError.do", method=RequestMethod.GET)
	public void view() { }

	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public String update(Board board, HttpSession session, Model model) {
		
		board = boardService.boardView(board);
		
		model.addAttribute("view", board);
		return "board/update";
	}

	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String updateProcess(Board board) {
		boardService.update(board);
		
		return "redirect:/board/view.do?boardno="+board.getBoardno();
	}

	@RequestMapping(value="/board/delete.do", method=RequestMethod.GET)
	public String deleteProcess(Board board, Model model) {
		boardService.delete(board);
		
		model.addAttribute("msg", "게시글 삭제 완료");
		model.addAttribute("url", "/board/list.do");
		
		return "util/alert";
	}
	
	@RequestMapping(value="/board/recommend.do", method=RequestMethod.GET)
	public void boardRecommend(Board board,	Writer writer, HttpSession session) {
		
		// 추천 여부 판단
		boolean result = boardService.recommend(board);
		
		// 추천수
		int recommend = boardService.getRecommend(board);
		
		try {
			writer.write("{\"result\":"+result+", \"recommend\":"+recommend+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/board/insertComment.do", method=RequestMethod.POST)
	public String insertComment(Comment comment) {

		boardService.insertComment(comment);
		
		return "redirect:/board/view.do?boardno="+comment.getBoardNo();
	}
	
	@RequestMapping(value="/board/deleteComment.do"
			, method=RequestMethod.POST)
	public void deleteComment(Comment comment, Writer out) {
		
		boolean success = boardService.deleteComment(comment);
		
		try {
			// ajax: http request 1번, response 1번 반드시 수행되어야 한다.
			// 댓글 삭제가 성공하면 success는 true로 반환
			out.append("{\"success\":"+success+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/board/deleteList.do", method=RequestMethod.POST)
	public String deleteList(String names) {
		
		if( !"".equals(names) && names != null) {
			boardService.boardListDelete(names);
		}
		
		return "redirect:/board/list.do";
	}
	
}
















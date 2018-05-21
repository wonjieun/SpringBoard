package mvc.service;

import java.util.List;

import mvc.dto.Board;
import mvc.dto.Comment;
import mvc.dto.UploadFile;
import mvc.util.Paging;

public interface BoardService {

	/**
	 * 게시글 전체 조회
	 *  
	 * @return List - 게시글 전제 조회 결과
	 */
	public List getList();
	
	/**
	 * 게시글 전체 수 조회
	 * 
	 * @return int - 게시글 총 갯수
	 */
	public int getTotal();

	/**
	 * 검색어 적용 게시글 수 조회
	 * 
	 * @param String - 검색어
	 * @return int - 게시글 총 갯수
	 */
	public int getTotal(Paging search);

	/**
	 * 선택된 페이지에 알맞는 게시글 리스트 조회
	 *  
	 * @param paging - 페이징 정보
	 * @return List - 페이징 처리된 게시글 리스트
	 */
	public List getPagingList(Paging paging);

	/**
	 * 검색결과에 페이징 처리한 게시글 목록
	 * 
	 * @param paging - 페이징,검색어 정보
	 * @return List - 검색되고 페이징처리 된 게시글
	 */
	public List getSearchPagingList(Paging search);

	/**
	 * 글작성
	 * 
	 * @param board - 사용자가 입력한 게시글 내용
	 */
	public void write(Board board, UploadFile uploadFile);

//	public void insertFile(UploadFile uploadFile);
	
	/**
	 * 게시글 상세보기
	 * 
	 * @param viewBoard - 조회될 게시글의 boardno
	 * @return Board - 조회된 게시글
	 */
	public Board boardView(Board viewBoard);

	/**
	 * 게시글 수정하기
	 * 
	 * @param board - 수정할 정보
	 */
	public void update(Board board);

	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호 
	 */
	public void delete(Board board);
	
	/**
	 * 게시글 추천상태 확인
	 * 
	 * @param chk - 추천인과 게시글번호
	 * @return 추천상태
	 * 	true - 추천한 게시글
	 * 	false - 추천한적 없는 게시글
	 */
	public boolean recommendCheck(Board chk);
	
	/**
	 * 추천 로직
	 * 
	 * @param board
	 * @return
	 */
	public boolean recommend(Board board);
	
	/**
	 * 추천수 구하기
	 * 
	 * @param board
	 * @return
	 */
	public int getRecommend(Board board);
	
	/**
	 * 댓글 입력
	 * 
	 * @param comment
	 */
	public void insertComment(Comment comment);
	
	/**
	 * 댓글 리스트
	 * 
	 * @param board - 게시글에 대한 정보
	 * @return
	 */
	public List getCommentList(Board board);

	/**
	 * 댓글 삭제
	 * 
	 * @param comment - 삭제할 댓글 정보
	 * @return
	 */
	public boolean deleteComment(Comment comment);
	
	/**
	 * 리스트에서 게시글 삭제하기
	 * 
	 * @param names - 삭제할 글번호가 담긴 문자열
	 */
	public void boardListDelete(String names);
	
}

















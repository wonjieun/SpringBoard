package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.BoardDao;
import mvc.dao.CommentDao;
import mvc.dao.RecommendDao;
import mvc.dto.Board;
import mvc.dto.Comment;
import mvc.dto.UploadFile;
import mvc.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;
	@Autowired RecommendDao recommendDao;
	@Autowired CommentDao commentDao;
	
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	@Override
	public int getTotal() {
		return boardDao.countAll();
	}

	@Override
	public int getTotal(Paging search) {
		return boardDao.countSearch(search);
	}

	@Override
	public List getPagingList(Paging paging) {
		return boardDao.selectPage(paging);
	}

	@Override
	public List getSearchPagingList(Paging search) {
		return boardDao.selectPageSearch(search);
	}
	
	@Override
	public void write(Board board, UploadFile uploadFile) {
		boardDao.write(board);
		uploadFile.setBoardno(board.getBoardno());
		if(!uploadFile.getStored_filename().equals(null))
			boardDao.insertFile(uploadFile);
	}
	
//	@Override
//	public void insertFile(UploadFile uploadFile) {
//		boardDao.insertFile(uploadFile);
//	}

	@Override
	public Board boardView(Board viewBoard) {
		
		boardDao.updateHit(viewBoard);
		
		return boardDao.selectBoardByBoardNo(viewBoard);
	}

	@Override
	public void update(Board board) {
		boardDao.update(board);
	}

	@Override
	public void delete(Board board) {
		boardDao.delete(board);
	}

	@Override
	public boolean recommendCheck(Board board) {
		
		if( recommendDao.selectCountRecommend(board) > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override	
	public boolean recommend(Board board) {
		if( recommendCheck(board) ) {
			recommendDao.deleteRecommend(board);
			return false;
		} else {
			recommendDao.insertRecommend(board);
			return true;
		}
	}
	
	@Override
	public int getRecommend(Board board) {
		return recommendDao.selectTotalRecommend(board);
	}

	@Override
	public void insertComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public List getCommentList(Board board) {
		return commentDao.selectComment(board);
	}

	@Override
	public boolean deleteComment(Comment comment) {
		commentDao.deleteComment(comment); 
		
		if( commentDao.countComment(comment) > 0 ) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void boardListDelete(String names) {
		boardDao.deleteBoardList(names);
	}
}














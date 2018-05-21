package mvc.dao;

import java.util.List;

import mvc.dto.Board;
import mvc.dto.Comment;

public interface CommentDao {

	/**
	 * 코멘트 SELECT
	 *  코멘트 번호를 rnum을 통해 같이 조회한다
	 *  
	 * @param board
	 * @return
	 */
	public List selectComment(Board board);
	
	/**
	 * 코멘트 INSERT
	 *  
	 * @param comment
	 */
	public void insertComment(Comment comment);

	/**
	 * 댓글 삭제하기
	 *  
	 * @param comment
	 */
	public void deleteComment(Comment comment);

	// 댓글 카운트 - 댓글 존재 여부 확인 
	public int countComment(Comment comment);
}




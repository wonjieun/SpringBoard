package mvc.dao;

import mvc.dto.Board;

public interface RecommendDao {
	/**
	 * 작성자가 추천한 글번호인지 조회
	 * 
	 * @param board
	 * @return
	 */
	public int selectCountRecommend(Board board);
	
	/**
	 * 추천 삽입
	 * 
	 * @param board
	 */
	public void insertRecommend(Board board);
	
	/**
	 * 추천 삭제
	 * 
	 * @param board
	 */
	public void deleteRecommend(Board board);
	
	/**
	 * 총 추천 수 구하기
	 * 
	 * @param board
	 * @return
	 */
	public int selectTotalRecommend(Board board);
}













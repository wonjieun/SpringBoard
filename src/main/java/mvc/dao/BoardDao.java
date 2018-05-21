package mvc.dao;

import java.util.List;

import mvc.dto.Board;
import mvc.dto.UploadFile;
import mvc.util.Paging;

public interface BoardDao {
	
	/**
	 * 게시글 전체 조회
	 * 
	 * @return List - 게시글 전제 조회 결과
	 */
	public List selectAll();
	
	/**
	 * 게시글 전체 수
	 * 
	 * @return int - 총 게시글 수
	 */
	public int countAll();

	/**
	 * 페이지 게시글 조회
	 * 
	 * @param paging - 페이징 정보
	 * @return List - 페이지 게시글 리스트
	 */
	public List selectPage(Paging paging);

	/**
	 * 검색어 적용한 게시글 수
	 * 
	 * @param search - 검색어
	 * @return int - 검색된 게시글 수
	 */
	public int countSearch(Paging search);
	
	/**
	 * 검색어 적용한 게시글 목록 조회
	 * 
	 * @param search - 검색어
	 * @return List - 검색되어 페이징처리된 게시글
	 */
	public List selectPageSearch(Paging search);

	/**
	 * 게시글 입력
	 *  
	 * @param board - 사용자 게시글
	 */
	public void write(Board board);

	/**
	 * 조회수 증가
	 * 
	 * @param viewBoard - 조회될 게시글의 boardno
	 */
	public void updateHit(Board viewBoard);
	
	/**
	 * 게시글 상세 조회
	 * 
	 * @param viewBoard - 조회될 boardno
	 * @return Board - 조회된 게시글 정보
	 */
	public Board selectBoardByBoardNo(Board viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param board - 수정할 정보를 가진 board
	 */
	public void update(Board board);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호
	 */
	public void delete(Board board);

	/**
	 * 리스트에서 게시글 삭제하기
	 * 
	 * @param names
	 */
	public void deleteBoardList(String names);
	
	public void insertFile(UploadFile uploadFile);
}


















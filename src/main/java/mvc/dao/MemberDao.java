package mvc.dao;

import mvc.dto.Writer;

public interface MemberDao {
	/**
	 * 회원가입
	 * @param writer
	 */
	public void join(Writer writer);
	
	/**
	 * userid로 조회하기
	 * @return
	 */
	public int selectByUserid(Writer writer);
	
	/**
	 * 로그인
	 * @param writer
	 * @return
	 */
	public int login(Writer writer);
	
	/**
	 * 님네임 가져오기
	 * @param writer
	 * @return
	 */
	public String getUsernick(Writer writer);
}













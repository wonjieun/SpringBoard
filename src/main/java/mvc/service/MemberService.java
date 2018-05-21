package mvc.service;

import mvc.dto.Writer;

public interface MemberService {

	
	/**
	 * 회원가입
	 * @param writer
	 */
	public boolean join(Writer writer);

	/**
	 * 로그인
	 * @param writer
	 * @return
	 */
	public boolean login(Writer writer);

	/**
	 * 닉네임 가져오기
	 * @param writer
	 * @return
	 */
	public String getUsernick(Writer writer);

}















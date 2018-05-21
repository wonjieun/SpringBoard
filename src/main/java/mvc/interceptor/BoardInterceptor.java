package mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor
extends HandlerInterceptorAdapter {

	private static final Logger logger
	= LoggerFactory.getLogger(BoardInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("+ + + INTERCEPTOR START + + +");
		logger.info(" Request URI : "
				+ request.getRequestURI());

		HttpSession session = request.getSession();
		if( session.getAttribute("login") == null ) {
			logger.info(" >> 접속불가 : 로그인되지 않음");

			response.sendRedirect("/board/boardError.do");

			return false;	// 컨트롤러 접근 금지
		} 

		return true;	// 컨트롤러 접근 허용
	}
}








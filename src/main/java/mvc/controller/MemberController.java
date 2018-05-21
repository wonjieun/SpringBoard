package mvc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.dto.Writer;
import mvc.service.MemberService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/member/main.do"
			, method=RequestMethod.GET)
	public void main() { }
	
	@RequestMapping(value="/member/join.do"
			, method=RequestMethod.GET)
	public void join() { }

	@RequestMapping(value="/member/join.do"
			, method=RequestMethod.POST)
	public String joinProcess(Writer writer, Model model) {
		boolean joinResult = memberService.join(writer);
		
		if(joinResult) {
			logger.info("회원가입 성공");
			model.addAttribute("msg", "회원가입 성공");
			model.addAttribute("url", "/member/main.do");
		} else {
			logger.info("회원가입 실패");
			model.addAttribute("msg", "회원가입 실패");
			model.addAttribute("url", "/member/join.do");
		}
		return "util/alert";
	}

	@RequestMapping(value="/member/login.do"
			, method=RequestMethod.GET)
	public void login() { }

	@RequestMapping(value="/member/login.do"
			, method=RequestMethod.POST)
	public String loginProcess(
			Writer writer,
			HttpSession session,
			Model model) {
		
		boolean loginResult = memberService.login(writer);
		
		if(loginResult) {
			logger.info("로그인 성공");
			model.addAttribute("msg", "로그인 성공");
			model.addAttribute("url", "/member/main.do");
			
			session.setAttribute("login", true);
			session.setAttribute("writerid", writer.getUserid());
			session.setAttribute("writernick", memberService.getUsernick(writer));
			
			logger.info("세션상태 : " + session.getAttribute("login"));
			logger.info("세션 아이디 : " + session.getAttribute("writerid"));
			logger.info("세션 닉네임 : " + session.getAttribute("writernick"));
			
		} else {
			logger.info("로그인실패");
			model.addAttribute("msg", "로그인 실패");
			model.addAttribute("url", "/member/login.do");
		}
		
		return "util/alert";
	}

	@RequestMapping(value="/member/logout.do"
			, method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/member/main.do";
	}
}











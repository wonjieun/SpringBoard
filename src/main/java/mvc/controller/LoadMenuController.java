package mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.UserVo;

@Controller
public class LoadMenuController {

	private static final Logger logger = LoggerFactory.getLogger(LoadMenuController.class);

	@RequestMapping(value="/loadMenu/main.do",
			method=RequestMethod.GET)
	public void login() { }

	@RequestMapping(value="/loadMenu/details.do",
			method=RequestMethod.GET)
	public void detailPage() { }

	@RequestMapping(value="/loadMenu/mgrMember.do",
			method=RequestMethod.GET)
	public void mgrMemberPage() { }

	@RequestMapping(value="/loadMenu/mgrProduct.do",
			method=RequestMethod.GET)
	public void mgrProductPage() { }

}

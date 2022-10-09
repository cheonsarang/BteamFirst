package com.hanul.bteam;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocialstarController {

	//소개페이지 화면 요청
	@RequestMapping("/list.yu")
	public String login(HttpSession session) {
		session.setAttribute("category", "list");
		//응답화면연결:로그인화면
		return "socialstar/list";
	}
	
}

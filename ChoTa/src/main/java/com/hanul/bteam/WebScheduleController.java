package com.hanul.bteam;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebScheduleController {

	@RequestMapping("/list.sc")
	public String list(Model model, HttpSession session) {
		session.setAttribute("category", "sc");
		
		
		return "schedule/list";
	}
}

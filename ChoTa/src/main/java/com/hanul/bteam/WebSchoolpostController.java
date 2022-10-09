package com.hanul.bteam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSchoolpostController {
	
	//목록화면 요청
	@RequestMapping("/list.sp")
	public String list() {
		return "school/list";
	}
}

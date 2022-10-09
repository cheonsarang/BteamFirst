package com.hanul.bteam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	//웹 채팅
	@RequestMapping("/chat")
	public String chat() {
		return "chat";
	}
}

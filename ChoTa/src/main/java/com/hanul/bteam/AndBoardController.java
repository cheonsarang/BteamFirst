package com.hanul.bteam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import board.BoardDAO;
import board.BoardVO;



@RestController
public class AndBoardController {
	@Autowired BoardDAO dao;
	Gson gson = new Gson();
	
	@RequestMapping(value = "/list.no", produces = "text/html;charset=utf-8")
	public String notice() {
		List<BoardVO> list = dao.board_list();
		System.out.println(list.size());
		
		
		return new Gson().toJson(list);
	}
	
	
}

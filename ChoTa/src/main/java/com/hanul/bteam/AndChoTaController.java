package com.hanul.bteam;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import chotamember.MemberDAO;
import chotamember.MemberVO;



@RestController
public class AndChoTaController {
	@Autowired MemberDAO dao;
	Gson gson = new Gson();
	
	@RequestMapping(value = "/list", produces = "text/html;charset=utf-8")
	public String chota_list(HttpServletRequest req) {
		List<MemberVO> list = dao.chota_list();
		System.out.println(list.size());
		return gson.toJson(list); 
	}
	
	//소셜로그인 가입할때 변동할 것임
	@RequestMapping(value = "/andlogin", produces = "text/html;charset=utf-8")
	public String login(String email, String pw, String social) {		
		MemberVO vo = new MemberVO();
		System.out.println(social);
		if(email == null) {
			return gson.toJson(null);
		}
		// 로직 자체에서 자바코드에서 프로그램흐름을 제어함.↓
		// #{param, jdbcType=VARCHAR}

		vo.setUserid(email);
		vo.setUserpw(pw);
		
		//vo = dao.login(vo, social);
		
		return gson.toJson(vo);
	}
	
	@RequestMapping(value = "/join", produces = "text/html;charset=utf-8")
	public String login(String vo) {		
		MemberVO joinInfo = gson.fromJson(vo, MemberVO.class);
		//dao.join(joinInfo);
		
		return gson.toJson(vo);
	}
	
	@RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
	public String login(String userid, String userpw) {		
		HashMap<String, String> map = new HashMap<String, String>();
		MemberVO vo = new MemberVO();
		System.out.println(userid);
		System.out.println(userpw);
		if(userid == null || userpw==null) {
			return gson.toJson(null);
		}
		// 로직 자체에서 자바코드에서 프로그램흐름을 제어함.↓
		// #{param, jdbcType=VARCHAR}
		map.put("userid", userid);
		map.put("userpw", userpw);
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
		
		vo = dao.login(map);
		System.out.println(vo);
	
		gson.toJson(vo);
		
		return gson.toJson(vo);
	}
	
}

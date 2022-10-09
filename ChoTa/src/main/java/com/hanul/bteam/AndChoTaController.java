package com.hanul.bteam;

import java.sql.Date;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import chotamember.EventVO;
import chotamember.MemberDAO;
import chotamember.MemberVO;
import common.CommonService;

@RestController
public class AndChoTaController {
	@Autowired MemberDAO dao; 
	@Autowired private CommonService common;
	Gson gson = new Gson();
	
	String imgpath = "";
	//프로필 변경
		@RequestMapping(value =  "/profile.info" , produces = "text/html;charset=utf-8")
		public String file(MultipartRequest mReq,HttpServletRequest req, String vo) {
			//파일 여러개 전송 시 mReq.getFileMap().get("")
			MemberVO mvo = gson.fromJson(vo, MemberVO.class);
			
			MultipartFile file =mReq.getFile("file");
			if(file != null) {

				imgpath = common.appName(req) + common.fileUpload("andinfo", file, req);
				System.out.println(imgpath);
				
				
			}
			mvo.setProfile(imgpath);
			int result = dao.profile_update(mvo);
			MemberVO svo = dao.member_detail(mvo.getUserid());
			System.out.println(svo.getProfile());
			return gson.toJson(svo);
		}
		
		
		//이벤트 참여 인서트 
		@RequestMapping(value = "/event_check", produces = "text/html;charset=utf-8")
		public void event_check(String str) {
			EventVO vo = new Gson().fromJson(str, EventVO.class);
			dao.event_check(vo);
		}
		
		//이벤트 처음 참여 인서트
		@RequestMapping(value = "/eventinsert", produces = "text/html;charset=utf-8")
		public void eventinsert(String userid) {
			dao.eventinsert(userid);
		}
		
		
		//이벤트 참여되었는지 여부 확인
		@RequestMapping(value = "/eventlist", produces = "text/html;charset=utf-8")
		public String eventlist(String userid) {
			List<EventVO> list = dao.eventlist(userid);
			return gson.toJson(list);
		}
	

	//멤버상세조회
	@RequestMapping(value = "/detail", produces = "text/html;charset=utf-8")
	public String member_detail(String id) {
		MemberVO vo = dao.member_detail(id);
		return gson.toJson(vo);
	}
	
	//반리스트
	@RequestMapping(value = "/banlist", produces = "text/html;charset=utf-8")
	public String ban_list(String data) {
		MemberVO vo = new Gson().fromJson(data, MemberVO.class);
		String name = vo.getName();
		List<MemberVO> list = dao.ban_list(name);
		
		System.out.println(list);
		return gson.toJson(list);
	}
	
	//멤버리스트
	@RequestMapping(value = "/list", produces = "text/html;charset=utf-8")
	public String chota_list(HttpServletRequest req) {
		List<MemberVO> list = dao.chota_list();
		System.out.println(list.size());
		return gson.toJson(list); 
	}
	
	

 	//로그인
	@RequestMapping(value = "/andlogin", produces = "text/html;charset=utf-8")
	public String login(String userid, String userpw, String social) {		
		HashMap<String, String> map = new HashMap<String, String>();
		MemberVO vo = new MemberVO();
		System.out.println(userid);
		System.out.println(userpw);
		if(userid == null) {
			return gson.toJson(null);
		}
		// 로직 자체에서 자바코드에서 프로그램흐름을 제어함.↓
		// #{param, jdbcType=VARCHAR}
		map.put("userid", userid);
		map.put("userpw", userpw);
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
		
		vo = dao.login(map, social);
		System.out.println(vo);
	
		gson.toJson(vo);
		
		return gson.toJson(vo);
	}
	
	//아이디 찾기
	@RequestMapping(value = "/andId_find", produces = "text/html;charset=utf-8")
	public String id_find(String name, String birth, String phone, HttpServletRequest request){
		System.out.println(name + birth + phone);
		MemberVO findId = new MemberVO();
	    
	    String birth2 = birth.substring(0,4) + "-" + birth.substring(4,6) + "-" + birth.substring(6);
	    System.out.println(birth2);

		//String → java.sql.Date 변환 
		Date birth3 = Date.valueOf(birth2);
		
		System.out.println(birth3);
		findId.setBirth(birth3);
		findId.setName(name);
		findId.setPhone(phone);
		MemberVO vo1 = dao.member_id_find(findId);
		
		System.out.println(vo1.getUserid());
		return gson.toJson(vo1);
		

	}
	
	//비밀번호 찾기1(지만 폰번호로 정보확인)
	@RequestMapping(value = "/andPw_find1", produces = "text/html;charset=utf-8")
	public String pw_find1(String phone) {
		System.out.println(phone);
	
		int result = dao.member_pw_find1(phone);
	
		return gson.toJson(result);
	}
	
	//비밀번호 중복확인 및 비밀번호 재설정
 	@ResponseBody @RequestMapping(value = "/andPw_find2", produces = "text/html;charset=utf-8")
 	public String pw_check(String userpw, String phone) {
 		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userpw",userpw);
		map.put("phone", phone);
 		//존재하는 경우 : 1(중복), 아니면 0(재설정 가능)
 		int result = dao.member_pw_check(map);
 		
 		if(result == 0){
 			int result1 = dao.member_pw_find2(map);	//1이면 재설정 성공
 			
 			return gson.toJson(result1);//1
 		}
 		
 		return gson.toJson("");
 		
 	}
	
	
	//회원가입
	@RequestMapping(value = "/andjoin", produces = "text/html;charset=utf-8")
	public String login(String vo, String birth) {
		System.out.println(vo);
		String birth2 = birth.substring(0,4) + "-" + birth.substring(4,6) + "-" + birth.substring(6);
		//String → java.sql.Date 변환 
		Date birth3 = Date.valueOf(birth2);
		System.out.println(birth3);
		
		MemberVO joinInfo = gson.fromJson(vo, MemberVO.class);
		if(joinInfo.getSocial() == null) {
			joinInfo.setSocial("N");
		}
		joinInfo.setBirth(birth3);
		System.out.println(joinInfo);
		
		int result = dao.member_join(joinInfo);
		System.out.println(result);
		
		return gson.toJson(result);
	}
	
	//아이디 중복확인 요청
 	@RequestMapping(value = "/andid_check", produces = "text/html;charset=utf-8")
 	public String id_check(String userid) {
 		//입력한 아이디가 DB에 존재하는지의 여부를 확인
 		//존재하는 경우 : 1(true), 아니면 0(false)
 		int result = dao.member_id_check(userid);
 		
 		return gson.toJson(result);
 	}
 	
 	//학교검색 요청
 	@RequestMapping(value = "/andschool_chk", produces = "text/html;charset=utf-8")
 	public String school_check(String school_name) {
 		//학교아이디 보내기
 		String school_id = dao.member_school_chk(school_name);
 		System.out.println(school_id);
 		
 		return gson.toJson(school_id);
 	}
 	
 	
}

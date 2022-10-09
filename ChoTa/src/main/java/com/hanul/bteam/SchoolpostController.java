package com.hanul.bteam;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import board.BoardFileVO;
import common.CommonService;
import school.SchoolpostVO;
import school.SchoolpostlDAO;

@RestController
public class SchoolpostController {
	@Autowired private CommonService common;
	@Autowired private SchoolpostlDAO dao;
	Gson gson = new GsonBuilder().create();
	SchoolpostVO schoolpostVO = new SchoolpostVO();
	
	//앱에 주소변경하기
		
	//앱네임 메소드
	private String appName(HttpServletRequest r) {
		// RequestURL: http://localhost:8080/iot/naver_callback
		// ServletPath: /naver_callback
		// replace 후: http://localhost:8080/iot
		return r.getRequestURL().toString().replace(r.getServletPath(), "");
	}
	
	
	//학교포스트 리스트 뽑음
	@RequestMapping(value="/andlist.sc", produces="text/html;charset=utf-8")
	public String getList() {
		List<SchoolpostVO> list = dao.schoolpost_list();
		System.out.println(gson.toJson(list));
		return gson.toJson(list);
	}
	

	//학교포스트 신규저장처리 요청(파일있음)
	@RequestMapping(value = "/andinsert.sc", produces = "text/html;charset=utf-8")
	public String insert(String vo, HttpServletRequest request) {
		schoolpostVO = gson.fromJson(vo, SchoolpostVO.class);	
		String imgpath = "";
			
		if(vo!=null) {System.out.print("들어왔음");}
		// 정보 빼오고나서 캐스팅.
		
		MultipartRequest mReq = (MultipartRequest) request;
		System.out.println(mReq);
		MultipartFile file = mReq.getFile("file");
		System.out.println(file);
		
		imgpath = appName(request) + common.fileUpload("andSchool", file, request);
		System.out.println(imgpath);
		
		//파일패스에 따로 셋해줌
		schoolpostVO.setFile_path(imgpath);
		dao.schoolpost_insert(schoolpostVO);
		return gson.toJson(schoolpostVO);
	}
	
	//학교포스트 신규저장처리 요청(파일없음)
	@RequestMapping(value = "/andinsert2.sc", produces = "text/html;charset=utf-8")
	public String insert2(String vo) {
		schoolpostVO = gson.fromJson(vo, SchoolpostVO.class);	
			
		if(vo!=null) {System.out.print("들어왔음");}
		// 정보 빼오고나서 캐스팅.
		
		dao.schoolpost_insert(schoolpostVO);
		return gson.toJson(schoolpostVO);
	}
	
	//학교포스트 글 상세보기
	@RequestMapping(value = "/anddetail.sc", produces = "text/html;charset=utf-8")
	public String detail(String id) {		
		SchoolpostVO vo = dao.schoolpost_detail(Integer.parseInt(id));
		System.out.println(vo);
		
		return new Gson().toJson(vo);
	}

	//학교포스트 수정
	//파일 없음 - 원래 파일 없음
	
	//파일 없음 - 원래 파일 있음
	
	//파일 있음 - 원래 파일 없음
	
	//파일 있음 - 원래 파일 있음
	
	
	//학교포스트 삭제
	//게시판 삭제처리 요청
	@RequestMapping(value = "/anddelete.sc", produces = "text/html;charset=utf-8")
	public String delete(String vo, HttpServletRequest request) {
		schoolpostVO = gson.fromJson(vo, SchoolpostVO.class);	
		//물리적파일정보를 위해 첨부파일정보를 조회해둔다
		
		if(schoolpostVO.getFile_path() != null) {
			String filepath = schoolpostVO.getFile_path();	
			filepath = filepath.replace( common.appName(request)
					, "d://app/" + request.getContextPath());
			File file = new File(filepath);
			if(file.exists()) file.delete();
		}
		
		int result = dao.schoolpost_delete(schoolpostVO.getSchoolpost_id());
		
		System.out.println(result);
		return gson.toJson(result+"");
	}
	
	
}

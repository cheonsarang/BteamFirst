package com.hanul.bteam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import board.BoardCommentVO;
import board.BoardDAO;
import board.BoardFileVO;
import board.BoardVO;
import common.CommonService;
import common.CommonVal;



@RestController
public class AndBoardController {
	@Autowired CommonService common;
	@Autowired BoardDAO dao;
	Gson gson = new Gson();
	BoardVO boardvo = new BoardVO();
	
	//게시판 스크랩 삭제
	@RequestMapping(value = "/andscrap_delete", produces = "text/html;charset=utf-8")
	public String scrap_delete(String scrapper, String board_id) {
		BoardVO vo = new BoardVO();
		vo.setScrapper(scrapper);
		vo.setId(Integer.parseInt(board_id));
		int result = dao.scrap_delete(vo);
		
		return gson.toJson(result);
	}
	
	
	//게시판 스크랩 저장
	@RequestMapping(value = "/andscrap_insert", produces = "text/html;charset=utf-8")
	public String scrap_insert(String scrapper, String board_id) {
		BoardVO vo = new BoardVO();
		vo.setScrapper(scrapper);
		vo.setId(Integer.parseInt(board_id));
		
		int result = dao.scrap_insert(vo);
		
		return gson.toJson(result);
	}
	
	
	//게시판 댓글삭제처리 요청
	@RequestMapping(value = "/andcomment_delete", produces = "text/html;charset=utf-8")
	public String comment_delete(String id) {
		
		int result = dao.board_comment_delete(Integer.parseInt(id));
		
		return gson.toJson(result);
	}
	
	
	
	//게시판 댓글변경저장처리 요청
	@RequestMapping(value = "/andcomment_update", produces = "text/html;charset=utf-8")
	public String comment_update(String vo) {
		BoardCommentVO commentVo = gson.fromJson(vo, BoardCommentVO.class);
		
		int result = dao.board_comment_update(commentVo);
		
		 return gson.toJson(result);
				
	}
	
	
	//게시판 댓글목록조회 요청
	@RequestMapping(value = "/andcomment_list", produces = "text/html;charset=utf-8")
	public String comment_list(String board_id) {
		
		List<BoardCommentVO> list = dao.board_comment_list(Integer.parseInt(board_id));
		
		return gson.toJson(list);
		
	}
	
	
	//게시판 댓글저장처리 요청
	@RequestMapping(value = "/andcomment_insert", produces = "text/html;charset=utf-8")
	public String comment_insert(String insertVo) {
		BoardCommentVO vo = gson.fromJson(insertVo, BoardCommentVO.class);
		
		int result = dao.board_comment_insert(vo);
		
		return gson.toJson(result);
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//물리적파일삭제 메소드
	private void removed_file(List<BoardFileVO> list, HttpServletRequest request) {
		for( BoardFileVO vo : list ) {
			String filepath = vo.getFilepath();
			// http://localhost/iot/upload/board/2022/08/30/323a9d55-a18a-4bcf-a685-64532fdfcaf1_초등학교식단표.csv
			//--> d://app/iot/upload/...
			filepath = filepath.replace( common.appName(request)
							, "d://app/" + request.getContextPath());
			File file = new File(filepath);
			if(file.exists()) file.delete();

		}	
	}
	
	
	//게시판 삭제처리 요청
	@RequestMapping(value = "/anddelete.bo", produces = "text/html;charset=utf-8")
	public String delete(String vo, HttpServletRequest request) {
		boardvo = gson.fromJson(vo, BoardVO.class);	
		//물리적파일정보를 위해 첨부파일정보를 조회해둔다
		List<BoardFileVO> list = dao.board_file_list(boardvo.getId());
		
		//해당 방명록을 삭제한 후
		if(dao.board_delete(boardvo.getId())==1) {
			//첨부된 파일정보가 있으면 함께 삭제: 테이블생성시 지정됨
			//물리적파일 삭제
			removed_file(list, request);
		}

		int result = dao.board_delete(boardvo.getId());
		
		System.out.println(result);
		return gson.toJson(result);
	}
	
	
	
	
	
	//게시판 수정저장처리 요청(파일있음)
	@RequestMapping(value = "/andupdate.bo", produces = "text/html;charset=utf-8")
	public String update(String vo, String removed, HttpServletRequest request) {
		List<BoardFileVO> list= null;//테스트중
		boardvo = gson.fromJson(vo, BoardVO.class);	
		String imgpath = "";
			
		// 정보 빼오고나서 캐스팅.
		MultipartRequest mReq = (MultipartRequest) request;
		System.out.println(mReq);
		MultipartFile file = mReq.getFile("file");
		System.out.println(file);
		
		if(file != null) {//나중에 따로 첨부파일메소드로 활용할 예정 그때는 파일 하나씩 꺼내기for(MultipartFile f : file ) {if( f.isEmpty()) continue;}
			imgpath = common.appName(request) + common.fileUpload("andboard", file, request);	
			System.out.println(imgpath);
			if( list==null ) list = new ArrayList<BoardFileVO>();
				BoardFileVO filevo = new BoardFileVO();//테스트중
				filevo.setFilename(file.getOriginalFilename());
				filevo.setFilepath(imgpath);
				list.add(filevo);				
		}	
		boardvo.setFileInfo(list);
		boardvo.setFile_path(imgpath);
		//첨부파일 관련처리
//		if(file.length > 1 ) {	
//			attached_file(vo, file, request);
//			
//		}
		
		//화면에서 입력한 정보를 DB에 변경저장한 후
		if( dao.board_update(boardvo) == 1 ) {
			//삭제된 파일이 있으면 DB의 board_file에서도 삭제
			if( !removed.isEmpty() ) {	//3,5,4
				//DB에서 board_file 정보 삭제하기 전에 업로드된 파일정보를 조회해둔다
				list = dao.board_file_list(removed);
				System.out.println(list.get(0).getFilename());
				//DB에서 삭제대상 파일정보를 삭제한 후
				if( dao.board_file_delete(removed) > 0) {
					//물리적파일도 삭제한다
					removed_file(list, request);
				}
				
			}
			
		}

		int result = dao.board_update(boardvo);
		System.out.println(result);
		
		return gson.toJson(boardvo);
	}
	
	//게시판 변경저장처리 요청(파일없음)
		@RequestMapping(value = "/andupdate.bo2", produces = "text/html;charset=utf-8")
		public String update2(String vo, HttpServletRequest request) {
			boardvo = gson.fromJson(vo, BoardVO.class);	
			
			int result = dao.board_update(boardvo);
			System.out.println(result);
			
			return gson.toJson(boardvo);
		}
	
	

//		@RequestMapping(value = "/files") 파일리스트로 받음 나중에 사용할거임
//		public String home(MultipartRequest  req) {
//			System.out.println("여기까지왔음");
//			System.out.println(req.getFileMap().size());
//			MultipartFile f1 = req.getFileMap().get("file1");
//			MultipartFile f2 = req.getFileMap().get("file2");
//			System.out.println(f1.getName());
//			System.out.println(f1.getOriginalFilename());
//			return "home";
//		}
	
	 			

	

	//게시판 신규저장처리 요청(파일있음)
	@RequestMapping(value = "/andinsert.bo", produces = "text/html;charset=utf-8")
	public String insert(String vo, HttpServletRequest request) {
		List<BoardFileVO> list= null;//테스트중
		boardvo = gson.fromJson(vo, BoardVO.class);	
		String imgpath = "";
			
		// 정보 빼오고나서 캐스팅.
		MultipartRequest mReq = (MultipartRequest) request;
		System.out.println(mReq);
		MultipartFile file = mReq.getFile("file");
		System.out.println(file);
		
		if(file != null) {//나중에 따로 첨부파일메소드로 활용할 예정 그때는 파일 하나씩 꺼내기for(MultipartFile f : file ) {if( f.isEmpty()) continue;}
			imgpath = common.appName(request) + common.fileUpload("andboard", file, request);	
			System.out.println(imgpath);
			if( list==null ) list = new ArrayList<BoardFileVO>();
				BoardFileVO filevo = new BoardFileVO();//테스트중
				filevo.setFilename(file.getOriginalFilename());
				filevo.setFilepath(imgpath);
				list.add(filevo);				
		}	
		boardvo.setFileInfo(list);
		//첨부파일 관련처리
//		if(file.length > 1 ) {	
//			attached_file(vo, file, request);
//			
//		}

		boardvo.setFile_path(imgpath);
		dao.board_insert(boardvo);
		
		return gson.toJson(boardvo);
	}
	
	
	//첨부파일관련 메소드(파일리스트로 filevo에 넣고 list.add시킴 그런다음 => BoardVO.setFileInfo 받기)
//	private void attached_file(BoardVO vo, MultipartFile[] file, HttpServletRequest request) {
//		List<BoardFileVO> list= null;
//		for(MultipartFile f : file ) {//파일태그는 한개지만 / 파일태그는 두개지만 
//			if( f.isEmpty()) continue;//실제선택한첨부파일은 없음. /실제선택한첨부파일은 한개
//			if( list==null ) list = new ArrayList<BoardFileVO>();//다형성이라서 상위는List사용가능(캐스팅)
//			
//			BoardFileVO filevo = new BoardFileVO();
//			filevo.setFilename(f.getOriginalFilename());
//			filevo.setFilepath( common.fileUpload("andboard", f, request)	);
//			list.add(filevo);
//		}
//		vo.setFileInfo(list);
//	}
	
	//게시판 신규저장처리 요청(파일없음)
		@RequestMapping(value = "/andinsert.bo2", produces = "text/html;charset=utf-8")
		public String insert2(String vo, HttpServletRequest request) {
			boardvo = gson.fromJson(vo, BoardVO.class);	
			
			dao.board_insert(boardvo);
			
			return gson.toJson(boardvo);
		}
	
	

	//게시판 글 상세보기
	@RequestMapping(value = "/anddetail.bo", produces = "text/html;charset=utf-8")
	public String detail(String id) {	
		dao.board_read(Integer.parseInt(id));
		
		BoardVO vo = dao.board_detail(Integer.parseInt(id));
		System.out.println(vo);
		
		
		return new Gson().toJson(vo);
	}
	

	//게시판 그룹별
	@RequestMapping(value = "/andgrp.bo", produces = "text/html;charset=utf-8")
	public String notice(String board_group_id) {
		List<BoardVO> list = dao.board_list(board_group_id);
		System.out.println(list.size());
		
		
		return new Gson().toJson(list);
	}
	
	//게시판 순위별(인기)글
	@RequestMapping(value = "/andrank.bo", produces = "text/html;charset=utf-8")
	public String board_rank() {
		List<BoardVO> list = dao.board_rank();
		System.out.println(list);

		
		return new Gson().toJson(list);
	}
	//게시판 총글
	@RequestMapping(value = "/andlist.bo", produces = "text/html;charset=utf-8")
	public String notice() {
		List<BoardVO> list = dao.board_list();
		System.out.println(list);

		return new Gson().toJson(list);
	}
	
	
}

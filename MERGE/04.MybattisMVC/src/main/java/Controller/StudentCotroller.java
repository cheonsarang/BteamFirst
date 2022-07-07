package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")// *<-전체를 받는 url패턴(맵핑)사용할때는 /<- 빼야됨 오류남
public class StudentCotroller extends HttpServlet {
	RequestDispatcher rd ;
	StudentDAO dao = new StudentDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 KYM)
		if(req.getServletPath().equals("/list.st")) {
			//추후 DB에서 가져온 정보를 이용 =>지금은 ArrayList를 수동으로 만들기
			//ArrayList<StudentDTO> list = dao.getManualList();
			//Object oList = dao.getManualList();
			//list = (ArrayList<StudentDTO>) oList;
			ArrayList<StudentDTO> list = dao.getList();
			
			req.setAttribute("list", list);
			/*
			 * for (int i = 0; i < list.size(); i++) {
			 * System.out.println(list.get(i).getStudent_no()); }
			 */
			// JSP 에 보내서 출력 해보기
			rd = req.getRequestDispatcher("student/list.jsp");
		}else if(req.getServletPath().equals("/test.st")) {
			Connection conn = dao.getConn();
//			try {
//				if(conn.isClosed())	{
//					System.out.println("닫힘");
//				}else {
//					System.out.println("열림");
//					dao.selectOne();
					//dao.getList();
					ArrayList<StudentDTO> stList = dao.getList();
					//디비연결 테스트 했음
					System.out.println(stList.size());
					for (int i = 0; i < stList.size(); i++) {
							System.out.println(stList.get(i).getStudent_no());
					}//for
//				}//if
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			dao.dbClose();
		}else if(req.getServletPath().equals("/detail.st")) {
			//파리메터 사용 이유 : 태그들을 간단히 보내기 위해 form 태그나 a 태그 사용하고, get 방식 사용했으므로 parameter로 받아옴
			//req.getParameter("user_id");
			System.out.println(req.getParameter("student_no"));
			System.out.println(req.getParameter("user_id"));
			//dao메소드 만들어서 학생 리스트 확인하기, getStudentInfo메소드 만들기(리턴타입 등등 자유롭게)
			//DTO 데이터베이스 컬럼이랑 맞춰서 만들어 놓은 클래스(필드==데이터베이스 컬럼)
			//학생 한명의 정보를 자세하게 보여주기 위해서
			StudentDTO dto = (StudentDTO) dao.getStudentInfo(Integer.parseInt(req.getParameter("student_no")), req.getParameter("user_id"));
			//StudentDTO dto = (StudentDTO) dao.getStudentInfo(req);
			System.out.println(dto.getUser_id());
			//detail.jsp ← 상세정보를 확인할 수 있는 페이지
			//헤더, 푸터 그대로 있고 내용만 바뀌게 해보기
			req.setAttribute("dto", dto); //오타만 안나면 됨
			//1. 페이지 전환의 기본 rd = req.getRequestDispatcher
			rd = req.getRequestDispatcher("student/detail.jsp");
			System.out.println(rd);
		}else if(req.getServletPath().equals("/update.st")) {
			//System.out.println(req.getParameter("student_no"));
			//System.out.println(req.getParameter("user_id"));
			StudentDTO dto = dao.getStudentInfo(Integer.parseInt(req.getParameter("student_no")), req.getParameter("user_id"));
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("student/update.jsp");
			//dto.setStudent_name()
		}else if(req.getServletPath().equals("/modify.st")) {
			//System.out.println(req.getParameter("student_no"));
			//System.out.println(req.getParameter("user_id"));
			//수정하는 로직을 작성하기
			//name 제외, first_name, last_name 만 수정되게끔 처리
			//업데이트 쿼리를 실행하고 나서 0보다 큰 숫자가 리턴되는지를 체크해보기
			// DAO이용한 업데이트 처리 ?( from태그 또는 url(get)방식으로 Servlet에 왔을때 파라메터가 어디있는지?)
			//dao.modify(req.getParameter("first_name"), req.getParameter("last_name"), Integer.parseInt(req.getParameter("student_no")), req.getParameter("user_id"));
			//rd = req.getRequestDispatcher("student/modify.jsp");
			
			StudentDTO dto = new StudentDTO(
					null, // student_name 수정안할꺼임 데이터 필요없음 
					req.getParameter("user_id"), 
					null, 
					req.getParameter("first_name"), 
					req.getParameter("last_name"), 
					Integer.parseInt(req.getParameter("student_no")));
			dao.modifyInfo(dto);
			//어떤 데이터를 넘길필요가없음.(페이지 새로고침만하면됨)
			//rd = req.getRequestDispatcher("student/list.jsp");
			resp.sendRedirect("list.st");
			return; //rd.forward가 다시 실행 안하게 함
		}else if(req.getServletPath().equals("/delete.st")) {
			//DAO를 통한 삭제 처리
			dao.delete(req.getParameter("student_no"), req.getParameter("user_id"));
			//rd = req.getRequestDispatcher("student/delete.jsp");
			resp.sendRedirect("list.st");
			return; //rd.forward가 다시 실행 안하게 함
		}else if(req.getServletPath().equals("/login.st")) {
			rd = req.getRequestDispatcher("student/login.jsp");
			System.out.println("rd : "+rd);
//			req.getParameter("id");
//			req.getParameter("pw");
		}else if(req.getServletPath().equals("/result.st")) {
			Connection conn = dao.getConn();
			ArrayList<StudentDTO> stList = dao.getList();
			System.out.println(stList.size());
			rd = req.getRequestDispatcher("student/Failed.jsp");
			for (int i = 0; i < stList.size(); i++) {
				if(stList.get(i).getUser_id().equals(req.getParameter("id")) && stList.get(i).getUser_pw().equals(req.getParameter("pw"))) {
					System.out.println("학생번호 : " + stList.get(i).getStudent_no());
					rd = req.getRequestDispatcher("index.jsp");
				}//if
			}//for	
		}//if
		rd.forward(req, resp);
	}
	
}//class

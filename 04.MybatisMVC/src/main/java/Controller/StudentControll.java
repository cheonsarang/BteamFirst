package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")	//* <- 전체를 받는 url패턴(맵핑) 사용할 때는 / 가 있으면 안됨 오류남 
public class StudentControll extends HttpServlet {
	RequestDispatcher rd;
	StudentDAO dao = new StudentDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp");	//나중에 추가 예정(2022.06.30 CSR)
		if(req.getServletPath().equals("/list.st")) {
			//추후 DB에서 가져온 정보를 이용 => 지금은 ArrayList를 수동으로 만들기
			ArrayList<StudentDTO> list = dao.getList();
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getStudent_no());
//			}
			
			//jsp 에 보내서 출력해보기 
			req.setAttribute("list", list);
			//JSP에 보내서 출력해보기
			rd = req.getRequestDispatcher("Student/list.jsp");
		}else if(req.getServletPath().equals("/test.st")) {
			//디비연결 테스트
			System.out.println(dao.getList().size());;
		}else if(req.getServletPath().equals("/detail.st")) {
			//DTO 데이터베이스 컬럼이랑 맞춰서 만들어놓은 클래스(필드==데이터베이스 컬럼)
			StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			System.out.println("여기까지 옴");
			System.out.println(req.getParameter("student_no"));
			System.out.println(req.getParameter("user_id"));
			req.setAttribute("dto", dto);
			//ArrayList, ??? getStudentInfo 메소드 만들기(리턴타입 등 자유롭게) 학생 한명의 상세정보 보여주기 위해서
			rd = req.getRequestDispatcher("Student/datail.jsp");
		}else if(req.getServletPath().equals("/update.st")) {
			StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("Student/update.jsp");
			
		}
		
		rd.forward(req, resp);
		
		
		
	}

}

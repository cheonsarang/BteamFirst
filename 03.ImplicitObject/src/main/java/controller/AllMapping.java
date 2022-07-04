package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.te")
public class AllMapping extends HttpServlet {
	// doGet , doPost 어떤 요청이 들어오는지에 따라서 로직을 분리해두는것은 
	//보안상 좋으나 코딩에 불편함이 많음
	
	//Webapp에서 어떤 경로를 내가 폴더로 만들고 Servlet에 요청을 하려고하면 햇갈림.
	// ../ , / , ../../ ==x 불편함.
	// *<-전체를 맵핑을 받을수있게도 할수가있음. Servlet을 Controller(Spring)와 유사한 구조로 만들기
	
	// * 전체를 입력받겠다. 
	// .구분자
	// adodofjofjof.구분자 ↑  ,  .do (servlet) ,  
	// 고객관리(Customer) *.cu
	// Hr(계정) *.hr
	// Student *.st
	
	//모든 요청을 받는 Service라는 메소드를 활용한다.
	RequestDispatcher rd ;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("여기 서비스까지옴 ");
		System.out.println(req.getMethod());
		if(req.getServletPath().equals("/header.te")) {
			rd = req.getRequestDispatcher("/Ex02_Response/Ex03_ResHeader.jsp");
		}else if(req.getServletPath().equals("/out.te")) {
			rd = req.getRequestDispatcher("/Ex03_Out/Ex01_Out.jsp");
		}else if(req.getServletPath().equals("/out2.te")) {
			PrintWriter out = resp.getWriter();	//초기화식
			//매번 HTML태그 써주거 태그 주면 불편 => contentType을 줄 수 있음(응답하는 스트림이 어떤 형태의 파일인지)
			//out.println("<html>");
			resp.setCharacterEncoding("UTP-8");
			resp.setContentType("text/html; charset=UTF-8");
			out.println("HELLO");
			out.println("<h1>안녕</h1>");
			out.println("<script>alert('됨');</script>");
			//out.println("</html>");
			
			
			//@Response(응답) 응답을 JSP나 다른 뷰단 통해서 하는게 아니라 URL(Controller, Servlet)
			//자체에서 하고싶을 때 사용(out)
			//JSP(JSP 파일한테 바로 객체생성해서 공개된 영역)
			//JAVA(직접 변수에 담아서 쓰게끔 만든 영역)
			//@ReresponseBody <- 어노테이션을 달면 바로 응답을 하게 되어있음(Spring)
		}
		else {
			rd = req.getRequestDispatcher("/Ex02_Response/Ex02_Failed.jsp");
		}
		
		//rd.forward(req, resp);
		
	}
}

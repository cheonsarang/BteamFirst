package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex01_Request")
public class Ex01_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex01_Request() {
        super();
    }
    // JSP 컨테이너 ( WAS + JSP 기능을 모아놓은 상자 )
    // 요청(크롬) => JSP => JAVA => Class => Excute => 결과보여줌
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("여기까지 옴");
		//JSP에서 Form태그를 통해서 '요청'한 파라메터를 받아보기
		// Form태그 안에있는 위젯의 name속성을 그대로적어준다.
		System.out.println(req.getParameter("name")); // json (String key , value )[] {}
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
		//입력한 id, pw를 통해서 회원가입처리(JDBC) 로그인처리(JDBC)
		
		System.out.println( req.getRemoteAddr() );
		System.out.println( req.getRemoteHost() );
		System.out.println( req.getContextPath() );
		
		
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

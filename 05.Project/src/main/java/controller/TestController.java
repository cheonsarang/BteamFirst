package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.TestDAO;


@WebServlet("*.te")
public class TestController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.getSession().setAttribute("userInfo", "a");
		//뒤로가기 해야 나온다
		
		TestDAO dao = new TestDAO();
		dao.test();
	}
}

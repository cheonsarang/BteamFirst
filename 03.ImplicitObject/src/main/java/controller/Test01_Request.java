package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test01_Request")
public class Test01_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test01_Request() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		for(int i = 0 ; i<100 ; i ++) {
			System.out.println(request.getParameter("param"+i));			
		}
		/*
		 * System.out.println(request.getParameter("param2"));
		 * System.out.println(request.getParameter("param3"));
		 * System.out.println(request.getParameter("param4"));
		 * System.out.println(request.getParameter("param5"));
		 * System.out.println(request.getParameter("param6"));
		 * System.out.println(request.getParameter("param7"));
		 * System.out.println(request.getParameter("param8"));
		 * System.out.println(request.getParameter("param9"));
		 */
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

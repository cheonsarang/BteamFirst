package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.deptDAO;
import emp.empDAO;


@WebServlet(urlPatterns = {"/list.emp","/list.dept"})

public class empcontroller extends HttpServlet {
	RequestDispatcher rd;
	empDAO dao = new empDAO();
	deptDAO dao1 = new deptDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/list.emp")) {
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("HR/emplist.jsp");
			
		}else if(req.getServletPath().equals("/list.dept")) {
			req.setAttribute("list1", dao1.getList());
			rd = req.getRequestDispatcher("HR/deptlist.jsp");
			
		}
		rd.forward(req, resp);
	}

}

//list.dept  list.emp
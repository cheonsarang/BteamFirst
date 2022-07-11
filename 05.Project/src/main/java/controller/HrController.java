package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import emp.EmpDAO;


@WebServlet(urlPatterns = {"*.emp","*.dept"})
public class HrController extends HttpServlet {
	EmpDAO empDAO = new EmpDAO();
	DeptDAO deptDAO = new DeptDAO();
	
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		
		if(req.getServletPath().equals("/list.emp")) {
			//DAO 만들고 req.setAtrr해야함
			System.out.println(empDAO.getList().size());
			System.out.println("사원 리스트 출력");
			req.setAttribute("emplist", empDAO.getList());
			rd = req.getRequestDispatcher("hr/emplist.jsp");
			
		}else if(req.getServletPath().equals("/list.dept")) {
			System.out.println(deptDAO.getList().size());
			System.out.println("부서 리스트 출력");
			req.setAttribute("deptlist", deptDAO.getList());
			rd = req.getRequestDispatcher("hr/deptlist.jsp");			
		}
		rd.forward(req, resp);
	}//service
}//class

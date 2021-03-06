package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("고객관리 모듈 ");
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 KYM)
		if (req.getServletPath().equals("/list.cu")) {
			req.setAttribute("list", dao.getList());// jsp에서 사용할수있게 담음(저장)
			rd = req.getRequestDispatcher("customer/listjstl.jsp");
		}else if (req.getServletPath().equals("/insert.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
<<<<<<< HEAD
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
=======
			dto.setGender(req.getParameter("gender"));
			dto.setEmail(req.getParameter("email"));
			dto.setPhone(req.getParameter("phone"));
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
			int result = dao.insert(dto);
			return ;
		}
		
		
		rd.forward(req, resp);
	}

}

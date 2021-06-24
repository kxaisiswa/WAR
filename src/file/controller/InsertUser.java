package file.controller;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.UserDAO;
import file.model.User;

@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO udao;
	public InsertUser() {
			super();
			udao = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		udao.insertuser(user);
		request.setAttribute("user", UserDAO.listuser());
		RequestDispatcher view = request.getRequestDispatcher("ListUser.jsp");
		view.forward(request, response);
	}
}

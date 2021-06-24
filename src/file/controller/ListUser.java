package file.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.UserDAO;

@WebServlet("/ListUser")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO udao;
	public ListUser() {
			super();
			udao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", UserDAO.listuser());
		RequestDispatcher view = request.getRequestDispatcher("ListUser.jsp");
		view.forward(request, response);
	}
}

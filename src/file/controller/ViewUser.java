package file.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.UserDAO;

@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO udao;
	public ViewUser() {
			super();
			udao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int updid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", UserDAO.viewuser(updid));
		RequestDispatcher view = request.getRequestDispatcher("ViewUser.jsp");
		view.forward(request, response);
	}
}
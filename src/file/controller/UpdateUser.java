package file.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.UserDAO;
import file.model.User;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO udao;
	public UpdateUser() {
			super();
			udao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int updid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", UserDAO.viewuser(updid));
		RequestDispatcher view = request.getRequestDispatcher("ViewUser.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User updateduser = new User();

		updateduser.setId(Integer.parseInt(request.getParameter("id")));
		updateduser.setName(request.getParameter("name"));
		updateduser.setEmail(request.getParameter("email"));

		udao.updateuser(updateduser);
	}
}
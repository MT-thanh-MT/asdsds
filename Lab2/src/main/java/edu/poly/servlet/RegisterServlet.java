package edu.poly.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/register.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String married = request.getParameter("married");
		String nationality = request.getParameter("nationality");

		String[] favorites = request.getParameterValues("favorites");
		String note = request.getParameter("note");

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("gender", gender);
		request.setAttribute("married", married);
		request.setAttribute("nationality", nationality);
		StringBuilder sp = new StringBuilder();
		if (favorites == null) {
			request.setAttribute("favorites", "Kh�ng c�");
		} else {
			for (String item : favorites) {
				if (item == favorites[favorites.length - 1]) {
					sp.append(item).append(".");
				} else {
					sp.append(item).append(", ");
				}
			}

			request.setAttribute("favorites", sp.toString());
		}
		request.setAttribute("note", note);

		request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	}

}

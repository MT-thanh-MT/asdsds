package edu.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		
		if (username != null && !username.equals("")) {
			request.setAttribute("massage", "Login successfuly!!!");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			return;
		} else {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginUser user = new LoginUser();
			
			BeanUtils.populate(user, request.getParameterMap());
			
			if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				
				
				
				if (user.isRemember()) {
					CookieUtils.add("username" , user.getUsername(), 2, response);
				}else {
					CookieUtils.add("username" , user.getUsername(), 0, response);
				}
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Inalid username or password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

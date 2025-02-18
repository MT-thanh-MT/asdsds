package edu.poly.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TamGiacServelet
 */
@WebServlet({"/TamGiacServelet/chuvi", "/TamGiacServelet/dientich"})
public class TamGiacServelet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/tamGiac.jsp");
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		RequestDispatcher rd = request.getRequestDispatcher("/views/tamGiac.jsp");
		
		String aSt = request.getParameter("a");
		String bSt = request.getParameter("b");
		String cSt = request.getParameter("c");
		
		float a = Float.parseFloat(aSt);
		float b = Float.parseFloat(bSt);
		float c = Float.parseFloat(cSt);
		
		if ( (a+b>c) && (b+c>a) && (a+c>b)) {
			if (uri.contains("chuvi")) {
				float cv = tinhChuVi(a,b,c);
				request.setAttribute("message", "chu vi của tam giác là: " + cv);
			} else {
				float dt = tinhDienTich(a,b,c);
				request.setAttribute("message", "Diện tích của tam giác là: " + dt);
			}
		}else {
			request.setAttribute("message", "Các cạnh của tam giác không hợp lệ");
		}
		rd.forward(request, response);
	}


	private float tinhDienTich(float a, float b, float c) {
		float s = (a+b+c)/2;
		float dt = (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return dt;
	}


	private float tinhChuVi(float a, float b, float c) {
		
		return a+b+c;
	}

}

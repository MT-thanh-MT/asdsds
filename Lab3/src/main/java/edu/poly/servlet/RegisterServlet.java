package edu.poly.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import edu.poly.model.Staffs;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("staffs/form.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			
			Staffs staff = new Staffs();
			
			BeanUtils.populate(staff, request.getParameterMap());
			
			String uploadFolder = request.getServletContext().getRealPath("/uploads");
			Path uploadPath = Paths.get(uploadFolder);
			
			if (!Files.exists(uploadPath)) {
				Files.createDirectory(uploadPath);
			}
			Part imagePart = request.getPart("image");
			
			
			String imageFilename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
			
			imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());
			
			//request.setAttribute("image", imageFilename);
			staff.setFavorites(request.getParameterValues("favorites"));
			StringBuilder sp = new StringBuilder();
			for(String item : staff.getFavorites()) {
				if (item == staff.getFavorites()[staff.getFavorites().length-1]) {
					sp.append(item).append(".");
				} else {
				sp.append(item).append(", ");
				}
			}
			request.setAttribute("favorites", sp.toString());
			staff.setImageName(imageFilename);
			
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/staffs/form.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/staffs/form.jsp").forward(request, response);
	}

}

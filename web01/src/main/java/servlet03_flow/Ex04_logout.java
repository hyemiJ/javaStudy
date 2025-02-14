package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcTest.StudentDTO;
import mvcTest.StudentService;


@WebServlet("/logout")
public class Ex04_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_logout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 .request , 한글 처리.
		request.setCharacterEncoding("UTF-8");
		String uri = "home.jsp";
		
		request.getSession().invalidate();
		System.out.println("로그아웃되었습니다.");
		System.out.println("세션 loginName = "+request.getSession().getAttribute("loginName"));
		response.sendRedirect(uri);
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

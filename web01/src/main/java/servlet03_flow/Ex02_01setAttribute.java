package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/01set")
public class Ex02_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_01setAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 . request 처리
		// ~/01set?id=banana&name=홍길동&age=22
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// => 콘솔로 확인
		System.out.println("** setAttribute Test **");
		System.out.printf("id = %s , name = %s , age = %s %n",id ,name,age);
		
		//보관 가능한 객체 Scope
		request.setAttribute("requestID", id);
		request.setAttribute("requestName", name);
		request.setAttribute("requestAge", age);
		
		// session 생성 : 클라이언트가 접속하면 server가 자동생성
		HttpSession session = request.getSession();
		session.setAttribute("sessionID", id);
		session.setAttribute("sessionName", name);
		session.setAttribute("sessionAge", age);
		
		// 이동 후 확인
		// 서블릿 -> 서블릿.
		String url = "02get";
		
		// 1. Forward 방식
		 request.getRequestDispatcher(url).forward(request, response);
		
		// 2. Redirect 방식
		//response.sendRedirect(url);
		
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

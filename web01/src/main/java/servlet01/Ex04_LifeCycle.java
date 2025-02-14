package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lcycle")
public class Ex04_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cno = 1; // 생성자 메서드 호출 횟수.
	int ino = 1; // init 메서드 호출 횟수.
	int gno = 1; // doGet 메서드 호출 횟수.
	int dno = 1; // destroy 메서드 호출 횟수.

	// constructor
	public Ex04_LifeCycle() {
		super();
		System.out.println("** 생성자 메서드 호출 횟수 " + cno++);
	}// constructor

	// init()
	public void init(ServletConfig config) throws ServletException {
		System.out.println("** init 메서드 호출 횟수 " + ino++);
	}// init()

	// destroy()
	public void destroy() {
		System.out.println("** destroy 메서드 호출 횟수 " + dno++);
	}// destroy()

	// doGet() : 클라이언트로 부터 get 방식 요청이 들어오면 자동 호출 메서드.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style='color:blue;'>** Servelt LifeCycle Test **</h2>");
		out.print("<pre><h3>");
		out.println(" ** 현재 시간  : " + new Date() );
		out.println(" ** doget 메서드 호출 횟수 : " + gno );
		out.print("</h3></pre>");
		out.print("</body></html>");
		
		System.out.println("** doget 메서드 호출 횟수 " + gno++);
	}// doGet()

}

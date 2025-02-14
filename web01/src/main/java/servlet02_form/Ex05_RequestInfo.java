package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rinfo")
public class Ex05_RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex05_RequestInfo() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Request Information **</h2>");
		out.print("<h3>=> 주요 메서드</h3>");
		out.print("<h3> 1) Request Header Names & Values</h3>");
		out.print("<h3> 2) ContextPath: 웹애플리케이션의 최상위 경로 </h3>");
		out.print("<h3> 3) RealPath: 웹애플리케이션의 실행위치</h3>");
		out.print("<h3> 4) 기타등등 </h3>");
		out.print("<h3> => Console 창에서 확인하세요 ~~~</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>이전으로</a></h2><br>");
		
		// Console을 통한 주요 메서드 확인
		System.out.println(" 1 ) Request Header Names & Values");
		Enumeration<String> hnames = request.getHeaderNames();
		while(hnames.hasMoreElements()) {
			String hName = hnames.nextElement();
			System.out.printf("%s = %s %n",hName , request.getHeader(hName));
		}
		System.out.println("2) ContextPath : 웹애플리케이션의 최상위 경로 = "+request.getContextPath());
		System.out.println("3) RealPath: 웹애플리케이션의 실행위치 = "+request.getRealPath("/"));
		System.out.println("4 ) 기타 등");
		System.out.println(" * Method =>"+request.getMethod());
		System.out.println(" * request URL =>"+request.getRequestURL());
		System.out.println(" * request URI =>"+request.getRequestURI());
		System.out.println(" * serverName =>"+request.getServerName());
		System.out.println(" * serverPort =>"+request.getServerPort());
		System.out.println(" * servletPath =>"+request.getServletPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

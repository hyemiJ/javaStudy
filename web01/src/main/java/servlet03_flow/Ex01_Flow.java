package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** PageFlow
//=> 서버내에서 웹페이지(Html, Jsp) 또는 Servlet 간의 이동    
//=> 서버외 : 클라이언트의 요청으로 이동 ( a Tag , submit 등 )     
//=> 경우
//   servlet -> servlet
//   servlet <-> jsp , html
//   jsp -> jsp    

//** Forward 와 Redirect
//** Forward : 웹브라우져의 주소창이 안바뀜
//   => 현재의 요청에 대해 서버내에서 page만 이동함.
//** Redirect: 웹브라우져의 주소창이 바뀜
//   => 현재의 요청에 대해 응답 -> 재요청 -> 처리
@WebServlet("/flow")
public class Ex01_Flow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex01_Flow() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 . Forward 방식
		//flow -> hello
		// 웹브라우저의 주소창이 바뀌지 않음.
		// 요청명(/flow)과는 다른 페이지(/hello)가 출력됨.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<h2 style='color:blue;'>** Forward Test **</h2>");
		out.print("</body></html>");
		//=> 콘솔로 확인 
		System.out.println("** Forward&Redirect Test  : Forward**");
		
		//서블릿 -> 서블릿.
		String url = "servletTestForm/form04_Select.jsp";
		
		//RequestDispatcher dis = request.getRequestDispatcher(url);
		//dis.forward(request, response);
		//request.getRequestDispatcher(url).forward(request, response);
		
		//2. Redirect 방식
		response.sendRedirect(url);
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

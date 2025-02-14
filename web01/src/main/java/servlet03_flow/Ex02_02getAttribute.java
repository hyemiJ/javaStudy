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


@WebServlet("/02get")
public class Ex02_02getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_02getAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 . request 처리
		// => 화면 출력에서 확인
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// => 콘솔로 확인
		System.out.println("** getAttribute Test **");
		System.out.printf("id = %s , name = %s , age = %s %n",id ,name,age);
		
		// request의 getAttribute.
		String idR = (String)request.getAttribute("requestID");
		String nameR = (String)request.getAttribute("requestName");
		String ageR = (String)request.getAttribute("requestAge");
		
		//session의 getAttribute.
		HttpSession session = request.getSession();
		
		String idS = (String)session.getAttribute("sessionID");
		String nameS = (String)session.getAttribute("sessionName");
		String ageS = (String)session.getAttribute("sessionAge");
		
		
		// view 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h2 style='color:blue;'>** getAtribute **</h2>");
        out.print("<hr>");
        out.print("<hr>");
        out.print("<h4> => 1. request 의 parameter 값이 유지되는지 확인</h4>");
        out.printf("<ul><li><h6> => ID = %s </h6></li>",id);
        out.printf("<li><h6> => NAME = %s  </h6></li>", name);
        out.printf("<li><h6> => AGE = %s</h6></li></ul>" ,age);
        out.print("<hr>");
        out.print("<h4> => 2. request 의 Attribute 값이 유지되는지 확인</h4>");
        out.printf("<ul><li><h6> => requestID = %s </h6></li>",idR);
        out.printf("<li><h6> => requestNAME = %s  </h6></li>", nameR);
        out.printf("<li><h6> => requestAGE = %s</h6></li></ul>" ,ageR);
        out.print("<hr>");
        out.print("<h4> => 3. session 의 Attribute 값이 유지되는지 확인</h4>");
        out.printf("<ul><li><h6> => sessionID = %s </h6></li>",idS);
        out.printf("<li><h6> => sessionNAME = %s  </h6></li>", nameS);
        out.printf("<li><h6> => sessionAGE = %s</h6></li></ul>" ,ageS);
        out.print("</body></html>");
		
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/radio")
public class Ex02_radioText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex02_radioText() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String gender  = request.getParameter("gender");
		String mailcheck = request.getParameter("mailcheck");
		String content = request.getParameter("content");
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(gender!=null) {			
			out.printf("<p>성별 : %s </p>",gender);
		}
		if(mailcheck != null) {
			if(mailcheck == "예") {
				out.print("메일 수신여부 ok");
			}else {
				out.print("메일 수신여부 no");
			}
		}
		out.print("<br>");
		if(content != null && content.length()>0) {
			out.print(content);
		}else {
			out.print("가입 인사 no");
		}
		
		out.print("</body></html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

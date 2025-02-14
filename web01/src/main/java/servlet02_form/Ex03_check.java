package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;


@WebServlet("/check")
public class Ex03_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex03_check() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] gift  = request.getParameterValues("gift");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(gift!=null&&gift.length>0) {
			out.print("<p>선택 됨</p>");
			for (String gf : gift) {
				out.print(gf+", ");
			}
		}else {
			out.print("<p>아무것도 출력되지 않았습니다</p>");
		}
		out.print("</body></html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/select")
public class Ex04_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex04_select() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String job  = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");
		
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(job!=null && job.length()>0) {
			out.print("<br>");
			out.print(job);
			out.print("<br>");
		}else {
			out.print("직업 미입력");
		}
		out.print("<br>");
		if(interest !=null && interest.length>0) {
			for (String it : interest) {
				out.print(it+" ");
			}
			out.print("<br>");
		}else {
			out.print("관심분야 미입력");
		}
		out.print("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

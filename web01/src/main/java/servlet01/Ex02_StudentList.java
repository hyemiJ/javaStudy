package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;


//@WebServlet(urlPatterns = {"/slist","/안녕","/123","/7seven"})
public class Ex02_StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex02_StudentList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. sevice 처리 하기 위한 인스턴스 생성
		StudentService service = new StudentService();
		List<StudentDTO> list =service.selectList();
		//2.결과 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h2 style='color:blue;'>** StudentList Servlet **</h2>");
        out.print("<table border=1>"
        		+ "<tr><th>Sno</th><th>Name</th><th>Age</th><th>Jno</th><th>Info</th><th>Point</th><th>Birhday</th><th>Now</th></tr>");
        if (list !=null) {
			for (StudentDTO s : list) {
				out.print("<tr><td>"+s.getSno()+"</td>");
				out.print("<td>"+s.getName()+"</td>");
				out.print("<td>"+s.getAge()+"</td>");
				out.print("<td>"+s.getJno()+"</td>");
				out.print("<td>"+s.getInfo()+"</td>");
				out.print("<td>"+s.getPoint()+"</td>");
				out.print("<td>"+s.getBirthday()+"</td>");
				out.print("<td>"+s.getNow()+"</td></tr>");
			}
		}else out.print("출력할 데이터가 없습니다");
        
        out.print("<h3> => ContextPath : "+request.getContextPath()+"</h3>");
        out.print("<h3> => 여기는 doGet 메서드 입니다.</h3>");
        out.print("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}

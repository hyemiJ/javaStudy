package mvcTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 매핑네임 설정 우선.
 */
@WebServlet("/myinfo")
public class Ex02_MVC2Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_MVC2Detail() {
        super();
    }//생성자

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. 요청 분석 & 해당 service
		StudentService service = new StudentService();
		int sno = (Integer)request.getSession().getAttribute("loginID");
		StudentDTO selectStudent = service.selectOne(sno);
	
		//3. 결과 저장 , JSP로 forward 
		//서비스의 결과물인 List를 JSP가 출력할 수 있도록 attribute 로 보관.
		request.setAttribute("apple", selectStudent);
		
		String uri = "mvcTestJsp/Ex02_MVC2Detail.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
	
	}//doGet 


	/* a 태그를 통한 유입은 doget 으로 들어오게 된다. 그럼으로 dopost는 없어도 된다. */

}

package controllerM;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

/**
 * 1. 매핑네임 설정 우선.
 */
@WebServlet("/mdelete")
public class C06_mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C06_mDelete() {
        super();
    }//생성자

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. 요청 분석 & 해당 service
		MemberService service = new MemberService();
		//MemberDTO selectStudent = service.selectOne((String)request.getSession().getAttribute("loginID"));
		
		String uri = "home.jsp";
		MemberDTO selectStudent = new MemberDTO();
		selectStudent.setId((String)request.getSession().getAttribute("loginID"));
		if(service.delete(selectStudent)>0) {
			System.out.println("삭제 성공");
			request.getSession().invalidate();
			request.setAttribute("message","삭제 성공");
		}else {
			System.out.println("삭제 실패");
			request.setAttribute("message","삭제 실패");
		}
		
		
		request.getRequestDispatcher(uri).forward(request, response);
	
	}//doGet 


	/* a 태그를 통한 유입은 doget 으로 들어오게 된다. 그럼으로 dopost는 없어도 된다. */

}

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
@WebServlet("/mdetail")
public class C03_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C03_mDetail() {
        super();
    }//생성자

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. 요청 분석 & 해당 service
		MemberService service = new MemberService();
		MemberDTO selectStudent = service.selectOne((String)request.getSession().getAttribute("loginID"));
		String uri = "member/memberDetail.jsp";
		
		//** 업데이트 요청시 uri를 바꾸자
		//if(request.getParameter("jCode").equals("U")) ->jcode 가 없으면 null 오류발생
		if("U".equals(request.getParameter("jCode"))) {
			uri ="member/updateForm.jsp";
		}
		
		//3. 결과 저장 , JSP로 forward 
		//서비스의 결과물인 List를 JSP가 출력할 수 있도록 attribute 로 보관.
		request.setAttribute("apple", selectStudent);
		
		request.getRequestDispatcher(uri).forward(request, response);
	
	}//doGet 


	/* a 태그를 통한 유입은 doget 으로 들어오게 된다. 그럼으로 dopost는 없어도 된다. */

}

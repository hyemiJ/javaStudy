package controllerF;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

//** FrontController 패턴 1.
//=> 대표 컨트롤러 1개만 서블릿으로 작성
//모든 요청을 이 대표컨트롤러(FrontController) 가 받도록 함.
//나머지 컨트롤러는 일반 클래스로 작성 (2단계, Factory 패턴 적용)

//=> 요청에 대한 서비스를 if문으로 서블릿내에서 모두 처리
//코드가독성, 모듈의 재사용성 떨어짐 (1단계)



@WebServlet(urlPatterns = {"*.do"})
public class Ex01_FrontBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex01_FrontBasic() {
        super();
    }//c

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getServletPath();
		System.out.println("url : " +request.getRequestURL());
		System.out.println("uri : " +request.getRequestURI());
		System.out.println("uri : " +uri);
		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		String id = (String)request.getSession().getAttribute("loginID");
		
		if("/mlist.do".equals(uri)) {
			// -> 멤버 리스트 
			//List<MemberDTO> list = service.selectList(); // 재사용하지 않는다면 , 아래와 같이 바로 보내기
			request.setAttribute("banana", service.selectList());
			uri="member/memberList.jsp";
		}else if("/mdetail.do".equals(uri)) {
			// -> 멤버 디테일 : 로그인 후 테스트 하는 것으로 함.
			//dto = service.selectOne(id);
			//request.setAttribute("apple", dto); // 재사용하지 않는다면 , 아래와 같이 바로 보내기
			request.setAttribute("apple", service.selectOne(id));
			uri = "member/memberDetail.jsp";
		}else {
			request.setAttribute("message", "요청에 해당하는 서비스는 없습니다.");
			uri="home.jsp";
		}
		
		request.getRequestDispatcher(uri).forward(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}//class

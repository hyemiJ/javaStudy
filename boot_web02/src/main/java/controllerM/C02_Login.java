package controllerM;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberDTO;
import service.MemberService;


@WebServlet("/login")
public class C02_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C02_Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 .request , 한글 처리.
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();//session 인스턴스.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String uri = "home.jsp";
		
		// 2. 비즈니스 (service) 처리.
		MemberService service = new MemberService();
		MemberDTO dto = service.selectOne(id);
		//sno 존재여부 -> dto의 null 여부로 판단.
		if( dto!=null && dto.getPassword().equals(password)) {
			//=> 완전 성공.
			System.out.println("sno와 name 이 DB내용과 일치.");
			System.out.println(dto);
			request.getSession().setAttribute("loginID", dto.getId());
			request.getSession().setAttribute("loginName", dto.getName());
			//System.out.println("세션 연결 객체 이름 반환 = "+session.getAttributeNames());
			System.out.println("세션 loginName = "+session.getAttribute("loginName"));
			System.out.println("request message = "+request.getAttribute("message"));
			response.sendRedirect(uri);
		}else {
			//=> 실패.
			System.out.println("sno와 name 이 DB내용이 일치하지 않거나 잘못된 내용.");
			uri = "member/loginForm.jsp";
			request.setAttribute("message", "로그인 실패 다시하세요.");
			//System.out.println("세션 연결 객체 이름 반환 = "+session.getAttributeNames());
			System.out.println("세션 loginName = "+session.getAttribute("loginName"));
			System.out.println("request message = "+request.getAttribute("message"));
			request.getRequestDispatcher(uri).forward(request, response);
			System.out.println("request*** message = "+request.getAttribute("message"));
		}
		
		
		
		//3. 결과 처리
		//=> 성공시 -> 홈화면(home.html) , 실패시->로그인폼(~loginForm.jsp) 재로그인 유도.
		
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}

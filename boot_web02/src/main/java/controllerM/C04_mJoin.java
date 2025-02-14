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


@WebServlet("/mjoin")
public class C04_mJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C04_mJoin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 .request , 한글 처리.
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();//session 인스턴스.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String uri = "member/loginForm.jsp";
		//2. 비즈니스 (service) 처리.
		MemberService service = new MemberService();
		//3. 멤버 DTO 선언
		MemberDTO dto = new MemberDTO();
		//4. DTO 의 setter
		dto.setId(request.getParameter("id"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("password"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setJno(Integer.parseInt(request.getParameter("jno")));
		dto.setInfo(request.getParameter("info"));
		dto.setPoint(Double.parseDouble(request.getParameter("point")));
		dto.setBirthday(request.getParameter("birthday"));
		dto.setRid(request.getParameter("rid"));
		
		//5.서비스의 insert 성공 여부 판단.
		//insert 성공시 로그인 유도 (home.jsp)
		//insert 실패시 재가입 유도 (joinForm.jsp)
		System.out.println(dto);
		if(service.insert(dto)>0) {
			System.out.println("insert 성공");
			request.setAttribute("message", "회원가입 성공 ! 로그인 후 이용해주세요.");
			request.getRequestDispatcher(uri).forward(request, response);
		}else {
			System.out.println("insert 실패");
			request.setAttribute("message", "회원가입 실패 ! 다시 가입 후 이용해주세요.");
			uri="member/joinForm.jsp";
			request.getRequestDispatcher(uri).forward(request, response);
		}
		
		

		
		
		
		//3. 결과 처리
		//=> 성공시 -> 홈화면(home.html) , 실패시->로그인폼(~loginForm.jsp) 재로그인 유도.
		
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}

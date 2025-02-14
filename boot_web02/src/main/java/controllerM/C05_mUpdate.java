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


@WebServlet("/mupdate")
public class C05_mUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C05_mUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 .request , 한글 처리.
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();//session 인스턴스.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String uri = "member/memberDetail.jsp";
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
		//update 성공시 detail 유도 (memberdetail.jsp)
		//update 실패시 재수정 유도 (updateForm.jsp)
		//그러므로 출력을 위해서는 출력 객체가 필요하다.
		request.setAttribute("apple", dto);
		System.out.println(dto);
		if(service.update(dto)>0) {
			System.out.println("update 성공");
			request.setAttribute("message", "회원 정보 수정 완료.");
			request.getRequestDispatcher(uri).forward(request, response);
		}else {
			System.out.println("update 실패");
			request.setAttribute("message", "회원 정보 수정 실패.");
			uri="member/updateForm.jsp";
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

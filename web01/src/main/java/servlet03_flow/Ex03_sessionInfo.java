package servlet03_flow;

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
//3. Session Time (제한시간) 설정 
// => 메서드: setMaxInactiveInterval(10), 단위는 초, 1시간(60*60)
// => 설정화일 (web.xml)
//    Tag session-config 의 subTag session-timeout 


// 4. Session 무효화(종료)
// => invalidate : 무효화
//    세션객체 자체를 소멸시키는것이 아니라, 세션을 초기화하고 무효화시킴.
//    session 이 null 이 아니고 session = ""

// => 퀴리스트링으로 테스트 ( ~~/sessioni?jCode=D )
// => 주의: jCode 라는 Parameter 가 없는 경우 null 을 return 
//         -> NullPointerException 예방 하도록 작성

@WebServlet("/sinfo")
public class Ex03_sessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_sessionInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 .session 인스턴스 생성 : session 객체는 클라이언트 접속과 동시에서버에서 생성
		// 이 값을 코드에서 사용하기 위해 전달받아 인스턴스 생성.
		
		HttpSession session = request.getSession();//session 인스턴스.
		Date now = new Date(); // 현재 시간.
		SimpleDateFormat formatter = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 인자로 패턴넣기.
		
		
		// view 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        //out.print("<html><body>");
        out.print("<h2 style='color:blue;' margin='auto'>** session 정보 **</h2>");
        out.print("<hr>");
        out.print("<hr>");
        
        out.printf("<ul><li><h3> => Session_ID = %s </h3></li>",session.getId());
        out.printf("<li><h3> => Now_현재시간 = %s  </h3></li>", formatter.format(now));
        now.setTime(session.getCreationTime());
        out.printf("<li><h3> => Session_CreationTime = %s</h3></li>" ,formatter.format(now));
        now.setTime(session.getLastAccessedTime());
        out.printf("<li><h3> => Session_LastAccessedTime = %s  </h3></li></ul>",formatter.format(now));
        out.print("<hr>");
        
        //session.setMaxInactiveInterval(10); // 인자만큼의 시간이 흐른다면 ,세션이 만료되고 , id 가 새로 반영
        //쿼리스트링으로활용 테스트.
        //if(request.getParameter("jCode")!=null&&request.getParameter("jCode").equals("D"))
        if("D".equals(request.getParameter("jCode"))) {
        	session.invalidate();
        	out.print("<h3>session 종료 !</h3>");
        	return;
        }
        
        out.print("<h3> => 정상 종료</h3>");
        //out.print("</body></html>");
		
		

		
		
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

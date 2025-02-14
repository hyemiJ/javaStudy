package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//** 톰켓10 사용시 주의사항
//=> Java 8 까지 지원
//=> 문제가 많아 실무에서 잘 안쓰임
//=> javax.servlet을 지원안함.
//   그러므로 javax -> jakarta 로 변경
//=> 실습: 톰켓9
/*
*** Tomcat 8080 Kill
1) cmd 
2) netstat -a -n -o -p tcp
   -> 아래처럼 실행되면 로컬주소 에서  127.0.0.1:8080 의 pid 값 확인후 kill
------------------------------------------------------------------------
프로토콜 로컬 주소         외부 주소     상태            PID
TCP  0.0.0.0:135    0.0.0.0:0  LISTENING     1120
~~    ~~              ~~            ~~~         ~~    
TCP  127.0.0.1:8080 0.0.0.0:0  LISTENING     10672    
~~    ~~            ~~            ~~~         ~~
------------------------------------------------------------------------

3) taskkill /f /pid 6560
*/

//** 오류가 없는데 실행인 안되고 계속 오류발생시
//=> 오타, 저장확인, web.xml 확인후
//=> 프로젝트클린, 서버클린, 서버재실행
//=> 서버 Remove & 재설치

//** Servlet 계층도
//=> Object -> interface : Servlet, ServletConfig,( java.io.Serializable : 객체를 직렬화(순차화) 시켜줌 . final serialVersionUID 변수를 넣어줘야 함.) 
//        -> GenericServlet (A) -> HttpServlet (A) 

//public abstract class HttpServlet extends GenericServlet {...}
//public abstract class GenericServlet implements Servlet, ServletConfig,
//                                          java.io.Serializable {...}

//** Servlet 의 실행방식
//=> 클라이언트의 요청에 자동반응하는 이벤트 드리븐 방식으로 작동
//=> 요청방식 이 Get -> doGet , Post -> doPost

//** url 매핑 네임
//=> url 배열 형태로 복수 선언가능
//=> 그러나 프로젝트 전체 기준 중복되면 안됨 : server Start 안됨. 
//=> 숫자, 한글 사용시 오류는 없으나 비추
//=> xml 로 설정가능 (web.xml 설정화일)
//=> @ , xml 모두 사용가능하지만 매핑네임 중복은 허용하지않음

@WebServlet("/hello")
public class Ex01_helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex01_helloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter()
//		.append("Served at: ")
//		.append(request.getContextPath())
//		.append("안녕하세요 Servlet !");
        // ** 출력문 (response 객체에 html 문서를 담아줌)
        // => 출력객체 생성 -> html 문서작성
        // => 한글처리 해야함 (출력객체 생성전에 해야함)
        response.setContentType("text/html; charset=UTF-8");
        // => 웹브라우져에게 처리할 데이터의 MIME 타입을 알려줌
        // => MIME : Multipurpose Internet Mail Extensionss
        // => 데이터 송.수신시 자료의 형식에 대한 정보 
        // => Jsp 의 page 디렉티브의 contentType 속성값과 동일
        
		PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h2 style='color:blue;'>** Hello Servlet **</h2>");
        out.print("<h3> => ContextPath : "+request.getContextPath()+"</h3>");
        out.print("<h3> => 여기는 doGet 메서드 입니다.</h3>");
        out.print("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//** Get
//- request 의 header 영역의 url 뒤에 쿼리스트링으로 전달,
//- 일반적으로 256 byte 이내로 크기제한이 있는 것으로 알려져 있으나,
//  이 용량은 브라우져 또는 장비에 따라 다를수 있음
//- 결론은 이미지 등 무거운 자료의 전송은 대부분 불가능 하므로 이때는 post로 해야함. 

//** Post
//- request 의 body 영역에 담겨져 전달됨
//- 크기제한 없음, 보안성 유리 

@WebServlet("/getpost")
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex03_GetPost() {
        super();
    }//기본생성자


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 의 parameter 처리
		// => getParameter("Parameter_name") , Parameter_name의 value를 String 타입으로 return.
		//	Parameter_name 에 해당하는  Parameter가 없다면 , null을 return => 오류가 일어나지 않음.
		//	Parameter_name 의 value 가 없다면 , null 이 아닌 빈문자열(= 값만 없음.).
		// 한글처리 , getParameter 전에 해야함.
        //        - Tomcat(WAS) 은 Get 방식요청에서는 "UTF-8" 을 default 로 적용함 
        //   ( html 문서에서 "UTF-8" 작성되었고 , Get 방식으로 전송되면 생략가능
        //     단, post 방식에서는 반드시 처리해야함 ) 
		request.setCharacterEncoding("UTF-8"); // 한글 처리
		
		String id = request.getParameter("id");
		String name = request.getParameter("name"); // getParameter
		String password = request.getParameter("password");
		if(password!=null && password.length()>0) {
			System.out.println("**password = "+password.toUpperCase());
		}else {
			System.out.println("**password is Null  , password is Empty");
		}
		
		// 2 . response 처리. 한글 처리먼저.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style='color:blue;'>** Get/Post Test **</h2>");
		out.print("<h3> => 전달된 Parameter 확인</h3>");
		out.print("<h3> => ID : " + id + "</h3>");
		out.print("<h3> => Name : " + name + "</h3>");
		out.print("</body></html>");
		
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("** do post **");
		doGet(request, response);
	}//doPost

}

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
//=> Factory 패턴 적용
// - ServiceFactory 필요
// - 개별 Controller 필요(일반적인 Java Class) 
// - 개별 컨트롤러는 일관성과 강제적인 규칙성을 위해 interface 사용.



@WebServlet(urlPatterns = {"*.fo"})
// => web.xml 에서 처리 가능.
public class Ex02_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_FrontController() {
        super();
    }//c

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getServletPath(); //요청명을 확인 -> 매핑네임을 확인.
		System.out.println("url : " +request.getRequestURL());
		System.out.println("uri : " +request.getRequestURI());
		System.out.println("uri : " +uri);
		
		// 서비스에 필요한 객체를 factory에 요청한다.
		Ex03_ServiceFactory serviceFactory =  Ex03_ServiceFactory.getInstance();
		
		//인터 페이스 형태의 컨트롤러를 factory를 통해 받도록 한다.
		Ex04_Controller cotroller = serviceFactory.getController(uri);
		uri = cotroller.doUser(request, response);
		
		
		request.getRequestDispatcher(uri).forward(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}//class

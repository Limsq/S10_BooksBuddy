package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberService;
import member.model.MemberVo;

/**
 * Servlet implementation class LoginDoController
 */
@WebServlet("/login.do")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("mid");
		String pw = request.getParameter("upw");
		System.out.println("###id:"+id);
		System.out.println("###pw:"+pw);
		MemberService service = new MemberService();
		MemberVo vo = service.login(id, pw);
		
		System.out.println("### login vo:"+ vo);
		request.getSession().setAttribute("ssInfo", vo);
		
		response.sendRedirect(request.getContextPath()+"/main");
				
	}

}

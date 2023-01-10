package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberVo;
import member.model.MemberService;

/**
 * Servlet implementation class JoinDoController
 */
@WebServlet("/join.do")
public class JoinDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinDoController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("id");
		String upw = request.getParameter("pw");
		String email = request.getParameter("email");
		MemberVo vo = new MemberVo();
		vo.setMid(mid);
		vo.setUpw(upw);
		vo.setEmail(email);
		
		System.out.println(vo);
		int result = new MemberService().insert(vo);
		if(result > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect(request.getContextPath()+"/login");
		}else {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath()+"/index");
		}
	}

}

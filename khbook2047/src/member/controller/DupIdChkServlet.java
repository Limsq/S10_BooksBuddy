package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import member.model.service.MemberService;

@WebServlet("/dupid.lo")
public class DupIdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DupIdChkServlet() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		MemberService mservice = new MemberService();
		int result = mservice.dupIdChk(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.append("fail"); // 만약 dupIdChk()의 결과값이 0 이상이면 'fail'
		} else {
			out.flush();
			out.close();
		}
	}
}

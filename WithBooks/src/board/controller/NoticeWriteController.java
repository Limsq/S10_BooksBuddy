package board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVo;
import board.model.BoardService;
import member.model.MemberVo;
/**
 * Servlet implementation class NoticeWriteController
 */
@WebServlet("/noticeWrite")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rpnoStr = request.getParameter("rpno");
		int rpno = 0;
		try {
			rpno = Integer.parseInt(rpnoStr);
			request.setAttribute("rpno", rpno);
			BoardVo vo = new BoardService().selectOne(rpno);
			request.setAttribute("board", vo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			String viewPath = "WEB-INF/view/board/write.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rptitle = request.getParameter("rptitle");
		String rpcontent = request.getParameter("rpcontent");
		String rpauthor = request.getParameter("rpauthor");
		String phrase = request.getParameter("phrase");
		String mid = request.getParameter("mid");
		
		BoardService service = new BoardService();
		BoardVo vo = new BoardVo();
		vo.setRptitle(rptitle);
		vo.setRpcontent(rpcontent);
		vo.setRpauthor(rpauthor);
		vo.setPhrase(phrase);
		vo.setMid(mid);
		
		String rpnoStr = request.getParameter("rpno");
		int rpno = 0;
		try {
			rpno = Integer.parseInt(rpnoStr);
		}catch(Exception e) {
		}
		
		int result = service.insert(vo);
		System.out.println(result);
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/notice");
		}else {
			request.setAttribute("msg", "게시글 등록에 실패하였습니다. 글쓰기를 다시 시도해주세요.");
			request.getRequestDispatcher("/WEB-INF/view/error/alert.jsp").forward(request, response);
		}
	}

}

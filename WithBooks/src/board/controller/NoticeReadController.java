package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import board.model.BoardVo;

/**
 * Servlet implementation class NoticeReadController
 */
@WebServlet("/noticeRead")
public class NoticeReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeReadController() {
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
			BoardVo vo = new BoardService().selectOne(rpno);
			request.setAttribute("board", vo);
		}catch (Exception e) {
			request.setAttribute("msg", "글을 읽어오는데 실패했습니다.\n 목록에서 다시 읽을 글을 선택해주세요.");
		} finally {
			String viewPath = "/WEB-INF/view/board/read.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
	}

}

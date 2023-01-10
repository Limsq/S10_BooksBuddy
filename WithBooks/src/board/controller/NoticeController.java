package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import board.model.BoardVo;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		final int pageSize = 10;
		final int pageBlock = 10;
		int cnt = 0;
		int pageCnt = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		
		try {
			if(cnt <1) {
				return;
			}
			try {
				currentPage = Integer.parseInt(request.getParameter("pagenum"));
			}catch(Exception e) {
				
			}
			pageCnt = (cnt/pageSize) + (cnt%pageSize==0 ? 0 : 1);
			if(currentPage%pageBlock ==0) {
				startPage = ((currentPage/pageBlock)-1)*pageBlock+1;
			}else {
				startPage = ((currentPage/pageBlock))*pageBlock+1;
			}
			endPage = startPage+pageBlock-1;
			if(endPage > pageCnt) {
				endPage = pageCnt;
			}
			int startRnum = (currentPage - 1)*pageSize + 1;
			int endRnum = startRnum + pageSize - 1;
			if(endRnum > cnt) {
				endRnum = cnt;
			}
			
			List<BoardVo> boardlist = new BoardService().selectList(startRnum, endRnum);
			request.setAttribute("boardlist", boardlist);
		} finally {
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			String viewPath = "WEB-INF/view/board/notice.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
	}

}

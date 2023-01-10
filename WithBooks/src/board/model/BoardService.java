package board.model;

import java.sql.Connection;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
//	insert
	public int insert(BoardVo vo) {
		System.out.println(">>>>BoardService Param : " + vo);
		int result = 0;		//insert, 0오류, 1정상
		Connection conn = JdbcTemplate.getConnection();
		JdbcTemplate.setAutoCommit(conn, false);
		if(vo.getRpno() != 0) { result = dao.insert(conn, vo); }
		if(result > 0) { JdbcTemplate.commit(conn); }
		else { JdbcTemplate.rollback(conn); }
		JdbcTemplate.close(conn);
		System.out.println(">>BoardService Return : " + result);
		return result;
	}
//	update
	public int update(BoardVo vo, int rpno) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, rpno);
		JdbcTemplate.close(conn);
		return result;
	}
//	delete
	public int delete(int rpno) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		
		result = dao.delete(conn, rpno);
		
		JdbcTemplate.close(conn);
		return result;
	}
//	selectList
	public List<BoardVo> selectList(int startRnum, int endRnum){
		List<BoardVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = dao.selectList(conn);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	public BoardVo selectOne(int rpno) {
		BoardVo vo =null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, rpno);
		JdbcTemplate.close(conn);
		return  vo;
	}
}

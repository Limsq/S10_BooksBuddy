package member.model;

import java.sql.Connection;
import java.util.List;

import static common.jdbc.JdbcTemplate.*;

public class MemberService {
	private MemberDao dao = new MemberDao();
	//insert
	public int insert(Members vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insert(conn, vo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//update
	public int update(Members vo, String uid) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.update(conn, vo, uid);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//delete
	public int delete(String uid) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.delete(conn, uid);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
//	목록조회
	public List<Members> selectList(){
		List<Members> volist = null;
		Connection conn = getConnection();
		volist = dao.selectList(conn);
		close(conn);
		return volist;
	}
//	상세조회
	public Members selectOne(String uid) {
		Members vo = null;
		Connection conn = getConnection();
		vo = dao.selectOne(conn, uid);
		close(conn);
		return vo;
	}
//	Login 상세조회
	public Members login(String uid, String upw) {
		Members vo = null;
		Connection conn = getConnection();
		vo=dao.login(conn, uid, upw);
		close(conn);
		return vo;
	}
}

package member.model;

import java.sql.Connection;
import java.util.List;

import static common.jdbc.JdbcTemplate.*;

public class MemberService {
	private MemberDao dao = new MemberDao();
	//insert
	public int insert(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insert(conn, vo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//update
	public int update(MemberVo vo, String mid) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.update(conn, vo, mid);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//delete
	public int delete(String mid) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.delete(conn, mid);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
//	목록조회
	public List<MemberVo> selectList(){
		List<MemberVo> volist = null;
		Connection conn = getConnection();
		volist = dao.selectList(conn);
		close(conn);
		return volist;
	}
//	상세조회
	public MemberVo selectOne(String mid) {
		MemberVo vo = null;
		Connection conn = getConnection();
		vo = dao.selectOne(conn, mid);
		close(conn);
		return vo;
	}
//	Login 상세조회
	public MemberVo login(String mid, String upw) {
		MemberVo vo = null;
		Connection conn = getConnection();
		vo=dao.login(conn, mid, upw);
		close(conn);
		return vo;
	}
}

package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class MemberDao {
	//insert 등록
	public int insert(Connection conn, Members vo) {
		int result = 0;
		return result;
	}
	//update 수정
	public int update(Connection conn, Members vo, String uid) {
		int result = 0;
		return result;
	}
	//delete 삭제
	public int delete(Connection conn, String uid) {
		int result=0;
		return result;
	}
	//selectList 목록조회
	public List<Members> selectList(Connection conn){
		List<Members> volist = null;
		
		return volist;
	}
	//selectOne 상세조회
	public Members selectOne(Connection conn, String uid) {
		Members vo = null;
		return vo;
	}
	//selectOne - login 상제조회
	public Members login(Connection conn, String uid, String upw) {
		Members vo = null;
		String query = "SELECT UID, EMAIL, JOINDATE FROM MEMBER WHERE UID=? AND UPW=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new Members();
				vo.setUid(rs.getString("uid"));
				vo.setEmail(rs.getString("email"));
				vo.setUpw(rs.getString("upw"));
				vo.setJoindate(rs.getDate("joindate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}
	
}
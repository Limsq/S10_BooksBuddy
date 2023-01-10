package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class MemberDao {
	//insert 등록
	public int insert(Connection conn, MemberVo vo) {
		int result = 0;
		return result;
	}
	//update 수정
	public int update(Connection conn, MemberVo vo, String mid) {
		int result = 0;
		return result;
	}
	//delete 삭제
	public int delete(Connection conn, String mid) {
		int result=0;
		return result;
	}
	//selectList 목록조회
	public List<MemberVo> selectList(Connection conn){
		List<MemberVo> volist = null;
		
		return volist;
	}
	//selectOne 상세조회
	public MemberVo selectOne(Connection conn, String mid) {
		MemberVo vo = null;
		return vo;
	}
	//selectOne - login 상제조회
	public MemberVo login(Connection conn, String mid, String upw) {
		System.out.println("###0"+mid);
		System.out.println("###0"+upw);
		MemberVo vo = null;
		String query = "SELECT MID, EMAIL,JOIN_DATE FROM MEMBER WHERE MID=? AND UPW=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			pstmt.setString(2, upw);
			rs = pstmt.executeQuery();
			System.out.println("###1");
			if(rs.next()) {
				System.out.println("###2");
				vo = new MemberVo();
				vo.setMid(rs.getString("MID"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setJoindate(rs.getDate("JOIN_DATE"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("###3"+vo);
		return vo;
	}
	
}
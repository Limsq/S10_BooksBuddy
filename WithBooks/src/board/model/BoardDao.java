package board.model;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class BoardDao {
//	insert
	public int insert(Connection conn, BoardVo vo) {
		System.out.println(">>>>BoardDao Param : "+ vo);
		int result = 0;
		
		String sql = "INSERT INTO REVIEW_POST (RP_NO, MID, RP_CONTENT, RP_TITLE, RP_AUTHOR, READ_DATE, REG_DATE, PHRASE, RP_READ_CHECK)";
		sql += " VALUES ((SELECT NVL(MAX(RP_NO),0)+1 FROM REVIEW_POST), ?,?,?,?,?,?,?,0";
		
		PreparedStatement pstmt = null;
		try {
			if(vo.getRpno()==0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  vo.getMid());
				pstmt.setString(2,  vo.getRpcontent());
				pstmt.setString(3,  vo.getRptitle());
				pstmt.setString(4,  vo.getRpauthor());
				pstmt.setDate(5,  vo.getReaddate());
				pstmt.setDate(6,  vo.getRegdate());
				pstmt.setString(7,  vo.getPhrase());
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>>BoardDao Return : " + result);
		return result;
	}
//	update 수정
	public int update(Connection conn, BoardVo vo, int rpno) {
		int result = 0;
		
		String sql = "UPDATE REVIEW_POST SET RP_TITLE=? RP_CONTENT=? RP_AUTHOR=? PHRASE=? READ_DATE=? WHERE RP_NO=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRptitle());
			pstmt.setString(2, vo.getRpcontent());
			pstmt.setString(3, vo.getRpauthor());
			pstmt.setString(4, vo.getPhrase());
			pstmt.setDate(5, vo.getReaddate());
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
//	delete 삭제
	public int delete(Connection conn, int rpno) {
		int result = 0;
		
		String sql = "DELETE FROM REVIEW_POST WHERE RP_NO=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rpno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
//	selectList 목록조회
	public List<BoardVo> selectList(Connection conn){
		List<BoardVo> volist = null;
		
		String sql = "SELECT * FROM REVIEW_POST";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				volist = new ArrayList<BoardVo>();
				do {
					BoardVo vo = new BoardVo();
					vo = new BoardVo();
					vo.setRpno(rs.getInt("rpno"));
					vo.setMid(rs.getString("mid"));
					vo.setRptitle(rs.getString("rptitle"));
					vo.setRpcontent(rs.getString("rpcontent"));
					vo.setRpauthor(rs.getString("rpauthor"));
					vo.setRegdate(rs.getDate("regdate"));
					vo.setReaddate(rs.getDate("readdate"));
					vo.setReadchk(rs.getInt("readchk"));
					vo.setPhrase(rs.getString("phrase"));
					volist.add(vo);
				}while(rs.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}
	public BoardVo selectOne(Connection conn, int rpno) {
		BoardVo result = null;
		String sql = "SELECT * FROM REVIEW_POST WHERE RP_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rpno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new BoardVo();
				result.setRpno(rs.getInt("rpno"));
				result.setMid(rs.getString("mid"));
				result.setRptitle(rs.getString("rptitle"));
				result.setRpcontent(rs.getString("rpcontent"));
				result.setRpauthor(rs.getString("rpauthor"));
				result.setRegdate(rs.getDate("regdate"));
				result.setReaddate(rs.getDate("readdate"));
				result.setReadchk(rs.getInt("readchk"));
				result.setPhrase(rs.getString("phrase"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	
}

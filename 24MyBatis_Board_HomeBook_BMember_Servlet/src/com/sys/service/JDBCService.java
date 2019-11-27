package com.sys.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.sys.common.MBUtils;
public class JDBCService {
	private Connection conn;
	public Map<String,Long> getMemberInfor(String memId) throws SQLException{
		Map<String,Long> map = new HashMap<>();
		conn = MBUtils.getSession().getConnection();
		long boardNum = 0;
		long homebookNum = 0;
		long revenueSum =0; 
		long expenseSum = 0; 
		PreparedStatement pstmt = null ;
		String sql = "SELECT COUNT(*) FROM BOARD WHERE MID=?"; 
		pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1,memId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			boardNum = rs.getLong(1);
		}
		sql = "SELECT COUNT(*) FROM HOMEBOOK WHERE USER_ID=?"; 
		pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1,memId);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			homebookNum = rs.getLong(1);
		}
		
		sql = "SELECT SUM(REVENUE),SUM(EXPENSE) FROM HOMEBOOK WHERE USER_ID=?"; 
		pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1,memId);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			revenueSum = rs.getLong(1);
			expenseSum = rs.getLong(2);
		}
		
		map.put("boardNum", boardNum);
		map.put("homebookNum", homebookNum);
		map.put("revenueSum", revenueSum);
		map.put("expenseSum", expenseSum);
		conn.close();
		return map;
	}
}
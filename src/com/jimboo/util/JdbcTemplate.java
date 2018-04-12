package com.jimboo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	/**²éÑ¯*/
	public <T> List<T> query(String sql,RowMapper<T> mapper,Object...objs){
		Connection conn = DBhelper.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			if(conn!=null) {
				pst  = conn.prepareStatement(sql);
			}
			for(int i=0;i<objs.length;i++) {
				pst.setObject(i+1, objs[i]);
			}
			rs=pst.executeQuery();
			List<T> list=new ArrayList<>();
			while (rs.next()) {
				list.add(mapper.getInstance(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBhelper.close(rs, pst, conn);
		}
		return null;
	}
	
	/**ÔöÉ¾¸Ä*/
	public int update(String sql,Object...objs) {
		Connection conn = DBhelper.getConn();
		PreparedStatement pst=null;
		try {
			if(conn!=null) {
				pst = conn.prepareStatement(sql);
				for(int i=0;i<objs.length;i++) {
					pst.setObject(i+1, objs[i]);
				}
				int i = pst.executeUpdate();
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBhelper.close(null, pst, conn);
		}
		return -1;
	}
	
	
}







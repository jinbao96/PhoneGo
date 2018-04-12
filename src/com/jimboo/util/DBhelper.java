package com.jimboo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBhelper {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	/**��������*/
	static {
		Properties prop=new Properties();
		InputStream is = DBhelper.class.getResourceAsStream("/source.properties");
		try {
			prop.load(is);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			pwd=prop.getProperty("pwd");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**��������*/
	public static Connection getConn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**�ر���Դ*/
	public static void close(ResultSet rs,Statement pst,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pst!=null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package cn.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.dao.DBConnection;

public class DBConnection {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	private Statement st = null;
	private ResultSet rs = null;

	static{
		loadConfig();
	}
	
	public static void loadConfig(){
		
		try {
			InputStream inStream = DBConnection.class.getResourceAsStream("/jdbc.properties");
			Properties prop = new Properties();
			prop.load(inStream);
			user = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("error",e);
		}
	}
	
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn == null){
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			}
			return conn;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

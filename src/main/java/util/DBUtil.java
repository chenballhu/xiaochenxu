package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	private static BasicDataSource ds;
	
	static{
		Properties p = new Properties();
		try{
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败",e);
		}
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		pwd = p.getProperty("pwd");
		
		ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pwd);
		
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("归还连接失败",e);
			}
		}
		else{
			throw new RuntimeException("没有建立连接");
		}
	}
	
	@Test
	public void test(){
		try {
			System.out.println(DBUtil.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(driver);
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(url);
	}
}

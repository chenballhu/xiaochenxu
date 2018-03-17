package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;
import util.DBUtil;

public class AdminDao {
	public Admin findAdminByName(String name){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from admin_list_yh where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			Admin admin = null;
			while(rs.next()){
				admin = new Admin();
				admin.setUserName(rs.getString("name"));
				admin.setPwd(rs.getString("pwd"));
			}
			return admin;
		}catch(SQLException e){
			throw new RuntimeException("查询管理员失败");
		}
	}
	
	
}

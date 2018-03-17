package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Student;
import util.DBUtil;

public class studentDao implements Serializable{
	
	private Student createStudent(ResultSet rs) throws SQLException {
		Student s = new Student();
		s.setDormNum(rs.getInt("dorm_num"));
		s.setStudentId(rs.getInt("student_id"));
		s.setRoomNum(rs.getInt("room_num"));
		s.setStudentName(rs.getString("student_name"));
		return s;
	}
	//����ȫ��ѧ��
	@Test
	public List<Student> findAll(){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from student_yh order by num";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student s = createStudent(rs);
				list.add(s);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("�������ݿ�ʧ��");
		}finally{
			DBUtil.close(conn);
		}
	}
	//����ѧ����Ϣ
	public void save(Student student){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into Student_yh values(student_seq_yh.nextval,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,student.getStudentId());
			ps.setString(2,student.getStudentName());
			ps.setInt(3,student.getDormNum());
			ps.setInt(4,student.getRoomNum());
			ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException("ѧ����Ϣд��ʧ��");
		}finally{
			DBUtil.close(conn);
		}
	}
	//ͨ��ѧ��Ѱ��ѧ��
	public Student findById(int id){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from student_yh where student_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return createStudent(rs);
			}
		}catch(SQLException e){
			throw new RuntimeException("ѧ����ϢѰ��ʧ��");
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//ͨ��ѧ��ɾ��ѧ�� 
	public void delectById(int id){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "delete from student_yh where student_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException("ѧ����Ϣɾ��ʧ��");
		}finally{
			DBUtil.close(conn);
		}
	
	}
	//�޸�ѧ����Ϣ
	public void modify(Student student){
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "update student_yh set student_id=?,student_name=?,dorm_num=?,room_num=? where student_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,student.getStudentId());
			ps.setString(2,student.getStudentName());
			ps.setInt(3,student.getDormNum());
			ps.setInt(4,student.getRoomNum());
			ps.setInt(5,student.getStudentId());
			ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException("�޸���Ϣʧ��");
		}finally{
			DBUtil.close(conn);
		}
	}
	
	
	@Test
	public void test(){
		List<Student> list=findAll();
		System.out.println(list);
	
	}
}
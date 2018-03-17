package web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.studentDao;
import entity.Admin;
import entity.Student;
import util.DBUtil;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/login.do".equals(path)){
			login(req,res);
		}else if("/find.do".equals(path)){
			find(req,res);
		}else if("/toLogin.do".equals(path)){
			toLogin(req,res);
		}else if("/deleteStudent.do".equals(path)){
			delectStudent(req,res);
		}else if("/addStudent.do".equals(path)){
			addStudent(req,res);
		}else if("/toAddStudent.do".equals(path)){
			toAdd(req,res);
		}else if("/toModify.do".equals(path)){
			toModify(req,res);
		}if("/toFind.do".equals(path)){
			toFind(req,res);
		}
		else if("/modify.do".equals(path)){
			modify(req,res);
		}
		else{
			throw new RuntimeException("ÎÞÐ§Â·¾¶");
		}
	}
	
	protected void find(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		studentDao dao = new studentDao();
		List<Student> list = dao.findAll();
		req.setAttribute("students",list);
		req.getRequestDispatcher("WEB-INF/student/find.jsp").forward(req, res);
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.sendRedirect("login.do");
		req.getRequestDispatcher("WEB-INF/index/login.jsp").forward(req, res);
	}
	
	protected void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		AdminDao dao = new AdminDao();
		Admin admin = dao.findAdminByName(userName);
		if(admin==null){
			req.setAttribute("error","µÇÂ½Ê§°Ü:ÕËºÅ´íÎó");
			req.getRequestDispatcher("WEB-INF/index/login.jsp").forward(req, res);
		}else if(!admin.getPwd().equals(pwd)){
			req.setAttribute("error","µÇÂ½Ê§°Ü:ÃÜÂë´íÎó");
			req.getRequestDispatcher("WEB-INF/index/login.jsp").forward(req, res);
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("userName",userName);
			studentDao dao1 = new studentDao();
			List<Student> list = dao1.findAll();
			req.setAttribute("students",list);
			req.getRequestDispatcher("WEB-INF/student/find.jsp").forward(req, res);
		}
		
	}
	
	protected void delectStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			int id = Integer.parseInt(req.getParameter("id"));
			new studentDao().delectById(id);
			studentDao dao1 = new studentDao();
			List<Student> list = dao1.findAll();
			req.setAttribute("students",list);
			req.getRequestDispatcher("WEB-INF/student/find.jsp").forward(req, res);
			//res.sendRedirect("find.do");
	}		
	
	protected void toAdd(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/student/add.jsp").forward(req, res);
		
	}
		
	
	protected void addStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		studentDao dao = new studentDao();
		Student student = new Student();
		student.setStudentId(Integer.parseInt(req.getParameter("studentId")));
		student.setStudentName(req.getParameter("studentName"));
		student.setDormNum(Integer.parseInt(req.getParameter("dormNum")));
		student.setRoomNum(Integer.parseInt(req.getParameter("roomNum")));
		dao.save(student);
		List<Student> list = dao.findAll();
		req.setAttribute("students",list);
		req.getRequestDispatcher("WEB-INF/student/find.jsp").forward(req, res);
	}
	
	protected void toModify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		studentDao dao = new studentDao();
		Student student = dao.findById(id);
		req.setAttribute("student",student);
		req.getRequestDispatcher("WEB-INF/student/modify.jsp").forward(req, res);
	}
	
	protected void modify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		studentDao dao = new studentDao();
		Student student = dao.findById(id);
		student.setStudentName(req.getParameter("studentName"));
		student.setRoomNum(Integer.parseInt(req.getParameter("roomNum")));
		student.setDormNum(Integer.parseInt(req.getParameter("dormNum")));
		dao.modify(student);
		res.sendRedirect("find.do");
	}
	
	protected void toFind(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("input");
		Student student = new studentDao().findById(Integer.parseInt(id));
		req.setAttribute("student",student);
		req.getRequestDispatcher("WEB-INF/student/toFind.jsp").forward(req, res);
	}
}

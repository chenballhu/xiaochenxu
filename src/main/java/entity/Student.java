package entity;

import java.io.Serializable;

public class Student implements Serializable {
	private Integer studentId;
	private String StudentName;
	private Integer dormNum;
	private Integer roomNum;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Integer getDormNum() {
		return dormNum;
	}
	public void setDormNum(Integer dormNum) {
		this.dormNum = dormNum;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	
}

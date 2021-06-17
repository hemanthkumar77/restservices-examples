package com.pack.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
public class studentdto 
{
   private int id;
   private String firstname;
   private String Lastname;
   private String deptname;
   public studentdto() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "studentdto [id=" + id + ", firstname=" + firstname + ", Lastname=" + Lastname + ", deptname=" + deptname
			+ ", gpa=" + gpa + ", age=" + age + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
public double getGpa() {
	return gpa;
}
public void setGpa(double gpa) {
	this.gpa = gpa;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
private double gpa;
   private int age;

	
}

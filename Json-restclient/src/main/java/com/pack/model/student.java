package com.pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="STUDENT_INFO",indexes= {@Index(columnList= "firstname"),@Index(columnList="Lastname")})
public class student
{
	@Id
	@Column(name="emp_id")
   private int id;
	@Column(columnDefinition="varchar(27)")
   private String firstname;
	@Column(columnDefinition="varchar(27)")
   private String Lastname;
	@Column(columnDefinition="varchar(14)")
   private String deptname;
	@Column(precision=1,scale=2)
   private double gpa;
   private int age;
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
@Override
public String toString() {
	return "student [id=" + id + ", firstname=" + firstname + ", Lastname=" + Lastname + ", deptname=" + deptname
			+ ", gpa=" + gpa + ", age=" + age + "]";
}
   
   
}

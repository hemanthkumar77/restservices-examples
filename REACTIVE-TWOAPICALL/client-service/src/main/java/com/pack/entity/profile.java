package com.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="client_info")
public class profile
{
	@Id
	@Column(columnDefinition="varchar(12)",name ="account_id")
     private String id;
	@Column(name="name")
     private String client_name;
	@Column(columnDefinition="varchar(7)")
     private String gender;
	@Column(name="salary")
     private double annual_income;
     private int age;

     
	public profile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getClient_name() {
		return client_name;
	}


	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public double getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(double annual_income) {
		this.annual_income = annual_income;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "profile [id=" + id + ", client_name=" + client_name + ", gender=" + gender + ", annual_income="
				+ annual_income + ", age=" + age + "]";
	}
     
     
}

package com.pack.model;



public class profile 
{
	     private String id;
	     private String client_name;
	     private String gender;
	     private double annual_income;
	     private int age;
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
		public profile() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "profile [id=" + id + ", client_name=" + client_name + ", gender=" + gender + ", annual_income="
					+ annual_income + ", age=" + age + "]";
		}
	     

}

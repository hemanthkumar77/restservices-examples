package com.pack.model;



public class accountdetails 
{
	    private String id;
		private String account_details;
		private double acoount_balance;
		private double creditcard_balances;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getAccount_details() {
			return account_details;
		}
		public void setAccount_details(String account_details) {
			this.account_details = account_details;
		}
		public double getAcoount_balance() {
			return acoount_balance;
		}
		public void setAcoount_balance(double acoount_balance) {
			this.acoount_balance = acoount_balance;
		}
		public double getCreditcard_balances() {
			return creditcard_balances;
		}
		public void setCreditcard_balances(double creditcard_balances) {
			this.creditcard_balances = creditcard_balances;
		}
		@Override
		public String toString() {
			return "accountdetails [id=" + id + ", account_details=" + account_details + ", acoount_balance="
					+ acoount_balance + ", creditcard_balances=" + creditcard_balances + "]";
		}
		public accountdetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}

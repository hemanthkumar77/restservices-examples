package com.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account_info")
public class accountdetails
{
	@Id
	@Column(columnDefinition="varchar(12)",name ="account_id")
    private String id;
	@Column(columnDefinition="varchar(27)",name="acc_details")
	private String account_details;
	@Column(name="balance")
	private double acoount_balance;
	@Column(name="credit_balances")
	private double creditcard_balances;
	@Override
	public String toString() {
		return "accountdetails [id=" + id + ", account_details=" + account_details + ", acoount_balance="
				+ acoount_balance + ", creditcard_balances=" + creditcard_balances + "]";
	}
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
	public accountdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}

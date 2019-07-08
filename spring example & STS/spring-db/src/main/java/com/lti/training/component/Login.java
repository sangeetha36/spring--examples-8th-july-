package com.lti.training.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_LOG")
public class Login {
	@Id
	@Column(name="ACNO")
	private int acNo;
	@Column(name="BALANCE")
  private double balance;
	@Column(name="NAME")
  private String name;
  @Column(name="ACC_TYPE")
  private String accType;
public int getAcNo() {
	return acNo;
}
public void setAcNo(int acNo) {
	this.acNo = acNo;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccType() {
	return accType;
}
public void setAccType(String accType) {
	this.accType = accType;
}

  
  

}

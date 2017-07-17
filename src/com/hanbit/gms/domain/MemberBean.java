package com.hanbit.gms.domain;

import java.io.Serializable;

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id, password, name, ssn, regdate;
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setSNN(String ssn){
		this.ssn = ssn;
	}
	public String getSSN(){
		return ssn;
	}
	
	public String toString(){
		return String.format("ID : %s, PW : %s, NAME : %s SSN : %s , REGDATE : %s \n ", id,password,name,ssn,regdate);
	}
}

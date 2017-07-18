package com.hanbit.gms.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import com.hanbit.gms.constant.DB;

//모든 객체 인터페이스로 통신
public class DatabaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String driver,url,user,password;
	private Connection connection;
	public DatabaseBean(String dirver, String url, String user, String password) {
		this.driver = dirver;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public Connection getConnection(){
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}

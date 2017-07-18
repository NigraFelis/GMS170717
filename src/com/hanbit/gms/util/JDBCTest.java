package com.hanbit.gms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.gms.constant.DB;

public class JDBCTest {
	public static void main(String[] args) {
		String findName="";
		Connection conn=null;
		try {
			Class.forName(DB.ORDRIVER);
			conn=DriverManager.getConnection(DB.ORURL,DB.USERNAME,DB.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM Member WHERE id='hong'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){ //있으면 돌린다
				findName=rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("###결과 :" +findName);
	}
}

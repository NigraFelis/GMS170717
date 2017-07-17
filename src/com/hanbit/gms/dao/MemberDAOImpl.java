package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO{

	public MemberDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (Exception e) {
			System.out.println("load fail");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberBean bean) {
		int rs=0;
		try {
			rs= DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s', '%s', '%s', '%s', SYSDATE)", 
					DB.TABLE_MEMBER,
					DB.MEMBER_ID,DB.MEMBER_NAME,DB.MEMBER_PASS,DB.MEMBER_SSN,DB.MEMBER_REGDATE,
					bean.getId(),bean.getName(),bean.getPassword(),bean.getSSN()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list = new ArrayList<>();
		MemberBean member=null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
				String.format("SELECT * From %s", DB.TABLE_MEMBER));
				while(rs.next()){
					member = new MemberBean();
					member.setId(rs.getString(DB.MEMBER_ID));
					member.setName(rs.getString(DB.MEMBER_NAME));
					member.setPassword(rs.getString(DB.MEMBER_PASS));
					member.setSNN(rs.getString(DB.MEMBER_SSN));
					member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
					list.add(member);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean>list = new ArrayList<>();
		MemberBean member=null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(
				String.format("SELECT * From %s WHERE NAME='"+name+"'", DB.TABLE_MEMBER));
				while(rs.next()){
					member = new MemberBean();
					member.setId(rs.getString(DB.MEMBER_ID));
					member.setName(rs.getString(DB.MEMBER_NAME));
					member.setPassword(rs.getString(DB.MEMBER_PASS));
					member.setSNN(rs.getString(DB.MEMBER_SSN));
					list.add(member);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		
		try {
			Connection conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member WHERE id='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				member.setSNN(rs.getString(DB.MEMBER_SSN));
				System.out.println(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return member;
	}

	@Override
	public int count() {
		//SELECT COUNT(*) AS count FROM Member;
		int count=0;
		try {
			/*String sql = "SELECT COUNT(*) AS count FROM Member";*/
			ResultSet rs2 = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("SELECT %s(*) AS count FROM %s", "count", DB.TABLE_MEMBER));
			if(rs2.next()){
				count = Integer.parseInt(rs2.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	@Override
	public int update(MemberBean member) {
		int rs=0;
		try {
			String sql ="UPDATE MEMBER SET NAME='"+member.getName()+"',PASSWORD='"+member.getPassword()+"',SSN='"+member.getSSN()+"' WHERE ID='"+member.getId()+"'";
			rs= DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public int delete(String id) {
		int rs=0;
		try {
			rs= DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("DELETE FROM %s WHERE ID='"+id+"'", DB.TABLE_MEMBER)
					//String.format("SELECT * From %s WHERE NAME='"+name+"'", DB.TABLE_MEMBER));
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}

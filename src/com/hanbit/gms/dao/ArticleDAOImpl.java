package com.hanbit.gms.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO{

	public ArticleDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String insert(ArticleBean bean) {
		// TODO Auto-generated method stub
		String rs ="";
		String sql ="INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)VALUES(article_seq.nextval,'"+bean.getId()+"','"+bean.getTitle()+"','"+bean.getContent()+"',0,SYSDATE)";
		try {
			rs=String.valueOf(DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(sql));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		String sql ="SELECT * FROM Board";
		try {
			ResultSet rs= DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(sql);
			while(rs.next()){
				bean = new ArticleBean();
				bean.setId(rs.getString("id")); 
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setHitcount(Integer.parseInt(rs.getString("hitcount")));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		String sql ="SELECT * FROM Board WHERE ID ='"+id+"'";
		try {
			ResultSet rs= DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(sql);
			while(rs.next()){
				bean = new ArticleBean();
				bean.setId(rs.getString("id")); 
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setHitcount(Integer.parseInt(rs.getString("hitcount")));
				list.add(bean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = null;
		String sql ="SELECT * FROM Board WHERE ARTICLE_SEQ ='"+seq+"'";
		try {
			ResultSet rs= DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(sql);
			while(rs.next()){
				bean = new ArticleBean();
				bean.setId(rs.getString("id")); 
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setHitcount(Integer.parseInt(rs.getString("hitcount")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public int count() {
		int count=0;
		try {
			String sql = "SELECT COUNT(*) AS count FROM BOARD";
			ResultSet rs2 = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(sql);
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
	public String update(ArticleBean bean) {
		//ArticleBean bean = new ArticleBean();
		String rs ="0";
		try {
			String sql = "UPDATE BOARD SET TITLE= '"+bean.getTitle()+"', CONTENT='"+bean.getContent()+"', REGDATE = SYSDATE WHERE ARTICLE_SEQ='"+bean.getArticleSeq()+"'";
			rs=String.valueOf(DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(sql));
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String remove(String seq) {
		String rs="";
		try {
			String sql = "DELETE FROM BOARD WHERE ARTICLE_SEQ='"+seq+"'";
			rs =String.valueOf(DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(sql));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
}

package com.hanbit.gms.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO{

	public static ArticleDAOImpl instance = new ArticleDAOImpl();
	public static ArticleDAOImpl getInstanse(){
		return instance;
	}
	
	private ArticleDAOImpl(){}
	
	@Override
	public String insert(ArticleBean bean) {

		String rs ="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, "0");
			rs = String.valueOf(pstmt.executeUpdate());
			
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
		try {
			PreparedStatement pstmt = DriverManager.getConnection(DB.ORURL,DB.USERNAME,DB.PASSWORD).prepareStatement(SQL.BOARD_LIST);
			ResultSet rs = pstmt.executeQuery();
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
			ResultSet rs= DriverManager.getConnection(DB.ORURL,DB.USERNAME,DB.PASSWORD).createStatement().executeQuery(sql);
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
			ResultSet rs= DriverManager.getConnection(DB.ORURL,DB.USERNAME,DB.PASSWORD).createStatement().executeQuery(sql);
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
			ResultSet rs2 = DriverManager.getConnection(DB.ORURL, DB.USERNAME, DB.PASSWORD).createStatement().executeQuery(sql);
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
		/*String rs ="0";
		try {
			String sql = "UPDATE BOARD SET TITLE= '"+bean.getTitle()+"', CONTENT='"+bean.getContent()+"' WHERE ARTICLE_SEQ='"+bean.getArticleSeq()+"'";
			rs=String.valueOf(DriverManager.getConnection(DB.ORURL, DB.USERNAME, DB.PASSWORD).createStatement().executeUpdate(sql));
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;*/
		ArticleBean temp = selectBySeq(String.valueOf(bean.getArticleSeq()));
		String title =(bean.getTitle().equals(""))?temp.getTitle():bean.getTitle();
		String content =(bean.getContent().equals(""))?temp.getContent():bean.getContent();
		String rs="";
		try {
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bean.getArticleSeq());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
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
			rs =String.valueOf(DriverManager.getConnection(DB.ORURL, DB.USERNAME, DB.PASSWORD).createStatement().executeUpdate(sql));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
}

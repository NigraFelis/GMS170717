package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{

	@Override
	public String write(ArticleBean bean) {
		
		return(ArticleDAOImpl.getInstanse().insert(bean).equals("1"))?"succes":"fail";
	}

	@Override
	public List<ArticleBean> list() {
		
		return ArticleDAOImpl.getInstanse().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		
		return ArticleDAOImpl.getInstanse().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstanse().selectBySeq(seq);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstanse().count();
	}

	@Override
	public String modify(ArticleBean bean) {
		// TODO Auto-generated method stub
		return (ArticleDAOImpl.getInstanse().update(bean).equals("1"))?"succes":"fail";
	}

	@Override
	public String remove(String seq) {
		// TODO Auto-generated method stub
		return (ArticleDAOImpl.getInstanse().remove(seq).equals("1"))?"succes":"fail";
	}

	

}
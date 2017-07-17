package com.hanbit.gms.service;


import java.util.List;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	int count;
	
	MemberBean member;
	MemberBean[] list;
	public MemberServiceImpl(){
		count=0;
		member = new MemberBean();
		list = new MemberBean[count];
	}
	
	@Override
	public String addMember(MemberBean bean) {
		return(new MemberDAOImpl().insert(bean)==1)?"succes":"fail";
	}

	@Override
	public List<MemberBean> getMembers() {
		
		return new MemberDAOImpl().selectAll();
	}

	@Override
	public int countMembers() {
		return new MemberDAOImpl().count();
	}

	
	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		
		MemberDAO dao = new MemberDAOImpl();
		member = dao.selectById(id);
	
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		
		return new MemberDAOImpl().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
		return(new MemberDAOImpl().update(bean)==1)?"succes":"fail";	
	}
	
	@Override
	public String remove(String id) {
		return(new MemberDAOImpl().delete(id)==1)?"succes":"fail";
	}
	
		
		
}


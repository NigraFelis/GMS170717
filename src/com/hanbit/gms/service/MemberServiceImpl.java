package com.hanbit.gms.service;


import java.util.List;

import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImpl implements MemberService {
public static MemberServiceImpl instance = new MemberServiceImpl();
	
	public MemberServiceImpl getInstance() {
		return instance;
	}
	private MemberServiceImpl(){}
	
	@Override
	public String addMember(MemberBean bean) {
		return(MemberDAOImpl.getInstance().insert(bean)=="1")?"succes":"fail";
	}

	@Override
	public List<MemberBean> getMembers() {
		
		return MemberDAOImpl.getInstance().selectAll();
	}

	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().count());
	}

	
	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
		return(MemberDAOImpl.getInstance().update(bean)=="1")?"succes":"fail";	
	}
	
	@Override
	public String remove(String id) {
		return(MemberDAOImpl.getInstance().delete(id)=="1")?"succes":"fail";
	}
	
		
		
}


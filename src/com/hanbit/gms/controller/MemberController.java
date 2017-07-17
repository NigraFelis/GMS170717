package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.service.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		//MemberDAO service2 = new MemberDAOImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.COUNT,Butt.FIND_SEQ,Butt.FIND_ID,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch ((Butt) JOptionPane.showInputDialog(null,
					"MEMBER ADMIN",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					buttons,
					buttons[1]
					)){
			case EXIT:
				return;
			case ADD:
				member = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("name/id/pass/snn").split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPassword(arr[2]);
				member.setSNN(arr[3]);
				JOptionPane.showMessageDialog(null, service.addMember(member));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers());
				break flag;

			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null,(service.findById(JOptionPane.showInputDialog("insert id"))).toString());
				break flag;

			case FIND_SEQ:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("insert find name")));				
				break flag;

			case UPDATE:
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("insert find id"));
				member.setPassword(JOptionPane.showInputDialog("비번"));
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setSNN(JOptionPane.showInputDialog("SSN"));
				JOptionPane.showMessageDialog(null, service.modify(member));
				break flag;
			case DEL:
				member = new MemberBean();
				JOptionPane.showMessageDialog(null, service.remove(JOptionPane.showInputDialog("insert delete id")));
				break flag;
			}
		}while (true);
	}
}

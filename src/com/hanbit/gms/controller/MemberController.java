package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberController {
	public static void main(String[] args) {
		//MemberService service = new MemberServiceImpl();
		//MemberDAO service2 = new MemberDAOImpl();
		MemberBean member = null;
		Butt[] buttons={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch ((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN",//frame title
					"SELECT MENU",//order
					JOptionPane.QUESTION_MESSAGE,//type
					null,//icon
					buttons,//Array of choices
					buttons[1]//default
					)) {
			case EXIT:
				return;
			case ADD:
				member = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("name/id/pass/snn").split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPassword(arr[2]);
				member.setSNN(arr[3]);
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().insert(member));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().count());
				break flag;

			case LIST:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().selectAll());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null,(MemberDAOImpl.getInstance().selectById(JOptionPane.showInputDialog("insert id"))).toString());
				break flag;

			case FIND_NAME:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().selectByName(JOptionPane.showInputDialog("insert find name")));				
				break flag;

			case UPDATE:
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("insert find id"));
				member.setPassword(JOptionPane.showInputDialog("비번"));
				//member.setName(JOptionPane.showInputDialog("이름"));
				//member.setSNN(JOptionPane.showInputDialog("SSN"));
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().update(member));
				break flag;
			case DEL:
				member = new MemberBean();
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().delete(JOptionPane.showInputDialog("insert delete id")));
				break flag;
			default:
				break;
			}
		}while (true);
	}
}

package com.hanbit.gms.controller;

import javax.swing.JOptionPane;
import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.service.ArticleServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		ArticleBean bean = null;
		ArticleService service = new ArticleServiceImpl();
		//List<ArticleBean> list = null;
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
				bean = new ArticleBean();
				String arry[] = JOptionPane.showInputDialog("id/title/content").split("/");
				bean.setId(arry[0]);
				bean.setTitle(arry[1]);
				bean.setContent(arry[2]);
				
				JOptionPane.showMessageDialog(null, service.write(bean));
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("insert id")));
				break flag;
			case FIND_SEQ:
				JOptionPane.showMessageDialog(null, service.findBySeq(JOptionPane.showInputDialog("insert seq")).toString());
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.count());
				break flag;
			case UPDATE:
				bean = new ArticleBean();
				//bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("insert seq")));
				String arry1[] = JOptionPane.showInputDialog("seq/title/content").split("/");
				bean.setArticleSeq(Integer.parseInt(arry1[0]));
				bean.setTitle(arry1[1]);
				bean.setContent(arry1[2]);
				JOptionPane.showMessageDialog(null, service.modify(bean));
				break flag;
			case DEL:
				bean = new ArticleBean();
				
				JOptionPane.showMessageDialog(null, service.remove(JOptionPane.showInputDialog("insert seq")));
				break flag;
			}
		}while (true);
	}
}

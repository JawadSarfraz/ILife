package controller;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import view.LoginBean;

public class LoginNgoController {

private static SessionFactory factory;	
	
	private LoginBean getLoginBean(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (LoginBean) facesContext.getApplication()
		    .getVariableResolver().resolveVariable(facesContext, "loginBean");	
	}
	
	public int checkLogin(){
		HibernateConfig hb = new HibernateConfig();
		
		//create session
		Session session = hb.createSessionFactory().withOptions().openSession();
	
			
		LoginBean loginBean = getLoginBean();
	/*	String email = signupBean.getEmail();
		String password = signupBean.getPassword();*/
		org.hibernate.Transaction tx = null;
		
		try{
			
		tx = session.beginTransaction();
		String hql = "select * from ngo log where log.email='"+loginBean.getEmail()+"' AND log.password='"+loginBean.getPassword()+"'";
		ArrayList abc = (ArrayList) session.createSQLQuery(hql).list();
		
		/*query.setParameter("email", loginBean.getEmail());
		query.setParameter("password",loginBean.getPassword());*/
		
//		int rows = query.executeUpdate();
		int rows = abc.size();
		if(rows != 0){
			ViewPostEvent viewPostEvent = new ViewPostEvent();
			viewPostEvent.init();
			return 1;//direct to nice page
		}
		else{
			return 0;//redirect to same page
		}
	      }catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return 0;
	}
}

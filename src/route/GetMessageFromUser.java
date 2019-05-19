package route;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.mysql.jdbc.StringUtils;

import controller.HibernateConfig;
import view.LoginBean;


public class GetMessageFromUser {

	public void callGcm(String location){
		
		HibernateConfig hb = new HibernateConfig();
		
		//create session
		Session session = hb.createSessionFactory().withOptions().openSession();

		org.hibernate.Transaction tx = null;
		//In location we saved city
		String getUserOfThatLocation = "Select * from users where location ='"+location+"'";
		ArrayList userAtThatLoc = (ArrayList) session.createSQLQuery(getUserOfThatLocation).list();
		try{
			
		}catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
		final String GCM_API_KEY = "AIzaSyCDcOrmN0NKzZb_2DlTDRUY8TW2_8WERU0";
	    final int retries = 3;
	    final String notificationToken = "dgs7Fvb_llU:APA91bGoRE17qVKwfvPnqqEIkzQSVwBBHJjaQw_DbwrKEW7ZicOcvFNo56ioVZcG0t4MuX6Cf2vY2AFf29efdHtr0qTlb2NTixFESCCxRvna04LE1gSX1FrIy-ats0R4LUm3VsCCkqJJ";
	    Sender sender = new Sender(GCM_API_KEY);
	    String message = "hi";
	    Message msg = new Message.Builder().addData("message", message).build();
	    Message msg2 = new Message.Builder().build();
	    try {
	                Result result = sender.send(msg, notificationToken, retries);

	                if (StringUtils.isNullOrEmpty(result.getErrorCodeName())) {
	                }   
	    	} catch (IOException e) {e.printStackTrace();
	    }
	}	
} 
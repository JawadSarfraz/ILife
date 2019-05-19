package controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;

import model.Location;
import model.Message;

public class MessageController {

	public void receiveMessage(Message getMessageObj,Location getLocationObj){
		String temp = "help";
		if(temp.equals("help")){
			HibernateConfig hb = new HibernateConfig();
			
			//create session
			Session session = hb.createSessionFactory().withOptions().openSession();
			
			org.hibernate.Transaction tx = null;
			tx = session.beginTransaction();
			
			String city = "isb";
			String country = "pak";
			String sector = "i-8";
			//get location where disastor occur from database
			String hql = "Select * from location loc where loc.city='"+getLocationObj.getCity()+"' AND loc.country='"+getLocationObj.getCountry()+"' AND loc.sector='"+getLocationObj.getSector()+"'";
			List<Object[]> result = session.createSQLQuery(hql).list();
			
			if(result.size()!= 0){
				
				//send message to desired stuff...
				// get id of the NGos
				for(Object[] rs :result){
					//get NGO jin jin ko msg bhejna h
						String getNgo = "Select * from ngo where ngoLocation='" +(int)rs[0] +"'";
					
					List<Objects[]> entities = session.createSQLQuery(getNgo).list();
					//time to send one by one text to the android device
					
						for (Object[] entity : entities) {
							String getNgoNumber = (String) entity[4];
							//send this message ro respective Ngo's
							
							//entity[4],Similar done by messenger like,, messenger timely check the updates...							
					}
				}
			}
			else{
				//redirect to same page
			}
		}
		else{
			
		}
	}
}


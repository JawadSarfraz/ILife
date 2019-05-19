package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Event;
import model.EventLocation;
import model.Location;


@ManagedBean
@SessionScoped
public class ViewPostEvent {
	private static SessionFactory factory;	
	
	private EventBean getEventBean(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (EventBean) facesContext.getApplication()
		    .getVariableResolver().resolveVariable(facesContext, "eventBean");	
	}
	
    public void init() {
	HibernateConfig hb = new HibernateConfig();
		
		//create session
		Session session = hb.createSessionFactory().withOptions().openSession();
	/*	String email = signupBean.getEmail();
		String password = signupBean.getPassword();*/
		org.hibernate.Transaction tx = null;

		try{
			
		tx = session.beginTransaction();
		String hql = "select * from event";
		List<Object[]> result = session.createSQLQuery(hql).list();
		
		/*query.setParameter("email", loginBean.getEmail());
		query.setParameter("password",loginBean.getPassword());*/
		EventBean eventBean = getEventBean();
//		int rows = query.executeUpdate();
		List<EventLocation> eventLocationList = new ArrayList<EventLocation>();
		int rows = result.size();
		if(rows>0){
			for(Object[] rs :result){
				//get location id from eventLocation
				String locId = "select * from eventLocation where eventId = '"+(int)rs[0]+"'";
				List<Object[]> obj = session.createSQLQuery(locId).list();
				
				for(Object[] loc :obj){
					//get location stuff
					String eventLocation = "select * from location where id = '"+(int)loc[2]+"'";
					List<Object[]> el = session.createSQLQuery(eventLocation).list();
					
					Event event = new Event();
					
					event.setId((Integer)rs[0]);
					event.setName((String)rs[1]);
					event.setType((String)rs[2]);
					event.setDescription((String)rs[3]);
					
					
					for(Object[] ELocation : el){
						Location location = new Location();
						location.setId((Integer)ELocation[0]);
						location.setCity((String)ELocation[1]);
						location.setCountry((String)ELocation[3]);
						location.setSector((String)ELocation[2]);
//						((EventLocation) eventLocationList).setEvent(event);
						EventLocation eventLocationObj = new EventLocation();
						
						eventLocationObj.setId((int)loc[0]);
						eventLocationObj.setEvent(event);
						eventLocationObj.setLocation(location);
						eventLocationList.add(eventLocationObj);
					}
					
				}
			}
			eventBean.setEventLocationList(eventLocationList);
		}
		
    }catch (Exception e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
	
	/*public void postToView(){
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("mypage.html"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		String content = contentBuilder.toString();
}*/
    }
}
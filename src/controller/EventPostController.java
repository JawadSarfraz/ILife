package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Event;
import model.EventLocation;
import model.Location;
import route.GetMessageFromUser;

@ManagedBean(name = "eventPostController")
@RequestScoped

public class EventPostController {

private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	private EventPostBean EventPostBean() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (EventPostBean) facesContext.getApplication()
		    .getVariableResolver().resolveVariable(facesContext, "eventPostBean");
	}
	
	public void add(){
		HibernateConfig hibernate = new HibernateConfig();
		//create session
		Session session = hibernate.createSessionFactory().withOptions().openSession();
		
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         EventPostBean eventPostBean = EventPostBean();
	         Location location = new Location();
	         location.setCity(eventPostBean.getCity());
	         location.setCountry(eventPostBean.getCountry());
	         location.setSector(eventPostBean.getSector());
	         
	         
	         session.saveOrUpdate(location);
	         
	         Event event = new Event();
	         event.setName(eventPostBean.getName());
	         event.setDescription(eventPostBean.getDescription());
	         event.setType(eventPostBean.getType());
	         
	         session.saveOrUpdate(event);
	         //use Email not location,set location for ngolocation table
	         //location SET (Y) 
	         EventLocation eventLocation = new EventLocation();
	         eventLocation.setEvent(event);
	         eventLocation.setLocation(location);
	         session.saveOrUpdate(eventLocation);
	         //ngo+location dono ka many to many ka realation ko catter karna h here...
	         //need to work on both place INDEED MANY TO MANY KA RELATION KO CATER MARNA H...
	         
	         //get Location id from location table by querying the city,sector name
/*	         location.setCity(signupBean.getCity());
	         location.setSector(signupBean.getSector());
	         
	         
	         //
	         Location location1 = new Location();
	         location1.setCity(signupBean.getCity());
	         location1.setSector(signupBean.getSector());
	         
	         Set<Location> locations = new HashSet<Location>();
	         locations.add(location);
	         ngo.setCategories(locations);
	         
	         session.save(location);
*/	         
	         //ngoLocation.setLocation(location);
	         //ngoLocation.setNgo(ngo);
	         
	         //session.saveOrUpdate(ngoLocation);
	         
	         /*
	         String sql = "SELECT * FROM Location WHERE Name = "+signupBean.getLocation();
	         Query query = session.createQuery(sql);*/
/*	         query.executeUpdate();	    
	        
	         ngoSignUp.setEmail(signupBean.getLocation());
	         
	         // ngoSignUp.setMobileNo(signupBean.getPhoneno());
	         
	         session.saveOrUpdate(ngoSignUp);
*/	         
	         GetMessageFromUser getMessageFromUser = new GetMessageFromUser();
	         getMessageFromUser.callGcm();
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	public void deleteEventLocation(Integer eventLocationId) {
		//
		HibernateConfig hibernate = new HibernateConfig();
		//create session
		Session session = hibernate.createSessionFactory().withOptions().openSession();
		
		Transaction tx = null;
		try{
		        tx = session.beginTransaction();
		        
		        String eventLocationDeleteQueryString = "delete from eventlocation el WHERE el.id = "+eventLocationId;
		        session.createQuery(eventLocationDeleteQueryString).executeUpdate();
		        
			    tx.commit();
		    }catch (HibernateException e) {
		       if (tx!=null) tx.rollback();
		       e.printStackTrace(); 
		    }finally {
		       session.close(); 
	    }
	
	}
}
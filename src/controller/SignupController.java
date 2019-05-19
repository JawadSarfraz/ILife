package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.*;
@ManagedBean(name = "signupController")
@RequestScoped
public class SignupController {
	private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	private SignupBean getSignupBean() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (SignupBean) facesContext.getApplication()
		    .getVariableResolver().resolveVariable(facesContext, "signupBean");
	}
	
	public String add(){
		
		HibernateConfig hibernate = new HibernateConfig();
		//create session
		Session session = hibernate.createSessionFactory().withOptions().openSession();
		
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         SignupBean signupBean = getSignupBean();
	         Location location = new Location();
	         location.setCity(signupBean.getCity());
	         location.setCountry(signupBean.getCountry());
	         location.setSector(signupBean.getSector());
	         
	         
	         session.saveOrUpdate(location);
	         
	         Ngo ngo = new Ngo();
	         ngo.setName(signupBean.getName());
	         ngo.setPassword(signupBean.getPassword());
	         ngo.setPhoneNumber(signupBean.getPhoneno());
	         ngo.setEmail(signupBean.getEmail());
	         
	         
	         session.saveOrUpdate(ngo);
	         //use Email not location,set location for ngolocation table
	         //location SET (Y) 
	         NgoLocation ngoLocation = new NgoLocation();
	         ngoLocation.setNgo(ngo);
	         ngoLocation.setLocation(location);
	         session.saveOrUpdate(ngoLocation);
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
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return "congratulation";
	}
	
}
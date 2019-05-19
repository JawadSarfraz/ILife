package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateConfig {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry1;
	public static SessionFactory createSessionFactory(){
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry1 = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry1);
	    return sessionFactory;
	}
}

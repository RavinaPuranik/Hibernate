package test;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Client {

	public static void main(String[] args) {
		try {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Tables created");
		sf.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
 
	}

}

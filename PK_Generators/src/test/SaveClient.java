package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.BookMovie;
;

//save data

public class SaveClient {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		BookMovie m=new BookMovie();
		m.setMovie("pk");
		m.setSeatno(21);
		m.setShowtime("10pm");
		
		int pk=(Integer)s.save(m);
		System.out.println(pk);
		
		t.commit();//query executed here
		s.close();
		sf.close();
		
		System.out.println("data inserted");
		
		
		
		
 
	}

}

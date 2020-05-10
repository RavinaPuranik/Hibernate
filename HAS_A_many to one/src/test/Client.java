package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Actor;
import beans.Movies;


public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Actor a=new Actor();
		a.setAid(1);
		a.setAname("srk");
		
		Movies m1=new Movies();
		m1.setMid(1);
		m1.setMname("k3g");
		m1.setActor(a);
		
		Movies m2=new Movies();
		m2.setMid(2);
		m2.setMname("ddlj");
		m2.setActor(a);
		
		
		s.save(m1);
		s.save(m2);
		s.save(a);
		t.commit();
		s.close();
		sf.close();

	}

}

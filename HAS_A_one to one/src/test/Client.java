package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Vote;
import model.Voter;


public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Voter v=new Voter();
		v.setVid(111);
		v.setVname("abc");
		v.setVage(25);
		
		Vote v1=new Vote();
		v1.setPname("bdp");
		v1.setCdate(new Date());
		v1.setVoter(v);
		
//		Vote v2=new Vote();
//		v2.setPname("bdp");
//		v2.setCdate(new Date());
//		v2.setVoter(v);
		
		s.save(v);
		s.save(v1);
		//s.save(v2);
		t.commit();
		s.close();
		sf.close();

	}

}

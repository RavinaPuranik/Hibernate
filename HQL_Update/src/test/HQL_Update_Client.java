package test;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class HQL_Update_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		//String hql="update Student set name='pqr',email='pqr@gmail.com' where id=111";
		String hql="update Student set id=222 where id=111";
		Query q=s.createQuery(hql);
		System.out.println("Rows updated: "+q.executeUpdate());
		t.commit();
		s.close();
		sf.close();

	}

}

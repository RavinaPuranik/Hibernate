package test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Course;
import model.Faculty;



public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Course c1=new Course();
		c1.setCid(1);
		c1.setCname("java");
		c1.setFee(2000);
		
		Course c2=new Course();
		c2.setCid(2);
		c2.setCname("hibernate");
		c2.setFee(1500);
		
		Course c3=new Course();
		c3.setCid(3);
		c3.setCname("spring");
		c3.setFee(3000);
		
		Course c4=new Course();
		c4.setCid(4);
		c4.setCname("angular");
		c4.setFee(3500);
		
		Set<Course> cset1=new HashSet<Course>();
		cset1.add(c1);
		cset1.add(c2);
		
		Set<Course> cset2=new HashSet<Course>();
		cset2.add(c2);
		cset2.add(c3);
		cset2.add(c4);
		
		Faculty f1=new Faculty();
		f1.setFid(1);
		f1.setFname("a");
		f1.setYearex(2);
		f1.setCourses(cset1);
		
		Faculty f2=new Faculty();
		f2.setFid(2);
		f2.setFname("b");
		f2.setYearex(4);
		f2.setCourses(cset2);
		
		
		s.saveOrUpdate(f1);
		s.saveOrUpdate(f2);
		s.saveOrUpdate(c1);
		s.saveOrUpdate(c2);
		s.saveOrUpdate(c3);
		s.saveOrUpdate(c4);
		t.commit();
		s.close();
		sf.close();

	}

}

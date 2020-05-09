package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;


public class SelectUsingProjections_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Criteria c=s.createCriteria(Employee.class);
		/*Projection p=Projections.property("name");
		
		c.setProjection(p);
		List<String> list=c.list();
		for(String name:list) {
			System.out.println(name);
		
		}
		*/
		
      Projection p1=Projections.property("name");
      Projection p2=Projections.property("email");
      ProjectionList plist=Projections.projectionList();
      plist.add(p1);
      plist.add(p2);
		c.setProjection(plist);
		List<Object[]> list=c.list();
		for(Object ar[]:list) {
			System.out.println(ar[0]);
			System.out.println(ar[1]);
		
		}
		s.close();
		sf.close();

	}

}

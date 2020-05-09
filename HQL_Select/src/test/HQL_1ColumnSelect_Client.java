package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Employee;

public class HQL_1ColumnSelect_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		/*String hql="select name from Employee";
		Query q=s.createQuery(hql);
		List<String> list=q.list();
		for(String name:list)
			System.out.println(name);
		
		*/
		String hql="select name,email from Employee";
		Query q=s.createQuery(hql);
		List<Object> list=q.list();
		for(Object o:list)
			{Object ar[]=(Object[])o;
	         System.out.println(ar[0]);
	         System.out.println(ar[1]);
			}

	}

}

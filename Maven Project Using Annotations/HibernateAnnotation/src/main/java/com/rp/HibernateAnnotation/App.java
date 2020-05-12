package com.rp.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory sf=meta.getSessionFactoryBuilder().build();
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        
        Employee e1=new Employee();    
        e1.setId(101);    
        e1.setFname("Gaurav");   
        e1.setLname("Chawla");    
            
        s.save(e1);  
        t.commit();  
        System.out.println("successfully saved");    
        sf.close();  
        s.close();    
        
    }
}

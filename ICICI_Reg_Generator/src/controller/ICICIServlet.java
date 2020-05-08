package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import beans.ICICIBean;


/**
 * Servlet implementation class ICICIServlet
 */
@WebServlet({ "/ICICIServlet", "/create" })
public class ICICIServlet extends HttpServlet {
	SessionFactory sf;
	
	public void init(ServletConfig config) throws ServletException {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		System.out.println("Session factory init");
		
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		int balance=Integer.parseInt(req.getParameter("balance"));
		
		ICICIBean icici= new ICICIBean(null,name,email,phone,balance);
		Session s=sf.openSession();
		org.hibernate.Transaction t=s.beginTransaction();
		
		String pk=(String)s.save(icici);
		t.commit();
		s.close();
		  resp.getWriter().println("reg success id= "+pk);
	
	}
	
   @Override
	public void destroy() {
		sf.close();
		super.destroy();
	}
	
	}


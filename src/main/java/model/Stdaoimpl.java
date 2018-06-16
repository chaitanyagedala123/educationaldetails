package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Stdaoimpl implements Stdao {

	public List<Stddtls> allList() {
Configuration con=new Configuration().configure("hibernate.cfg.xml");
SessionFactory fact=con.buildSessionFactory();
Session se=fact.openSession();
Transaction t=se.beginTransaction();
List<Stddtls> stdlist=se.createQuery("from Stddtls").list();
se.close();
return stdlist;
	}

	public Stddtls login(String mobile) {
		Configuration con=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact=con.buildSessionFactory();
		Session se=fact.openSession();
		Transaction t=se.beginTransaction();
		
		List<Stddtls> stdlist=se.createQuery("from Stddtls").list();
		for(Stddtls student:stdlist) {
			if(student.getStdMobleno().equals(mobile)) {
		return student;
		}
		}
		
		
		se.close();
		return null;
	}

}

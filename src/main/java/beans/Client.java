package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		Student st = new Student();
		st.setId(111);
		st.setName("kaushik");
		st.setEmail("kaushikmandal27@gmail.com");
		//till here transient state
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.save(st);
		//here persistent state
		s.beginTransaction().commit();
		//here database state 
		s.evict(st);
		//here object removed from persistent (detached)
		//here gc can recollect object
	}
}

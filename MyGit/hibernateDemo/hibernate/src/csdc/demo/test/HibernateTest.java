package csdc.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import csdc.demo.User;

public class HibernateTest {

	@Test
	public void test() {
		
		System.out.println("test...");
		
		//1. ����һ�� SessionFactory ����
		SessionFactory sessionFactory = null;
		
		//1). ���� Configuration ����: ��Ӧ hibernate �Ļ���������Ϣ�� �����ϵӳ����Ϣ
		Configuration cfg = new Configuration().configure();
		
		//4.0 ֮ǰ��������
//		sessionFactory = configuration.buildSessionFactory();
		
		//2). ����һ�� ServiceRegistry ����: hibernate 4.x ����ӵĶ���
		//hibernate ���κ����úͷ�����Ҫ�ڸö�����ע��������Ч.
		//ServiceRegistry serviceRegistry = 
		//		new ServiceRegistryBuilder().applySettings(cfg.getProperties())
		//		                            .buildServiceRegistry();
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//3).
		//sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		//2. ����һ�� Session ����
		Session session = sessionFactory.openSession();
		//Session session=sessionFactory.openSession();
		//3. ��������
		//Transaction transaction = session.beginTransaction();
		Transaction transaction =session.beginTransaction();
		//4. ִ�б������
		User user = new User(1,"11","22","33");
		//session.save(user);
		session.save(user);
		//5. �ύ���� 
		//transaction.commit();
		transaction.commit();
		//6. �ر� Session
		session.close();
		
		//7. �ر� SessionFactory ����
		sessionFactory.close();
	}
	
}

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import csdc.demo.User;

public class HibernateTest {
	//	��һ�� ����hibernate���������ļ�
		//��src�����ҵ�hibernate.cfg.xml
		//��hibernate�����װ����
	Configuration cfg = new Configuration().configure();
	//	�ڶ��� ����SessionFactory����
	SessionFactory sessionFactory=null;
	//	������ ʹ��SessionFactory����session����
	ServiceRegistry serviceRegistry = 
			new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	
	Session session=sessionFactory.openSession();
	//	���Ĳ� ��������
	Transaction transaction =session.beginTransaction();
	//	���岽 д�����߼�crud
	User user = new User(1,"11","22","33");
	session.save(user);
	
	//	������ �ύ����
	 transaction.commit();
	//	���߲� �ر���Դ
	 session.close();
	 sessionFactory.close();
}
*/
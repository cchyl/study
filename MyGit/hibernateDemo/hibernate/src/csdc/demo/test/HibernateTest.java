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
		
		//1. 创建一个 SessionFactory 对象
		SessionFactory sessionFactory = null;
		
		//1). 创建 Configuration 对象: 对应 hibernate 的基本配置信息和 对象关系映射信息
		Configuration cfg = new Configuration().configure();
		
		//4.0 之前这样创建
//		sessionFactory = configuration.buildSessionFactory();
		
		//2). 创建一个 ServiceRegistry 对象: hibernate 4.x 新添加的对象
		//hibernate 的任何配置和服务都需要在该对象中注册后才能有效.
		//ServiceRegistry serviceRegistry = 
		//		new ServiceRegistryBuilder().applySettings(cfg.getProperties())
		//		                            .buildServiceRegistry();
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//3).
		//sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		//2. 创建一个 Session 对象
		Session session = sessionFactory.openSession();
		//Session session=sessionFactory.openSession();
		//3. 开启事务
		//Transaction transaction = session.beginTransaction();
		Transaction transaction =session.beginTransaction();
		//4. 执行保存操作
		User user = new User(1,"11","22","33");
		//session.save(user);
		session.save(user);
		//5. 提交事务 
		//transaction.commit();
		transaction.commit();
		//6. 关闭 Session
		session.close();
		
		//7. 关闭 SessionFactory 对象
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
	//	第一步 加载hibernate核心配置文件
		//到src下面找到hibernate.cfg.xml
		//在hibernate里面封装对象
	Configuration cfg = new Configuration().configure();
	//	第二步 创建SessionFactory对象
	SessionFactory sessionFactory=null;
	//	第三步 使用SessionFactory创建session对象
	ServiceRegistry serviceRegistry = 
			new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	
	Session session=sessionFactory.openSession();
	//	第四步 开启事务
	Transaction transaction =session.beginTransaction();
	//	第五步 写具体逻辑crud
	User user = new User(1,"11","22","33");
	session.save(user);
	
	//	第六步 提交事务
	 transaction.commit();
	//	第七步 关闭资源
	 session.close();
	 sessionFactory.close();
}
*/
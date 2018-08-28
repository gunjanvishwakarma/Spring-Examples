package hello.hello;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
private static SessionFactory sessionFactory;
static {
	try{
		Configuration cfg=new AnnotationConfiguration(); //When new Configuration() is called,Hibernate searches for 
		//a file named hibernate.properties in the root of the classpath. If it's found all hibernate.* 
		//properties are loaded and added to the configuration object. 
		
		sessionFactory=cfg.configure().buildSessionFactory();//when configure is called, Hibernate searches 
		//for a file of named hibenate.cfg.xml in the root of the classpath, and an exception is thrown 
		//if it can't be found.You don't have to call this method if u do not have this configuration file.
		//If setting in the XML configuration file duplicate of properties set earlier, the XML setting 
		//override the previous ones.
		
		//The location of hibernate.properties configuration file is always the root of the classpath, outside
		//of any package.
		
		// If you wish to use a different file or to  have Hibernate look in a subdirectory of your 
		// classpath for the XML configuration file,you must pass a path as an argument of the configure() 
		// method.
		
		// configure("/persistence/auction.cfg.xml")
		// 
		// first create a database of name hibernatedb manually than remove comment of below 2 lines.
		// these two line will automatically create message table in your hibernatedb database
		//SchemaExport schemaExport = new SchemaExport(cfg); 
		//schemaExport.create(true,true);
	}
	catch(Throwable ex){
		throw new ExceptionInInitializerError(ex);
	}
}
public static SessionFactory getSessionFactory(){
	
	return sessionFactory;
}
public static void shutdown(){
	getSessionFactory().close();
}
}

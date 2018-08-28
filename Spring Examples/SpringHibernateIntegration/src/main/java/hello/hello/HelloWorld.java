package hello.hello;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// first unit of work
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Message message = new Message("Hello World ");
		Long msgId=(Long)session.save(message);
		tx.commit();
		session.close();
		
		//second unit of work
		/*Session newSession=HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction=newSession.beginTransaction();
		List messages=newSession.createQuery("from Message m order by m.text asc").list();
		System.out.println(messages.size()+" message(s) found:");
		for ( Iterator iterator=messages.iterator();iterator.hasNext();){
			Message loadedMsg=(Message)iterator.next();
			System.out.println(loadedMsg.getText());
		}
		newTransaction.commit();
		newSession.close();
		HibernateUtil.shutdown();*/
		
		//third unit of work
		//automatic dirty checking and cascading  
		//This code calls three SQL Statements inside the same database transaction:
		
		
		
		/*Session thirdSession = HibernateUtil.getSessionFactory().openSession();
		Transaction thirdTransaction=thirdSession.beginTransaction();
		// select m.MESSAGE_ID, m.MESSAGE_TEXT, m.NEXT_MESSAGE_ID from MESSAGES m where m.MESSAGE_ID = 1
		message=(Message)thirdSession.get(Message.class, msgId);
		// update MESSAGES set MESSAGE_TEXT  = 'Greetings Earthling',NEXT_MESSAGE_ID = 2 where MESSAGE_ID = 1
		message.setText("Greeting Earthling");
		// insert into MESSAGES (MESSAGE_ID,MESSAGE_TEXT,NEXT_MESSAGE_ID) values (2,'Take me to your leader (please)',null)
		message.setNextMessage(new Message("Take me to your leader (please)"));
		thirdTransaction.commit();
		thirdSession.close();
		HibernateUtil.shutdown();
		
		//notice how hibernate detected the modification to the text and nextMessage properties of the 
		//first message and automatically updated the database. (Automatic dirty checking).This feature 
		//saves you the effort of explicitly asking hibernate to update the database when you modify the 
		//state of an object inside a unit of work
		
		//Similarly, the new message was made persistent when a reference was created from the first message.
		//This feature is called cascading save.It saves you the effort of explicitly making new object persistent 
		// by calling save(),as long as it's reachable by an already persistent instance.
		*/
		
		

	}

}

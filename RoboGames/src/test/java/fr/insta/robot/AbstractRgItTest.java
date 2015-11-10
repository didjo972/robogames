package fr.insta.robot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe abstraite des tests d'intégration.
 */
public class AbstractRgItTest {

	static ConfigurableApplicationContext context;

	/**
	 * Initialisation Environnement
	 */
//	@BeforeClass
//	public static void initEnvironment() {
//		
//		System.out.println("load context");
//		context = new ClassPathXmlApplicationContext("spring/application-config.xml");
//	}
//
//	protected static ConfigurableApplicationContext getContext() {
//		return context;
//	}
	/*@AfterClass
	public static void initEnvironment2() {
		
		System.out.println("load context");
		context = new ClassPathXmlApplicationContext("spring/application-config.xml");
	}*/

	
}

///**
// * Factory des services.
// */
//public class AbstractRgItTest {
//	
//	static GenericXmlApplicationContext context;
//
//	/**
//	 * Initialisation Environnement
//	 */
//	@BeforeClass
//	public static void initEnvironment() {
//		// Initial spring context with profiles
//	    context= new GenericXmlApplicationContext();
//	    ConfigurableEnvironment env = (ConfigurableEnvironment) context.getEnvironment();
//	    env.setDefaultProfiles("test");
//	    context.load("spring/application-config.xml");
//	    context.refresh();
//		
//		System.out.println("load context");
//	}
//
//	protected static ConfigurableApplicationContext getContext() {
//		return context;
//	}
//}

package fr.insta.robot;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Factory des services.
 */
public class AbstractServiceFactory {

	static ConfigurableApplicationContext context;

	/**
	 * Initialisation Environnement
	 */
	public static void initEnvironment() {

		System.out.println("load context");
		context = new ClassPathXmlApplicationContext("spring/application-config.xml");
	}

	protected static ConfigurableApplicationContext getContext() {
		return context;
	}
}

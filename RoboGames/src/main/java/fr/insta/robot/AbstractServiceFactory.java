package fr.insta.robot;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.TRACE);
		PropertyConfigurator.configure("classpath:log4jconfig.xml");
	}

	protected static ConfigurableApplicationContext getContext() {
		return context;
	}
}

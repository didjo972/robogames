package fr.insta.robot;

import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

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
		Logger.getRootLogger().setLevel(Level.ERROR);
		try {
			Log4jConfigurer.initLogging("classpath:log4jconfig.xml");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur initialisation log4j");
		}
	}

	protected static ConfigurableApplicationContext getContext() {
		return context;
	}
}

/// **
// * Factory des services.
// */
// public class AbstractServiceFactory {
//
// static GenericXmlApplicationContext context;
//
// /**
// * Initialisation Environnement
// */
// @BeforeClass
// public static void initEnvironment() {
// // Initial spring context with profiles
// context= new GenericXmlApplicationContext();
// ConfigurableEnvironment env = (ConfigurableEnvironment)
/// context.getEnvironment();
// env.setDefaultProfiles("dev");
// context.load("spring/application-config.xml");
// context.refresh();
//
// System.out.println("load context");
// }
//
// protected static ConfigurableApplicationContext getContext() {
// return context;
// }
// }

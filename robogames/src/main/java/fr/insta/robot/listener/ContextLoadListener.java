package fr.insta.robot.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import fr.insta.robot.services.impl.ActionEvenementServiceImpl;

/**
 * Listener du context
 */
public class ContextLoadListener extends ContextLoaderListener {
	
	Logger LOG = Logger.getLogger(ContextLoadListener.class);

	/**
	 * Batch de vérification des évènements
	 */
	public ContextLoadListener() {
		super();
		BasicConfigurator.configure();
		//PropertyConfigurator.configure("classpath:log4j.properties");
		Timer monTimer = new Timer();
		TimerTask taskAExec = new TimerTask(){
			public void run(){
				LOG.info("lancement du batch de vérification des états des évènements...");
				ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
				actionEvenement.updateStateEvenement();
				LOG.info("batch de vérification des états des évènements terminé...");
			}
		};
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.NOVEMBER, 1);
		monTimer.schedule(taskAExec, c.getTime(), 2592000000L);
	}
	
}

package fr.insta.robot.listener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.services.RoleConstantService;
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;
import fr.insta.robot.services.impl.MailServiceImpl;

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
				
				// Envoie des mails si création d'un évent
				LOG.info("Envoie des mails d'informations aux admin");
				envoieMailCreationEvent();
				
				// Vérification des états des évents
				LOG.info("Vérification des états des évènements");
				verificationEtatEvenement();
			}
		};
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.NOVEMBER, 1);
		monTimer.schedule(taskAExec, c.getTime(), 2592000000L);
	}
	
	private void envoieMailCreationEvent() {
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		// La clé est -1 car c'est le serveur qui fait la demande
		List<UserEntity> listAdmin = actionUser.findAllUserByType(RoleConstantService.ADMIN);
		List<String> listEmailAdmin = new ArrayList<String>();
		for (UserEntity userAdmin : listAdmin) {
			listEmailAdmin.add(userAdmin.getInformation().getEmail());
		}
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		List<EvenementEntity> listEvenement = actionEvenement.findAllEnvenement();
		if (listEvenement != null) {
			for (EvenementEntity evenement : listEvenement) {
				if (!evenement.getValide()) {
					MailServiceImpl mailService = new MailServiceImpl();
					mailService.sendMail("[RG]Evènement à valider", "Bonjour, \nil y a un nouvelle évènement nommé, "
									+evenement.getNom()+" à valider. \nCordialement.", listEmailAdmin);
				}
			}
		}
	}
	
	private void verificationEtatEvenement() {
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		actionEvenement.updateStateEvenement();
	}
	
}

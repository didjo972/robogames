package fr.insta.robot.listener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.services.RoleConstantService;
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;
import fr.insta.robot.services.impl.HabilitationServiceImpl;
import fr.insta.robot.services.impl.MailServiceImpl;
import fr.insta.robot.util.DateUtil;

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
				// Vérification des états des évents
				LOG.info("lancement du batch de vérification des états des évènements...");
				verificationEtatEvenement();
				LOG.info("batch de vérification des états des évènements terminé...");
				
				// Envoie des mails si création d'un évent
				LOG.info("Envoie des mails d'informations aux admin...");
				envoieMailCreationEvent();
				
				// Vérification de l'état de l'habilitation des USERs
				LOG.info("Vérification des habilitations...");
				verificationHabilitation();
				
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
	
	private void verificationHabilitation() {
		HabilitationServiceImpl habilitationService = new HabilitationServiceImpl();
		List<HabilitationEntity> listHabilitation = habilitationService.findAll();
		if (listHabilitation != null) {
			for (HabilitationEntity habilitation : listHabilitation) {
				if (!habilitation.getEtat()) {
					Calendar c = Calendar.getInstance();
					c.setTime(habilitation.getDateFin()); 
					c.add(Calendar.DATE, habilitation.getBanTime());
					if (DateUtil.afterOrEqual(c.getTime(), new Date())) {
						// TODO Supprimer User
					}
				}
			}
		}
	}
	
}

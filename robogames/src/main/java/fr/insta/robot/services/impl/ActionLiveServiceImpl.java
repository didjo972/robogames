package fr.insta.robot.services.impl;

import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.services.ActionLiveService;
import fr.insta.robot.services.LiveService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionLiveServiceImpl implements ActionLiveService {

	@Override
	public void delete(LiveEntity live) throws DonneesInexistantException {
		if(live == null){
			throw new DonneesInexistantException("Erreur, le live est vide");
		}
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		liveS.deleteLive(live);
	}
	@Override
	public LiveEntity ajouteUrl(String url) throws DonneesInexistantException{
		if(StringUtils.isBlank(url)){
			throw new DonneesInexistantException("Erreur, le lien est vide");
		}
		LiveEntity live = findURL();
		LiveService liveService = RGServiceFactory.getInstance().getLiveService();
		if(live != null){
			liveService.deleteLive(live);
		}
		live = RGEntityFactory.getLiveEntityInstance();
		live.setUrl(url);
		
		liveService.persistLive(live);
		return live;
	}
	@Override
	public LiveEntity findURL() {
		LiveService liveService = RGServiceFactory.getInstance().getLiveService();
		LiveEntity live = liveService.findLive();
		return live;
	}

}
package fr.insta.robot.services.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.services.ActionLiveService;
import fr.insta.robot.services.LiveService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionLiveServiceImpl implements ActionLiveService {

	@Override
	public LiveEntity createLive(String url) throws DonneesInexistantException {
		if(StringUtils.isBlank(url)){
			throw new DonneesInexistantException("Erreur, l'url du lien est vide");
		}
		LiveEntity live = RGEntityFactory.getLiveEntityInstance();
		live.setUrl(url);
		
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		liveS.persistLive(live);
		return live;
	}

	@Override
	public LiveEntity updateLive(LiveEntity live,String url) throws DonneesInexistantException {
		if(live == null){
			throw new DonneesInexistantException("Erreur, le live est vide");
		}
		if(StringUtils.isNoneBlank(url)){
			live.setUrl(url);
		}
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		liveS.updateLive(live);
		return live;
	}

	@Override
	public LiveEntity findById(Long id) {
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		LiveEntity live = liveS.findLiveById(id);
		return live;
	}

	@Override
	public List<LiveEntity> findAllLive() {
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		return liveS.findAllLive();
	}

	@Override
	public void delete(LiveEntity live) throws DonneesInexistantException {
		if(live == null){
			throw new DonneesInexistantException("Erreur, le live est vide");
		}
		LiveService liveS = RGServiceFactory.getInstance().getLiveService();
		liveS.deleteLive(live);
	}

}
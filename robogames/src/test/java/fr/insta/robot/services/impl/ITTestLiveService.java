package fr.insta.robot.services.impl;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.services.ActionLiveService;

public class ITTestLiveService {
	@Test
	public void testLive(){
		ActionLiveService actionliveS = new ActionLiveServiceImpl();
		LiveEntity live = actionliveS.findURL();
		Assert.assertEquals("", live.getUrl());
	}
}

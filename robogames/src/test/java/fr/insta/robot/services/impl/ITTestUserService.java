package fr.insta.robot.services.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.services.RoleConstantService;

public class ITTestUserService {

	@Test
	public void testFindAllUserByTypeNominal() {
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		List<UserEntity> listAdmin = actionUser.findAllUserByType(RoleConstantService.ADMIN);
		Assert.assertNotNull(listAdmin);
		Assert.assertTrue(!listAdmin.isEmpty());
		Assert.assertEquals(1, listAdmin.size());
	}
	
}

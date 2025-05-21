package com.vass.register.web.action;

import com.liferay.portal.kernel.json.JSONObject;

import com.vass.register.web.constants.RegisterWebPortletKeys;


import org.junit.Assert;
import org.junit.Test;

public class SaveUserMVCResourceCommandTest {

	@Test
	public void testValidNameAndEmail() {
		JSONObject result = SaveUserMVCResourceCommand.validateNameAndEmail("Juan", "juan@example.com");

		Assert.assertTrue(result.getBoolean(RegisterWebPortletKeys.SUCCESS));
		Assert.assertFalse(result.has(RegisterWebPortletKeys.ERROR));
	}

	@Test
	public void testMissingName() {
		JSONObject result = SaveUserMVCResourceCommand.validateNameAndEmail(null, "juan@example.com");

		Assert.assertFalse(result.getBoolean(RegisterWebPortletKeys.SUCCESS));
		Assert.assertEquals("El nombre y el email son obligatorios.", result.getString(RegisterWebPortletKeys.ERROR));
	}

	@Test
	public void testMissingEmail() {
		JSONObject result = SaveUserMVCResourceCommand.validateNameAndEmail("Juan", null);

		Assert.assertFalse(result.getBoolean(RegisterWebPortletKeys.SUCCESS));
		Assert.assertEquals("El nombre y el email son obligatorios.", result.getString(RegisterWebPortletKeys.ERROR));
	}

	@Test
	public void testInvalidEmail() {
		JSONObject result = SaveUserMVCResourceCommand.validateNameAndEmail("Juan", "correo-invalido");

		Assert.assertFalse(result.getBoolean(RegisterWebPortletKeys.SUCCESS));
		Assert.assertEquals("El email tiene un formato inválido.", result.getString(RegisterWebPortletKeys.ERROR));
	}
}
package com.vass.register.web.portlet;

import com.vass.register.web.configuration.RegisterWebConfiguration;

import com.liferay.portal.kernel.util.*;

import com.vass.register.web.constants.RegisterWebPortletKeys;

import java.io.IOException;

import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrés Camilo
 */
@Component(
	configurationPid = "com.vass.register.web.configuration.RegisterWebConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Register Web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegisterWebPortletKeys.REGISTERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.add-default-resource=true",
	},
	service = Portlet.class
)
public class RegisterWebPortlet extends MVCPortlet {
	

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			renderRequest.setAttribute(
				RegisterWebConfiguration.class.getName(),
				configurationProvider.getCompanyConfiguration(
						RegisterWebConfiguration.class,
						portal.getCompanyId(renderRequest)));
		}
		catch (ConfigurationException configurationException) {
			throw new PortletException(configurationException);
		}

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private Portal portal;
	
	
}
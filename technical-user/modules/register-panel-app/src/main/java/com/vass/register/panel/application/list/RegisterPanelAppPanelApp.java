package com.vass.register.panel.application.list;

import com.vass.register.panel.constants.RegisterPanelAppPanelCategoryKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.vass.register.web.constants.RegisterWebPortletKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

// import com.liferay.application.list.constants.PanelCategoryKeys;

/**
 * @author Andrés Camilo
 */
@Component(
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + RegisterPanelAppPanelCategoryKeys.CONTROL_PANEL_CATEGORY
		// "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
	},
	service = PanelApp.class
)
public class RegisterPanelAppPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return RegisterWebPortletKeys.REGISTERWEB;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public PortletURL getPortletURL(HttpServletRequest httpServletRequest) throws PortalException {
	    PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
	        httpServletRequest, getGroup(httpServletRequest), getPortletId(), 0,
	        0, PortletRequest.RENDER_PHASE);

	    Group group = groupProvider.getGroup(httpServletRequest);

	    if (group != null) {
	        portletURL.setParameter("p_v_l_s_g_id", String.valueOf(group.getGroupId()));
	    }

	    portletURL.setParameter("mvcRenderCommandName", RegisterWebPortletKeys.VIEW_USER);

	    return portletURL;
	}


	@Reference(target = "(javax.portlet.name=" + RegisterWebPortletKeys.REGISTERWEB + ")")
	private Portlet _portlet;

}
package com.vass.register.web.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.vass.register.model.CustomUser;
import com.vass.register.service.CustomUserLocalService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static com.vass.register.web.constants.RegisterWebPortletKeys.*;

@Component(
	    immediate = true,
	    property = {
			"javax.portlet.name=" + REGISTERWEB,
	        "mvc.command.name=" + VIEW_USER
	    },
	    service = MVCRenderCommand.class
	)
public class ViewUserMVCRenderCommand implements MVCRenderCommand {
	
    @Reference
    private CustomUserLocalService customUserService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            List<CustomUser> users = customUserService.getCustomUsers(-1, -1);
            renderRequest.setAttribute(USERS, users);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/user/view_user.jsp";
    }
}
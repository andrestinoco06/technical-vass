package com.vass.register.web.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import static com.vass.register.web.constants.RegisterWebPortletKeys.*;

@Component(
    immediate = true,
    property = {
		"javax.portlet.name=" + REGISTERWEB,
        "mvc.command.name=" + REGISTER_USER
    },
    service = MVCRenderCommand.class
)
public class SaveUserMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        return "/user/register_user.jsp";
    }
}
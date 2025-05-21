package com.vass.register.web.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.vass.register.model.CustomUser;
import com.vass.register.service.CustomUserLocalService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static com.vass.register.web.constants.RegisterWebPortletKeys.*;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + REGISTERWEB,
        "mvc.command.name=" + SAVE_USER
    },
    service = MVCResourceCommand.class
)
public class SaveUserMVCResourceCommand implements MVCResourceCommand {

    @Reference
    private CustomUserLocalService customUserLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
    	
        JSONObject response = JSONFactoryUtil.createJSONObject();

        try {
            String name = ParamUtil.getString(resourceRequest, NAME);
            String email = ParamUtil.getString(resourceRequest, EMAIL);

            JSONObject validationResult = validateNameAndEmail(name, email);

            if (!validationResult.getBoolean(SUCCESS)) {
                writeJson(resourceResponse, validationResult);
                return false;
            }

            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                CustomUser.class.getName(), resourceRequest);

            long customUserId = counterLocalService.increment(CustomUser.class.getName());
            CustomUser customUser = customUserLocalService.createCustomUser(customUserId);

            customUser.setUserId(customUserId);
            customUser.setName(name);
            customUser.setEmail(email);
            customUser.setUuid(serviceContext.getUuid());

            customUser = customUserLocalService.addCustomUser(customUser);

            response.put(SUCCESS, true);
        } catch (Exception e) {
            response.put(SUCCESS, false);
            response.put(ERROR, e.getMessage());
        }

        writeJson(resourceResponse, response);

        return false;
    }


    private static void writeJson(ResourceResponse response, JSONObject jsonObject) throws PortletException {
        try (PrintWriter writer = response.getWriter()) {
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            throw new PortletException("Error writing JSON response", e);
        }
    }
    
    public static JSONObject validateNameAndEmail(String name, String email) {
        JSONObject response = JSONFactoryUtil.createJSONObject();

        if (Validator.isNull(name) || Validator.isNull(email)) {
            response.put(SUCCESS, false);
            response.put(ERROR, "El nombre y el email son obligatorios.");
            return response;
        }

        if (!Validator.isEmailAddress(email)) {
            response.put(SUCCESS, false);
            response.put(ERROR, "El email tiene un formato inválido.");
            return response;
        }

        response.put(SUCCESS, true);
        return response;
    }

}

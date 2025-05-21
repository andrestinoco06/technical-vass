package com.vass.register.web.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import static com.vass.register.web.constants.RegisterWebPortletKeys.*;

@ExtendedObjectClassDefinition(
		category = "register",
		scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
		id = PORTLET_CONFIGURATION,
		localization = "content/Language",
		name = CONFIGURATION_NAME
)
public interface RegisterWebConfiguration {

	@Meta.AD(deflt = "Formulario de Registro de Usuarios", required = false)
	public String message();
	
}

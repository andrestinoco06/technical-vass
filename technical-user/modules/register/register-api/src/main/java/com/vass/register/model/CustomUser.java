/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CustomUser service. Represents a row in the &quot;CUSTOMUSER_CustomUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserModel
 * @generated
 */
@ImplementationClassName("com.vass.register.model.impl.CustomUserImpl")
@ProviderType
public interface CustomUser extends CustomUserModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.vass.register.model.impl.CustomUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CustomUser, Long> USER_ID_ACCESSOR =
		new Accessor<CustomUser, Long>() {

			@Override
			public Long get(CustomUser customUser) {
				return customUser.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CustomUser> getTypeClass() {
				return CustomUser.class;
			}

		};

}
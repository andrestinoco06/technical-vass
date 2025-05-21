/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserService
 * @generated
 */
public class CustomUserServiceWrapper
	implements CustomUserService, ServiceWrapper<CustomUserService> {

	public CustomUserServiceWrapper() {
		this(null);
	}

	public CustomUserServiceWrapper(CustomUserService customUserService) {
		_customUserService = customUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customUserService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomUserService getWrappedService() {
		return _customUserService;
	}

	@Override
	public void setWrappedService(CustomUserService customUserService) {
		_customUserService = customUserService;
	}

	private CustomUserService _customUserService;

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.service.impl;

import com.liferay.portal.aop.AopService;

import com.vass.register.service.base.CustomUserLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.vass.register.model.CustomUser",
	service = AopService.class
)
public class CustomUserLocalServiceImpl extends CustomUserLocalServiceBaseImpl {
}
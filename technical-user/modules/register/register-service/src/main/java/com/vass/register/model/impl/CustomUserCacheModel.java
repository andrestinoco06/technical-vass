/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.vass.register.model.CustomUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomUserCacheModel
	implements CacheModel<CustomUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomUserCacheModel)) {
			return false;
		}

		CustomUserCacheModel customUserCacheModel =
			(CustomUserCacheModel)object;

		if (userId == customUserCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomUser toEntityModel() {
		CustomUserImpl customUserImpl = new CustomUserImpl();

		if (uuid == null) {
			customUserImpl.setUuid("");
		}
		else {
			customUserImpl.setUuid(uuid);
		}

		customUserImpl.setUserId(userId);

		if (name == null) {
			customUserImpl.setName("");
		}
		else {
			customUserImpl.setName(name);
		}

		if (email == null) {
			customUserImpl.setEmail("");
		}
		else {
			customUserImpl.setEmail(email);
		}

		customUserImpl.resetOriginalValues();

		return customUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public String uuid;
	public long userId;
	public String name;
	public String email;

}
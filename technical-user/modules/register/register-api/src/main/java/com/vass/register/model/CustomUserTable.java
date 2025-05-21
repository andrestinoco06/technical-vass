/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CUSTOMUSER_CustomUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CustomUser
 * @generated
 */
public class CustomUserTable extends BaseTable<CustomUserTable> {

	public static final CustomUserTable INSTANCE = new CustomUserTable();

	public final Column<CustomUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CustomUserTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomUserTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CustomUserTable() {
		super("CUSTOMUSER_CustomUser", CustomUserTable::new);
	}

}
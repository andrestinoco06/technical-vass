/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.vass.register.exception.NoSuchCustomUserException;
import com.vass.register.model.CustomUser;
import com.vass.register.service.CustomUserLocalServiceUtil;
import com.vass.register.service.persistence.CustomUserPersistence;
import com.vass.register.service.persistence.CustomUserUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CustomUserPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.vass.register.service"));

	@Before
	public void setUp() {
		_persistence = CustomUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CustomUser> iterator = _customUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomUser customUser = _persistence.create(pk);

		Assert.assertNotNull(customUser);

		Assert.assertEquals(customUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		_persistence.remove(newCustomUser);

		CustomUser existingCustomUser = _persistence.fetchByPrimaryKey(
			newCustomUser.getPrimaryKey());

		Assert.assertNull(existingCustomUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCustomUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomUser newCustomUser = _persistence.create(pk);

		newCustomUser.setUuid(RandomTestUtil.randomString());

		newCustomUser.setName(RandomTestUtil.randomString());

		newCustomUser.setEmail(RandomTestUtil.randomString());

		_customUsers.add(_persistence.update(newCustomUser));

		CustomUser existingCustomUser = _persistence.findByPrimaryKey(
			newCustomUser.getPrimaryKey());

		Assert.assertEquals(
			existingCustomUser.getUuid(), newCustomUser.getUuid());
		Assert.assertEquals(
			existingCustomUser.getUserId(), newCustomUser.getUserId());
		Assert.assertEquals(
			existingCustomUser.getName(), newCustomUser.getName());
		Assert.assertEquals(
			existingCustomUser.getEmail(), newCustomUser.getEmail());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		CustomUser existingCustomUser = _persistence.findByPrimaryKey(
			newCustomUser.getPrimaryKey());

		Assert.assertEquals(existingCustomUser, newCustomUser);
	}

	@Test(expected = NoSuchCustomUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CustomUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CUSTOMUSER_CustomUser", "uuid", true, "userId", true, "name", true,
			"email", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		CustomUser existingCustomUser = _persistence.fetchByPrimaryKey(
			newCustomUser.getPrimaryKey());

		Assert.assertEquals(existingCustomUser, newCustomUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomUser missingCustomUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCustomUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CustomUser newCustomUser1 = addCustomUser();
		CustomUser newCustomUser2 = addCustomUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomUser1.getPrimaryKey());
		primaryKeys.add(newCustomUser2.getPrimaryKey());

		Map<Serializable, CustomUser> customUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, customUsers.size());
		Assert.assertEquals(
			newCustomUser1, customUsers.get(newCustomUser1.getPrimaryKey()));
		Assert.assertEquals(
			newCustomUser2, customUsers.get(newCustomUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CustomUser> customUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CustomUser newCustomUser = addCustomUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CustomUser> customUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customUsers.size());
		Assert.assertEquals(
			newCustomUser, customUsers.get(newCustomUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CustomUser> customUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomUser.getPrimaryKey());

		Map<Serializable, CustomUser> customUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customUsers.size());
		Assert.assertEquals(
			newCustomUser, customUsers.get(newCustomUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CustomUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CustomUser>() {

				@Override
				public void performAction(CustomUser customUser) {
					Assert.assertNotNull(customUser);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("userId", newCustomUser.getUserId()));

		List<CustomUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CustomUser existingCustomUser = result.get(0);

		Assert.assertEquals(existingCustomUser, newCustomUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("userId", RandomTestUtil.nextLong()));

		List<CustomUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CustomUser newCustomUser = addCustomUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("userId"));

		Object newUserId = newCustomUser.getUserId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("userId", new Object[] {newUserId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserId = result.get(0);

		Assert.assertEquals(existingUserId, newUserId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("userId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CustomUser addCustomUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomUser customUser = _persistence.create(pk);

		customUser.setUuid(RandomTestUtil.randomString());

		customUser.setName(RandomTestUtil.randomString());

		customUser.setEmail(RandomTestUtil.randomString());

		_customUsers.add(_persistence.update(customUser));

		return customUser;
	}

	private List<CustomUser> _customUsers = new ArrayList<CustomUser>();
	private CustomUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
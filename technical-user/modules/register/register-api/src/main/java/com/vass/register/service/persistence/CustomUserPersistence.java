/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.vass.register.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.vass.register.exception.NoSuchCustomUserException;
import com.vass.register.model.CustomUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserUtil
 * @generated
 */
@ProviderType
public interface CustomUserPersistence extends BasePersistence<CustomUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomUserUtil} to access the custom user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the custom users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom users
	 */
	public java.util.List<CustomUser> findByUuid(String uuid);

	/**
	 * Returns a range of all the custom users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @return the range of matching custom users
	 */
	public java.util.List<CustomUser> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the custom users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom users
	 */
	public java.util.List<CustomUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the custom users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom users
	 */
	public java.util.List<CustomUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom user
	 * @throws NoSuchCustomUserException if a matching custom user could not be found
	 */
	public CustomUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Returns the first custom user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom user, or <code>null</code> if a matching custom user could not be found
	 */
	public CustomUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns the last custom user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom user
	 * @throws NoSuchCustomUserException if a matching custom user could not be found
	 */
	public CustomUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Returns the last custom user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom user, or <code>null</code> if a matching custom user could not be found
	 */
	public CustomUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns the custom users before and after the current custom user in the ordered set where uuid = &#63;.
	 *
	 * @param userId the primary key of the current custom user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom user
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser[] findByUuid_PrevAndNext(
			long userId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Removes all the custom users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of custom users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom users
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the custom user in the entity cache if it is enabled.
	 *
	 * @param customUser the custom user
	 */
	public void cacheResult(CustomUser customUser);

	/**
	 * Caches the custom users in the entity cache if it is enabled.
	 *
	 * @param customUsers the custom users
	 */
	public void cacheResult(java.util.List<CustomUser> customUsers);

	/**
	 * Creates a new custom user with the primary key. Does not add the custom user to the database.
	 *
	 * @param userId the primary key for the new custom user
	 * @return the new custom user
	 */
	public CustomUser create(long userId);

	/**
	 * Removes the custom user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the custom user
	 * @return the custom user that was removed
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser remove(long userId) throws NoSuchCustomUserException;

	public CustomUser updateImpl(CustomUser customUser);

	/**
	 * Returns the custom user with the primary key or throws a <code>NoSuchCustomUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the custom user
	 * @return the custom user
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser findByPrimaryKey(long userId)
		throws NoSuchCustomUserException;

	/**
	 * Returns the custom user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the custom user
	 * @return the custom user, or <code>null</code> if a custom user with the primary key could not be found
	 */
	public CustomUser fetchByPrimaryKey(long userId);

	/**
	 * Returns all the custom users.
	 *
	 * @return the custom users
	 */
	public java.util.List<CustomUser> findAll();

	/**
	 * Returns a range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @return the range of custom users
	 */
	public java.util.List<CustomUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom users
	 */
	public java.util.List<CustomUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom users
	 */
	public java.util.List<CustomUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom users.
	 *
	 * @return the number of custom users
	 */
	public int countAll();

}
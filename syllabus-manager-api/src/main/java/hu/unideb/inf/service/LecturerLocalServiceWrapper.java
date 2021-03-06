/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.unideb.inf.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LecturerLocalService}.
 *
 * @author Adam Kiss
 * @see LecturerLocalService
 * @generated
 */
@ProviderType
public class LecturerLocalServiceWrapper implements LecturerLocalService,
	ServiceWrapper<LecturerLocalService> {
	public LecturerLocalServiceWrapper(
		LecturerLocalService lecturerLocalService) {
		_lecturerLocalService = lecturerLocalService;
	}

	@Override
	public boolean hasTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		return _lecturerLocalService.hasTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	@Override
	public boolean hasTimetableCourseLecturers(long timetableCourseId) {
		return _lecturerLocalService.hasTimetableCourseLecturers(timetableCourseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _lecturerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lecturerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _lecturerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lecturerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lecturerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the lecturer to the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was added
	*/
	@Override
	public hu.unideb.inf.model.Lecturer addLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return _lecturerLocalService.addLecturer(lecturer);
	}

	@Override
	public hu.unideb.inf.model.Lecturer addLecturer(
		java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.addLecturer(lecturerName, lecturerUserId,
			serviceContext);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	@Override
	public hu.unideb.inf.model.Lecturer createLecturer(long lecturerId) {
		return _lecturerLocalService.createLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was removed
	*/
	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return _lecturerLocalService.deleteLecturer(lecturer);
	}

	/**
	* Deletes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lecturerLocalService.deleteLecturer(lecturerId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.deleteLecturer(lecturerId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Lecturer fetchLecturer(long lecturerId) {
		return _lecturerLocalService.fetchLecturer(lecturerId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer fetchLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId) {
		return _lecturerLocalService.fetchLecturerByN_U(lecturerName,
			lecturerUserId);
	}

	/**
	* Returns the lecturer with the primary key.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lecturerLocalService.getLecturer(lecturerId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer getLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return _lecturerLocalService.getLecturerByN_U(lecturerName,
			lecturerUserId);
	}

	/**
	* Updates the lecturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was updated
	*/
	@Override
	public hu.unideb.inf.model.Lecturer updateLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return _lecturerLocalService.updateLecturer(lecturer);
	}

	@Override
	public hu.unideb.inf.model.Lecturer updateLecturer(long userId,
		long lecturerId, java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.updateLecturer(userId, lecturerId,
			lecturerName, lecturerUserId, serviceContext);
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	*/
	@Override
	public int getLecturersCount() {
		return _lecturerLocalService.getLecturersCount();
	}

	@Override
	public int getTimetableCourseLecturersCount(long timetableCourseId) {
		return _lecturerLocalService.getTimetableCourseLecturersCount(timetableCourseId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _lecturerLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _lecturerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _lecturerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _lecturerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerLocalService.getLecturers();
	}

	/**
	* Returns a range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of lecturers
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		int start, int end) {
		return _lecturerLocalService.getLecturers(start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturersByIds(
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return _lecturerLocalService.getLecturersByIds(lecturerIds);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId) {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end) {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId,
			start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.Lecturer> orderByComparator) {
		return _lecturerLocalService.getTimetableCourseLecturers(timetableCourseId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _lecturerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _lecturerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the timetableCourseIds of the timetable courses associated with the lecturer.
	*
	* @param lecturerId the lecturerId of the lecturer
	* @return long[] the timetableCourseIds of timetable courses associated with the lecturer
	*/
	@Override
	public long[] getTimetableCoursePrimaryKeys(long lecturerId) {
		return _lecturerLocalService.getTimetableCoursePrimaryKeys(lecturerId);
	}

	@Override
	public void addTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer) {
		_lecturerLocalService.addTimetableCourseLecturer(timetableCourseId,
			lecturer);
	}

	@Override
	public void addTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		_lecturerLocalService.addTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	@Override
	public void addTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers) {
		_lecturerLocalService.addTimetableCourseLecturers(timetableCourseId,
			lecturers);
	}

	@Override
	public void addTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		_lecturerLocalService.addTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	@Override
	public void clearTimetableCourseLecturers(long timetableCourseId) {
		_lecturerLocalService.clearTimetableCourseLecturers(timetableCourseId);
	}

	@Override
	public void deleteTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer) {
		_lecturerLocalService.deleteTimetableCourseLecturer(timetableCourseId,
			lecturer);
	}

	@Override
	public void deleteTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		_lecturerLocalService.deleteTimetableCourseLecturer(timetableCourseId,
			lecturerId);
	}

	@Override
	public void deleteTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers) {
		_lecturerLocalService.deleteTimetableCourseLecturers(timetableCourseId,
			lecturers);
	}

	@Override
	public void deleteTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		_lecturerLocalService.deleteTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	@Override
	public void setTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		_lecturerLocalService.setTimetableCourseLecturers(timetableCourseId,
			lecturerIds);
	}

	@Override
	public LecturerLocalService getWrappedService() {
		return _lecturerLocalService;
	}

	@Override
	public void setWrappedService(LecturerLocalService lecturerLocalService) {
		_lecturerLocalService = lecturerLocalService;
	}

	private LecturerLocalService _lecturerLocalService;
}
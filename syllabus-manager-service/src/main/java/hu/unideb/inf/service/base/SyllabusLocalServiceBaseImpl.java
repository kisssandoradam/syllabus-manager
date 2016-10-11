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

package hu.unideb.inf.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalService;
import hu.unideb.inf.service.persistence.CoursePersistence;
import hu.unideb.inf.service.persistence.CourseTypePersistence;
import hu.unideb.inf.service.persistence.CurriculumPersistence;
import hu.unideb.inf.service.persistence.LecturerPersistence;
import hu.unideb.inf.service.persistence.SemesterPersistence;
import hu.unideb.inf.service.persistence.SubjectPersistence;
import hu.unideb.inf.service.persistence.SyllabusPersistence;
import hu.unideb.inf.service.persistence.TimetableCoursePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the syllabus local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.unideb.inf.service.impl.SyllabusLocalServiceImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.impl.SyllabusLocalServiceImpl
 * @see hu.unideb.inf.service.SyllabusLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class SyllabusLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SyllabusLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.unideb.inf.service.SyllabusLocalServiceUtil} to access the syllabus local service.
	 */

	/**
	 * Adds the syllabus to the database. Also notifies the appropriate model listeners.
	 *
	 * @param syllabus the syllabus
	 * @return the syllabus that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Syllabus addSyllabus(Syllabus syllabus) {
		syllabus.setNew(true);

		return syllabusPersistence.update(syllabus);
	}

	/**
	 * Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	 *
	 * @param syllabusId the primary key for the new syllabus
	 * @return the new syllabus
	 */
	@Override
	public Syllabus createSyllabus(long syllabusId) {
		return syllabusPersistence.create(syllabusId);
	}

	/**
	 * Deletes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syllabusId the primary key of the syllabus
	 * @return the syllabus that was removed
	 * @throws PortalException if a syllabus with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Syllabus deleteSyllabus(long syllabusId) throws PortalException {
		return syllabusPersistence.remove(syllabusId);
	}

	/**
	 * Deletes the syllabus from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syllabus the syllabus
	 * @return the syllabus that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Syllabus deleteSyllabus(Syllabus syllabus) {
		return syllabusPersistence.remove(syllabus);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Syllabus.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return syllabusPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return syllabusPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return syllabusPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return syllabusPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return syllabusPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Syllabus fetchSyllabus(long syllabusId) {
		return syllabusPersistence.fetchByPrimaryKey(syllabusId);
	}

	/**
	 * Returns the syllabus with the primary key.
	 *
	 * @param syllabusId the primary key of the syllabus
	 * @return the syllabus
	 * @throws PortalException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus getSyllabus(long syllabusId) throws PortalException {
		return syllabusPersistence.findByPrimaryKey(syllabusId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(syllabusLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Syllabus.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("syllabusId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(syllabusLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Syllabus.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("syllabusId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(syllabusLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Syllabus.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("syllabusId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return syllabusLocalService.deleteSyllabus((Syllabus)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return syllabusPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the syllabuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of syllabuses
	 */
	@Override
	public List<Syllabus> getSyllabuses(int start, int end) {
		return syllabusPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of syllabuses.
	 *
	 * @return the number of syllabuses
	 */
	@Override
	public int getSyllabusesCount() {
		return syllabusPersistence.countAll();
	}

	/**
	 * Updates the syllabus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param syllabus the syllabus
	 * @return the syllabus that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Syllabus updateSyllabus(Syllabus syllabus) {
		return syllabusPersistence.update(syllabus);
	}

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public hu.unideb.inf.service.CourseLocalService getCourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setCourseLocalService(
		hu.unideb.inf.service.CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public CoursePersistence getCoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setCoursePersistence(CoursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the course type local service.
	 *
	 * @return the course type local service
	 */
	public hu.unideb.inf.service.CourseTypeLocalService getCourseTypeLocalService() {
		return courseTypeLocalService;
	}

	/**
	 * Sets the course type local service.
	 *
	 * @param courseTypeLocalService the course type local service
	 */
	public void setCourseTypeLocalService(
		hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}

	/**
	 * Returns the course type persistence.
	 *
	 * @return the course type persistence
	 */
	public CourseTypePersistence getCourseTypePersistence() {
		return courseTypePersistence;
	}

	/**
	 * Sets the course type persistence.
	 *
	 * @param courseTypePersistence the course type persistence
	 */
	public void setCourseTypePersistence(
		CourseTypePersistence courseTypePersistence) {
		this.courseTypePersistence = courseTypePersistence;
	}

	/**
	 * Returns the curriculum local service.
	 *
	 * @return the curriculum local service
	 */
	public hu.unideb.inf.service.CurriculumLocalService getCurriculumLocalService() {
		return curriculumLocalService;
	}

	/**
	 * Sets the curriculum local service.
	 *
	 * @param curriculumLocalService the curriculum local service
	 */
	public void setCurriculumLocalService(
		hu.unideb.inf.service.CurriculumLocalService curriculumLocalService) {
		this.curriculumLocalService = curriculumLocalService;
	}

	/**
	 * Returns the curriculum persistence.
	 *
	 * @return the curriculum persistence
	 */
	public CurriculumPersistence getCurriculumPersistence() {
		return curriculumPersistence;
	}

	/**
	 * Sets the curriculum persistence.
	 *
	 * @param curriculumPersistence the curriculum persistence
	 */
	public void setCurriculumPersistence(
		CurriculumPersistence curriculumPersistence) {
		this.curriculumPersistence = curriculumPersistence;
	}

	/**
	 * Returns the lecturer local service.
	 *
	 * @return the lecturer local service
	 */
	public hu.unideb.inf.service.LecturerLocalService getLecturerLocalService() {
		return lecturerLocalService;
	}

	/**
	 * Sets the lecturer local service.
	 *
	 * @param lecturerLocalService the lecturer local service
	 */
	public void setLecturerLocalService(
		hu.unideb.inf.service.LecturerLocalService lecturerLocalService) {
		this.lecturerLocalService = lecturerLocalService;
	}

	/**
	 * Returns the lecturer persistence.
	 *
	 * @return the lecturer persistence
	 */
	public LecturerPersistence getLecturerPersistence() {
		return lecturerPersistence;
	}

	/**
	 * Sets the lecturer persistence.
	 *
	 * @param lecturerPersistence the lecturer persistence
	 */
	public void setLecturerPersistence(LecturerPersistence lecturerPersistence) {
		this.lecturerPersistence = lecturerPersistence;
	}

	/**
	 * Returns the semester local service.
	 *
	 * @return the semester local service
	 */
	public hu.unideb.inf.service.SemesterLocalService getSemesterLocalService() {
		return semesterLocalService;
	}

	/**
	 * Sets the semester local service.
	 *
	 * @param semesterLocalService the semester local service
	 */
	public void setSemesterLocalService(
		hu.unideb.inf.service.SemesterLocalService semesterLocalService) {
		this.semesterLocalService = semesterLocalService;
	}

	/**
	 * Returns the semester persistence.
	 *
	 * @return the semester persistence
	 */
	public SemesterPersistence getSemesterPersistence() {
		return semesterPersistence;
	}

	/**
	 * Sets the semester persistence.
	 *
	 * @param semesterPersistence the semester persistence
	 */
	public void setSemesterPersistence(SemesterPersistence semesterPersistence) {
		this.semesterPersistence = semesterPersistence;
	}

	/**
	 * Returns the subject local service.
	 *
	 * @return the subject local service
	 */
	public hu.unideb.inf.service.SubjectLocalService getSubjectLocalService() {
		return subjectLocalService;
	}

	/**
	 * Sets the subject local service.
	 *
	 * @param subjectLocalService the subject local service
	 */
	public void setSubjectLocalService(
		hu.unideb.inf.service.SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}

	/**
	 * Returns the subject persistence.
	 *
	 * @return the subject persistence
	 */
	public SubjectPersistence getSubjectPersistence() {
		return subjectPersistence;
	}

	/**
	 * Sets the subject persistence.
	 *
	 * @param subjectPersistence the subject persistence
	 */
	public void setSubjectPersistence(SubjectPersistence subjectPersistence) {
		this.subjectPersistence = subjectPersistence;
	}

	/**
	 * Returns the syllabus local service.
	 *
	 * @return the syllabus local service
	 */
	public SyllabusLocalService getSyllabusLocalService() {
		return syllabusLocalService;
	}

	/**
	 * Sets the syllabus local service.
	 *
	 * @param syllabusLocalService the syllabus local service
	 */
	public void setSyllabusLocalService(
		SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}

	/**
	 * Returns the syllabus persistence.
	 *
	 * @return the syllabus persistence
	 */
	public SyllabusPersistence getSyllabusPersistence() {
		return syllabusPersistence;
	}

	/**
	 * Sets the syllabus persistence.
	 *
	 * @param syllabusPersistence the syllabus persistence
	 */
	public void setSyllabusPersistence(SyllabusPersistence syllabusPersistence) {
		this.syllabusPersistence = syllabusPersistence;
	}

	/**
	 * Returns the timetable course local service.
	 *
	 * @return the timetable course local service
	 */
	public hu.unideb.inf.service.TimetableCourseLocalService getTimetableCourseLocalService() {
		return timetableCourseLocalService;
	}

	/**
	 * Sets the timetable course local service.
	 *
	 * @param timetableCourseLocalService the timetable course local service
	 */
	public void setTimetableCourseLocalService(
		hu.unideb.inf.service.TimetableCourseLocalService timetableCourseLocalService) {
		this.timetableCourseLocalService = timetableCourseLocalService;
	}

	/**
	 * Returns the timetable course persistence.
	 *
	 * @return the timetable course persistence
	 */
	public TimetableCoursePersistence getTimetableCoursePersistence() {
		return timetableCoursePersistence;
	}

	/**
	 * Sets the timetable course persistence.
	 *
	 * @param timetableCoursePersistence the timetable course persistence
	 */
	public void setTimetableCoursePersistence(
		TimetableCoursePersistence timetableCoursePersistence) {
		this.timetableCoursePersistence = timetableCoursePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("hu.unideb.inf.model.Syllabus",
			syllabusLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"hu.unideb.inf.model.Syllabus");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SyllabusLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Syllabus.class;
	}

	protected String getModelClassName() {
		return Syllabus.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = syllabusPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.unideb.inf.service.CourseLocalService.class)
	protected hu.unideb.inf.service.CourseLocalService courseLocalService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeLocalService.class)
	protected hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService;
	@BeanReference(type = CourseTypePersistence.class)
	protected CourseTypePersistence courseTypePersistence;
	@BeanReference(type = hu.unideb.inf.service.CurriculumLocalService.class)
	protected hu.unideb.inf.service.CurriculumLocalService curriculumLocalService;
	@BeanReference(type = CurriculumPersistence.class)
	protected CurriculumPersistence curriculumPersistence;
	@BeanReference(type = hu.unideb.inf.service.LecturerLocalService.class)
	protected hu.unideb.inf.service.LecturerLocalService lecturerLocalService;
	@BeanReference(type = LecturerPersistence.class)
	protected LecturerPersistence lecturerPersistence;
	@BeanReference(type = hu.unideb.inf.service.SemesterLocalService.class)
	protected hu.unideb.inf.service.SemesterLocalService semesterLocalService;
	@BeanReference(type = SemesterPersistence.class)
	protected SemesterPersistence semesterPersistence;
	@BeanReference(type = hu.unideb.inf.service.SubjectLocalService.class)
	protected hu.unideb.inf.service.SubjectLocalService subjectLocalService;
	@BeanReference(type = SubjectPersistence.class)
	protected SubjectPersistence subjectPersistence;
	@BeanReference(type = SyllabusLocalService.class)
	protected SyllabusLocalService syllabusLocalService;
	@BeanReference(type = SyllabusPersistence.class)
	protected SyllabusPersistence syllabusPersistence;
	@BeanReference(type = hu.unideb.inf.service.TimetableCourseLocalService.class)
	protected hu.unideb.inf.service.TimetableCourseLocalService timetableCourseLocalService;
	@BeanReference(type = TimetableCoursePersistence.class)
	protected TimetableCoursePersistence timetableCoursePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}
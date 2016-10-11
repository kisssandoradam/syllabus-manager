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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusService;
import hu.unideb.inf.service.persistence.CoursePersistence;
import hu.unideb.inf.service.persistence.CourseTypePersistence;
import hu.unideb.inf.service.persistence.CurriculumPersistence;
import hu.unideb.inf.service.persistence.LecturerPersistence;
import hu.unideb.inf.service.persistence.SemesterPersistence;
import hu.unideb.inf.service.persistence.SubjectPersistence;
import hu.unideb.inf.service.persistence.SyllabusPersistence;
import hu.unideb.inf.service.persistence.TimetableCoursePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the syllabus remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.unideb.inf.service.impl.SyllabusServiceImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.impl.SyllabusServiceImpl
 * @see hu.unideb.inf.service.SyllabusServiceUtil
 * @generated
 */
public abstract class SyllabusServiceBaseImpl extends BaseServiceImpl
	implements SyllabusService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.unideb.inf.service.SyllabusServiceUtil} to access the syllabus remote service.
	 */

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
	 * Returns the course remote service.
	 *
	 * @return the course remote service
	 */
	public hu.unideb.inf.service.CourseService getCourseService() {
		return courseService;
	}

	/**
	 * Sets the course remote service.
	 *
	 * @param courseService the course remote service
	 */
	public void setCourseService(
		hu.unideb.inf.service.CourseService courseService) {
		this.courseService = courseService;
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
	 * Returns the course type remote service.
	 *
	 * @return the course type remote service
	 */
	public hu.unideb.inf.service.CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	/**
	 * Sets the course type remote service.
	 *
	 * @param courseTypeService the course type remote service
	 */
	public void setCourseTypeService(
		hu.unideb.inf.service.CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
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
	 * Returns the curriculum remote service.
	 *
	 * @return the curriculum remote service
	 */
	public hu.unideb.inf.service.CurriculumService getCurriculumService() {
		return curriculumService;
	}

	/**
	 * Sets the curriculum remote service.
	 *
	 * @param curriculumService the curriculum remote service
	 */
	public void setCurriculumService(
		hu.unideb.inf.service.CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
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
	 * Returns the lecturer remote service.
	 *
	 * @return the lecturer remote service
	 */
	public hu.unideb.inf.service.LecturerService getLecturerService() {
		return lecturerService;
	}

	/**
	 * Sets the lecturer remote service.
	 *
	 * @param lecturerService the lecturer remote service
	 */
	public void setLecturerService(
		hu.unideb.inf.service.LecturerService lecturerService) {
		this.lecturerService = lecturerService;
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
	 * Returns the semester remote service.
	 *
	 * @return the semester remote service
	 */
	public hu.unideb.inf.service.SemesterService getSemesterService() {
		return semesterService;
	}

	/**
	 * Sets the semester remote service.
	 *
	 * @param semesterService the semester remote service
	 */
	public void setSemesterService(
		hu.unideb.inf.service.SemesterService semesterService) {
		this.semesterService = semesterService;
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
	 * Returns the subject remote service.
	 *
	 * @return the subject remote service
	 */
	public hu.unideb.inf.service.SubjectService getSubjectService() {
		return subjectService;
	}

	/**
	 * Sets the subject remote service.
	 *
	 * @param subjectService the subject remote service
	 */
	public void setSubjectService(
		hu.unideb.inf.service.SubjectService subjectService) {
		this.subjectService = subjectService;
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
	public hu.unideb.inf.service.SyllabusLocalService getSyllabusLocalService() {
		return syllabusLocalService;
	}

	/**
	 * Sets the syllabus local service.
	 *
	 * @param syllabusLocalService the syllabus local service
	 */
	public void setSyllabusLocalService(
		hu.unideb.inf.service.SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}

	/**
	 * Returns the syllabus remote service.
	 *
	 * @return the syllabus remote service
	 */
	public SyllabusService getSyllabusService() {
		return syllabusService;
	}

	/**
	 * Sets the syllabus remote service.
	 *
	 * @param syllabusService the syllabus remote service
	 */
	public void setSyllabusService(SyllabusService syllabusService) {
		this.syllabusService = syllabusService;
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
	 * Returns the timetable course remote service.
	 *
	 * @return the timetable course remote service
	 */
	public hu.unideb.inf.service.TimetableCourseService getTimetableCourseService() {
		return timetableCourseService;
	}

	/**
	 * Sets the timetable course remote service.
	 *
	 * @param timetableCourseService the timetable course remote service
	 */
	public void setTimetableCourseService(
		hu.unideb.inf.service.TimetableCourseService timetableCourseService) {
		this.timetableCourseService = timetableCourseService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SyllabusService.class.getName();
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
	@BeanReference(type = hu.unideb.inf.service.CourseService.class)
	protected hu.unideb.inf.service.CourseService courseService;
	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeLocalService.class)
	protected hu.unideb.inf.service.CourseTypeLocalService courseTypeLocalService;
	@BeanReference(type = hu.unideb.inf.service.CourseTypeService.class)
	protected hu.unideb.inf.service.CourseTypeService courseTypeService;
	@BeanReference(type = CourseTypePersistence.class)
	protected CourseTypePersistence courseTypePersistence;
	@BeanReference(type = hu.unideb.inf.service.CurriculumLocalService.class)
	protected hu.unideb.inf.service.CurriculumLocalService curriculumLocalService;
	@BeanReference(type = hu.unideb.inf.service.CurriculumService.class)
	protected hu.unideb.inf.service.CurriculumService curriculumService;
	@BeanReference(type = CurriculumPersistence.class)
	protected CurriculumPersistence curriculumPersistence;
	@BeanReference(type = hu.unideb.inf.service.LecturerLocalService.class)
	protected hu.unideb.inf.service.LecturerLocalService lecturerLocalService;
	@BeanReference(type = hu.unideb.inf.service.LecturerService.class)
	protected hu.unideb.inf.service.LecturerService lecturerService;
	@BeanReference(type = LecturerPersistence.class)
	protected LecturerPersistence lecturerPersistence;
	@BeanReference(type = hu.unideb.inf.service.SemesterLocalService.class)
	protected hu.unideb.inf.service.SemesterLocalService semesterLocalService;
	@BeanReference(type = hu.unideb.inf.service.SemesterService.class)
	protected hu.unideb.inf.service.SemesterService semesterService;
	@BeanReference(type = SemesterPersistence.class)
	protected SemesterPersistence semesterPersistence;
	@BeanReference(type = hu.unideb.inf.service.SubjectLocalService.class)
	protected hu.unideb.inf.service.SubjectLocalService subjectLocalService;
	@BeanReference(type = hu.unideb.inf.service.SubjectService.class)
	protected hu.unideb.inf.service.SubjectService subjectService;
	@BeanReference(type = SubjectPersistence.class)
	protected SubjectPersistence subjectPersistence;
	@BeanReference(type = hu.unideb.inf.service.SyllabusLocalService.class)
	protected hu.unideb.inf.service.SyllabusLocalService syllabusLocalService;
	@BeanReference(type = SyllabusService.class)
	protected SyllabusService syllabusService;
	@BeanReference(type = SyllabusPersistence.class)
	protected SyllabusPersistence syllabusPersistence;
	@BeanReference(type = hu.unideb.inf.service.TimetableCourseLocalService.class)
	protected hu.unideb.inf.service.TimetableCourseLocalService timetableCourseLocalService;
	@BeanReference(type = hu.unideb.inf.service.TimetableCourseService.class)
	protected hu.unideb.inf.service.TimetableCourseService timetableCourseService;
	@BeanReference(type = TimetableCoursePersistence.class)
	protected TimetableCoursePersistence timetableCoursePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}
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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseTypeService}.
 *
 * @author Adam Kiss
 * @see CourseTypeService
 * @generated
 */
public class CourseTypeServiceWrapper implements CourseTypeService,
	ServiceWrapper<CourseTypeService> {
	public CourseTypeServiceWrapper(CourseTypeService courseTypeService) {
		_courseTypeService = courseTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public hu.unideb.inf.model.CourseType getCourseTypeByCourseTypeId(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return _courseTypeService.getCourseTypeByCourseTypeId(courseTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseTypeService getWrappedCourseTypeService() {
		return _courseTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseTypeService(CourseTypeService courseTypeService) {
		_courseTypeService = courseTypeService;
	}

	@Override
	public CourseTypeService getWrappedService() {
		return _courseTypeService;
	}

	@Override
	public void setWrappedService(CourseTypeService courseTypeService) {
		_courseTypeService = courseTypeService;
	}

	private CourseTypeService _courseTypeService;
}
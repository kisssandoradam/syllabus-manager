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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import hu.unideb.inf.exception.NoSuchSubjectException;
import hu.unideb.inf.model.Subject;

import java.util.List;

/**
 * Provides the remote service interface for Subject. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Adam Kiss
 * @see SubjectServiceUtil
 * @see hu.unideb.inf.service.base.SubjectServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SubjectServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=syllabus_manager", "json.web.service.context.path=Subject"}, service = SubjectService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SubjectService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectServiceUtil} to access the subject remote service. Add custom service methods to {@link hu.unideb.inf.service.impl.SubjectServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Subject addSubject(java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	public Subject deleteSubject(long subjectId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Subject fetchSubjectByC_S(long curriculumId,
		java.lang.String subjectCode) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Subject getSubject(long subjectId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Subject getSubjectByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws SystemException, NoSuchSubjectException;

	public Subject updateSubject(long userId, long subjectId,
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubjectsCountByCurriculumId(long curriculumId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Subject> getSubjects() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Subject> getSubjectsByCurriculumId(long curriculumId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Subject> getSubjectsByCurriculumId(long curriculumId,
		int start, int end) throws SystemException;
}
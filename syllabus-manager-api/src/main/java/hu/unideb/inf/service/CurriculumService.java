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

import hu.unideb.inf.exception.NoSuchCurriculumException;
import hu.unideb.inf.model.Curriculum;

import java.util.List;

/**
 * Provides the remote service interface for Curriculum. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Adam Kiss
 * @see CurriculumServiceUtil
 * @see hu.unideb.inf.service.base.CurriculumServiceBaseImpl
 * @see hu.unideb.inf.service.impl.CurriculumServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=syllabus_manager", "json.web.service.context.path=Curriculum"}, service = CurriculumService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CurriculumService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CurriculumServiceUtil} to access the curriculum remote service. Add custom service methods to {@link hu.unideb.inf.service.impl.CurriculumServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Curriculum addCurriculum(java.lang.String curriculumCode,
		java.lang.String curriculumName, ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Curriculum deleteCurriculum(long curriculumId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Curriculum fetchCurriculumByCode(java.lang.String curriculumCode)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Curriculum getCurriculum(long curriculumId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Curriculum getCurriculumByCode(java.lang.String curriculumCode)
		throws SystemException, NoSuchCurriculumException;

	public Curriculum updateCurriculum(long userId, long curriculumId,
		java.lang.String curriculumCode, java.lang.String curriculumName,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Curriculum> getCurriculums() throws SystemException;
}
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

package hu.unideb.inf.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.model.Syllabus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Syllabus in entity cache.
 *
 * @author Adam Kiss
 * @see Syllabus
 * @generated
 */
@ProviderType
public class SyllabusCacheModel implements CacheModel<Syllabus>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SyllabusCacheModel)) {
			return false;
		}

		SyllabusCacheModel syllabusCacheModel = (SyllabusCacheModel)obj;

		if (syllabusId == syllabusCacheModel.syllabusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, syllabusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", syllabusId=");
		sb.append(syllabusId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", timetableCourseId=");
		sb.append(timetableCourseId);
		sb.append(", competence=");
		sb.append(competence);
		sb.append(", ethicalStandards=");
		sb.append(ethicalStandards);
		sb.append(", topics=");
		sb.append(topics);
		sb.append(", educationalMaterials=");
		sb.append(educationalMaterials);
		sb.append(", recommendedLiterature=");
		sb.append(recommendedLiterature);
		sb.append(", weeklyTasks=");
		sb.append(weeklyTasks);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Syllabus toEntityModel() {
		SyllabusImpl syllabusImpl = new SyllabusImpl();

		if (uuid == null) {
			syllabusImpl.setUuid(StringPool.BLANK);
		}
		else {
			syllabusImpl.setUuid(uuid);
		}

		syllabusImpl.setSyllabusId(syllabusId);
		syllabusImpl.setGroupId(groupId);
		syllabusImpl.setCompanyId(companyId);
		syllabusImpl.setUserId(userId);

		if (userName == null) {
			syllabusImpl.setUserName(StringPool.BLANK);
		}
		else {
			syllabusImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			syllabusImpl.setCreateDate(null);
		}
		else {
			syllabusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			syllabusImpl.setModifiedDate(null);
		}
		else {
			syllabusImpl.setModifiedDate(new Date(modifiedDate));
		}

		syllabusImpl.setTimetableCourseId(timetableCourseId);

		if (competence == null) {
			syllabusImpl.setCompetence(StringPool.BLANK);
		}
		else {
			syllabusImpl.setCompetence(competence);
		}

		if (ethicalStandards == null) {
			syllabusImpl.setEthicalStandards(StringPool.BLANK);
		}
		else {
			syllabusImpl.setEthicalStandards(ethicalStandards);
		}

		if (topics == null) {
			syllabusImpl.setTopics(StringPool.BLANK);
		}
		else {
			syllabusImpl.setTopics(topics);
		}

		if (educationalMaterials == null) {
			syllabusImpl.setEducationalMaterials(StringPool.BLANK);
		}
		else {
			syllabusImpl.setEducationalMaterials(educationalMaterials);
		}

		if (recommendedLiterature == null) {
			syllabusImpl.setRecommendedLiterature(StringPool.BLANK);
		}
		else {
			syllabusImpl.setRecommendedLiterature(recommendedLiterature);
		}

		if (weeklyTasks == null) {
			syllabusImpl.setWeeklyTasks(StringPool.BLANK);
		}
		else {
			syllabusImpl.setWeeklyTasks(weeklyTasks);
		}

		syllabusImpl.setStatus(status);
		syllabusImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			syllabusImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			syllabusImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			syllabusImpl.setStatusDate(null);
		}
		else {
			syllabusImpl.setStatusDate(new Date(statusDate));
		}

		syllabusImpl.resetOriginalValues();

		return syllabusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		syllabusId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		timetableCourseId = objectInput.readLong();
		competence = objectInput.readUTF();
		ethicalStandards = objectInput.readUTF();
		topics = objectInput.readUTF();
		educationalMaterials = objectInput.readUTF();
		recommendedLiterature = objectInput.readUTF();
		weeklyTasks = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(syllabusId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(timetableCourseId);

		if (competence == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(competence);
		}

		if (ethicalStandards == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ethicalStandards);
		}

		if (topics == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topics);
		}

		if (educationalMaterials == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(educationalMaterials);
		}

		if (recommendedLiterature == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recommendedLiterature);
		}

		if (weeklyTasks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(weeklyTasks);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long syllabusId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long timetableCourseId;
	public String competence;
	public String ethicalStandards;
	public String topics;
	public String educationalMaterials;
	public String recommendedLiterature;
	public String weeklyTasks;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}
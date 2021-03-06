<%@include file="/init.jsp"%>

<%
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Subject subject = null;
	
	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(subjectId);
		curriculumId = subject.getCurriculumId();
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", WebKeys.VIEW_COURSES);
	iteratorURL.setParameter("subjectId", String.valueOf(subjectId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<%@ include file="/notifications/success.jspf" %>
<%@ include file="/notifications/error.jspf" %>

<c:set var="home" value="<%=WebKeys.ADMIN_HOME_CURRICULUMS%>" scope="request" />
<c:set var="curriculumId" value="<%=curriculumId%>" scope="request" />
<c:set var="subjectId" value="<%=subjectId%>" scope="request" />

<jsp:include page="/admin/navigation_bar.jsp" />
<jsp:include page="/admin/breadcrumb.jsp" />

<aui:form method="post" name="fmCourse">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="courses-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>" total="<%=CourseLocalServiceUtil.getCoursesCountBySubjectId(subjectId)%>">
		<aui:input name="subjectId" type="hidden" value="<%= subjectId %>" />
		<aui:input name="deleteCourseIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=CourseLocalServiceUtil.getCoursesBySubjectId(subjectId, searchContainer.getStart(), searchContainer.getEnd())%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Course" escapedModel="<%= true %>" modelVar="course" keyProperty="courseId">
			<c:if test='<%=CoursePermission.contains(permissionChecker, course.getCourseId(), "VIEW")%>'>				
				<portlet:renderURL var="viewTimetableCoursesURL">
					<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_TIMETABLE_COURSES%>" />
					<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
					<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
					<portlet:param name="courseId" value="<%=String.valueOf(course.getCourseId())%>" />
					<portlet:param name="home" value="<%=WebKeys.ADMIN_HOME_CURRICULUMS%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="course-type"
					value="<%=HtmlUtil.escapeAttribute(CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId()).getTypeName())%>" href="<%=viewTimetableCoursesURL.toString()%>" />
				<liferay-ui:search-container-column-text name="hours-per-semester" property="hoursPerSemester" />
				<liferay-ui:search-container-column-text name="hours-per-week" property="hoursPerWeek" />
				<liferay-ui:search-container-column-jsp path="/admin/courses/course_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_COURSES)%>'>
	<portlet:actionURL name="deleteCourses" var="deleteCoursesURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
	</portlet:actionURL>
	
	<aui:script use="aui-base">
		A.one('.removeCheckedItemsButton').on(
			'click',
			function(event) {
				<portlet:namespace />deleteCourses();
			}
		);
		
	    Liferay.provide(
	        window,
	        '<portlet:namespace />deleteCourses',
	        function() {
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmCourse.method = "post";
					document.<portlet:namespace />fmCourse.<portlet:namespace />deleteCourseIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCourse, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmCourse, "<%=deleteCoursesURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>
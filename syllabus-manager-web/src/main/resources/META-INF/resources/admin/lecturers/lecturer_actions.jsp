<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Lecturer lecturer = (Lecturer) row.getObject();
	long lecturerId = lecturer.getLecturerId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="lecturerId" value="<%=String.valueOf(lecturerId)%>" />
			<portlet:param name="mvcPath" value="<%=WebKeys.EDIT_LECTURER%>" />
			<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Lecturer.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(lecturerId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteLecturer" var="deleteURL">
			<portlet:param name="lecturerId" value="<%=String.valueOf(lecturerId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>

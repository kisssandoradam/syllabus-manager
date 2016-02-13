<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Semester semester = (Semester) row.getObject();
%>

<liferay-ui:icon-menu>
    <c:if test="<%= SemesterPermission.contains(permissionChecker, semester.getSemesterId(), ActionKeys.UPDATE) %>">
        <portlet:renderURL var="editURL">
            <portlet:param name="semesterId" value="<%= String.valueOf(semester.getSemesterId()) %>" />
            <portlet:param name="mvcPath" value="/html/subjectcourseadmin/semesters/edit_semester.jsp" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />
    </c:if>
    
    <c:if test="<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(), ActionKeys.PERMISSIONS) %>">
	    <liferay-security:permissionsURL
	        modelResource="<%= Semester.class.getName() %>"
	        modelResourceDescription=""
	        resourcePrimKey="<%= String.valueOf(semester.getSemesterId()) %>"
	        var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />
	
	    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" useDialog="true" />
	</c:if>
	
	<c:if test="<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(), ActionKeys.DELETE) %>">
        <portlet:actionURL name="deleteSemester" var="deleteURL">
            <portlet:param name="semesterId"
                value="<%= String.valueOf(semester.getSemesterId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
    </c:if>
</liferay-ui:icon-menu>
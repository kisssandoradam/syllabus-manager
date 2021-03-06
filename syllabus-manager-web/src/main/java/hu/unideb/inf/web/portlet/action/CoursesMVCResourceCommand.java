package hu.unideb.inf.web.portlet.action;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.CourseLocalService;
import hu.unideb.inf.service.CourseTypeLocalService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_RESOURCE_SERVE_COURSES
	},
	service = MVCResourceCommand.class
)
public class CoursesMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(CoursesMVCResourceCommand.class);

	private CourseLocalService courseLocalService;

	private CourseTypeLocalService courseTypeLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.trace("Subject selected, serving courses.");

		try (PrintWriter writer = resourceResponse.getWriter()) {
			long subjectId = ParamUtil.getLong(resourceRequest, "subjectSelect");

			if (log.isDebugEnabled()) {
				log.debug(String.format("subjectId: %d", subjectId));
			}

			JSONArray jsonArray = serveCourses(subjectId);

			if (log.isDebugEnabled()) {
				log.debug(String.format("courses to serve: '%s'", jsonArray));
			}

			writer.write(jsonArray.toString());
			writer.flush();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
		}
	}

	private JSONArray serveCourses(long subjectId) throws PortalException {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<Course> courses = courseLocalService.getCoursesBySubjectId(subjectId);
		for (Course course : courses) {
			Course c = course.toEscapedModel();
			CourseType ct = courseTypeLocalService.getCourseType(c.getCourseTypeId()).toEscapedModel();

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("courseId", c.getCourseId());
			jsonObject.put("courseTypeName", ct.getTypeName());
			jsonObject.put("hoursPerSemester", c.getHoursPerSemester());
			jsonObject.put("hoursPerWeek", c.getHoursPerWeek());

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	@Reference(unbind = "-")
	protected void setCourseService(CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	@Reference(unbind = "-")
	protected void setCourseTypeService(CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}

}

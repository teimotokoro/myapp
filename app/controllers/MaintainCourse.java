package controllers;

import models.Course;
import models.CourseExecution;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;

/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 19/09/13
 * Time: 12:10
 * To change this template use File | Settings | File Templates.
 */
public class MaintainCourse extends Controller {


    static Form<CourseExecution> courseExecutionForm = Form.form(CourseExecution.class);

    public static Result findCourse(Long id){
        return ok(views.html.MaintainCourse.render(Course.findCourseById(id),courseExecutionForm));

    }

    public static Result newCourseExecution(Long courseId, CourseExecution courseExecution){
      return ok();
    }

}
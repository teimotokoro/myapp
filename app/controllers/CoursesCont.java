package controllers;

/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 27/08/13
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */

import models.Course;
import play.mvc.*;
import play.data.*;
import java.lang.*;
import java.util.*;



public class CoursesCont extends Controller {

    static Form<Course> courseForm = Form.form(Course.class);


    public static Result index() {
        return ok(views.html.index.render("Called index method Your new Course List in being worked on."));
    }

    public static Result listCourses() {

       return ok(views.html.listCourses.render(Course.all(),courseForm));
    }

    public static Result newCourse() {
        Form<Course> filledForm = courseForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(views.html.listCourses.render(Course.all(), filledForm));
        } else {
            Course.create(filledForm.get());
            return redirect(routes.CoursesCont.listCourses());

            }
        }


    public static Result deleteCourse(Long id) {
        Course.delete(id);
        return redirect(routes.CoursesCont.listCourses());
    }

}



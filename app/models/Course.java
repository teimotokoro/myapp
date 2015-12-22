package models;



import play.db.ebean.Model;
import java.util.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import play.data.*;
import models.*;


/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 27/08/13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Course extends Model {


    @Id
    public Long id;
    @Required
    public String courseName;
    public String courseDescription;

    @OneToMany
    public List<CourseExecution> courseExecutionList;

    public static Finder<Long, Course> find = new Finder( Long.class, Course.class);

    public static List<Course> all(){
        return find.all();


    }

    public static void create (Course course){
        course.save();


        }


    public static void delete(Long id){
        find.ref(id).delete();

    }

    public static Course findCourseById(Long id){
        return find.byId(id);
    }



}

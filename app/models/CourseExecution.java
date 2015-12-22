package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.lang.*;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 11/09/13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class CourseExecution extends Model {

    @Id
   public Long id;

   public Date startDate;
   public int days;
   public float costPerDay;


    @ManyToOne
    public Course course;


    @ManyToMany
    public List<Person> persons;

    public static Finder<Long, CourseExecution> find = new Finder( Long.class, CourseExecution.class);

    public static List<CourseExecution> all(Long id){
        return find.all();

    }

    public static void create (CourseExecution courseExecution){
        courseExecution.save();

    }

    public static void delete(Long id){
        find.ref(id).delete();
    }


}

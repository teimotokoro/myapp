
import models.Course;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import java.util.*;
import java.lang.*;

/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 05/09/13
 * Time: 00:15
 * To change this template use File | Settings | File Templates.
 */
public class ModelTests extends WithApplication {

    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }


    @Test
    public void  createAndRetrieveCourse(){

        Course course1 = new Course();
        course1.courseName="testCourse1";
        course1.courseDescription="description1";
        course1.save();

        Course course2 = new Course();
        course2.courseName="testCourse2";
        course2.courseDescription="description2";
        course2.save();

        Course course3 = new Course();
        course3.courseName="testCourse3";
        course3.courseDescription="description3";
        course3.save();


        //    find the number of entries
        List<Course> courseList = Course.find.all();
        assertNotNull(courseList);
        assertEquals(3,courseList.size());
    }
     //find course 3
     @Test
     public void testFindCourse() {
            Course course = Course.find.where().eq("courseName","testCourse3").findUnique();
            assertNotNull(course);
            assertEquals("description3",course.courseDescription);
        }


    @Test
    public void testDeleteCourse() {
        Course course = Course.find.where().eq("courseName","testCourse3").findUnique();
        course.delete();
        Course courseFind = Course.find.where().eq("courseName","testCourse3").findUnique();
        assertNotNull(courseFind);
        assertEquals("description3",course.courseDescription);
    }




    }



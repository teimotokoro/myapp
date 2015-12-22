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
 * Date: 06/09/13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Person extends Model {


    @Id
    public long id;
    @Required
    public String firstName;
    @Required
    public String lastName;
    public String middleInitial;


    public static Model.Finder<Long, Person> find = new Model.Finder(Long.class, Person.class);


    public static List<Person> all() {
        return find.all();
    }
    public static void create(Person person) {
        person.save();
    }
        public static void delete (Long id){
            find.ref(id).delete();
        }

}

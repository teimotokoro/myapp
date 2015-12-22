package controllers;



import models.Person;
import play.mvc.*;
import play.data.*;
import java.lang.*;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: Teomo
 * Date: 06/09/13
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class PersonCont extends Controller {


    static Form<Person> personForm = Form.form(Person.class);

    public static Result index() {
        return ok(views.html.index.render("Called index method Your new Person List in being worked on."));
    }

    public static Result listPerson() {

        return ok(views.html.listPerson.render(Person.all(),personForm));
    }

    public static Result newPerson() {
        Form<Person> filledForm = personForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(views.html.listPerson.render(Person.all(), filledForm));
        } else {
            Person.create(filledForm.get());
            return redirect(routes.PersonCont.listPerson());
        }
    }

    public static Result deletePerson(Long id) {
        Person.delete(id);
        return redirect(routes.PersonCont.listPerson());

    }


    public static Result user(Long id){
        return ok("Play's controller told that you're about to get data for user no. "+id);
    }
}

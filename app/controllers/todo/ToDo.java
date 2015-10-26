package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import play.data.Form;
import models.Task;

public class ToDo extends Controller {

    static Form<Task> taskForm = Form.form(Task.class);

    public Result foo() {
        return ok(foo.render("todoa app"));
    }

    public Result tasks() {
        return ok(tasks.render(Task.all(), taskForm));
      }

      public  Result newTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors()) {
          return badRequest(
            views.html.index.render(Task.all(), filledForm)
          );
        } else {
          Task.create(filledForm.get());
          return redirect(routes.Application.tasks());
        }
      }

      public Result deleteTask(Long id) {
        return TODO;
      }

}

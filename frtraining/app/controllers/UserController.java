package controllers;
import javax.inject.Singleton;
import play.mvc.*;
import tables.T_User;
import tables.Repositry;
import play.data.Form;
import play.data.FormFactory;
import java.util.List;
import com.google.inject.Inject;
import models.find.Receipt;

@Singleton
public class UserController extends Controller {
  @Inject
  FormFactory formFactory;

  Repositry item = new Repositry();
  boolean isEmp;

  public Result init(Http.Request request) {
    T_User t = new T_User();
    isEmp = true;
    return ok(views.html.user.render(t,isEmp));
  }

  public Result create(Http.Request request){
    T_User t = new T_User();
    isEmp = true;
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    if (f.hasErrors()) {
      return badRequest(views.html.user.render(t,isEmp));
    }
    Receipt r = f.get();
    if(r.name.isEmpty() || item.strToDate(r.birthDay) == null) {
      return badRequest(views.html.user.render(t,isEmp));
    }
    this.item.add(r);
    return redirect(routes.Application.index());
  }

  public Result edit(Http.Request request, Long id) {
    T_User t = new T_User();
    isEmp = false;
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    if (f.hasErrors()) {
      return badRequest(views.html.user.render(t,isEmp));
    }
    Receipt r = f.get();
    r.id = id;
    t = item.find(id).get(0);
    return ok(views.html.user.render(t,isEmp));
  }

  public Result update(Http.Request request, Long id) {
    T_User t = new T_User();
    isEmp = false;
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    if (f.hasErrors()) {
      return redirect(routes.UserController.edit(id));
    }
    Receipt r = f.get();
    r.id = id;
    if(r.name.isEmpty() || item.strToDate(r.birthDay) == null) {
      return redirect(routes.UserController.edit(id));
    }
    this.item.update(r);
    t = item.find(id).get(0);
    return redirect(routes.Application.index());
  }

  public Result delete(Http.Request request, Long id){
    item.delete(id);
    return redirect(routes.Application.index());
  }
}

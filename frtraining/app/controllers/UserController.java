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
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();
    this.item.add(r);
    isEmp = true;
    return ok(views.html.user.render(t,isEmp));
  }

  public Result edit(Http.Request request, Long id) {
    T_User t = new T_User();
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();
    r.id = id;
    t = item.find(id).get(0);
    isEmp = false;
    return ok(views.html.user.render(t,isEmp));
  }

  public Result update(Http.Request request, Long id) {
    T_User t = new T_User();
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();
    r.id = id;
    this.item.update(r);
    t = item.find(id).get(0);
    isEmp = false;
    return ok(views.html.user.render(t,isEmp));
  }

  public Result delete(Http.Request request, Long id){
    item.delete(id);
    return redirect(routes.Application.index());
  }
}

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

  public Result init(Http.Request request) {
    return ok(views.html.user.render());
  }

  public Result create(Http.Request request){
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();
    Repositry cr = new Repositry();
    cr.add(r);
    return ok(views.html.user.render());
  }
}

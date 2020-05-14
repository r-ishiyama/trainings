package controllers;

import javax.inject.Singleton;

import play.data.Form;
import play.data.FormFactory;

import java.util.List;
import play.mvc.*;

import tables.*;
import models.find.Receipt;

import com.google.inject.Inject;

@Singleton
public class Application extends Controller {

  @Inject
  FormFactory formFactory;

  public Result index(Http.Request request) {
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();
    List<T_User> items = Repositry.find(r.input);
    return ok(views.html.index.render(items, f));
  }
}

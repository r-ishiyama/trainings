package controllers;

import javax.inject.Singleton;


import io.ebean.Finder;

import play.data.Form;
import play.data.FormFactory;

import java.util.List;
import play.mvc.*;

import tables.*;
import models.find.Receipt;

import com.google.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class Application extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


  @Inject
  FormFactory formFactory;



  public Result index(Http.Request request) {
    Form<Receipt> f = formFactory.form(Receipt.class).bindFromRequest(request);
    Receipt r = f.get();

    List<T_User> items = Repositry.find(r.input);

    return ok(views.html.index.render(items, f));
  }
}

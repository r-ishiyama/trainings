package controllers;

import javax.inject.Singleton;

import io.ebean.Finder;

import java.util.List;
import play.mvc.Controller;
import play.mvc.Result;

import tables.T_User;

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
  public Result index() {
    Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
    List<T_User> items = finder.all();
    return ok(views.html.index.render(items));
  }

}

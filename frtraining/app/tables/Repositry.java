package tables;

import java.util.*;
import tables.T_User;
import play.db.ebean.*;
import io.ebean.*;

public class Repositry {
  public static Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);

  public static List<T_User> find(String s) {
    if (s == null) {
      return finder.all();
    } else {
      return finder.query().where().ilike("name", "%" + s + "%").findList();
    }

  }
}

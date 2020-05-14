package tables;

import java.util.*;
import tables.T_User;
import play.db.ebean.*;
import io.ebean.*;
import models.find.Receipt;

public class Repositry {
  public static Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);

  public static List<T_User> find(String s) {
    if (s == null) {
      return finder.all();
    } else {
      return finder.query().where().ilike("name", "%" + s + "%").findList();
    }
  }

  T_User newUser = new T_User();



  public void add(Receipt in) {
    this.newUser.name = in.name;
    this.newUser.schoolYear = in.schoolYear;
    this.newUser.birthDay = in.birthDay;
    this.newUser.height = in.height;
    this.newUser.food = in.food;
    newUser.save();
  }
}


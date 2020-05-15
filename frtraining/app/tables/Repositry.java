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

  public static List<T_User> find(Long id) {
    return finder.query().where().eq("id",  id).findList();
  }

  public void add(Receipt in) {
    T_User newUser = new T_User();
    newUser.name = in.name;
    newUser.schoolYear = in.schoolYear;
    newUser.birthDay = in.birthDay;
    newUser.height = in.height;
    newUser.food = in.food;
    newUser.save();
  }

  public void update(Receipt in) {
    T_User updatedUser = find(in.id).get(0);
    if (in.name != null) {
      updatedUser.name = in.name;
    }
    if (in.schoolYear != null) {
      updatedUser.schoolYear = in.schoolYear;
    }
    if (in.birthDay != null) {
      updatedUser.birthDay = in.birthDay;
    }
    if (in.height != null) {
      updatedUser.height = in.height;
    }
    if (in.food != null) {
      updatedUser.food = in.food;
    }
    updatedUser.save();
  }

  public void delete(Long id) {
    T_User deletedUser = find(id).get(0);
    deletedUser.delete();
  }
}


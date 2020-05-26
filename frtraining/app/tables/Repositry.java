package tables;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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

  public Date strToDate(String s){
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
    try {
      Date d = sdFormat.parse(s);
      return d;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }

  }

  public void add(Receipt in) {
    T_User newUser = new T_User();
    newUser.name = in.name;
    newUser.schoolYear = in.schoolYear;
    newUser.birthDay = strToDate(in.birthDay);
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
      updatedUser.birthDay = strToDate(in.birthDay);
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


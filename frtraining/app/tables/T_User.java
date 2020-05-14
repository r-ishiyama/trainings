package tables;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.*;


@Entity
public class T_User extends BaseTable {
  @Id
  public Long id;

  public String name;
  public Integer schoolYear;
  public Date birthDay;
  public Integer height;
  public String food;
}

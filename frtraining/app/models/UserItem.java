package models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import play.data.format.Formats;
import tables.T_User;

@Getter
@NoArgsConstructor
public class UserItem {
  public Long id;
  public String name;
  public String schoolYear;
  @Formats.DateTime(pattern = "MM月dd日")
  public Date birthDay;
  public String height;
  public String food;
  @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
  public Date createdAt;
  @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
  public Date updatedAt;

  public UserItem(T_User user) {
    this.id = user.id;
    this.name = user.schoolYear + "年生";
    this.birthDay = user.birthDay;
    this.height = user.height + "cm";
    this.food = user.food;
    this.createdAt =user.createdAt;
    this.updatedAt = user.updatedAt;
  }
}

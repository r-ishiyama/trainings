package tables;

import java.util.Date;

import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Version;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseTable extends Model {
  @CreatedTimestamp
  public Date createdAt;

  @Version
  public Date updatedAt;

}

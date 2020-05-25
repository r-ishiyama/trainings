package frtraining;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import models.find.Receipt;
import tables.Repositry;
import static org.mockito.Mockito.*;

public class ModelTest {

  @Test
  public void testFindId() {
    Repositry repositry = new Repositry();
    assertEquals(1l,(long)repositry.find(1l).get(0).id);
  }

  @Test
  public void testFindName() {
    Repositry repositry = new Repositry();
    assertEquals(1l,(long)repositry.find("").get(0).id);
  }

  @Test
  public void testStrToDate() {
    Repositry repositry = new Repositry();
    assertEquals("Fri May 22 00:00:00 JST 2020", repositry.strToDate("2020/05/22").toString());
  }

  @Test
  public void testDatabaseManagement() {
    Repositry repositry = new Repositry();
  }

}

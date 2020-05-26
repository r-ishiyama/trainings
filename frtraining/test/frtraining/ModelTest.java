package frtraining;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.*;
import org.junit.*;
import java.util.*;


import models.find.Receipt;
import tables.Repositry;
import static org.mockito.Mockito.*;
import play.mvc.*;

public class ModelTest {
  play.Application fakeApp = fakeApplication();

  @Before
  public void setUpTest() {
    start(this.fakeApp);
  }

  @After
  public void tearDownTest() {
    stop(this.fakeApp);
  }

  @Test
  public void testFindId() {
    assertEquals(1l,(long)Repositry.find(1l).get(0).id);
  }

  @Test
  public void testFindName() {
    assertEquals(1l,(long)Repositry.find("").get(0).id);
  }

  @Test
  public void testStrToDate() {
    Repositry repositry = new Repositry();
    assertEquals("Fri May 22 00:00:00 JST 2020", repositry.strToDate("2020/05/22").toString());
  }

  @Test
  public void testAdd() {
    Receipt receipt = new Receipt();
    receipt.name = "たけし";
    receipt.schoolYear = 2;
    receipt.birthDay = "2000/01/01";
    receipt.height = 180;
    receipt.food = "プロテイン";

    Repositry repositry = new Repositry();
    repositry.add(receipt);
    assertEquals("プロテイン",Repositry.find("たけし").get(0).food);
  }

  @Test
  public void testUpdate() {
    Receipt receipt = new Receipt();
    receipt.id = 7l;
    receipt.name = "たけし";
    receipt.schoolYear = 2;
    receipt.birthDay = "2000/01/01";
    receipt.height = 180;
    receipt.food = "プロテイン";

    Repositry repositry = new Repositry();
    repositry.update(receipt);
    assertEquals("プロテイン",Repositry.find(7l).get(0).food);
  }

  @Test
  public void testDelete() {
    Repositry repositry = new Repositry();
    repositry.delete(5l);
    assertEquals(Repositry.find("たなか"), Repositry.find("渡辺"));
  }

}

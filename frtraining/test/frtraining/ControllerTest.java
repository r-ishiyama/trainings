package frtraining;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import play.twirl.api.Content;
import static play.test.Helpers.*;

import tables.T_User;
import controllers.Application;
import controllers.UserController;

import play.mvc.*;

import org.junit.*;

public class ControllerTest {
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
  public void testIndex() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/");
    Result result = route(fakeApp, request);
    assertEquals(200, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("黒澤"));
  }

  @Test
  public void testIndexSearch() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/?input=ダイヤ");
    Result result = route(fakeApp, request);
    assertEquals(200, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("プリン"));
  }

  @Test
  public void testInit() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/user");
    Result result = route(fakeApp, request);
    assertEquals(200, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("新規登録(^^"));
  }

  @Test
  public void testEdit() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/user/1");
    Result result = route(fakeApp, request);
    assertEquals(200, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("編集(^^"));
  }

  @Test
  public void testDelete() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/user/8/delete");
    Result result = route(fakeApp, request);
    assertEquals(303, result.status());
  }

  @Test
  public void testCreate() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/user/submit?id=&name=%E3%81%82&schoolYear=3&birthDay=1999%2F10%2F10&height=200&food=aa");
    Result result = route(fakeApp, request);
    assertEquals(303, result.status());
  }

  @Test
  public void testUpdate() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/user/3/update?id=&name=%E6%9D%BE%E6%B5%A6+%E6%9E%9C%E5%8D%97&schoolYear=3&birthDay=2003%2F02%2F10&height=162&food=%E3%81%95%E3%81%96%E3%81%88%E3%83%BB%E3%82%8F%E3%81%8B%E3%82%81");
    Result result = route(fakeApp, request);
    assertEquals(303, result.status());
  }

}

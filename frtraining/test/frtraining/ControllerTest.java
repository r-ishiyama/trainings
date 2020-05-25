package frtraining;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import play.twirl.api.Content;
import static play.test.Helpers.*;

import controllers.Application;

import play.mvc.*;

import org.junit.Test;

public class ControllerTest {
  play.Application fakeApp = fakeApplication();

  @Test
  public void testIndex() {
    Http.RequestBuilder request = fakeRequest().method(GET).uri("/");
    Result result = route(fakeApp, request);
    assertEquals(200, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("黒澤"));
  }
}

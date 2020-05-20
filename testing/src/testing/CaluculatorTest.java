package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CaluculatorTest {

	@Test
	void mulTest() {
		Calculator cal = new Calculator();
		int exp = 10;
		int act = cal.maltiplication(5, 2);
		assertEquals(act,exp);
	}
	
	@Test
	void divTest() {
		Calculator cal = new Calculator();
		float exp = 0.625f;
		float act = cal.division(5, 8);
		assertEquals(act,exp);
	}

}

package chess.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class ColorTest {

	@Test
	void colorTest() {
		assertEquals(Color.WHITE.toString(), "WHITE");
		assertEquals(Color.BLACK.toString(), "BLACK");
	}

}

package chess.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class ChessMoveExceptionTest {

	@Test
	void chessMoveExceptionTest() {
		String text = "test";
		Position start = new Position(1, 0);
		Position end = new Position(0, 1);
		ChessMoveException exception = new ChessMoveException(text, start, end);
		assertEquals(exception.getMessage(), text + " ( Départ : " + start.getX() + "," + start.getY()
				+ " / Destination : " + end.getX() + "," + end.getY() + " )");
	}

}

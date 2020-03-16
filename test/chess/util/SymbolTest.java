package chess.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class SymbolTest {

	@Test
	void symbolTest() {
		assertEquals(Symbol.WHITE_KING, '♔');
		assertEquals(Symbol.WHITE_QUEEN, '♕');
		assertEquals(Symbol.WHITE_ROOK, '♖');
		assertEquals(Symbol.WHITE_BISHOP, '♗');
		assertEquals(Symbol.WHITE_KNIGHT, '♘');
		assertEquals(Symbol.WHITE_PAWN, '♙');

		assertEquals(Symbol.BLACK_KING, '♚');
		assertEquals(Symbol.BLACK_QUEEN, '♛');
		assertEquals(Symbol.BLACK_ROOK, '♜');
		assertEquals(Symbol.BLACK_BISHOP, '♝');
		assertEquals(Symbol.BLACK_KNIGHT, '♞');
		assertEquals(Symbol.BLACK_PAWN, '♟');
		assertEquals(Symbol.BLACK_BISHOP, '♝');
	}

}

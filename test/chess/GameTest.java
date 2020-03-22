package chess;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

class GameTest {

	@Test
	void TurnTest() {
		Game g = new Game("Mehdi","Charles");
		assertEquals(Color.WHITE,g.getCurrentColor());
		try {
			g.turn(new Position(0,0),new Position(0,3));
			assertEquals(Color.BLACK,g.getCurrentColor());
		} catch (ChessMoveException exception){}
	}

	@Test
	void NullStartTurnTest() {
		Game g = new Game("Mehdi","Charles");
		try {
			g.turn(null,new Position(0,7));
			fail("Fail");
		} catch(ChessMoveException e) {}
		
	}
	@Test
	void PositionIsTakenTurnTest() {
		Game g = new Game("Mehdi","Charles");
		try {
			g.turn(new Position(0,0),new Position(0,7));
			fail("Fail");
		} catch(ChessMoveException e) {}
		
	}
	@Test
	void getBlackPlayerNameTest() {
		Game g = new Game("Mehdi","Charles");
		assertEquals("Mehdi",g.getBlackPlayerName());
	}
	@Test
	void getWhitePlayerNameTest() {
		Game g = new Game("Mehdi","Charles");
		assertEquals("Charles",g.getWhitePlayerName());
	}
	@Test
	void getCurrentColorTest() {
		Game g = new Game("Mehdi","Charles");
		assertEquals(Color.WHITE,g.getCurrentColor());
	}
	@Test
	void getCurrentColorAfterTurnTest() {
		Game g = new Game("Mehdi","Charles");
		try {
			g.turn(new Position(0,0),new Position(0,3));
			assertEquals(Color.BLACK,g.getCurrentColor());
		} catch (ChessMoveException exception){}
		assertEquals(Color.BLACK,g.getCurrentColor());
	}


}

package chess;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

class GameTest {

	@Test
	void gameTest() {
		String black = "Mehdi";
		String white = "Charles";
		Game game = new Game(black,white);
		assertEquals(game.getCurrentColor(), Color.WHITE);
		assertEquals(game.getBlackPlayerName(), black);
		assertEquals(game.getWhitePlayerName(), white);
	}
	
	@Test
	void gameBlackPlayerTest() {
		Game game = new Game("Mehdi","Charles");
		assertEquals(game.getBlackPlayerName(),"Mehdi");
	}
	
	@Test
	void gameWhitePlayerTest() {
		Game game = new Game("Mehdi","Charles");
		assertEquals(game.getWhitePlayerName(),"Charles");
	}
	
	@Test
	void getCurrentColorStartGameTest() {
		Game game = new Game("Mehdi","Charles");
		assertEquals(game.getCurrentColor(),Color.WHITE);
	}
	
	@Test
	void turnNormalTest() {
		Game game = new Game("Mehdi","Charles");
		Position start = new Position("G1");
		Position end = new Position("F3");
		try {
			game.turn(start, end);
		} catch (ChessMoveException exception) {}
	}
	
	@Test
	void turnErrorTest() {
		Game game = new Game("Mehdi","Charles");
		Position start = new Position("G1");
		Position end = new Position("G3");
		try {
			game.turn(start, end);
			fail("Erreur le cavalier ne se déplace pas en ligne droite.");
		} catch (ChessMoveException exception) {}
	}
	
	@Test
	void turnExceptionStartNullTest() {
		Game game = new Game("Mehdi","Charles");
		Position start = new Position("A3");
		Position end = new Position("A4");
		try {
			game.turn(start, end);
			fail("Erreur la case de départ est vide.");
		} catch (ChessMoveException exception) {}
	}
	
	@Test
	void turnExceptionYourPieceOnDestinationTest() {
		Game game = new Game("Mehdi","Charles");
		Position start = new Position("A1");
		Position end = new Position("A2");
		try {
			game.turn(start, end);
			fail("Erreur la case de destination contient une de vos pièces.");
		} catch (ChessMoveException exception) {}
	}

	@Test
	void turnExceptionEnemyPieceOnStartTest() {
		Game game = new Game("Mehdi","Charles");
		Position start = new Position("H7");
		Position end = new Position("H6");
		try {
			game.turn(start, end);
			fail("Erreur la case de départ contient une pièce adverse.");
		} catch (ChessMoveException exception) {}
	}
	
	@Test
	void isNotEchecTest() {
		Game game = new Game("Mehdi","Charles");
		assertFalse(game.isEchec(Color.WHITE));
	}
	
	@Test
	void isEchecTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("E2"), new Position("E3"));
			game.turn(new Position("E7"), new Position("E6"));
			game.turn(new Position("E1"), new Position("E2"));
			game.turn(new Position("D8"), new Position("E7"));
			game.turn(new Position("E2"), new Position("B5"));
			game.turn(new Position("H7"), new Position("H6"));
			game.turn(new Position("B5"), new Position("D7"));
			assertTrue(game.isEchec(Color.BLACK));

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void playerColorWinNullTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("E2"), new Position("E3"));
			game.turn(new Position("E7"), new Position("E6"));
			game.turn(new Position("E1"), new Position("E2"));
			game.turn(new Position("D8"), new Position("E7"));
			game.turn(new Position("E2"), new Position("B5"));
			assertNull(game.playerColorWin());

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void playerColorWinTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("E2"), new Position("E3"));
			game.turn(new Position("E7"), new Position("E6"));
			game.turn(new Position("E1"), new Position("E2"));
			game.turn(new Position("D8"), new Position("E7"));
			game.turn(new Position("E2"), new Position("B5"));
			game.turn(new Position("H7"), new Position("H6"));
			game.turn(new Position("B5"), new Position("D7"));
			game.turn(new Position("H7"), new Position("H6"));
			game.turn(new Position("D7"), new Position("E7"));
			assertEquals(game.playerColorWin(), Color.WHITE);

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void isNotPossibleRoqueTest() {
		Game game = new Game("Mehdi","Charles");
		assertFalse(game.isRoquePossible());
	}
	
	@Test
	void isPossibleLeftSmallRoqueTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("B1"), new Position("C3"));
			game.turn(new Position("B2"), new Position("B3"));
			game.turn(new Position("C1"), new Position("B2"));
			assertTrue(game.isRoquePossible());

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void isPossibleRoqueLeftBigTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("B1"), new Position("C3"));
			game.turn(new Position("B2"), new Position("B3"));
			game.turn(new Position("C1"), new Position("B2"));
			game.turn(new Position("E2"), new Position("E3"));
			game.turn(new Position("E1"), new Position("E2"));
			game.turn(new Position("D1"), new Position("E1"));
			assertTrue(game.isRoquePossible());

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void isPossibleRoqueRightSmallTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("G1"), new Position("H3"));
			game.turn(new Position("G2"), new Position("G3"));
			game.turn(new Position("F1"), new Position("G2"));
			game.turn(new Position("D2"), new Position("D3"));
			game.turn(new Position("D1"), new Position("D2"));
			game.turn(new Position("E1"), new Position("D1"));
			game.turn(new Position("D2"), new Position("E1"));
			assertTrue(game.isRoquePossible());

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}
	
	@Test
	void isPossibleRoqueRightBigTest() {
		Game game = new Game("Mehdi","Charles");
		try {
			game.turn(new Position("G1"), new Position("H3"));
			game.turn(new Position("G2"), new Position("G3"));
			game.turn(new Position("F1"), new Position("G2"));
			game.turn(new Position("D2"), new Position("D3"));
			game.turn(new Position("D1"), new Position("D2"));
			game.turn(new Position("E1"), new Position("D1"));
			game.turn(new Position("D2"), new Position("E1"));
			game.turn(new Position("D1"), new Position("D2"));
			game.turn(new Position("E1"), new Position("D1"));
			assertTrue(game.isRoquePossible());

		} catch (IllegalArgumentException | ChessMoveException exception) {}
	}

}

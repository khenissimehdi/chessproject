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
		System.out.println(game.getCurrentColor());
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
	
}

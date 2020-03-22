package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import chess.pieces.King;
import chess.pieces.Piece;
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
	
}

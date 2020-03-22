package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class BishopTest {

	@Test
	public void bishopTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		Bishop piece = new Bishop(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isNotValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D6");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B6");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("D3");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D3");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E3");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveRightLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveLeftLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("A4");
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}

	@Test
	public void isNotValidMoveFrontRightDiagonalPieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		Position posBetween = new Position("E5");

		Bishop pieceBetween = new Bishop(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackLeftDiagonalPieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("E5");
		Position posDest = new Position("D3");
		Position posBetween = new Position("D4");

		Bishop pieceBetween = new Bishop(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);
		
		Bishop piece = new Bishop(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}

}

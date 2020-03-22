package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class QueenTest {

	@Test
	public void queenTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		Queen piece = new Queen(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D6");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B6");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("D3");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D3");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E3");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveRightLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveLeftLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("A4");
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveLeftLinePieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		Position posBetween = new Position("F4");

		Queen pieceBetween = new Queen(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);

		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontRightDiagonalPieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		Position posBetween = new Position("E5");

		Queen pieceBetween = new Queen(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackLeftDiagonalPieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("E5");
		Position posDest = new Position("D3");
		Position posBetween = new Position("D4");

		Queen pieceBetween = new Queen(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);
		
		Queen piece = new Queen(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}

}

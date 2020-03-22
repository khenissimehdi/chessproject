package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class RookTest {

	@Test
	public void rookTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		Rook piece = new Rook(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D6");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B6");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("D3");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D3");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E3");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveRightLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveRightLinePieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		Position posBetween = new Position("F4");

		Rook pieceBetween = new Rook(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);

		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveLeftLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("A4");
		
		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveLeftLinePieceBetweenTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("A4");
		Position posBetween = new Position("B4");

		Rook pieceBetween = new Rook(board, posBetween, Color.BLACK);
		board.setPiece(posBetween, pieceBetween);

		Rook piece = new Rook(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
}

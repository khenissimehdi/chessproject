package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class KingTest {

	@Test
	public void kingTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		King piece = new King(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D5");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D6");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C5");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B6");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveFrontRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E5");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F6");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("D3");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackLeftDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D3");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveBackRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("E5");
		Position posDest = new Position("D4");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackRightDiagonalTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("E5");
		Position posDest = new Position("C3");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveRightLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("H4");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveRightLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E5");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveLeftLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("A4");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveLeftLineTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C4");
		
		King piece = new King(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
}

package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class KnightTest {

	@Test
	public void knightTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		Knight piece = new Knight(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isNotValidMoveFrontColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D5");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("D3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveRightColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E4");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveLeftColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C4");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontDiagonalRightTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E5");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveFrontDiagonalLeftTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C5");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackDiagonalRightTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackDiagonalLeftTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertFalse(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveRightUpTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F5");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveRightDownTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("F3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveLeftUpTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B5");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveLeftDownTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("B3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveUpRightTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("C6");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveUpLeftTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D4");
		Position posDest = new Position("E6");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveDownRightTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("C3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveDownLeftTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("D5");
		Position posDest = new Position("E3");
		
		Knight piece = new Knight(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		
		assertTrue(piece.isValidMove(posDest));
	}
	
	
	
}

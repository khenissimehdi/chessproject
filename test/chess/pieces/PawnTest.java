package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

class PawnTest {
	
	@Test
	public void pawnTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position("A1");
		Color colorPiece = Color.BLACK;
		Pawn piece = new Pawn(board, posPiece, colorPiece);
		assertEquals(posPiece, piece.getPosition());
		assertEquals(colorPiece, piece.getColor());
	}
	
	@Test
	public void isNotValidMovePushMoreThanOneCaseColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A2");
		Position posDest = new Position("A4");
		Pawn piece = new Pawn(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveBackOneCaseColumnTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A4");
		Position posDest = new Position("A3");
		Pawn piece = new Pawn(board, posStart, Color.BLACK);
		board.setPiece(posStart, piece);
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveDiagonalNullTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A2");
		Position posDest = new Position("B3");
		
		Pawn pieceWhite = new Pawn(board, posStart, Color.BLACK);
		board.setPiece(posStart, pieceWhite);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isNotValidMoveDiagonalMeTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A2");
		Position posDest = new Position("B3");
		
		Pawn pieceWhite = new Pawn(board, posStart, Color.BLACK);
		board.setPiece(posStart, pieceWhite);
		
		Pawn pieceBlack = new Pawn(board, posDest, Color.BLACK);
		board.setPiece(posDest, pieceBlack);
		
		assertFalse(board.getPiece(posStart).isValidMove(posDest));
	}
	
	@Test
	public void isValidMoveDiagonalEnemyTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A2");
		Position posDest = new Position("B3");
		
		Pawn pieceWhite = new Pawn(board, posStart, Color.BLACK);
		board.setPiece(posStart, pieceWhite);
		
		Pawn pieceBlack = new Pawn(board, posDest, Color.WHITE);
		board.setPiece(posDest, pieceBlack);
		
		assertTrue(board.getPiece(posStart).isValidMove(posDest));
	}
	
}

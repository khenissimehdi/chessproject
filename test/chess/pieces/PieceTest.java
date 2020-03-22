package chess.pieces;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

class PieceTest {
	
	@Test
	public void getColorTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertEquals(Color.BLACK,piece.getColor());
	}
	
	@Test
	public void getNameTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertEquals("BLACK PAWN",piece.getName());
	}
	
	@Test
	public void getSymbolTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertEquals(Symbol.BLACK_PAWN,piece.getSymbol());
	}
	
	@Test
	public void isNotBlackTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.WHITE);
		assertFalse(piece.isBlack());
	}
	
	@Test
	public void isWhiteTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.WHITE);
		assertTrue(piece.isWhite());
	}
	
	@Test
	public void isNotWhiteTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertFalse(piece.isWhite());
	}
	
	@Test
	public void moveToTest() {
		Chessboard board = new Chessboard();
		Position posStart = new Position("A2");
		Position posDest = new Position("A3");
		try {
			board.getPiece(posStart).moveTo(posDest);
		} catch (ChessMoveException e) {}
		assertTrue(board.getPiece(posStart) == null);
		assertTrue(board.getPiece(posDest) != null);
	}

}

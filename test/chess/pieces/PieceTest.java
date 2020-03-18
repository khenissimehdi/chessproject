package chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
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
		assertEquals("_PAWN",piece.getName());
	}
	
	@Test
	public void getPositionTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		Position pos = new Position(6, 0);
		assertEquals(pos,piece.getPosition());
	}
	
	@Test
	public void getSymbolTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertEquals(Symbol.BLACK_PAWN,piece.getSymbol());
	}
	
	@Test
	public void isBlackTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.BLACK);
		assertEquals(true,piece.isBlack());
	}
	
	@Test
	public void isWhiteTest() {
		Chessboard board = new Chessboard();
		Piece piece = new Pawn(board, new Position(6, 0), Color.WHITE);
		assertEquals(true,piece.isWhite());
	}
	
	@Test
	public void moveToTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		Position pos = new Position(1,0);
		pieces[0][0] = new Pawn(board, new Position(0, 0), Color.WHITE);
		try
		{
			pieces[0][0].moveTo(pieces[1][0].getPosition());
			fail("ChessMoveException");
		}
		catch (ChessMoveException e) { }
		assertEquals(pos,pieces[0][0].getPosition());
	}

}

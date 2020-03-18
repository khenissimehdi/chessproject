package chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

class KnightTest {

	@Test
	public void isValidMoveTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new Knight(board, new Position(0, 0), Color.WHITE);
		pieces[1][2] = null;
		assertEquals(true,pieces[0][0].isValidMove(pieces[1][2].getPosition()));
	}
	
	@Test
	public void isNotValidMoveTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new Knight(board, new Position(0, 0), Color.WHITE);
		pieces[0][1] = null;
		assertEquals(false,pieces[0][0].isValidMove(pieces[0][1].getPosition()));
	}
	
	@Test
	public void isNotValidMoveWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new Knight(board, new Position(0, 0), Color.WHITE);
		pieces[1][2] = new Knight(board, new Position(1, 2), Color.WHITE);;
		assertEquals(false,pieces[0][0].isValidMove(pieces[1][2].getPosition()));
	}
	
	@Test
	public void isValidMoveWhiteVSBlackTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new Knight(board, new Position(0, 0), Color.WHITE);
		pieces[1][2] = new Knight(board, new Position(1, 2), Color.BLACK);;
		assertEquals(true,pieces[0][0].isValidMove(pieces[1][2].getPosition()));
	}
	
	@Test
	public void chessMoveExceptionTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][5] = new Knight(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = null;
		try {
			pieces[0][5].moveTo(pieces[1][0].getPosition());
			fail("ChessMoveException");
		}catch(ChessMoveException e) {}
	}
	
}

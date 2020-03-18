package chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

class KingTest {
	
	@Test
	public void isValidMoveLineTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new King(board, new Position(0, 0), Color.WHITE);
		assertEquals(true,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	
	@Test
	public void isNotValidMovelineTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new King(board, new Position(0, 0), Color.WHITE);
		assertEquals(false,pieces[0][0].isValidMove(pieces[7][0].getPosition()));
	}
	
	@Test
	public void isNotValidMoveLineWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Pawn(board, new Position(1, 0), Color.WHITE);;
		assertEquals(false,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	
	@Test
	public void isValidMoveLineWhiteVSBlackTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][0] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Pawn(board, new Position(1, 0), Color.BLACK);;
		assertEquals(true,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	
	@Test
	public void isValidMoveColumnTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][0] = new King(board, new Position(0, 0), Color.WHITE);
		assertEquals(true,pieces[2][0].isValidMove(pieces[1][0].getPosition()));
	}
	
	@Test
	public void isNotValidMoveColumnTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][0] = new King(board, new Position(0, 0), Color.WHITE);
		assertEquals(false,pieces[2][0].isValidMove(pieces[7][0].getPosition()));
	}
	
	@Test
	public void isNotValidMoveColumnWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][0] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[7][0] = new Pawn(board, new Position(7, 0), Color.WHITE);
		assertEquals(false,pieces[2][0].isValidMove(pieces[7][0].getPosition()));
	}
	
	@Test
	public void isValidMoveColumnWhiteVSBlackTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][0] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[7][0] = new Pawn(board, new Position(7, 0), Color.BLACK);
		assertEquals(false,pieces[2][0].isValidMove(pieces[7][0].getPosition()));
	}
	
	@Test
	public void isValidMoveDiagonalTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][2] = new King(board, new Position(2, 2), Color.WHITE);
		assertEquals(true,pieces[2][2].isValidMove(pieces[1][1].getPosition()));
	}
	
	@Test
	public void isNotValidMoveDiagonalTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][2] = new King(board, new Position(2, 2), Color.WHITE);
		assertEquals(false,pieces[2][2].isValidMove(pieces[7][7].getPosition()));
	}
	
	@Test
	public void isNotValidMoveDiagonalWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][2] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[3][3] =  new Pawn(board, new Position(3, 3), Color.WHITE);;
		assertEquals(false,pieces[2][2].isValidMove(pieces[3][3].getPosition()));
	}
	
	@Test
	public void isValidMoveDiagonalWhiteVSBlackTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[2][2] = new King(board, new Position(0, 0), Color.WHITE);
		pieces[3][3] =  new Pawn(board, new Position(3, 3), Color.BLACK);;
		assertEquals(true,pieces[2][2].isValidMove(pieces[3][3].getPosition()));
	}
	
	@Test
	public void chessMoveExceptionTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board = new Chessboard();
		pieces[0][5] = new King(board, new Position(0, 0), Color.WHITE);
		try {
			pieces[0][5].moveTo(pieces[1][0].getPosition());
			fail("ChessMoveException");
		}catch(ChessMoveException e) {}
	}
	
}

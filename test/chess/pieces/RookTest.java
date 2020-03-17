package chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import chess.util.Position;

class RookTest {

	@Test
	public void isValidMoveLineTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[0][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = null;
		assertEquals(true,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	@Test
	public void isNotValidMoveLineTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[0][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][1] = null;
		assertEquals(false,pieces[0][0].isValidMove(pieces[1][1].getPosition()));
	}
	@Test
	public void isNotValidMoveLineWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[0][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Rook(board, new Position(1, 0), Color.WHITE);
		assertEquals(false,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	@Test
	public void isNotValidMoveLineWhiteVSBlackTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[0][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Rook(board, new Position(1, 0), Color.BLACK);
		assertEquals(false,pieces[0][0].isValidMove(pieces[1][0].getPosition()));
	}
	@Test
	public void isValidMoveColumnTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[2][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = null;
		assertEquals(true,pieces[2][0].isValidMove(pieces[1][0].getPosition()));
	}
	@Test
	public void isNotValidMoveColumnWhiteVSWhiteTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[2][0] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Rook(board, new Position(1, 0), Color.WHITE);
		assertEquals(false,pieces[2][0].isValidMove(pieces[1][0].getPosition()));
	}
	@Test
	public void chessMoveExceptionTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		pieces[0][5] = new Rook(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = null;
		try {
			pieces[0][5].moveTo(pieces[1][0].getPosition());
			fail("ChessMoveException");
		}catch(ChessMoveException e) {}
	}

}

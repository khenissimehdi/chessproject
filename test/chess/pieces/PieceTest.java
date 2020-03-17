package chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import chess.util.Position;
import chess.util.Symbol;

class PieceTest {

	
	
	
	@Test
	public void getColorTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.BLACK);
		assertEquals(Color.BLACK,p.getColor())
	}
	@Test
	public void getNameTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.BLACK);
		assertEquals("_PAWN",p.getName());
	}
	@Test
	public void getPositionTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.BLACK);
		Position pos = new Position(6, 0);
		assertEquals(pos,p.getPosition());
	}
	@Test
	public void getSymbolTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.BLACK);
		assertEquals(Symbol.BLACK_PAWN,p.getSymbol());
	}
	@Test
	public void isBlackTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.BLACK);
		assertEquals(true,p.isBlack());
	}
	@Test
	public void isWhiteTest() {
		Piece p = new Pawn(this, new Position(6, 0), Color.WHITE);
		boolean res = true;
		assertEquals(true,p.isWhite());
	}
	@Test
	public void moveToTest() {
		Piece[][] pieces = new Piece[8][8];
		Chessboard board ;
		Position pos = new Position(1,0);
		pieces[0][0] = new Pawn(board, new Position(0, 0), Color.WHITE);
		pieces[1][0] = null;
		pieces[0][0].moveTo(pieces[1][0].getPosition());
		assertEquals(pos,pieces[0][0].getPosition());
	}

}

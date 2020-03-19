package chess;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import chess.pieces.Piece;
import chess.pieces.Rook;
import chess.util.Color;
import chess.util.Position;

class ChessboardTest {

	@Test
	void getPieceTest() {
		Chessboard b = new Chessboard();
		Piece p =  new Rook(this, new Position(7, 0), Color.BLACK);
		assertEquals(p,b.getPiece(7, 0));
	}
	@Test
	void getPiecePosTest() {
		Chessboard b = new Chessboard();
		Piece p =  new Rook(this, new Position(7, 0), Color.BLACK);
		assertEquals(p,b.getPiece(new Position(7, 0)));
	}
	@Test 
	void addHistoricTest() {
		Chessboard b = new Chessboard();
		Position Old = new Position(0,1);
		Position New = new Position(0,2);
		b.addHistoric(" ROOK",Old,New);
		String s = "1 Déplacement du ROOK de la case "+Old.toAlgebraicNotation() + " à la case " New.toAlgebraicNotation()+".";
		assertEquals(s,b.printHistoric());
	}
	@Test
	void printHistoricTest() {
		Chessboard b = new Chessboard();
		Position Old = new Position(0,1);
		Position New = new Position(0,2);
		b.addHistoric(" ROOK",Old,New);
		String s = "1 Déplacement du ROOK de la case "+Old.toAlgebraicNotation() + " à la case " New.toAlgebraicNotation()+".";
		assertEquals(s,b.printHistoric());
	}
	@Test 
	void isPiecePresentOnSameColumnBetweenFalseTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(0,1);
		Position two = new Position(0,2);
		assertEquals(false,b.isPiecePresentOnSameColumnBetween(one,two));
		
		
	}
	@Test 
	void isPiecePresentOnSameColumnBetweenTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(0,1);
		Position two = new Position(0,3);
		Piece p =  new Rook(this, new Position(0, 1), Color.BLACK);
		Position pos = new Position(0,2);
		b.setPiece(pos, p);
		assertEquals(true,b.isPiecePresentOnSameColumnBetween(one,two));
		
		
	}
	@Test 
	void isPiecePresentOnSameDiagonalBetweenFalseTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(1,1);
		Position two = new Position(2,2);
		assertEquals(false,b.isPiecePresentOnSameDiagonalBetween(one,two));	
	}
	@Test 
	void isPiecePresentOnSameDiagonalBetweenTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(1,1);
		Position two = new Position(3,3);
		Piece p =  new Rook(this, new Position(2, 2), Color.BLACK);
		Position pos = new Position(2,2);
		assertEquals(true,b.isPiecePresentOnSameDiagonalBetween(one,two));	
	}
	@Test 
	void isPiecePresentOnSameLineBetweenFalseTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(1,0);
		Position two = new Position(2,0);
		assertEquals(false,b.isPiecePresentOnSameDiagonalBetween(one,two));	
	}
	@Test 
	void isPiecePresentOnSameLineBetweenTest() {
		Chessboard b = new Chessboard();
		Position one = new Position(1,0);
		Position two = new Position(3,0);
		Piece p =  new Rook(this, new Position(2, 0), Color.BLACK);
		Position pos = new Position(2,0);
		assertEquals(true,b.isPiecePresentOnSameDiagonalBetween(one,two));	
	}
	@Test
	void setPiece() {
		Chessboard b = new Chessboard();
		Piece p =  new Rook(this, new Position(0, 1), Color.BLACK);
		Position pos = new Position(2,2);
		b.setPiece(pos, p);
		assertEquals(p.getName(),b.getPiece(pos).getName());		
	}

}

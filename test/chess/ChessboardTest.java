package chess;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import chess.util.Color;
import chess.util.Position;
import chess.pieces.Piece;
import chess.pieces.Rook;

class ChessboardTest {
	
	@Test
	void chessboardTest() {
		Chessboard board = new Chessboard();
		assertEquals(board.getHistoricSize(), 0);
		assertEquals(board.getPiece(0, 0).getName(), "WHITE ROOK");
		assertEquals(board.getPiece(7, 0).getName(), "WHITE ROOK");
		assertEquals(board.getPiece(0, 7).getName(), "BLACK ROOK");
		assertEquals(board.getPiece(7, 7).getName(), "BLACK ROOK");
		
	}
	
	@Test
	void getPieceXYTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position(4, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertEquals(piece, board.getPiece(4, 4));
	}
	
	@Test
	void getPiecePositionTest() {
		Chessboard board = new Chessboard();
		Position posPiece = new Position(4, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertEquals(piece, board.getPiece(posPiece));
	}

	@Test
	void getPieceXYNullTest() {
		Chessboard board = new Chessboard();
		assertEquals(board.getPiece(4,4), null);
	}
	
	@Test
	void getPiecePositionNullTest() {
		Chessboard board = new Chessboard();
		Position pos = new Position(4, 4);
		assertEquals(null, board.getPiece(pos));
	}
	
	
	@Test
	void isNotPiecePresentOnSameColumnBetweenTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 2);
		Position end = new Position(0, 6);
		assertFalse(board.isPiecePresentOnSameColumnBetween(start, end));
	}

	@Test
	void isPiecePresentOnSameColumnBetweenLowStartTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 2);
		Position end = new Position(0, 6);
		Position posPiece = new Position(0, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameColumnBetween(start, end));
	}
	
	@Test
	void isPiecePresentOnSameColumnBetweenHighStartTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 7);
		Position end = new Position(0, 2);
		Position posPiece = new Position(0, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameColumnBetween(start, end));
	}
	

	@Test
	void isNotPiecePresentOnSameDiagonalBetweenTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 2);
		Position end = new Position(3, 5);
		assertFalse(board.isPiecePresentOnSameDiagonalBetween(start, end));
	}
	
	@Test
	void isPiecePresentOnSameDiagonalBetweenLowStartTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 2);
		Position end = new Position(3, 5);
		Position posPiece = new Position(1, 3);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameDiagonalBetween(start, end));
	}
	
	@Test
	void isPiecePresentOnSameDiagonalBetweenHighStartTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(3, 5);
		Position end = new Position(0, 2);
		Position posPiece = new Position(1, 3);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameDiagonalBetween(start, end));
	}
	
	
	@Test
	void isNotPiecePresentOnSameLineBetweenTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 4);
		Position end = new Position(7, 4);
		assertFalse(board.isPiecePresentOnSameLineBetween(start, end));
	}
	
	@Test
	void isPiecePresentOnSameLineLowStartBetweenTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 4);
		Position end = new Position(7, 4);
		Position posPiece = new Position(4, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameLineBetween(start, end));
	}
	
	@Test
	void isPiecePresentOnSameLineHighStartBetweenTest() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 4);
		Position end = new Position(7, 4);
		Position posPiece = new Position(4, 4);
		Piece piece = new Rook(board, posPiece, Color.BLACK);
		board.setPiece(posPiece, piece);
		assertTrue(board.isPiecePresentOnSameLineBetween(start, end));
	}
	
	
	@Test
	void setPiece() {
		Chessboard board = new Chessboard();
		Piece piece = new Rook(board, new Position(0, 1), Color.BLACK);
		Position pos = new Position(2, 2);
		assertEquals(board.getPiece(pos), null);
		board.setPiece(pos, piece);
		assertEquals(piece.getName(), board.getPiece(pos).getName());
	}
	
	@Test
	void addHistoric() {
		Chessboard board = new Chessboard();
		Position start = new Position(0, 4);
		Position end = new Position(7, 4);
		Piece piece = new Rook(board, start, Color.BLACK);
		assertEquals(board.getHistoricSize(), 0);
		board.addHistoric(piece, end);
		assertEquals(board.getHistoricSize(), 1);
	}

}

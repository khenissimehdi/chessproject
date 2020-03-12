package chess;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * @author khen0002
 *
 */

public final class Chessboard {

	
	private Piece[][] pieces;

	
	public Chessboard() {
		pieces = new Piece[8][8];
		
		pieces[0][0] = new Rook(this, new Position(0,0), Color.WHITE);
		pieces[0][1] = new Knight(this, new Position(0,1), Color.WHITE);
		pieces[0][2] = new Bishop(this, new Position(0,2), Color.WHITE);
		pieces[0][3] = new King(this, new Position(0,3), Color.WHITE);
		pieces[0][4] = new Queen(this, new Position(0,4), Color.WHITE);
		pieces[0][5] = new Bishop(this, new Position(0,5), Color.WHITE);
		pieces[0][6] = new Knight(this, new Position(0,6), Color.WHITE);
		pieces[0][7] = new Rook(this, new Position(0,7), Color.WHITE);
		
		pieces[1][0] = new Pawn(this, new Position(1,0), Color.WHITE);
		pieces[1][1] = new Pawn(this, new Position(1,1), Color.WHITE);
		pieces[1][2] = new Pawn(this, new Position(1,2), Color.WHITE);
		pieces[1][3] = new Pawn(this, new Position(1,3), Color.WHITE);
		pieces[1][4] = new Pawn(this, new Position(1,4), Color.WHITE);
		pieces[1][5] = new Pawn(this, new Position(1,5), Color.WHITE);
		pieces[1][6] = new Pawn(this, new Position(1,6), Color.WHITE);
		pieces[1][7] = new Pawn(this, new Position(1,7), Color.WHITE);

		pieces[7][0] = new Rook(this, new Position(7,0), Color.BLACK);
		pieces[7][1] = new Knight(this, new Position(7,1), Color.BLACK);
		pieces[7][2] = new Bishop(this, new Position(7,2), Color.BLACK);
		pieces[7][3] = new King(this, new Position(7,3), Color.BLACK);
		pieces[7][4] = new Queen(this, new Position(7,4), Color.BLACK);
		pieces[7][5] = new Bishop(this, new Position(7,5), Color.BLACK);
		pieces[7][6] = new Knight(this, new Position(7,6), Color.BLACK);
		pieces[7][7] = new Rook(this, new Position(7,7), Color.BLACK);
		
		pieces[6][0] = new Pawn(this, new Position(6,0), Color.BLACK);
		pieces[6][1] = new Pawn(this, new Position(6,1), Color.BLACK);
		pieces[6][2] = new Pawn(this, new Position(6,2), Color.BLACK);
		pieces[6][3] = new Pawn(this, new Position(6,3), Color.BLACK);
		pieces[6][4] = new Pawn(this, new Position(6,4), Color.BLACK);
		pieces[6][5] = new Pawn(this, new Position(6,5), Color.BLACK);
		pieces[6][6] = new Pawn(this, new Position(6,6), Color.BLACK);
		pieces[6][7] = new Pawn(this, new Position(6,7), Color.BLACK);
	}
	

	public Piece getPiece(int x, int y) {
		return pieces[x][y];

	}

	
	public Piece getPiece(Position pos) {
		return pieces[pos.getX()][pos.getY()];
	}

	
	public void setPiece(Position pos, Piece newPiece) {
		try {
			newPiece.moveTo(getPiece(pos).getPosition());
		} catch (ChessMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end) {
		boolean res = false;
		if (!(start.isOnSameColumnAs(end))) {
			throw new java.lang.IllegalArgumentException("not same Colum");
		}
		int add = 1;
		if (start.getY() > end.getY()) {
			add = -1;
		}
		for (int y = start.getY() - add; y != end.getY(); y += add) {
			if (!(this.getPiece(start.getX(), y) == null)) {
				res = true;
			}
		}
		return res;
	}
	

	public boolean isPiecePresentOnSameLineBetween(Position start, Position end) {
		boolean res = false;
		if (!(start.isOnSameLineAs(end))) {
			throw new java.lang.IllegalArgumentException("not same Colum");
		}
		int add = 1;
		if (start.getX() > end.getX()) {
			add = -1;
		}
		for (int x = start.getX() - add; x != end.getX(); x += add) {
			if (!(this.getPiece(x, start.getX()) == null)) {
				res = true;
			}
		}
		return res;
	}
	

	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) {
		boolean res = false;
		if (!(start.isOnSameDiagonalAs(end))) {
			throw new java.lang.IllegalArgumentException("not same Colum");
		}
		int add = 1;
		if (start.getX() > end.getX()) {
			add = -1;
		}
		int x = start.getX() + add;
		for (int y = start.getY() - add; y != end.getY(); y += add) {
			if (!(this.getPiece(x, y) == null)) {
				res = true;
			}
		}
		x += add;
		return res;
	}

	
	@Override
	public String toString() {
		String res = "";
		int numLine = 7;

		for (int line = 0; line <= 16; line++) {

			int numRow = 7;
			if (line == 0) {
				res += "┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓";
				res += "\n";
			} else if (line == 16) {
				res += "┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛";
				res += "\n";
			} else {

				for (int row = 0; row <= 16; row++) {
					if (line % 2 == 0) {

						if (row == 0) {
							res += "┣";
						} else if (row == 16) {
							res += "┫";
						} else if (row % 2 != 0) {
							res += "━━━";
						} else {
							res += "╋";
						}

					} else {

						if (row == 0) {
							res += "┃";
						} else if (row == 14) {
							res += "┃";
						} else if (row % 2 != 0) {
							if (getPiece(numLine, numRow) != null) {
								res += " " + getPiece(numLine, numRow).getSymbol() + " ";
							} else {
								res += "   ";
							}
							numRow--;
						} else {
							res += "┃";
						}

					}
				}
				if (line % 2 == 0) {
					numLine -= 1;
				}
				res += "\n";
			}
		}
		res += "";
		res += "\n";
		return res;
	}
}


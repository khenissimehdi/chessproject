package chess;

import chess.pieces.Piece;
import chess.util.Position;

/**
 * @author khen0002
 *
 */

public final class Chessboard {
	public static void main(String[] args) {
		Chessboard board = new Chessboard();
		System.out.println(board);
	}

	private Piece[][] pieces;

	public Chessboard() {
		pieces = new Piece[8][8];

	}

	public Piece getPiece(int x, int y) {
		Piece res = pieces[x][y];
		if (res == null) {
			res = null;
		}
		return res;

	}

	public Piece getPiece(Position pos) {
		Piece res = pieces[pos.getX()][pos.getY()];
		if (res == null) {
			res = null;
		}
		return res;
	}

	public void setPiece(Position pos, Piece newPiece) {
		pieces[pos.getX()][pos.getY()] = newPiece;
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
		res += "";
		for (int row = 0; row <= 16; row++) {
			if (row == 0) {
				res += "┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓";
				res += "\n";
			} else if (row == 16) {
				res += "┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛";
				res += "\n";
			} else {
				for (int line = 0; line <= 16; line++) {
					if (row % 2 == 0) {
						if (line == 0) {
							res += "┣";
						} else if (line == 16) {
							res += "┫";
						} else if (line % 2 != 0) {
							res += "━━━";
						} else {
							res += "╋";
						}
					} else {
						if (line == 0) {
							res += "┃";
						} else if (line == 14) {
							res += "┃";
						} else if (line % 2 != 0) {
							if (getPiece(line -, row) == null)
								res += "   ";
							else
								res += " " + getPiece(line, row) + " ";
						} else {
							res += "┃";
						}
					}
				}
				res += "\n";
			}
		}
		res += "";
		res += "\n";
		return res;
	}
}

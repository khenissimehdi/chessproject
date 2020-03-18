/**
 * 
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * @author khen0002
 *
 */
public abstract class Piece {

	private Color color;
	private String name;
	private Position position;
	private char symbol;
	protected final Chessboard board;

	public Piece(Chessboard board, Position position, Color color, String name, char symbol) {
		this.board = board;
		this.position = position;
		this.color = color;
		this.name = name;
		this.symbol = symbol;
	}

	public Color getColor() {
		return this.color;
	}

	public String getName() {
		return this.name;
	}

	public Position getPosition() {
		return this.position;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public boolean isBlack() {
		boolean res = false;
		if (this.color == Color.BLACK) {
			res = true;
		}
		return res;
	}

	public abstract boolean isValidMove(Position destination);

	public boolean isWhite() {
		boolean res = false;
		if (this.color == Color.WHITE) {
			res = true;
		}
		return res;
	}

	public void moveTo(Position destination) throws ChessMoveException {
		if (isValidMove(destination)) {
			this.board.setPiece(destination, this);
			this.position = destination;
		} else {
			throw new ChessMoveException("Erreur : ", this.position, destination);
		}
	}

}

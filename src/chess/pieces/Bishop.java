/**
 * 
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * @author khen0002
 *
 */
public final class Bishop extends Piece {

	/**
	 * 
	 */
	public Bishop(Chessboard board, Position position, Color color) {
		super(board, position, color, color + "_BISHOP",
				(color == Color.WHITE) ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().isOnSameDiagonalAs(destination)) {
			res = true;
		}

		return res;
	}

}
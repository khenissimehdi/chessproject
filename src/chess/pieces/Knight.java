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
public final class Knight extends Piece {

	/**
	 * 
	 */
	public Knight(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " KNIGHT",
				(color == Color.WHITE) ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT);
	}

	@Override
	public boolean isValidMove(Position destination) {
		return true;
	}

}
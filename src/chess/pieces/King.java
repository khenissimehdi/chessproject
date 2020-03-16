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
public final class King extends Piece {

	/**
	 * 
	 */
	public King(Chessboard board, Position position, Color color) {
		super(board, position, color, color + "_KING", (color == Color.WHITE) ? Symbol.WHITE_KING : Symbol.BLACK_KING);
	}

	@Override
	public boolean isValidMove(Position destination) {
		return true;
	}

}

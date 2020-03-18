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
public final class Queen extends Piece {

	/**
	 * 
	 */
	public Queen(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " QUEEN",
				(color == Color.WHITE) ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		return true;
	}

}
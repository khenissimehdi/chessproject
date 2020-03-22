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
public final class Rook extends Piece {

	/**
	 * 
	 */
	public Rook(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " ROOK", (color == Color.WHITE) ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().isOnSameColumnAs(destination))
		{
			if (!board.isPiecePresentOnSameColumnBetween(getPosition(), destination))
				res = true;	
		}
		else if (getPosition().isOnSameLineAs(destination))
		{
			if (!board.isPiecePresentOnSameLineBetween(getPosition(), destination))
				res = true;
		}

		return res;
	}

}
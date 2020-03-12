/**
 * 
 */
package chess.pieces;

import chess.Chessboard;
import chess.pieces.Piece;
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
		super(board, position, color, color + "_BISHOP", (color == Color.WHITE) ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP);
	}

	@Override
	public boolean isValidMove(Position destination)
	{
		boolean res = super.isValidMove(destination);
		if (res)
		{
			if (getPosition().isOnSameDiagonalAs(destination))
			{
				if (this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination))
				{
					res = false;
				}
			}
		}
		return res;
	}

}
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
public final class Rook extends Piece {

	/**
	 * 
	 */
	public Rook(Chessboard board, Position position, Color color) {
		super(board, position, color, color + "_ROOK", (color == Color.WHITE) ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK);
	}

	@Override
	public boolean isValidMove(Position destination)
	{
		boolean res = super.isValidMove(destination);
		if (res)
		{
			if (getPosition().isOnSameColumnAs(destination))
			{
				if (this.board.isPiecePresentOnSameColumnBetween(this.getPosition(), destination))
				{
					res = false;
				}
			}
			else if (getPosition().isOnSameLineAs(destination))
			{
				if (this.board.isPiecePresentOnSameLineBetween(this.getPosition(), destination))
				{
					res = false;
				}
			}
		}
		return res;
	}

}
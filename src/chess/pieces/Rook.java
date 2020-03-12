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
		return true;
	}

}
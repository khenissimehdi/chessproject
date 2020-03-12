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
public final class Pawn extends Piece {

	/**
	 * 
	 */
	public Pawn(Chessboard board, Position position, Color color) {
		super(board, position, color, color + "_PAWN", (color == Color.WHITE) ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN);
	}

	@Override
	public boolean isValidMove(Position destination)
	{
		return true;
	}

}
/**
 * 
 */
package chess;

import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * @author khen0002
 *
 */
public final class Game {

	private String blackPlayerName;
	private String whitePlayerName;
 	private Color currentColor;
 	private Chessboard board;
 	
 	public Game(String blackPlayerName,String whitePlayerName) {
 		this.blackPlayerName = blackPlayerName;
 		this.whitePlayerName = whitePlayerName;
 		this.board = new Chessboard();
 		this.currentColor = Color.WHITE;
 	}
 	
 	public static void main(String[] args)
 	{
 		
 	}
 	
 	public void turn(Position start, Position end) throws ChessMoveException
 	{
 		if ()
 		{
 			
 		}
 	}

	/**
	 * @return the blackPlayerName
	 */
	public String getBlackPlayerName() {
		return blackPlayerName;
	}

	/**
	 * @return the whitePlayerName
	 */
	public String getWhitePlayerName() {
		return whitePlayerName;
	}

	/**
	 * @return the currentColor
	 */
	public Color getCurrentColor() {
		return currentColor;
	}
	
}

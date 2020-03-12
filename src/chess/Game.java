/**
 * 
 */
package chess;

import java.util.Scanner;

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
 	
 	public Game(String blackPlayerName, String whitePlayerName) {
 		this.blackPlayerName = blackPlayerName;
 		this.whitePlayerName = whitePlayerName;
 		this.board = new Chessboard();
 		this.currentColor = Color.WHITE;
 	}
 	
 	public static void main(String[] args)
 	{
 		Scanner sc = new Scanner(System.in);
 		
 		System.out.println("Veuillez saisir votre nom (pions noirs) :");
 		String blackPlayerName = sc.nextLine();
 		
 		System.out.println("Veuillez saisir votre nom (pions blancs) :");
 		String whitePlayerName = sc.nextLine();
 		
 		Game game = new Game(blackPlayerName, whitePlayerName);
 		boolean error = true;
 		
 		System.out.println(game.board);
 		
 		if (game.currentColor == Color.WHITE)
 		{
 			while (error)
 			{
 				try {
 					System.out.println("[ " + game.getWhitePlayerName() + " ] - Position de la pièce à déplacer :");
 		 			Position start = new Position(sc.nextLine());
 		 			System.out.println("[ " + game.getWhitePlayerName() + " ] - Destination du déplacement :");
 		 			Position end = new Position(sc.nextLine());
 		 			game.turn(start, end);
 		 			error = false;
 				} catch (Exception e) {
 					System.out.print(e.getMessage() + "\n");
 					error = true;
 				}
 			}
 		}
 		
 		else if (game.currentColor == Color.BLACK)
 		{
 			while (error)
 			{
 				try {
 					System.out.println("[ " + game.getBlackPlayerName() + " ] - Position de la pièce à déplacer :");
 		 			Position start = new Position(sc.nextLine());
 		 			System.out.println("[ " + game.getBlackPlayerName() + " ] - Destination du déplacement :");
 		 			Position end = new Position(sc.nextLine());
 		 			game.turn(start, end);
 		 			error = false;
 				} catch (Exception e) {
 					System.out.print(e.getMessage() + "\n");
 					error = true;
 				}
 			}
 		}
 		System.out.println(game.board);
 		
 		sc.close();
 	}
 	
 	public void turn(Position start, Position end) throws ChessMoveException
 	{
 		board.setPiece(end, board.getPiece(start));
 		(this.board.getPiece(start)).moveTo(end);
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

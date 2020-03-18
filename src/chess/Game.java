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

	private Chessboard board;
	private Color currentColor;
	private String blackPlayerName;
	private String whitePlayerName;

	public Game(String blackPlayerName, String whitePlayerName) {
		this.board = new Chessboard();
		this.currentColor = Color.WHITE;
		this.blackPlayerName = blackPlayerName;
		this.whitePlayerName = whitePlayerName;
	}

	/**
	 * @return the blackPlayerName
	 */
	public String getBlackPlayerName() {
		return this.blackPlayerName;
	}

	/**
	 * @return the currentColor
	 */
	public Color getCurrentColor() {
		return this.currentColor;
	}
		
	/**
	 * @return the whitePlayerName
	 */
	public String getWhitePlayerName() {
		return whitePlayerName;
	}

	public void turn(Position start, Position end) throws ChessMoveException {
		if (this.board.getPiece(start) == null) {
			throw new ChessMoveException("La case de départ est vide", start, end);
		} else if (this.board.getPiece(start).getColor() != this.getCurrentColor()) {
			throw new ChessMoveException("La case de départ contient une pièce de l'adversaire", start, end);
		} else {
			this.board.getPiece(start).moveTo(end);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez saisir votre nom (pions noirs) :");
		String blackPlayerName = sc.nextLine();
		
		System.out.println("Veuillez saisir votre nom (pions blancs) :");
		String whitePlayerName = sc.nextLine();

		Game game = new Game(blackPlayerName, whitePlayerName);
		boolean isTheEndOfTheGame = false;

		System.out.println(game.board);

		while (isTheEndOfTheGame != true) {

			if (game.currentColor == Color.WHITE) {
				
				try {
					
					System.out.println("[ " + game.getWhitePlayerName() + " ] - Position de la pièce à déplacer :");
					Position start = new Position(sc.nextLine());

					System.out.println("[ " + game.getWhitePlayerName() + " ] - Destination du déplacement :");
					Position end = new Position(sc.nextLine());

					game.turn(start, end);
					game.currentColor = Color.BLACK;
					
				} catch (IllegalArgumentException e) {
					System.out.print(e.getMessage() + "\n");
				} catch (ChessMoveException e) {
					System.out.print(e.getMessage() + "\n");
				}
			}

			else if (game.currentColor == Color.BLACK) {
				
				try {
					
					System.out.println("[ " + game.getBlackPlayerName() + " ] - Position de la pièce à déplacer :");
					Position start = new Position(sc.nextLine());

					System.out.println("[ " + game.getBlackPlayerName() + " ] - Destination du déplacement :");
					Position end = new Position(sc.nextLine());

					game.turn(start, end);
					game.currentColor = Color.WHITE;
					
				} catch (IllegalArgumentException e) {
					System.out.print(e.getMessage() + "\n");
				} catch (ChessMoveException e) {
					System.out.print(e.getMessage() + "\n");
				}
			}
			
			
			System.out.println(game.board);
			game.board.printHistoric();
			
		}

		sc.close();

	}

}

/**
 * 
 */
package chess;

import java.util.Scanner;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

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
		if (this.board.getPiece(start) == null)
			throw new ChessMoveException("La case de départ est vide.", start, end);
		else if (this.board.getPiece(start).getColor() != this.getCurrentColor())
			throw new ChessMoveException("La case de départ contient une pièce adverse.", start, end);
		else
			this.board.getPiece(start).moveTo(end);
	}

	/*
	public static void clear() {
		try {
			if (System.getProperty("os.name").startsWith("Windows"))
				Runtime.getRuntime().exec("cls");
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception exception) {
			for (int i = 0; i < 100; i++)
				System.out.println("\n");
		}
	}
	*/

	public static void main(String[] args) {
		System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
		System.out.println("#                         THE CHESS GAME                          #");
		System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
		System.out.println('\n');

		boolean isTheEndOfTheGame = false;
		Scanner sc = new Scanner(System.in);

		System.out.println(" > Veuillez saisir votre nom (Noirs  ⚑ ) :");
		String blackPlayerName = sc.nextLine();

		System.out.println(" > Veuillez saisir votre nom (Blancs ⚐ ) :");
		String whitePlayerName = sc.nextLine();

		Game game = new Game(blackPlayerName, whitePlayerName);
		
		//clear();

		while (isTheEndOfTheGame != true) {
			
			System.out.println(game.board);
			System.out.println(" # Écrire HISTORIQUE pour voir l'historique des coups jouées.\n");

			if (game.currentColor == Color.WHITE) {

				try {
			    	System.out.println(" > " + game.getWhitePlayerName() + " (⚐) : Lieu actuel de la pièce à déplacer ? (exemple : A1)");
					String choice = sc.nextLine();
										
					switch (choice.toUpperCase())
					{
						/* On a choisi un switch en se disant que dans une version futur on pourrait ajouter des commandes comme REGLES */
					    case "HISTORIQUE" :
							System.out.println("\n");
					    	game.board.printHistoric();
							System.out.println("\n");
					    	System.out.println(" > " + game.getWhitePlayerName() + " (⚐) : Lieu actuel de la pièce à déplacer ? (exemple : A1)");
					    	choice = sc.nextLine();
					}
					
					Position start = new Position(choice);
					System.out.println(" > " + game.getWhitePlayerName() + " (⚐) : Lieu de destination de la pièce ? (exemple : A4)");
					Position end = new Position(sc.nextLine());
					game.turn(start, end);
					game.currentColor = Color.BLACK;

				} catch (IllegalArgumentException exception) {
					System.out.print(exception.getMessage() + "\n");
				} catch (ChessMoveException exception) {
					System.out.print(exception.getMessage() + "\n");
				}
				
			}

			else if (game.currentColor == Color.BLACK) {
				
				try {
			    	System.out.println(" > " + game.getBlackPlayerName() + " (⚑) : Lieu actuel de la pièce à déplacer ? (exemple : A1)");
					String choice = sc.nextLine();
										
					switch (choice.toUpperCase())
					{
						/* On a choisi un switch en se disant que dans une version futur on pourrait ajouter des commandes comme REGLES */
					    case "HISTORIQUE" :
							System.out.println("\n");
					    	game.board.printHistoric();
							System.out.println("\n");
					    	System.out.println(" > " + game.getBlackPlayerName() + " (⚑) : Lieu actuel de la pièce à déplacer ? (exemple : A1)");
					    	choice = sc.nextLine();
					}
					
					Position start = new Position(choice);
					System.out.println(" > " + game.getBlackPlayerName() + " (⚑) : Lieu de destination de la pièce ? (exemple : A4)");
					Position end = new Position(sc.nextLine());
					game.turn(start, end);
					game.currentColor = Color.WHITE;

				} catch (IllegalArgumentException exception) {
					System.out.print(exception.getMessage() + "\n");
				} catch (ChessMoveException exception) {
					System.out.print(exception.getMessage() + "\n");
				}
				
			}

		}

		sc.close();

	}

}

package chess;

import java.util.ArrayList;
import java.util.Scanner;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * Classe Game Classe représentant une partie d'échecs
 */
public final class Game {

	// Echiquier associé à la partie d'échecs
	private Chessboard board;
	// Couleur des pièces du joueur courant
	private Color currentColor;
	// Nom du joueur ayant les pièces blanches
	private String blackPlayerName;
	// Nom du joueur ayant les pièces noires
	private String whitePlayerName;

	/**
	 * Constructeur
	 * 
	 * @param blackPlayerName Nom du joueur ayant les pièces noires
	 * @param whitePlayerName Nom du joueur ayant les pièces blanches
	 */
	public Game(String blackPlayerName, String whitePlayerName) {
		this.board = new Chessboard();
		this.currentColor = Color.WHITE;
		this.blackPlayerName = blackPlayerName;
		this.whitePlayerName = whitePlayerName;
	}

	public Chessboard getBoard() {

		return this.board;
	}
	
	/**
	 * Accesseur du nom du joueur ayant les pièces noires
	 * 
	 * @return Le nom du joueur ayant les pièces noires
	 */
	public String getBlackPlayerName() {

		return this.blackPlayerName;
	}

	/**
	 * Accesseur à la couleur des pièces du joueur dont c'est le tour
	 * 
	 * @return La couleur des pièces du joueur dont c'est le tour
	 */
	public Color getCurrentColor() {
		return this.currentColor;
	}

	/**
	 * Accesseur du nom du joueur ayant les pièces blanches
	 * 
	 * @return Le nom du joueur ayant les pièces blanches
	 */
	public String getWhitePlayerName() {
		return whitePlayerName;
	}

	/**
	 * Méthode qui teste si le roi d'une certaine couleur est en échec
	 * 
	 * @param color Couleur testé
	 */
	public boolean isEchec(Color color) {
		boolean res = false;
		ArrayList<Piece> listPiecesEnemy = new ArrayList<>();
		King myKing = null;

		for (Piece piece : board.getAllPieceOnChessboard()) {
			if (piece.getColor() != color)
			{
				listPiecesEnemy.add(piece);
			}
			else {
				if (piece.getName().contains("KING"))
				{
					myKing = (King) piece;
				}
			}
		}

		for (Piece piece : listPiecesEnemy) {
			String pieceName = piece.getName();
			if (pieceName.contains("QUEEN")) {
				Queen queen = (Queen) piece;
				if (queen.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			} else if (pieceName.contains("KING")) {
				King king = (King) piece;
				if (king.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			} else if (pieceName.contains("BISHOP")) {
				Bishop bishop = (Bishop) piece;
				if (bishop.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			} else if (pieceName.contains("ROOK")) {
				Rook rook = (Rook) piece;
				if (rook.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			} else if (pieceName.contains("PAWN")) {
				Pawn pawn = (Pawn) piece;
				if (pawn.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			} else if (pieceName.contains("KNIGHT")) {
				Knight knight = (Knight) piece;
				if (knight.isValidMove(myKing.getPosition()))
				{
					res = true;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * Méthode qui teste si joueur à gagné
	 * @return Color renvoie la couleur du joueur qui a gagné la partie, renvoit null si personne n'a gagné
	 */
	public Color playerColorWin() {
		Color res = null;
		ArrayList<King> listKing = new ArrayList<>();

		for (Piece piece : board.getAllPieceOnChessboard()) {
			if (piece.getName().contains("KING"))
				listKing.add((King) piece);
		}
		
		if (listKing.size() == 1)
		{
			res = listKing.get(0).getColor();
		}
		
		return res;
	}

	/**
	 * Méthode qui teste si un roque est possible pour le joueur courant
	 * @return True si un roque est possible, false sinon
	 */
	public boolean isRoquePossible() {
		boolean res = false;
		ArrayList<Rook> listRook = new ArrayList<>();
		King myKing = null;

		for (Piece piece : board.getAllPieceOnChessboard()) {
			if (piece.getColor() == getCurrentColor()) {
				if (piece.getName().contains("KING"))
					myKing = (King) piece;
				else if (piece.getName().contains("ROOK"))
					listRook.add((Rook) piece);
			}
		}

		for (Rook rook : listRook) {
			if (myKing.getPosition().getManhattanDistance(rook.getPosition()) <= 4)
			{
				if (myKing.getPosition().isOnSameLineAs(rook.getPosition())) {
					if (!board.isPiecePresentOnSameLineBetween(myKing.getPosition(), rook.getPosition())) {
						res = true;
					}
				}

			}
		}
		return res;
	}

	/**
	 * Méthode qui effectue un roque pour le joueur dont la couleur est passé en
	 * paramètre
	 * 
	 * @param color Couleur
	 */
	public void doRoque(King king, Rook rook) {
		int intKing = 0;
		int intRook = 0;

		if ( (getCurrentColor() == Color.WHITE && king.isWhite() && rook.isWhite()) || (getCurrentColor() == Color.BLACK && king.isBlack() && rook.isBlack()) ) {
			if (rook.getName().contains("ROOK") && king.getName().contains("KING")) {
				if (king.getPosition().isOnSameLineAs(rook.getPosition())) {
					if (!board.isPiecePresentOnSameLineBetween(king.getPosition(), rook.getPosition())) {

						// Petit roque
						if (king.getPosition().getManhattanDistance(rook.getPosition()) == 3) {
							if (king.getPosition().getX() < rook.getPosition().getX()) {
								intKing += 2;
								intRook -= 2;
							} else if (king.getPosition().getX() > rook.getPosition().getX()) {
								intKing -= 2;
								intRook += 2;
							}

							// Grand roque
						} else if (king.getPosition().getManhattanDistance(rook.getPosition()) == 4) {
							if (king.getPosition().getX() < rook.getPosition().getX()) {
								intKing += 2;
								intRook -= 3;
							} else if (king.getPosition().getX() > rook.getPosition().getX()) {
								intKing -= 2;
								intRook += 3;
							}
							
						}

						Position newPosKing = new Position(king.getPosition().getX() + intKing,
								(king.getPosition().getY()));
						Position newPosRook = new Position(rook.getPosition().getX() + intRook,
								(king.getPosition().getY()));
						board.setPiece(newPosKing, king);
						board.setPiece(newPosRook, rook);
					}
				}
			}
		}
	}

/**
 * Méthode qui joue le tour du joueur courant
 * 
 * @param start Position de la pièce à déplacer
 * @param end   Destination du déplacement
 * @throws ChessMoveException Si la case de départ est vide, si elle contient une pièce de l'adversaire, ou si le déplacement est invalide
 */
public void turn(Position start, Position end) throws ChessMoveException {

	if (this.board.getPiece(start) == null)
		throw new ChessMoveException("La case de départ est vide.", start, end);

	else if (this.board.getPiece(start).getColor() != this.getCurrentColor())
		throw new ChessMoveException("La case de départ contient une pièce adverse.", start, end);

	if (this.board.getPiece(end) != null)
		if (this.board.getPiece(end).getColor() == this.getCurrentColor())
			throw new ChessMoveException("La case de destination est contient une de vos pièces.", start, end);

	this.board.getPiece(start).moveTo(end);
}

/**
 * Méthode qui saute des ligne pour rendre l'affichage dans la console plus lisible
 */
public static void clear() {
	for (int i = 0; i < 20; i++)
		System.out.println("\n");
}

/**
 * Programme principal
 * Permet à deux joueurs de saisir leurs déplacements à tour de rôle, en affichant l'échiquier après chaque coup
 */
public static void main(String[] args) {
	System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
	System.out.println("#                         THE CHESS GAME                          #");
	System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
	System.out.println('\n');

	boolean isTheEndOfTheGame = false;
	Scanner sc = new Scanner(System.in);

	System.out.println(" > Veuillez saisir votre nom (Noirs  ⚑ ) :");
	String blackPlayerName = sc.nextLine().toUpperCase();

	System.out.println(" > Veuillez saisir votre nom (Blancs ⚐ ) :");
	String whitePlayerName = sc.nextLine().toUpperCase();

	Game game = new Game(blackPlayerName, whitePlayerName);

	while (isTheEndOfTheGame != true) {
		
		String nameCurrentPlayer = (game.getCurrentColor() == Color.WHITE) ? game.getWhitePlayerName() : game.getBlackPlayerName();
		String symbolCurrentPlayer = (game.getCurrentColor() == Color.WHITE) ? "⚐" : "⚑";
		String prefixCurrentPlayer = " > " + nameCurrentPlayer + " (" + symbolCurrentPlayer + ") : ";
		String nameCurrentEnemy = (game.getCurrentColor() == Color.WHITE) ? game.getBlackPlayerName() : game.getWhitePlayerName();
		String symbolCurrentEnemy = (game.getCurrentColor() == Color.WHITE) ? "⚑" : "⚐";
		
		if (game.isEchec(game.getCurrentColor()))
		{
			System.out.println(prefixCurrentPlayer + "Vous avez été mit en échec par " + nameCurrentEnemy + " (" + symbolCurrentEnemy + ") !\n");
		}
		
		System.out.println(game.board);
		System.out.println(" # Écrire HISTORIQUE pour voir l'historique des coups jouées.\n");
		System.out.println(" # Si possible, écrire ROQUE pour effectuer un roque.\n");
		
			try {
				System.out.println(prefixCurrentPlayer + "Lieu actuel de la pièce à déplacer ? (exemple : A1)");
				String choice = sc.nextLine();

				switch (choice.toUpperCase()) {
				/*
				 * On a choisi un switch en se disant que dans une version futur on pourrait
				 * ajouter des commandes comme REGLES
				 */
				case "HISTORIQUE":
					System.out.println("\n");
					game.board.printHistoric();
					System.out.println("\n");
					
					System.out.println(prefixCurrentPlayer + "Position actuel de la pièce à déplacer ? (exemple : A1)");
					Position start = new Position(sc.nextLine().toUpperCase());
					System.out.println(prefixCurrentPlayer + "Position de destination de la pièce ? (exemple : A4)");
					Position end = new Position(sc.nextLine().toUpperCase());
					game.turn(start, end);
					game.currentColor = (game.getCurrentColor() == Color.WHITE) ? Color.BLACK : Color.WHITE;
					clear();
					break;
					
				case "ROQUE":
					if (game.isRoquePossible()) {
						System.out.println(prefixCurrentPlayer + "[ ROQUE ] Position du roi ? (exemple : D1)");
						Position roi = new Position(sc.nextLine().toUpperCase());
						System.out.println(prefixCurrentPlayer + "[ ROQUE ] Position de la tour ? (exemple : A1)");
						Position rook = new Position(sc.nextLine().toUpperCase());
						game.doRoque((King) game.board.getPiece(roi), (Rook) game.board.getPiece(rook));
						game.currentColor = (game.getCurrentColor() == Color.WHITE) ? Color.BLACK : Color.WHITE;
						clear();
					}
					else {
						clear();
						System.out.println(" ‼ Roque non disponible");
					}
					break;
				
				default :
					start = new Position(choice);
					System.out.println(prefixCurrentPlayer + "Position de destination de la pièce ? (exemple : A4)");
					end = new Position(sc.nextLine().toUpperCase());
					game.turn(start, end);
					game.currentColor = (game.getCurrentColor() == Color.WHITE) ? Color.BLACK : Color.WHITE;
					clear();
					break;
				}
				
			} catch (IllegalArgumentException exception) {
				clear();
				System.out.print(exception.getMessage() + "\n");
			} catch (ChessMoveException exception) {
				clear();
				System.out.print(exception.getMessage() + "\n");
			}
			catch (ClassCastException exception) {
				clear();
				System.out.print(" ‼ Erreur dans le choix des pièces pour le ROQUE.\n");
			}
			
			if (game.playerColorWin() != null)
			{
				isTheEndOfTheGame = true;
				String winner = (game.playerColorWin() == Color.WHITE) ? game.getWhitePlayerName() : game.getBlackPlayerName();
				System.out.print(" # Félicitation au vainqueur : " + winner + "\n");
			}
		}

	sc.close();
	
}

}

package chess.pieces;

import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * Classe abstraite Piece
 * Classe de base représentant une pièce du jeu d'échecs
 */
public abstract class Piece {

	// Echiquier auquel la pièce appartient
	protected final Chessboard board;
	// Couleur de la pièce (Color.WHITE ou Color.BLACK)
	private Color color;
	// Nom de la pièce (Roi, Reine...)
	private String name;
	// Position de la pièce sur l'échiquier
	private Position position;
	// Symbole de la pièce
	private char symbol;

	/**
	 * Constructeur d'une pièce
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 * @param name Nom de la pièce
	 * @param symbol Symbole de la pièce
	 */
	public Piece(Chessboard board, Position position, Color color, String name, char symbol) {
		this.board = board;
		this.position = position;
		this.color = color;
		this.name = name;
		this.symbol = symbol;
	}

	/**
	 * Accesseur à la couleur de la pièce
	 * @return Couleur de la pièce
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Accesseur au nom de la pièce
	 * @return Nom de la pièce
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Accesseur à la position de la pièce
	 * @return Position de la pièce
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Accesseur au symbole de la pièce
	 * @return Symbole de la pièce
	 */
	public char getSymbol() {
		return this.symbol;
	}

	/**
	 * Méthode qui teste si la couleur de la pièce est noire
	 * @return True si la pièce est noire, false sinon
	 */
	public boolean isBlack() {
		boolean res = false;
		if (this.color == Color.BLACK) {
			res = true;
		}
		return res;
	}

	/**
	 * Méthode qui teste si la couleur de la pièce est blanche
	 * @return True si la pièce est blanche, false sinon
	 */
	public boolean isWhite() {
		boolean res = false;
		if (this.color == Color.WHITE) {
			res = true;
		}
		return res;
	}
	
	/**
	 * Méthode qui déplace la pièce sur la case indiquée
	 * @param destination Position de la case de destination du déplacement
	 * @throws ChessMoveException Si le mouvement n'est pas possible
	 */
	public void moveTo(Position destination) throws ChessMoveException {
		if (isValidMove(destination)) {
			this.board.setPiece(destination, this);
			this.position = destination;
		} else {
			throw new ChessMoveException("Déplacement impossible : " + this.symbol, this.position, destination);
		}
	}
	
	/**
	 * Méthode abstraite qui teste la validité d'un déplacement
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	public abstract boolean isValidMove(Position destination);

}

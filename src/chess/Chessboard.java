package chess;

import java.util.ArrayList;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.Color;
import chess.util.Position;

/**
 * Classe Chessboard
 * Classe représentant un échiquier lors d'une partie d'échecs
 */
public final class Chessboard {

	// Tableau de pièces représentant les cases de l'échiquier (une case vide vaut null)
	private Piece[][] pieces;
	// Liste représentant l'ensemble des coups joués
	private ArrayList<String> historic;

	
	/**
	 * Constructeur par défaut
	 */
	public Chessboard() {
		pieces = new Piece[8][8];
		this.historic = new ArrayList<String>();

		pieces[0][0] = new Rook(this, new Position(0, 0), Color.WHITE);
		pieces[1][0] = new Knight(this, new Position(1, 0), Color.WHITE);
		pieces[2][0] = new Bishop(this, new Position(2, 0), Color.WHITE);
		pieces[3][0] = new King(this, new Position(3, 0), Color.WHITE);
		pieces[4][0] = new Queen(this, new Position(4, 0), Color.WHITE);
		pieces[5][0] = new Bishop(this, new Position(5, 0), Color.WHITE);
		pieces[6][0] = new Knight(this, new Position(6, 0), Color.WHITE);
		pieces[7][0] = new Rook(this, new Position(7, 0), Color.WHITE);

		pieces[0][1] = new Pawn(this, new Position(0, 1), Color.WHITE);
		pieces[1][1] = new Pawn(this, new Position(1, 1), Color.WHITE);
		pieces[2][1] = new Pawn(this, new Position(2, 1), Color.WHITE);
		pieces[3][1] = new Pawn(this, new Position(3, 1), Color.WHITE);
		pieces[4][1] = new Pawn(this, new Position(4, 1), Color.WHITE);
		pieces[5][1] = new Pawn(this, new Position(5, 1), Color.WHITE);
		pieces[6][1] = new Pawn(this, new Position(6, 1), Color.WHITE);
		pieces[7][1] = new Pawn(this, new Position(7, 1), Color.WHITE);
		
		pieces[0][6] = new Pawn(this, new Position(0, 6), Color.BLACK);
		pieces[1][6] = new Pawn(this, new Position(1, 6), Color.BLACK);
		pieces[2][6] = new Pawn(this, new Position(2, 6), Color.BLACK);
		pieces[3][6] = new Pawn(this, new Position(3, 6), Color.BLACK);
		pieces[4][6] = new Pawn(this, new Position(4, 6), Color.BLACK);
		pieces[5][6] = new Pawn(this, new Position(5, 6), Color.BLACK);
		pieces[6][6] = new Pawn(this, new Position(6, 6), Color.BLACK);
		pieces[7][6] = new Pawn(this, new Position(7, 6), Color.BLACK);
		
		pieces[0][7] = new Rook(this, new Position(0, 7), Color.BLACK);
		pieces[1][7] = new Knight(this, new Position(1, 7), Color.BLACK);
		pieces[2][7] = new Bishop(this, new Position(2, 7), Color.BLACK);
		pieces[3][7] = new King(this, new Position(3, 7), Color.BLACK);
		pieces[4][7] = new Queen(this, new Position(4, 7), Color.BLACK);
		pieces[5][7] = new Bishop(this, new Position(5, 7), Color.BLACK);
		pieces[6][7] = new Knight(this, new Position(6, 7), Color.BLACK);
		pieces[7][7] = new Rook(this, new Position(7, 7), Color.BLACK);
		
	}

	/*
	 * Accesseur qui donne l'ensemble des pièces encore présent sur le tableau
	 * @return ArrayList des pièces sur le plateau
	 */
	public ArrayList<Piece> getAllPieceOnChessboard() {
		ArrayList<Piece> listOfAllPieces = new ArrayList <>();
		for (Piece[] linePiece : this.pieces)
		{
			for (Piece piece : linePiece)
			{
				if (piece != null) {
					listOfAllPieces.add(piece);
				}
			}
		}
		return listOfAllPieces;
	}
	
	/**
	 * Accesseur de la pièce de la case (x,y) de l'échiquier
	 * @param x Abscisse de la case (0 à 7)
	 * @param y Ordonnée de la case (0 à 7)
	 * @return Pièce située sur la case ou null si la case est vide
	 */
	public Piece getPiece(int x, int y) {
		return pieces[x][y];

	}

	/**
	 * Accesseur de la pièce de la case indiquée par pos
	 * @param pos Position de la case
	 * @return Pièce située sur la case ou null si la case est vide
	 */
	public Piece getPiece(Position pos) {
		return pieces[pos.getX()][pos.getY()];
	}

	/**
	 * Accesseur de la taille de l'historique
	 * @return Taille de l'historique
	 */
	public int getHistoricSize() {
		return this.historic.size();
	}

	/**
	 * Méthode qui affiche l'historique des coups joués
	 */
	public void printHistoric() {
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("                            HISTORIQUE                             ");
		if (getHistoricSize() == 0) {
			System.out.println("Aucun déplacement n'a été effectué.");
		} else if (getHistoricSize() > 0) {
			for (String str : this.historic) {
				System.out.println(str);
			}
		}
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	}

	/**
	 * Méthode qui ajoute d'une entrée à l'historique
	 * @param piece Pièce que l'on déplace
	 * @param dest Position à laquelle on déplace la pièce
	 */
	public void addHistoric(Piece piece, Position dest) {
		StringBuilder str = new StringBuilder();
		str.append(getHistoricSize() + 1);
		str.append(") Joueur ");
		String colorPlayer = (piece.getColor() == Color.BLACK) ? "⚑" : "⚐";
		str.append(colorPlayer);
		str.append(" déplace ");
		str.append(piece.getSymbol());
		str.append(" de ");
		str.append(piece.getPosition());
		str.append(" → ");
		str.append(dest);
		str.append(".");
		this.historic.add(str.toString());
	}


	/**
	 * Méthode qui teste la présence d'une pièce sur la colonne comprise entre les positions start et end (exclues)
	 * @param start Première extrémité
	 * @param end Seconde extrémité
	 * @return True s'il y a une pièce sur la colonne comprise entre les positions start et end (exclues), false sinon
	 * @throws IllegalArgumentException Si les positions start et end ne sont pas sur la même colonne
	 */
	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end) throws IllegalArgumentException {
		boolean res = false;
		if (!(start.isOnSameColumnAs(end))) {
			throw new IllegalArgumentException("La pièce se trouvant en " + start
					+ " ne se trouve pas sur la même colonne que la pièce en " + end);
		}
		int add = (start.getY() > end.getY()) ? -1 : 1;
		int y = start.getY() + add;

		while (y != end.getY()) {
			if (!(this.getPiece(start.getX(), y) == null)) {
				res = true;
			}
			y += add;
		}

		return res;
	}

	/**
	 * Méthode qui teste la présence d'une pièce sur la diagonale comprise entre les positions start et end (exclues)
	 * @param start Première extrémité
	 * @param end Seconde extrémité
	 * @return True s'il y a une pièce sur la diagonale comprise entre les positions start et end (exclues), false sinon
	 * @throws IllegalArgumentException Si les positions start et end ne sont pas sur la même diagonale
	 */
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) throws IllegalArgumentException {
		boolean res = false;
		if (!(start.isOnSameDiagonalAs(end))) {
			throw new IllegalArgumentException("La pièce se trouvant en " + start
					+ " ne se trouve pas sur la même diagonale que la pièce en " + end);
		}
		int addY = (start.getY() > end.getY()) ? -1 : 1;
		int addX = (start.getX() > end.getX()) ? -1 : 1;
		int y = start.getY() + addY;
		int x = start.getX() + addX;
		while (x != end.getX() && y != end.getY()) {
			if (!(this.getPiece(x, y) == null)) {
				res = true;
			}
			x += addX;
			y += addY;
		}
		return res;
	}

	/**
	 * Méthode qui teste  la présence d'une pièce sur la ligne comprise entre les positions start et end (exclues)
	 * @param start Première extrémité
	 * @param end Seconde extrémité
	 * @return True s'il y a une pièce sur la ligne comprise entre les positions start et end (exclues), false sinon.
	 * @throws IllegalArgumentException Si les positions start et end ne sont pas sur la même ligne
	 */
	public boolean isPiecePresentOnSameLineBetween(Position start, Position end) throws IllegalArgumentException {
		boolean res = false;
		if (!(start.isOnSameLineAs(end))) {
			throw new IllegalArgumentException(
					"La pièce se trouvant en " + start + " ne se trouve pas sur la même ligne que la pièce en " + end);
		}
		int add = (start.getX() > end.getX()) ? -1 : 1;
		int x = start.getX() + add;

		while (x != end.getX()) {
			if (!(this.getPiece(x, start.getY()) == null)) {
				res = true;
			}
			x += add;
		}
		return res;
	}

	/**
	 * Méthode qui remplace la pièce située sur la case indiquée
	 * @param pos position de la case de destination
	 * @param newPiece nouvelle pièce de la case
	 */
	public void setPiece(Position pos, Piece newPiece) {
		addHistoric(newPiece, pos);
		pieces[newPiece.getPosition().getX()][newPiece.getPosition().getY()] = null;
		pieces[pos.getX()][pos.getY()] = newPiece;
	}

	/**
	 * Retourne une chaîne de caractères représentant l'échiquier
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("\n");
		res.append("     A   B   C   D   E   F   G   H  \n");
		res.append("   ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓  \n");
		int numLine = 7;

		for (int line = 1; line <= 15; line++) {
			int numRow = 0;
			for (int row = 0; row <= 16; row++) {
				if (line % 2 == 0) {
					if (row == 0) {
						res.append("   ┣");
					} else if (row == 16) {
						res.append('┫');
					} else if (row % 2 != 0) {
						res.append("━━━");
					} else {
						res.append('╋');
					}
				} else {
					if (row == 0) {
						res.append(' ');
						res.append(numLine + 1);
						res.append(" ┃");
					} else if (row == 16) {
						res.append("┃ ");
						res.append(numLine + 1);
						numLine--;
					} else if (row % 2 != 0) {
						if (getPiece(numRow, numLine) != null) {
							res.append(' ');
							res.append(getPiece(numRow, numLine).getSymbol());
							res.append(' ');
						} else {
							res.append("   ");
						}
						numRow++;
					} else {
						res.append('┃');
					}
				}
			}
			res.append('\n');
		}
		res.append("   ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛  \n");
		res.append("     A   B   C   D   E   F   G   H  \n");
		res.append('\n');
		return res.toString();
	}


}

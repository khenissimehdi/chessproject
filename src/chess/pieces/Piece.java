/**
 * 
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

/**
 * @author khen0002
 *
 */
public abstract class Piece {

	protected Chessboard board;
	private Color color;
	private String name;
	private Position position;
	private char symbol;


	public Piece(Chessboard board,Position position,Color color,String name,char symbol) {
		this.board= board;
		this.position=position;
		this.color=color;
		this.name=name;
		this.symbol=symbol;
	}


	public Color getColor() {
		return this.color;
	}


	public String getName() {
		return this.name;
	}


	public Position getPosition() {
		return this.position;
	}


	public char getSymbol() {
		return this.symbol;
	}


	public boolean isBlack() {
		boolean res = false;
		if(this.color == Color.BLACK) {
			res = true;	
		}
		return res;
	}


	public boolean isWhite() {
		boolean res = false;
		if(this.color == Color.WHITE) {
			res = true;	
		}
		return res;
	}


	public void moveTo(Position destination) throws ChessMoveException{
		if(this.isValidMove(destination))
		{
			this.board.setPiece(destination, this);
			this.position = destination;
		}
		else
		{
			throw new ChessMoveException("Erreur : ", this.position, destination);
		}
	}


	public boolean isValidMove(Position destination) {
		boolean res = false;
		if (board.getPiece(destination) == null)
		{
			res = true;
		}
		else if (board.getPiece(destination).getColor() != this.getColor())
		{

			res = true;	
		}

		return res;
	}


}

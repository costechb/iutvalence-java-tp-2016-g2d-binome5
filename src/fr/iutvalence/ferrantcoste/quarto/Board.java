package fr.iutvalence.ferrantcoste.quarto;

import java.util.Stack;

/**
 * define a board like a table of box
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Board {

	/** TODO */
	private final Piece[][] theBoard;

	public Board(int size) {
		this.theBoard = new Piece[size][size];
	}

	public void putPiece(int i, int j, Piece piece) {
		theBoard[i][j] = piece;
	}

	public Piece pickPiece(int i, int j) {
		Piece pieceTemp = theBoard[i][j];
		theBoard[i][j] = null;
		return pieceTemp;
	}
	public Piece watchPiece(int i, int j) {
		return theBoard[i][j];
	}
	
	public boolean isOccuped(int i, int j) {
		return this.theBoard[i][j] != null;
	}
}
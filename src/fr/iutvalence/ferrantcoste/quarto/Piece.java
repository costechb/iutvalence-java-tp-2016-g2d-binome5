package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Piece {

	/** isTall is true if the Piece is Tall */
	private boolean isTall;
	/** isSquare is true if the Piece is Square */
	private boolean isSquare;
	/** isWhite is true if the Piece is White */
	private boolean isWhite;
	/** isFull is true if the Piece is Full */
	private boolean isFull;

	/** TODO. */
	// private String imageName;

	public Piece(boolean full, boolean square, boolean tall, boolean white) {
		this.isFull = full;
		this.isSquare = square;
		this.isTall = tall;
		this.isWhite = white;
	}
}

package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Piece {
	/** TODO. */
	private boolean isTall = true;
	/** TODO. */
	private boolean isSquare = true;
	/** TODO. */
	private boolean isWhite = true;
	/** TODO. */
	private boolean isFull = true;
	/** TODO. */
	private String imageName;

	public Piece(boolean full, boolean square, boolean tall, boolean white) {
		this.isFull = full;
		this.isSquare = square;
		this.isTall = tall;
		this.isWhite = white;
	}
}

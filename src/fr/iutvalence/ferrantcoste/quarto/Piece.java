package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Piece {

	private String  id;
	
	/** isTall is true if the Piece is Tall */
	private boolean isTall;
	/** isSquare is true if the Piece is Square */
	private boolean isSquare;
	/** isWhite is true if the Piece is White */
	private boolean isWhite;
	/** isFull is true if the Piece is Full */
	private boolean isFull;

	public boolean getTall() {
		return isTall;
	}

	public boolean getSquare() {
		return isSquare;
	}

	public boolean getWhite() {
		return isWhite;
	}

	public boolean getFull() {
		return isFull;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	/** TODO. */
	// private String imageName;

	public Piece(boolean full, boolean square, boolean tall, boolean white, String id) {
		this.isFull = full;
		this.isSquare = square;
		this.isTall = tall;
		this.isWhite = white;
		this.id = id;
	}
	
/*	public boolean compareWith(Piece p2, Piece p3, Piece p4) {
		if (isTall == p2.isTall == p3.isTall == p4.isTall) {
			
		}
	}*/
}

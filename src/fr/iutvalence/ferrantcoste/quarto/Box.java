package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Box {
	/** TODO. */
	protected boolean isOccuped;
	/**
	 * Coordinates is a 4 digits long number constitute by 0 and 1 so there is
	 * 16 different possibilities for the 16 different pieces
	 */
	private int coordinates;

	public Box(boolean occuped, int coordinates) {
		this.isOccuped = occuped;
	}

}

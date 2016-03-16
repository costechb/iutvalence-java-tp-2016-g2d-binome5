package fr.iutvalence.ferrantcoste.quarto;

/**
 * define a board like a table of box
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Board {

	/** TODO */
	private final Box[][] theBoard;

	public Board(int size, boolean initialState) {
		this.theBoard = new Box[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.theBoard[i][j] = new Box(initialState);
			}
		}
	}
}
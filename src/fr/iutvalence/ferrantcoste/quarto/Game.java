package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Game {
	/** TODO. */
	private Player player1;
	/** TODO. */
	private Player player2;
	/** TODO. */
	private Player winner;
	/** TODO. */
	private Player playerTurn;
	/** NB_COLUMN_MAX is the maximum number of column . */
	public static final int DEFAULT_SIZE = 4;

	public static final boolean OCCUPPED_BOXES = true;

	public static final boolean EMPTY_BOXES = false;

	public static void main(String[] args) {
		Board boardStock = new Board(DEFAULT_SIZE, OCCUPPED_BOXES);
		Board boardPalyed = new Board(DEFAULT_SIZE, EMPTY_BOXES);
		Board boardToPlay = new Board(1, EMPTY_BOXES);

		Piece unePiece1 = new Piece(false, false, false, false);
		Piece unePiece2 = new Piece(false, false, false, true);
		Piece unePiece3 = new Piece(false, false, true, false);
		Piece unePiece4 = new Piece(false, false, true, true);
		Piece unePiece5 = new Piece(false, true, false, false);
		Piece unePiece6 = new Piece(false, true, false, true);
		Piece unePiece7 = new Piece(false, true, true, false);
		Piece unePiece8 = new Piece(false, true, true, true);
		Piece unePiece9 = new Piece(true, false, false, false);
		Piece unePiece10 = new Piece(true, false, false, true);
		Piece unePiece11 = new Piece(true, false, true, false);
		Piece unePiece12 = new Piece(true, false, true, true);
		Piece unePiece13 = new Piece(true, true, false, false);
		Piece unePiece14 = new Piece(true, true, false, true);
		Piece unePiece15 = new Piece(true, true, true, false);
		Piece unePiece16 = new Piece(true, true, true, true);

	}
}

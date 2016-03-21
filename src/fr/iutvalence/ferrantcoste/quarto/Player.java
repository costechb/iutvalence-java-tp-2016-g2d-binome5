package fr.iutvalence.ferrantcoste.quarto;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Player {

	/** pseudo is the name of the player. */
	private String pseudo;
	/** num is the number of the player. */
	private int num;

	/**
	 * TODO.
	 *
	 * @return TODO
	 */
	public Player(int num, String pseudo) {
		this.pseudo = pseudo;
		this.num = num;
	}

	public String getPseudo() {
		return pseudo;
	}
}

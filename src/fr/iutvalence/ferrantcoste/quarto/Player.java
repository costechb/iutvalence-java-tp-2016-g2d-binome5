package fr.iutvalence.ferrantcoste.quarto;

/**
 * PLayer is the object representing the 2 players in the game
 * 
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Player {

	/** pseudo is the name choose by the player. */
	private final String pseudo;

	/** num is the number of the player (the first get the number 1) */
	private final int num;

	/**
	 * 
	 * @return an Object Player
	 */
	public Player(int num, String pseudo) {
		this.pseudo = pseudo;
		this.num = num;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return pseudo;
	}
}
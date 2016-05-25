package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner; 	// To read data entry
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

	private int score;
	
	private Scanner scanner;

	/**
	 * 
	 * @return an Object Player
	 */
	public Player(int num, String pseudo, Scanner scanner) {
		this.num = num;
		this.pseudo = pseudo;
		this.scanner = scanner;
	}
	
	public String getPseudo() {return pseudo;}
	
	public int getNum() {return num;}
	
	/***/
	public int askRow(){
		int i=0;
		boolean ok;
		do{
			ok=true;
			System.out.printf("\n %s Please enter the row you want :",this.pseudo);
			i= (scanner.nextInt())-1; // the -1 is user-friendly, making the tab [1;4] instead of [0,3]
			if (i!=0 && i!=1 && i!=2 && i!=3) {
				System.out.println("\n the row must be between 1 and 4, please try again");
				ok=false;
			}
		}while (!ok);
		return i;
	}
	/***/ 
	public int askColumn(){
		int j=0;
		boolean ok;
		do{
			ok=true;
			System.out.printf("\n %s Please enter the column you want :", this.pseudo);
			j=  scanner.nextInt()-1; // the -1 is user-friendly, making the tab [1;4] instead of [0,3]
			if (j!=0 && j!=1 && j!=2 && j!=3) {
				System.out.println("\n the column must be between 1 and 4, please try again");
				ok=false;
			}
		}while (!ok);
		return j;
	}

	@Override
	public String toString() {
		return pseudo;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int turnCount) {
		this.score=turnCount;
	}
	
}
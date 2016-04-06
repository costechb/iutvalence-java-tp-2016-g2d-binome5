package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner;

public class Quarto {

	public static void main(String[] args) {
		
		/* Start of initializing the players */
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Veuillez saisir le nom du joueur 1 :");
		Player player1 = new Player(1, sc.nextLine());
		System.out.println("Bonjour " + player1.getPseudo() + " !");

		System.out.println("Veuillez saisir le nom du joueur 2 :");
		Player player2 = new Player(2, sc.nextLine());
		System.out.println("Bonjour " + player2.getPseudo() + " !");
		
		Game game = new Game(player1, player2);
		game.run();
		
		sc.close();
	}
}

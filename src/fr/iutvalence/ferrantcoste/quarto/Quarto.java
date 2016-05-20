package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner;

public class Quarto {

	public static void main(String[] args)  {

		/* Start of initializing the players */
		try (Scanner sc = new Scanner(System.in)) {
			boolean ok;
			String name="Jarjar";
			
			do{
				ok=true;
				System.out.println("Please enter the name of player 1 :");
				name = sc.nextLine();
				if (name.contains(" ")) {
					System.out.println("No space in name please. Try Again");
					ok=false;
				}
			}while (!ok);
			Player player1 = new Player(1, name);
			System.out.println("Hello " + player1.getPseudo() + " !");
			do{
				ok=true;
				System.out.println("Please enter the name of player 2 :");
				name = sc.nextLine();
				if (name.contains(" ")) {
					System.out.println("No space in name please. Try Again");
					ok=false;
				}
				if (name.equals(player1.getPseudo())) {
					System.out.println("No namesake please. Try Again");
					ok=false;
				}
			}while (!ok);
			
			Player player2 = new Player(2, name);
			System.out.println("Hello " + player2.getPseudo() + " !");
			
			Game game = new Game(player1, player2, sc);
			game.run();
		}
	}
}

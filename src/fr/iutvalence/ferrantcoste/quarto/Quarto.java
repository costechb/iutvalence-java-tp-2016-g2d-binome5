package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner;

public class Quarto {

	public static void main(String[] args)  {

		/* Start of initializing the players */
		try (Scanner sc = new Scanner(System.in)) {
			boolean ok;
			String name="Jarjar";
			int gamemode = 2;
			do{
				ok=true;
				System.out.println("Choose : Solo mode (1) or Multiplayer (2) ");
				gamemode = sc.nextInt();
				if (gamemode<1 || gamemode>2) {
					System.out.println("Entry not available. Try Again");
					ok=false;
				}
			}while (!ok);
			
			System.out.println("You selected :" + gamemode);	
			
			if(gamemode==1){
				do{
					ok=true;
					System.out.println("Please enter the name of player :");
					name = sc.nextLine();
					if (name.contains(" ")) {
						System.out.println("No space in name please. Try Again");
						ok=false;
					}
				}while (!ok);
				Player player = new Player(1, name);
				System.out.println("Hello " + player.getPseudo() + " !");
				Player player2=new Player(2,name);
				Game game = new Game(player, player2);
				game.run();
			}
			
			else{
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
			
			Game game = new Game(player1, player2);
			game.run();
			}
		}
	}
}

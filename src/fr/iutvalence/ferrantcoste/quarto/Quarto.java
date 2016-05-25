package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner;

public class Quarto {

	private static String askPseudo(int num){
		boolean ok;
		String name="Jarjar";
		Scanner scPseudo = new Scanner(System.in);
		do{
			ok=true;
			System.out.printf("\n Please enter the name of player %d:",num);
			name = scPseudo.nextLine();
			if (name.contains(" ")) {
				System.out.println("\n No space in name please. Try Again");
				ok=false;
			}
		}while (!ok);
		return name;
	}
	
	public static void main(String[] args)  {

		try (Scanner sc = new Scanner(System.in)) {
			boolean ok;
			String name="Jarjar";
			int gamemode = 2;
			
			do{
				ok=true;
				System.out.println("Choose : Solo mode (1) or Multiplayer (2) ");
				gamemode = sc.nextInt();
				if (gamemode<1 || gamemode>2) {
					System.err.println("Entry not available. Try Again");
					ok=false;
				}
			}while (!ok);
			
			System.out.println("You selected :" + gamemode);	
			
			Player player1 = new Player(1, askPseudo(1), sc);
			System.out.println("Hello " + player1.getPseudo() + " !");
			
			if(gamemode==1){		// = solo VS IA mode
				IA player2=new IA();
				Game game = new Game(player1, player2);
				game.run();
			}
			
			else{					// = 1 VS 1 mode
				do{
					ok=true;
					if (askPseudo(2).equals(player1.getPseudo())) {
						System.out.println("No namesake please. Try Again");
						ok=false;
					}
				}while (!ok);
				Player player2 = new Player(2, name, sc);
				System.out.println("Hello " + player2.getPseudo() + " !");
				Game game = new Game(player1, player2);
				game.run();
			}
		}
	}
}

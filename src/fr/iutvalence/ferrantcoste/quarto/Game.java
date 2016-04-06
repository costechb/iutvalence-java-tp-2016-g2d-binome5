package fr.iutvalence.ferrantcoste.quarto;

import java.util.Random; // sert à sortir un nombre aléatoire
// sert pour récupérer des données en lecture

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Game {

	private Player[] players;

	/** Current player. */
	private int currentPlayer;

	/** DEFAULT_SIZE is the maximum number of column and lines . */
	public static final int DEFAULT_SIZE = 4;

	/* Start initializing the boards */
	Board boardStock = new Board(DEFAULT_SIZE);
	Board boardPlayed = new Board(DEFAULT_SIZE);
	Board boardToPlay = new Board(1);
	/* End of initializing the boards */
	
	
	public Game(Player player1, Player player2) {
		players = new Player[] { player1, player2 };
		/* End of initializing the players */

		/* Start initializing the players */
		boardStock.putPiece(0, 0, new Piece(false, false, false, false));
		boardStock.putPiece(0, 1, new Piece(false, false, false, true));
		boardStock.putPiece(0, 2, new Piece(false, false, true, false));
		boardStock.putPiece(0, 3, new Piece(false, false, true, true));
		boardStock.putPiece(1, 0, new Piece(false, true, false, false));
		boardStock.putPiece(1, 1, new Piece(false, true, false, true));
		boardStock.putPiece(1, 2, new Piece(false, true, true, false));
		boardStock.putPiece(1, 3, new Piece(false, true, true, true));
		boardStock.putPiece(2, 0, new Piece(true, false, false, false));
		boardStock.putPiece(2, 1, new Piece(true, false, false, true));
		boardStock.putPiece(2, 2, new Piece(true, false, true, false));
		boardStock.putPiece(2, 3, new Piece(true, false, true, true));
		boardStock.putPiece(3, 0, new Piece(true, true, false, false));
		boardStock.putPiece(3, 1, new Piece(true, true, false, true));
		boardStock.putPiece(3, 2, new Piece(true, true, true, false));
		boardStock.putPiece(3, 3, new Piece(true, true, true, true));

		/* End of initializing the players */
		currentPlayer = new Random().nextInt(2);

		}

	
	public boolean checkAttribut(Piece p1,Piece p2,Piece p3,Piece p4){
		boolean full=false;
		boolean square=false;
		boolean white=false;
		boolean tall=false;

		for(int i=0; i<4; i++){
			if( p1.getFull()==p2.getFull()==p3.getFull()==p4.getFull() ){
				full=true;
				}
			if( p1.getSquare()==p2.getSquare()==p3.getSquare()==p4.getSquare() ){
				square=true;
			}
			if( p1.getWhite()==p2.getWhite()==p3.getWhite()==p4.getWhite() ){
				white=true;
			}
			if( p1.getTall()==p2.getTall()==p3.getTall()==p4.getTall() ){
				tall=true;
			}
		}
		return unBool;
	}
	
	public void run() {
		System.out.printf("%s will play first this time !", players[currentPlayer]);
		
		
		
		/**is true when someone wins
		 */
		boolean victory = false; 
		do {
			System.out.printf("%s , pick a piece for your opponent", players[currentPlayer]);
			/**
			 * TODO.
			 * lecture de la pièce choisie
			 * i et j à récupérer à la saisie du joueur 
			 */
			int i =0, j=0;
			boardToPlay.putPiece(0,0,boardStock.pickPiece(i,j));
			
			// Turn changing
			currentPlayer= ++currentPlayer % 2;		// good formule by Benoit, turns 0 in 1 and 1 to 0
			
		/*	if (currentPlayer==0) 
				{currentPlayer=1;}
			else 
				{currentPlayer=0;}*/
			
			System.out.printf("%s , you can now play the piece that your oppenent choose for you", players[currentPlayer]);
			
			/**
			 * TODO.
			 * lecture de la case choisie
			 * i2 et j2 à récupérer à la saisie du joueur 
			 */
			int i2 =0, j2=0;
			boardPlayed.putPiece(i2,j2,boardToPlay.pickPiece(1,1));
			
			if( i2==0&&(j2==0||j2==3) || i2==3&&(j2==0||j2==3) || i2==1&&(j2==1||j2==2) || i2==2&&(j2==1||j2==2) ) {
				// c'est dans une diagonnale 
				// donc tester les diagonnales
			}
			
		
			
				
		
		} while (!victory);
		
		

		/*
		 * public void dessineEchiquier(){ int ligne , col , i , ligElem ; for
		 * (ligne=0;ligne<nbLignes;ligne++) {
		 * traceLigneEtoiles((LARGEUR_CASE-1)*NB_COL+1); for (ligElem=0; ligElem
		 * < (HAUTEUR_CASE-1)/2;ligElem++) {traceLigneIntermediaire();} for
		 * (col=0;col<NB_COL;col++) { printf("*"); if (LARGEUR_CASE%2 != 0)
		 * printf(" ") ; tracePlusieursEspaces((LARGEUR_CASE-4)/2); if
		 * (echiquier[ligne][col] != CAVALIER_NON_PASSE)
		 * printf("%2d",echiquier[ligne][col]); else printf("  ");
		 * 
		 * tracePlusieursEspaces((LARGEUR_CASE-4)/2);
		 * 
		 * } printf("*\n");
		 * 
		 * 
		 * for (ligElem=0; ligElem < (HAUTEUR_CASE-1)/2;ligElem++)
		 * traceLigneIntermediaire(); }
		 * traceLigneEtoiles((LARGEUR_CASE-1)*NB_COL+1);
		 * 
		 * } void traceLigneEtoiles(int nbEtoiles) { int i; for
		 * (i=0;i<nbEtoiles;i++) printf("*"); printf("\n"); } void
		 * traceLigneIntermediaire(void) { int i,k; for (i=0;i<NB_COL;i++) {
		 * printf("*"); for(k=0;k<LARGEUR_CASE-2;k++) printf(" "); }
		 * printf("*\n"); } void tracePlusieursEspaces(int nbEspaces) { int i;
		 * for (i=0;i<nbEspaces;i++) printf (" "); }
		 */

	}
}

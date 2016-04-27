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


	public int checkCommonCarac(Piece p1,Piece p2,Piece p3,Piece p4){
		if (p1 == null || p2 == null || p3 == null || p4 == null) {
			return 0;
		}

		if( p1.getFull()==p2.getFull()==p3.getFull()==p4.getFull() ){
			if (p1.getFull()) {
				return 1;					// 1 mean the 4 pieces are all full
			}
			else {
				return 2;					// 2 mean the 4 pieces are all not full
			}
		}
		if( p1.getSquare()==p2.getSquare()==p3.getSquare()==p4.getSquare() ){
			if (p1.getSquare()==true) {
				return 3;					// 3 mean the 4 pieces are all square
			}
			else {
				return 4;					// 4 mean the 4 pieces are all not square
			}		
		}
		if( p1.getWhite()==p2.getWhite()==p3.getWhite()==p4.getWhite() ){
			if (p1.getWhite()==true) {
				return 5;					// 5 mean the 4 pieces are all white
			}
			else {
				return 6;					// 6 mean the 4 pieces are all not white
			}		
		}
		if( p1.getTall()==p2.getTall()==p3.getTall()==p4.getTall() ){
			if (p1.getTall()==true) {
				return 7;					// 7 mean the 4 pieces are all tall
			}
			else {
				return 8;					// 8 mean the 4 pieces are all not tall
			}		
		}
		return 0;							// 0 mean the 4 pieces have nothing in common
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
				victory = (i2 == j2) 
						? !(checkCommonCarac(boardPlayed.watchPiece(0,0), boardPlayed.watchPiece(1,1), boardPlayed.watchPiece(2,2), boardPlayed.watchPiece(3,3)) == 0 )
						: !(checkCommonCarac(boardPlayed.watchPiece(0,3), boardPlayed.watchPiece(1,2), boardPlayed.watchPiece(2,1), boardPlayed.watchPiece(3,0)) == 0 );					
			}
			if (!victory)	{
				
				if ( checkCommonCarac(boardPlayed.watchPiece(i2,0),boardPlayed.watchPiece(i2,1),boardPlayed.watchPiece(i2,2),boardPlayed.watchPiece(i2,3) ) == 0 ) {
					victory = false;
				}
				if ( checkCommonCarac(boardPlayed.watchPiece(0,j2),boardPlayed.watchPiece(1,j2),boardPlayed.watchPiece(2,j2),boardPlayed.watchPiece(3,j2) ) == 0 ) {
					victory = false;
				}
							
			}




			// tester les lignes et colonnes







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

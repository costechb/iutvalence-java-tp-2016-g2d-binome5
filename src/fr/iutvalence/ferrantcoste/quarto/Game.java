package fr.iutvalence.ferrantcoste.quarto;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Game {

	/** playerTurn stock the player who have to play. */
	private Player playerTurn;

	/** DEFAULT_SIZE is the maximum number of column and lines . */
	public static final int DEFAULT_SIZE = 4;

	public static void main(String[] args) {

		/* Start of initializing the players */
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du premier joueur :");
		String pseudo1 = sc1.nextLine();
		System.out.println("Bonjour  " + pseudo1 + "!");

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du second joueur :");
		String pseudo2 = sc2.nextLine();
		System.out.println("Bonjour  " + pseudo2 + "!");

		Player player1 = new Player(1, pseudo1);
		Player player2 = new Player(2, pseudo2);
		/* End of initializing the players */

		/* Start initializing the boards */
		Board boardStock = new Board(DEFAULT_SIZE);
		Board boardPlayed = new Board(DEFAULT_SIZE);
		Board boardToPlay = new Board(1);
		/* End of initializing the boards */

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

		/*
		 * public void dessineEchiquier(){
		 * 
		 * int ligne , col , i , ligElem ; for (ligne=0;ligne<nbLignes;ligne++)
		 * { traceLigneEtoiles((LARGEUR_CASE-1)*NB_COL+1); for (ligElem=0;
		 * ligElem < (HAUTEUR_CASE-1)/2;ligElem++) {traceLigneIntermediaire();}
		 * for (col=0;col<NB_COL;col++) { printf("*"); if (LARGEUR_CASE%2 != 0)
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
		 * for (i=0;i<nbEspaces;i++) printf (" ");
		 * 
		 * }
		 */

	}
}

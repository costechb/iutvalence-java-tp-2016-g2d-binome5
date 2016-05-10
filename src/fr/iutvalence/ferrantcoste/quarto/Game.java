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

	/** DEFAULT_SIZE is the maximum number of column and lines . */
	Board boardStock = new Board(DEFAULT_SIZE);
	/** DEFAULT_SIZE is the maximum number of column and lines . */
	Board boardPlayed = new Board(DEFAULT_SIZE);
	/** DEFAULT_SIZE is the maximum number of column and lines . */
	Board boardToPlay = new Board(1);


	public Game(Player player1, Player player2) {
		players = new Player[] { player1, player2 };
		/* End of initializing the players */
		
		try {
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
		} catch (PieceAlreadyHereException | OutsideOfBoardException e) {
			// no possible exception at initialization
			e.printStackTrace();
		}
		
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

		System.out.println(boardStock.toString());

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
			try {
				boardToPlay.putPiece(0,0,boardStock.pickPiece(i,j));
			} catch (PieceAlreadyHereException | OutsideOfBoardException | NoPieceHereException e1) {
				e1.printStackTrace();
			}

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
			
			try
			{
				boardPlayed.putPiece(i2,j2,boardToPlay.pickPiece(1,1));
			} catch (PieceAlreadyHereException | OutsideOfBoardException | NoPieceHereException e1) {
				e1.printStackTrace();
			}

			if( i2==0&&(j2==0||j2==3) || i2==3&&(j2==0||j2==3) || i2==1&&(j2==1||j2==2) || i2==2&&(j2==1||j2==2) ) {
				try {
					victory = (i2 == j2) 
							? !(checkCommonCarac(boardPlayed.watchPiece(0,0), boardPlayed.watchPiece(1,1), boardPlayed.watchPiece(2,2), boardPlayed.watchPiece(3,3)) == 0 )
							: !(checkCommonCarac(boardPlayed.watchPiece(0,3), boardPlayed.watchPiece(1,2), boardPlayed.watchPiece(2,1), boardPlayed.watchPiece(3,0)) == 0 );
				} catch (OutsideOfBoardException | NoPieceHereException e1) {
					e1.printStackTrace();
				}				
			}
			
			if (!victory)	
			{
				try {
					victory = !(checkCommonCarac(boardPlayed.watchPiece(i2,0),boardPlayed.watchPiece(i2,1),boardPlayed.watchPiece(i2,2),boardPlayed.watchPiece(i2,3))==0);
				} catch (OutsideOfBoardException | NoPieceHereException e1) {
					e1.printStackTrace();
				}			
						
			}
			if (!victory)	
			{
				try {
					victory = !(checkCommonCarac(boardPlayed.watchPiece(0,j2),boardPlayed.watchPiece(1,j2),boardPlayed.watchPiece(2,j2),boardPlayed.watchPiece(3,j2) )==0);
				} catch (OutsideOfBoardException | NoPieceHereException e1) {
					e1.printStackTrace();
				}			
			}

		} while (!victory);
		
		
	}
}

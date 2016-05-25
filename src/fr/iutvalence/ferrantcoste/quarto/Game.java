package fr.iutvalence.ferrantcoste.quarto;


import java.util.Random; 	// to use random
import java.util.Scanner; 	// To read data entry

/**
 * TODO.
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Game {
	
	private Player[] players;
	/** This is the number of the current player*/
	private int currentPlayer;
	int turnCount=0;
	/** DEFAULT_SIZE is the maximum number of column and lines . */
	public static final int DEFAULT_SIZE = 4;
	/** This is the Board with the Pieces you have to pick for your opponent . */
	private final Board boardStock = new Board(DEFAULT_SIZE);
	/** This is the Board with the Piece you have to play with. */
	private final Board boardPlayed = new Board(DEFAULT_SIZE);
	/** This is the Board with the Pieces you have to place on */
	private final Board boardToPlay = new Board(1);


	public Game(Player player1, Player player2) {
		players = new Player[] { player1, player2 };
		
		try {
			boardStock.putPiece(0, 0, new Piece(false, false, false, false,"01"));
			boardStock.putPiece(0, 1, new Piece(false, false, false, true,"02"));
			boardStock.putPiece(0, 2, new Piece(false, false, true, false,"03"));
			boardStock.putPiece(0, 3, new Piece(false, false, true, true,"04"));
			boardStock.putPiece(1, 0, new Piece(false, true, false, false,"05"));
			boardStock.putPiece(1, 1, new Piece(false, true, false, true,"06"));
			boardStock.putPiece(1, 2, new Piece(false, true, true, false,"07"));
			boardStock.putPiece(1, 3, new Piece(false, true, true, true,"08"));
			boardStock.putPiece(2, 0, new Piece(true, false, false, false,"09"));
			boardStock.putPiece(2, 1, new Piece(true, false, false, true,"10"));
			boardStock.putPiece(2, 2, new Piece(true, false, true, false,"11"));
			boardStock.putPiece(2, 3, new Piece(true, false, true, true,"12"));
			boardStock.putPiece(3, 0, new Piece(true, true, false, false,"13"));
			boardStock.putPiece(3, 1, new Piece(true, true, false, true,"14"));
			boardStock.putPiece(3, 2, new Piece(true, true, true, false,"15"));
			boardStock.putPiece(3, 3, new Piece(true, true, true, true,"16"));
		} catch (PieceAlreadyHereException | OutsideOfBoardException e) {/* no possible exception at initialization */}
		
		currentPlayer = new Random().nextInt(2); // choose randomly between 0 and 1
	}
	
	public void showBoards() {
		System.out.println("\n\n This is the Board with the Pieces you have to pick for your oppenent");
		System.out.println(boardStock.toString(DEFAULT_SIZE));
		System.out.println("\n\n This is the Board with the Piece you have to play with");
		System.out.println(boardToPlay.toString(1));
		System.out.println("\n\n This is the Board with the Pieces you have to place on");
		System.out.println(boardPlayed.toString(DEFAULT_SIZE));
	}

	public int checkCommonCarac(Piece p1,Piece p2,Piece p3,Piece p4){
		
		if (p1 == null || p2 == null || p3 == null || p4 == null) {
			return 0;
		}

		if( p1.getFull()==p2.getFull()&&p2.getFull()==p3.getFull()&&p3.getFull()==p4.getFull() ){
			if (p1.getFull()) {
				return 1;					// 1 mean the 4 pieces are all full
			}
			else {
				return 2;					// 2 mean the 4 pieces are all not full
			}
		}
		if( p1.getSquare()==p2.getSquare()&&p2.getSquare()==p3.getSquare()&&p3.getSquare()==p4.getSquare() ){
			if (p1.getSquare()==true) {
				return 3;					// 3 mean the 4 pieces are all square
			}
			else {
				return 4;					// 4 mean the 4 pieces are all not square
			}		
		}
		if( p1.getWhite()==p2.getWhite()&&p2.getWhite()==p3.getWhite()&&p3.getWhite()==p4.getWhite() ){
			if (p1.getWhite()==true) {
				return 5;					// 5 mean the 4 pieces are all white
			}
			else {
				return 6;					// 6 mean the 4 pieces are all not white
			}		
		}
		if( p1.getTall()==p2.getTall()&&p2.getTall()==p3.getTall()&&p3.getTall()==p4.getTall() ){
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
		System.out.printf("%s will play first this game !", players[currentPlayer]);

		showBoards();
		/**
		 * i is the row index
		 */
		int i;
		/**
		 * j is the column index
		 */
		int j;
		boolean ok;
		


		
		boolean victory = false; 
		do {
			System.out.printf("%s , pick a piece for your opponent \n", players[currentPlayer]);
			do{
				ok=true;
				i = players[currentPlayer].askRow();
				j = players[currentPlayer].askColumn();
				if(!boardStock.isOccuped(i, j)){
					System.out.printf("\n There is no Piece on the square you chose. Try again");
					ok=false;
				}
			}while(!ok);
			try {
				boardToPlay.putPiece(0,0,boardStock.pickPiece(i,j));
			} catch (PieceAlreadyHereException | OutsideOfBoardException | NoPieceHereException e1) {
				/* No need with precedent do while */
			}

			// Turn changing
			currentPlayer= ++currentPlayer % 2;
			// Turn counting
			turnCount++;

			showBoards();
			
			System.out.printf("%s , you can now play the piece that %s chose for you \n", players[currentPlayer],players[++currentPlayer % 2]);
			
			do{
				ok=true;
				i = players[currentPlayer].askRow();
				j = players[currentPlayer].askColumn();
				if(boardPlayed.isOccuped(i, j)){
					System.out.printf("\n The square you chose is occuped. Try again");
					ok=false;
				}
			}while(!ok);

			
			try
			{
				boardPlayed.putPiece(i,j,boardToPlay.pickPiece(0,0));
			} catch (PieceAlreadyHereException | OutsideOfBoardException | NoPieceHereException e1) {
				e1.printStackTrace();
			}

			if( i==0&&(j==0||j==3) || i==3&&(j==0||j==3) || i==1&&(j==1||j==2) || i==2&&(j==1||j==2) ) {
				try {
					System.out.println("Test diag");
					victory = (i == j) 
							? (checkCommonCarac(boardPlayed.watchPiece(0,0), boardPlayed.watchPiece(1,1), boardPlayed.watchPiece(2,2), boardPlayed.watchPiece(3,3)) != 0 )
							: (checkCommonCarac(boardPlayed.watchPiece(0,3), boardPlayed.watchPiece(1,2), boardPlayed.watchPiece(2,1), boardPlayed.watchPiece(3,0)) != 0 );

				} catch (OutsideOfBoardException | NoPieceHereException e1) { /* NOTHING */ }
		
			}
			
			if (!victory)
			{
				try {
					System.out.println("Test column");
					victory = (checkCommonCarac(boardPlayed.watchPiece(i,0),boardPlayed.watchPiece(i,1),boardPlayed.watchPiece(i,2),boardPlayed.watchPiece(i,3))!=0);
				} catch (OutsideOfBoardException | NoPieceHereException e1) { /* NOTHING */ }

						
			}
			if (!victory)	
			{
				try {
					System.out.println("Test line");
					victory = (checkCommonCarac(boardPlayed.watchPiece(0,j),boardPlayed.watchPiece(1,j),boardPlayed.watchPiece(2,j),boardPlayed.watchPiece(3,j) )!=0);
				} catch (OutsideOfBoardException | NoPieceHereException e1) { /* NOTHING */ }
			}

			showBoards();
			
		} while (!victory);

		System.out.printf("%s , you win in %d turns\n",players[currentPlayer],turnCount);
		players[currentPlayer].setScore(turnCount);
	}
}

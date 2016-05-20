package fr.iutvalence.ferrantcoste.quarto;
/**
 * define a board like a table of box
 *
 * @author Ferrant & Costechareyre
 * @version 1
 */
public class Board {

	/** TODO */
	private final Piece[][] theBoard;
	/** DEFAULT_SIZE is the maximum number of column and lines . */
	
	public static final int DEFAULT_SIZE = 4;

	public Board(int size) {
		this.theBoard = new Piece[size][size];	
	} 

	
	public String toString(int size){
		StringBuilder representation = new StringBuilder(500);
			
			for(int i=0 ; i<size ; i++ ){
				representation.append(" ______");
			}
			
			for(int i=0 ; i<size ; i++ ){
				
				representation.append("\n|");
				
				for( int j=0; j<size ; j++ ){
					representation.append("      |");
	     		}
				
				representation.append("\n|");
				
				for( int j=0; j<size ; j++ ){
					Piece current = theBoard[i][j];
					representation.append("  ")
								  .append(current == null ? "  " : current)
								  .append("  |");
	        	}
				
				representation.append("\n|");
				for( int j=0; j<size ; j++ ){
					representation.append("______|");
				} 
			}
			
			representation.append("\n");
			return representation.toString();
	}
	

	public void putPiece(int i, int j, Piece piece) throws PieceAlreadyHereException , OutsideOfBoardException {
		
		if ( i>3 || i<0 || j>3 || j<0 )
			{	throw new OutsideOfBoardException();	}
		if (theBoard[i][j] != null) 
			{	throw new PieceAlreadyHereException();	}
		
		theBoard[i][j] = piece;
	}

	public Piece pickPiece(int i, int j) throws NoPieceHereException , OutsideOfBoardException {
		
		if ( i>3 || i<0 || j>3 || j<0 )
			{	throw new OutsideOfBoardException();	}		
		if (theBoard[i][j] == null) 
			{	throw new NoPieceHereException();	}
		
		Piece pieceTemp = theBoard[i][j];
		theBoard[i][j] = null;
		return pieceTemp;
		}
	
	public Piece watchPiece(int i, int j) throws NoPieceHereException , OutsideOfBoardException {
		
		if ( i>3 || i<0 || j>3 || j<0 )
		{	throw new OutsideOfBoardException();	}		
		if (theBoard[i][j] == null) 
		{	throw new NoPieceHereException();	}
		
		return theBoard[i][j];
	}
	
	public boolean isOccuped(int i, int j) {
		return this.theBoard[i][j] != null;
	}
}
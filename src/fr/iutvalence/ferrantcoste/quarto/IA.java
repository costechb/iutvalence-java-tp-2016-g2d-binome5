package fr.iutvalence.ferrantcoste.quarto;

import java.util.Random;

public class IA extends Player{
	
	private static final String IA = null;

	public IA(int num, String pseudo) {
		super(2, IA);
	}
	public int askRow(){
		return new Random().nextInt(4);
	}
	public int askColumn(){
		return new Random().nextInt(4);	
	}

}
package fr.iutvalence.ferrantcoste.quarto;

import java.util.Random;

public class IA extends Player{
	private final Random random;
	
	public IA() {
		super(2, "IA", null);
		random = new Random();
	}
	public int askRow(){
		return random.nextInt(4);
	}
	public int askColumn(){
		return random.nextInt(4);	
	}
}
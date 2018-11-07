package asgn04;

import java.util.Random;

public class RandomValueGeneratorImpl implements RandomValueGenerator {
	
	

	//generates random int using Random object
	@Override
	public int getRandomValue() {
		Random rand = new Random();
		return rand.nextInt();
	}
	
	//generates random int within specified range
	@Override
	public int getRandomValue(int max, int min) {
		Random rand = new Random();
		return rand.nextInt((max-min)+1) +min;
	}
}

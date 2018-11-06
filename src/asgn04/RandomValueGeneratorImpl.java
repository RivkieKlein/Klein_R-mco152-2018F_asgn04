package asgn04;

import java.util.Random;

public class RandomValueGeneratorImpl implements RandomValueGenerator {
	//generates random int using Random object
	@Override
	public int getRandomValue() {
		Random r = new Random();
		return r.nextInt();
	}
}

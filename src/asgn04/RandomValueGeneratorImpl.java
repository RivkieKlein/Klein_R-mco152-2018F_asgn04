package asgn04;

import java.util.Random;

public class RandomValueGeneratorImpl implements RandomValueGenerator {
public int getRandomValue(){
	Random r = new Random();
	return r.nextInt();
}
}

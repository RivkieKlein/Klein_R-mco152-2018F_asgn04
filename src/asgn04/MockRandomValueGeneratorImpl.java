package asgn04;

public class MockRandomValueGeneratorImpl implements RandomValueGenerator {
	private int notRlyRand;

	@Override
	public int getRandomValue() {
		return notRlyRand;
	}

	public void setRandomValue(int num) {
		notRlyRand = num;
	}

}

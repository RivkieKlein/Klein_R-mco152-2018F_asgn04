package asgn04;

public class InvalidProbabilityException extends RuntimeException{
	public InvalidProbabilityException() {
		super("Not a valid probability");
	}

	public InvalidProbabilityException(String s) {
		super(s);
	}
}

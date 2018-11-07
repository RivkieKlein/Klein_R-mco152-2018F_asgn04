package asgn04;




import static org.junit.Assert.*;

import org.junit.*;

public class Betting_TESTS {
	private  Betting better;
	
	@Before
	public void initialize() {
	better = new Betting( 25,new MockRandomValueGeneratorImpl());
	System.out.println("Betting class built");
	}
	
	@After
	public void initialized() {
		better=null;
		System.out.println("Betting class taken down");
	}
	
	@Test
	// assert that canBet returns false when amt passed in is greater than current balance - min balance
	//covers regular false case, positive amount passed
	public void betAmount20CurrentBalance40MinimumBalance25CanBetReturnsFalse() {
		better.addMoney(40);
		assertFalse(better.canBet(20));
	}
	
	@Test
	//tests case where minimum ends up equaling current. can bet should still return true
	public void betAmount15CurrentBalance40MinimumBalance25CanBetReturnTrue() {
		better.addMoney(40);
		assertTrue(better.canBet(15));
		
	}
	
	@Test
	//tests that a case where the selected number matches random number winnings are positive and correct
	public void betAmount10Min6Max11SelNum7RandNum7BetOnANumberReturns50() {
		better.addMoney(40);
		((MockRandomValueGeneratorImpl) better.generator).setRandomValue(7);
		assertEquals(7, better.betOnANumber(10, 6, 11, 7));
	}
	
	@Test
	//tests that a case where the selected number does not match random number return is negative equals amount 
	public void betAmount10Min6Max11SelNum8RandNum7BetOnANumberReturnsNeg10() {
		better.addMoney(40);
		((MockRandomValueGeneratorImpl) better.generator).setRandomValue(7);
		int amt =10;
		assertEquals((amt*(-1)), better.betOnANumber(amt, 6, 11, 7));
	}
	
	@Test (expected= IllegalArgumentException.class)
	//testing bet on a number
	//what happens when bet amount is not valid-it will make the current balance go below min balance
	//will throw illegal argument exception
	//in a situation where canBet would have returned false
	public void betAmount10MinBalance25CurBalance30BetOnANumberThrowsIllegalArgumentException() {
		better.addMoney(30);
		better.betOnANumber(10, 6, 11, 7);
	}
	
	@Test
	//if event happens
	//should return correct positive winnings
	public void betAmount10ProbabilityPoint4EventHappensReturns15() {
		better.addMoney(40);
		assertEquals(15,better.betOnProbability(10, .4));
	}
	
	@Test
	//if event does not happen
	//should return negative losses
	public void betAmount10ProbabilityPoint4EventDoesNotHappenReturnsNeg10() {
		better.addMoney(40);
		int amt=10;
		assertEquals((amt*(-1)),better.betOnProbability(amt, .4));
	}
	
	@Test (expected=InvalidProbabilityException.class)
	//should throw exception if bet on a negative probability
	public void negProbabilityThrowsInvalidProbabilityException() {
		better.addMoney(40);
		better.betOnProbability(10,-.3);
	}
	
	@Test (expected=InvalidProbabilityException.class)
	//should throw exception if bet on a  probability greater than 1
	public void greaterThan1ProbabilityThrowsInvalidProbabilityException() {
		better.addMoney(40);
		better.betOnProbability(10,1.2);
	}
	
	@Test (expected=InvalidProbabilityException.class)
	//should throw exception if bet on a negative probability
	public void greaterThan1ProbabilityIllegalBetThrowsInvalidProbabilityException() {
		better.addMoney(40);
		better.betOnProbability(10,1.2);
	}
	
	@Test (expected=IllegalArgumentException.class)
	//should throw illega
	public void betAmount10MinBalance25CurBalance30BetOnProbabilityThrowsIllegalArgumentException() {
		better.addMoney(30);
		better.betOnProbability(10,.2);
	}
	
	
	

}

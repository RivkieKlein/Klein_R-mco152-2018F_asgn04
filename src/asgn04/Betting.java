package asgn04;

public class Betting {
	
	private int currBalance;
	private int minBalance;
	private RandomValueGenerator generator;
	
	public Betting(int minBalance, RandomValueGenerator rand) {
		
		
	}
	
	//getter
	public int getCurrentBalance() {
		return 0;
	}
	
	//returns boolean indicating if a bet for specified amount can be placed
	public boolean canBet(int amt) {
		return false;
	}
	
	//add money to increase current balance
	public void addMoney(int amt) {
		
	}
	
	//bet placer for number range gamble
	//accepts amount of bet, minimum number in range, max number in range, and the number to be bet on
	//returns int of winnings or losses
	public int betOnANumber(int amnt, int min, int max, int selectedNumber) {
		return 0;
	}
	
	//accepts amnt of bet, and probability that when reached the bet will execute
	//returns int of winnings or losses
	//throws invalid probability exception for negative probabilities or those greater than 1
	public int betOnProbability(int amnt, double p) {
	return 0;	
	}
	

}

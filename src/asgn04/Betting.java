package asgn04;

public class Betting {
	
	private double currBalance;
	private int minBalance;
	protected RandomValueGenerator generator;
	private boolean happens;
	
	public Betting(int minBalance, RandomValueGenerator rand) {
		this.minBalance=minBalance;
		currBalance=0;
		generator=rand;
		
	}
	
	//getter
	public double getCurrentBalance() {
		return currBalance;
	}
	
	//returns boolean indicating if a bet for specified amount can be placed
	public boolean canBet(int amt) {
		if(amt<=currBalance-minBalance) {
			return true;
		}
		else {
		return false;
		}
	}
	
	//add money to increase current balance
	public void addMoney(int amt) {
		currBalance+=amt;
	}
	
	//bet placer for number range gamble
	//accepts amount of bet, minimum number in range, max number in range, and the number to be bet on
	//returns int of winnings or losses
	public int betOnANumber(int amnt, int min, int max, int selectedNumber) {
		int winnings=0;
		int winningNum=generator.getRandomValue(max, min);
		if(!canBet(amnt)) {
			throw new IllegalArgumentException("You do not have a large enough balance to bet that amount");
		}
		else {
			if(winningNum==selectedNumber) {
				winnings=(max-min)*amnt;
			}
			
			else {
				winnings=amnt*-1;
			}
			
		}
		currBalance+=winnings;
		return winnings;
	}
	
	//accepts amnt of bet, and probability that when reached the bet will execute
	//returns int of winnings or losses
	//throws invalid probability exception for negative probabilities or those greater than 1
	public double betOnProbability(int amnt, double p) {
	
		double winnings;
		if(p<0) {
			throw new InvalidProbabilityException("Probability cannot be negative");
		}
		else if(p>1) {
			throw new InvalidProbabilityException("Probability cannot be greater than 1");
		}
		
		else if(!canBet(amnt)) {
			throw new IllegalArgumentException("You do not have a large enough balance to bet that amount");
		}
		
		if(happens) {
			winnings=((1/p)-1)*amnt;
			currBalance+=amnt;
		}
		else {
			winnings=amnt*-1;
			currBalance+=amnt;
		}
		
		
	return winnings;	
	}
	
	//method that holds case for probability bet
	public void setHappens(boolean occurred) {
		happens=occurred;
	}
	

}

package asgn04;

public class Betting {
	
	private int currBalance;
	private int minBalance;
	
	public Betting(int minBalance, RandomValueGenerator rand) {
		currBalance=0;
		this.minBalance=minBalance;
		
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
	//accepts amount of bet, minimum number in range, max number in range
	
	//
	

}

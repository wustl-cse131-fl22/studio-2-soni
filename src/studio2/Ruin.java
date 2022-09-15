package studio2;

import java.util.Scanner;

public class Ruin {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money will you start with? ");
		double startAmount = in.nextDouble();
		System.out.println("Win probability (between 0 and 1): ");
		double winChance = in.nextDouble();
		System.out.println("How much is your win limit? ");
		double winLimit = in.nextDouble();
		System.out.println("How many simulations would you like to run? ");
		int totalSimulations = in.nextInt();
		double currentAmount = 0;
		int day = 1;
		double loss = 0;
		double win = 0;
	
	for (int i = 0; i < totalSimulations; i++) {
		currentAmount = startAmount;
		int totalPlays = 0;
		while (currentAmount > 0 && currentAmount < winLimit) {
		double gamble = Math.random();
			if (gamble > winChance) {
				currentAmount = currentAmount - 1;
			}
			else {
				currentAmount = currentAmount + 1;
				}
		totalPlays = totalPlays + 1;
			
		}
		if (currentAmount == 0) {
			day = day + 1;
			System.out.println("Day " + day + ": Total plays = " + totalPlays + ". LOSS");
			loss = loss + 1;
		}
		else if (currentAmount == winLimit){
			day = day + 1;
			System.out.println("Day " + day + ": Total plays = " + totalPlays + ". WIN");
			win = win + 1;
		}
		}
	double lossRate = (loss / totalSimulations);
	double expectedRuinRate = 0;
			if (winChance == 0.5) {
				expectedRuinRate = 1 - (startAmount/winLimit);
			}
			else {
				double a = (1 - winChance) / winChance;
				expectedRuinRate = ((Math.pow(a, startAmount)) - (Math.pow(a, winLimit))) /(1 - (Math.pow(a, winLimit)));
			}
			
			
	System.out.println("Losses: " + (int) loss + " ; Simulations: " + totalSimulations);
	System.out.println("Ruin rate: " + lossRate + " ; Expected ruin rate: " + expectedRuinRate);
	
	
	}
}
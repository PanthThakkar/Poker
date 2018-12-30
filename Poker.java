package code;

import java.util.Scanner;

public class Poker {

	static Scanner input = new Scanner(System.in);
	static int[] cardValue = new int[5];
	//This generates a number between 0-52 (13 numbers per suit)
	static double[] rnumber = new double[5];
	static String suit[] = {"Spades", "Diamonds", "Hearts", "Clubs"}; 
	//This is the money each person
	static int money = 100000;
	static int money2 = 100000;
	static int money3 = 100000;
	static int money4 = 100000;
	static int money5 = 100000;
	static int money6 = 100000;
	static int bet = 0;
	static int reBet = 0;
	static int bets = 0;
	static int benchmark = 0;
	static int randomBet = 0; 
	static int total = 0;
	//This global variable is for the face value
	static int[] rShape = new int[5];
	static String otherPlayers[] = {"John Doe", "Jane Do", "Bob Dope", "Al Pachino", "Joesph deKeegan"};
	static int randomBetFoldSwitch = 0;
	//Determines who wins based on score
	static int score1 = 0;
	static int score2 = 0;
	static int score3 = 0;
	static int score4 = 0;
	static int score5 = 0;
	static int winings = 0;
	
	public static void main(String[] args) {
		System.out.println("Well to the Five Pin Casino!");
		System.out.println("You are now playing 5 card poker");
		System.out.println("There are 5 people playing with you (a total of 6 people)");
		System.out.println("You start off with $ 100 000. No max wager. Minimum wager is $4000.");
		System.out.println("The other players are:");
		System.out.println(otherPlayers[0]);
		System.out.println(otherPlayers[1]);
		System.out.println(otherPlayers[2]);
		System.out.println(otherPlayers[3]);
		System.out.println(otherPlayers[4]);
		
		//This do-while loop does everything in the class 
		do{
			System.out.println("Do you want to play? Yes(1) or No (2)");
			int playAgain = input.nextInt();
			if (playAgain == 1){
				String card = "";
				deck();
	
				updateBalance();
		
				int score = 1;
				//This if statement tells you the royal flush
				if (isRoyalFlush(card, rShape, rnumber)) {
					System.out.println("You have a royal flush!");
					score = 10;
				}
				//This if statement tells you that your hand is a straight flush
				else if (isStraightFlush(card, rShape, rnumber)){
					System.out.println("You have a Straight Flush");
					score = 9;
				}
				//This if statement tells you that the you have four of a number 
				else if (isFourOfAKind(card, rShape, rnumber) == true){
					System.out.println("You have Four of a Kind");
					score = 8;
				}
				//This if statement tells you that you have a triple of a number and a pair
				else if(isFullHouse(card, rShape, rnumber) == true){
					System.out.println("You have a Full House");
					score = 7;
				}
				//This if statement tells you that you have 5 of a suit 
				else if(isFlush(card, rShape, rnumber) == true){
					System.out.println("You have a Flush!");
					score = 6;
				}
				//This if statement tells you that you have 5 numbers in a row
				else if (isStraight(card, rShape, rnumber) == true) {
					System.out.println("You have a Straight!");
					score = 5;
				}
				//This if statement tells you that you have 3 of number
				else if (isTriple(card, rShape, rnumber) == true){
					System.out.println("You have a Triple!!");
					score = 4;
				}
				//This if statement tells you that you have two pairs
				else if(isTwoPair(card, rShape, rnumber) == true){
					System.out.println("You have Two Pairs");
					score = 3;
				}	
				//This if statement tells you that you have a pair
				else if (isDouble(card,  rShape,  rnumber) == true) {
					System.out.println("You have a Pair");
					score = 2;
				}
		
				int smallBlind = 2000;
				int bigBlind = smallBlind *2;
				System.out.println(randomChoice(card, smallBlind, bigBlind));
				
				int randomBetFold = 0;
				int randomBetFoldSwitch = 0;
				double potOfRound = 0;
			System.out.println("$ " + pot(total, randomBetFoldSwitch, bet, bets, randomBetFold, smallBlind, bigBlind, potOfRound) + " is in the pot");
			
				System.out.println(findWinner( score, score1, score2, score3, score4));
			}
			else if (playAgain == 2){
				System.out.println("Thank you for playing at Shady Sin's Casino. You left with $" + money + " in your pocket");
				break;
			}
		}while((money > 0));
	}
	//This method finds the winner and gives them the pot
	public static int findWinner(int score, int score1, int score2, int score3, int score4) {
		int counters = 0;
		if ((score > score1)&&(score > score2) &&(score > score3)&&(score > score4)&&(score > score5)){
			counters++;
			money = money + total;
			System.out.println("You win!! You have $" + money + " You won " + counters + " Times");
		}
		else if ((score1 > score)&&(score1 > score2) &&(score1 > score3)&&(score1 > score4)&&(score > score5)){
			counters++;
			money2 = money2 + total;
			System.out.println("John Doe wins !! He has $" + money2 + ". He won" + counters + " Time");
		}
		else if ((score2 > score)&&(score2 > score1) &&(score2 > score3)&&(score2 > score4)&&(score2 > score5)){
			counters++;
			money3 = money3 + total;
			System.out.println("Jane Do wins !! She has $" + money3 + ". She won" + counters + " Time");
		}
		else if ((score3 > score)&&(score3 > score1) &&(score3 > score2)&&(score3 > score4)&&(score3 > score5)){
			counters++;
			money4 = money4 + total;
			System.out.println("Bob Hope wins !! She has $" + money4 + ". He won" + counters + " Time");
		}
		else if ((score4 > score)&&(score4 > score1) &&(score4 > score2)&&(score4 > score3)&&(score4 > score5)){
			counters++;
			money5 = money5 + total;
			System.out.println("Al Pachino wins !! She has $" + money5 + ". He won" + counters + " Time");
		}
		else if ((score5 > score)&&(score5 > score1) &&(score5 > score2)&&(score5 > score4)&&(score5 > score4)){
			//Tells the user that Joesph deKeegan won
			counters++;
			money6 = money6 + total;
			System.out.println("Joesph deKeegan wins!! He has $" + money6 + ". He won " + counters + " time");
		}
		else {
			//This tells the computer to divide up the pot evenly if none are true 
			money = total /6;
			money2 = total /6;
			money3 = total /6;
			money4 = total /6;
			money5 = total /6;
			money6 = total /6;
			System.out.println("You win $" + (total/6) + ". Now you have $" + money);
			System.out.println("John Doe wins $" + (total/6) + ". Now he has $" + money2);
			System.out.println("Jane Do wins $" + (total/6) + ". Now she has $" + money3);
			System.out.println("Bob Dope wins $" + (total/6) + ". Now he has $" + money4);
			System.out.println("Al Pachino wins $" + (total/6) + ". Now you have $" + money5);
			System.out.println("Joesph deKeegan wins $" + (total/6) + ". Now you have $" + money6);
		}
		return money;
	}
	//This method gives the user a hand
	public static void deck(){
		System.out.println("");
		for (int i = 0; i < cardValue.length; i++){
			rShape[i] =(int) (Math.random()*14) + 2;
			rnumber[i] = (Math.random()*52);
			//For the Spades
			if ((rnumber[i] >= 0)&&(rnumber[i] <= 13)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Spades");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Spades");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Spades");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Spades");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Spades");
				}
			}
			//For the Diamonds
			else if ((rnumber[i] >= 14)&&(rnumber[i] <= 26)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i +". " + rShape[i] + " of Diamonds");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Diamonds");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Diamonds");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Diamonds");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Diamonds");
				}
			}
			//For the Clubs
			else if((rnumber[i] >= 27)&&(rnumber[i] <= 39)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Clubs");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Clubs");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Clubs");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Clubs");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Clubs");
				}
			}
			//This outputs the suit hearts
			else if((rnumber[i] >= 40) && (rnumber[i] <= 56)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Hearts");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Hearts");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Hearts");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Hearts");
				}
				else if (rShape[i] == 14){
					System.out.println( i + ". Ace of Hearts");
				}
			}
			else{
				System.out.println( i + ". 2 of hearts");
			}
		}
	}
	//This method outputs what the user wants to do, i.e, switch cards in hand 
	public static int switchOne(){
		System.out.println("");
		int betFoldSwitch = 0;
		for (int i = 0; i < 1; i++){
			rShape[i] =(int) (Math.random()*14) + 2;
			rnumber[i] = Math.rint(Math.random()*52);
			if ((rnumber[i] >= 0)&&(rnumber[i] <= 13)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Spades");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Spades");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Spades");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Spades");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Spades");
				}
			}
			else if ((rnumber[i] >= 14)&&(rnumber[i] <= 26)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i +". " + rShape[i] + " of Diamonds");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Diamonds");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Diamonds");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Diamonds");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Diamonds");
				}
			}
			else if((rnumber[i] >= 27)&&(rnumber[i] <= 39)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Clubs");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Clubs");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Clubs");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Clubs");
				}
				else if (rShape[i] == 14){
					System.out.println(i + ". Ace of Clubs");
				}
			}
			else if((rnumber[i] >= 40) && (rnumber[i] <= 56)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					System.out.println(i + ". " + rShape[i] + " of Hearts");
				}
				else if (rShape[i] == 11){
					System.out.println(i + ". Jack of Hearts");
				}
				else if (rShape[i] == 12){
					System.out.println(i + ". Queen of Hearts");
				}
				else if (rShape[i] == 13){
					System.out.println(i + ". King of Hearts");
				}
				else if (rShape[i] == 14){
					System.out.println( i + ". Ace of Hearts");
				}
			}
			else{
				System.out.println("2 of hearts");
			}
		}
		return betFoldSwitch;
	}
	//This method gets the users input
	public static void updateBalance(){
		System.out.println("Do you want to bet (1), switch your hand(2), or fold (3)?");
		int betFoldSwitch = input.nextInt();
		for (int i = 0; i < 1; i++){
			//This is if the player wants to bet if he/she likes the hand
			if (betFoldSwitch == 1){
				System.out.println("How much do you want to bet?");
				bet = input.nextInt();
				money = money - bet;
				System.out.println("You have $" + money + " left");
			}
			//This is if the players wants to switch a card in the hand
			else if (betFoldSwitch == 2){
				System.out.println("How many card(s) would you like to trade?");
				int switchCard = input.nextInt();
				int cardSwitch;
				
				if (switchCard >= 1){
					for (int e = switchCard; e < 5; e++){
						if (switchCard >= 1){
							System.out.println("Which card would like to switch?");
							cardSwitch = input.nextInt();
							cardSwitch = switchOne();
						}
					}
				}
				//This asks the player if they want to bet or fold after switching their hand
					System.out.println("Do you want to bet (1) or fold (2)?");
					reBet = input.nextInt();
					//This is if the player wants to bet
					if (reBet == 1){
						System.out.println("How much would you like to bet?");
						bets = input.nextInt();
						money = money - bets;
						System.out.println("You have $ " + money + " left");break;
					}
					//This is if the player wants to fold
					else if (reBet == 2){
						System.out.println("Playing it smart, I see you there");break;
					}break;
				}
			//This is if the player folds before he/she switches cards 
			else if (betFoldSwitch == 3){
				System.out.println("Playing it smart, I see you there.");break;
			}
			//This is if the player inserts an unusable number
			else{
				System.out.println("Thank you for playing at Shady Shin's Casino");break;
			}
		}
	}
	//This code is for the other 5 player
	public static void hiddenDeck(){
		String card = "";
		for (int i = 0; i < cardValue.length; i++){
			rShape[i] =(int)(Math.random()*14) + 2;
			rnumber[i] =(int) Math.rint(Math.random()*52);
			if ((rnumber[i] >= 0)&&(rnumber[i] <= 13)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = rShape[i] + " of Spades";
				}
				else if (rShape[i] == 11){
					card = "Jack of Spades";
				}
				else if (rShape[i] == 12){
					card = "Queen of Spades";
				}
				else if (rShape[i] == 13){
					card = "King of Spades";
				}
				else if (rShape[i] == 14){
					card = "Ace of Spades";
				}
			}
			else if ((rnumber[i] >= 14)&&(rnumber[i] <= 26)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = rShape[i] + " of Diamonds";
				}
				else if (rShape[i] == 11){
					card = "Jack of Diamonds";
				}
				else if (rShape[i] == 12){
					card = "Queen of Diamonds";
				}
				else if (rShape[i] == 13){
					card = "King of Diamonds";
				}
				else if (rShape[i] == 14){
					card = "Ace of Diamonds";
				}
			}
			else if((rnumber[i] >= 27)&&(rnumber[i] <= 39)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = rShape[i] + " of Clubs";
				}
				else if (rShape[i] == 11){
					card = "Jack of Clubs";
				}
				else if (rShape[i] == 12){
					card = "Queen of Clubs";
				}
				else if (rShape[i] == 13){
					card = "King of Clubs";
				}
				else if (rShape[i] == 14){
					card = "Ace of Clubs";
				}
			}
			else if((rnumber[i] >= 40) && (rnumber[i] <= 56)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = rShape[i] + " of Hearts";
				}
				else if (rShape[i] == 11){
					card = "Jack of Hearts";
				}
				else if (rShape[i] == 12){
					card = "Queen of Hearts";
				}
				else if (rShape[i] == 13){
					card = "King of Hearts";
				}
				else if (rShape[i] == 14){
					card = "Ace of Hearts";
				}
			}
		}
	}
	//This switches the card for the computer
	public static String switchTwo(String card){
		card = "";
		for (int i = 0; i < 1; i++){
			rShape[i] =(int) (Math.random()*14) + 2;
			rnumber[i] = Math.rint(Math.random()*52);
			if ((rnumber[i] >= 0)&&(rnumber[i] <= 13)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card =i + ". " + rShape[i] + " of Spades";
				}
				else if (rShape[i] == 11){
					card = i + ". Jack of Spades";
				}
				else if (rShape[i] == 12){
					card = i + ". Queen of Spades";
				}
				else if (rShape[i] == 13){
					card = i + ". King of Spades";
				}
				else if (rShape[i] == 14){
					card = i + ". Ace of Spades";
				}
			}
			else if ((rnumber[i] >= 14)&&(rnumber[i] <= 26)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = i +". " + rShape[i] + " of Diamonds";
				}
				else if (rShape[i] == 11){
					card = i + ". Jack of Diamonds";
				}
				else if (rShape[i] == 12){
					card = i + ". Queen of Diamonds";
				}
				else if (rShape[i] == 13){
					card = i + ". King of Diamonds";
				}
				else if (rShape[i] == 14){
					card = i + ". Ace of Diamonds";
				}
			}
			else if((rnumber[i] >= 27)&&(rnumber[i] <= 39)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = i + ". " + rShape[i] + " of Clubs";
				}
				else if (rShape[i] == 11){
					card = i + ". Jack of Clubs";
				}
				else if (rShape[i] == 12){
					card = i + ". Queen of Clubs";
				}
				else if (rShape[i] == 13){
					card = i + ". King of Clubs";
				}
				else if (rShape[i] == 14){
					card = i + ". Ace of Clubs";
				}
			}
			else if((rnumber[i] >= 40) && (rnumber[i] <= 56)){
				if ((rShape[i] <= 10) && (rShape[i] >= 2)){
					card = i + ". " + rShape[i] + " of Hearts";
				}
				else if (rShape[i] == 11){
					card = i + ". Jack of Hearts";
				}
				else if (rShape[i] == 12){
					card = i + ". Queen of Hearts";
				}
				else if (rShape[i] == 13){
					card = i + ". King of Hearts";
				}
				else if (rShape[i] == 14){
					card = i + ". Ace of Hearts";
				}
			}
		}
		return card;
	}
	//This creates the blinds for each person
	public static void blinds(){
		int smallBlind = 2000;
		int bigBlind = smallBlind * 2;
	}
	//This method is to create a randomly generated choice for each of the five players
	public static String randomChoice(String card, int smallBlind, int bigBlind){
		randomBet = (int) (Math.random()*money);
		//The counter determines how many computer players are betting
		int counter = 0;
		for (int i = 0; i < otherPlayers.length; i++){
			if (money > 0){
			randomBetFoldSwitch = (int) Math.rint(Math.random()*2);
				//This if statement bets
				if (randomBetFoldSwitch == 0){
					if (i == 0) {
						score1 = ((int) Math.random()*9) + 1;
						money2 = money2 -randomBet;
						counter++;
					}
					else if (i == 1) {
						score2 = ((int) Math.random()*9) + 1;
						money3 = money3 -randomBet;
						counter++;
					}
					else if (i == 2) {
						score3 = ((int) Math.random()*9) + 1;
						money4 = money4 -randomBet;
						counter++;
					}
					else if (i == 3) {
						score4 = ((int) Math.random()*9) + 1;
						money5 = money5 -randomBet;
						counter++;
					}
					else if (i == 4) {
						score5 = ((int) Math.random()*9) + 1;
						money6 = money6 -randomBet;
						counter++;
					}
					System.out.println("Mr(s). " + otherPlayers[i] + " bets $" + randomBet);
					System.out.println("Mr(s). " + otherPlayers[i] + " has $" + money + " left");
					counter++;
				}
				//This if statement switches cards in the computers hand 
				else if (randomBetFoldSwitch == 1){
					System.out.println("Mr(s). " + otherPlayers[i] + "  switches hands");
					switchTwo(card);
					int randomBetFold = (int) Math.rint(Math.random()*2);
					if (randomBetFold == 1){
						System.out.println("Mr(s). " + otherPlayers[i] + " bets $" + randomBet);
						if (i== 0){
							money2 = money2 -randomBet;
							System.out.println("Mr(s). " + otherPlayers[i] + " has $ " + money2 + " left");
							counter++;
						}
						else if (i == 1){
							money3 = money3 -randomBet;
							System.out.println("Mr(s). " + otherPlayers[i] + " has $ " + money3 + " left");
							counter++;
						}
						else if (i == 2){
							money4 = money4 -randomBet;
							System.out.println("Mr(s). " + otherPlayers[i] + " has $ " + money4 + " left");
							counter++;
						}
						else if (i == 3){
							money5 = money5 -randomBet;
							System.out.println("Mr(s). " + otherPlayers[i] + " has $ " + money5 + " left");
							counter++;
						}
						else if (i == 4){
							money6 = money6 -randomBet;
							System.out.println("Mr(s). " + otherPlayers[i] + " has $ " + money6 + " left");
							counter++;
						}
					}
					else if (randomBetFold == 2){
						System.out.println("Mr(s). " + otherPlayers[i] + " folds");
					}
					else{
						System.out.println("Mr(s). " + otherPlayers[i] + " folds");
					}
				}
				//This is statement f
				else if (randomBetFoldSwitch == 2){
					System.out.println("Mr(s). " + otherPlayers[i] + " folds");
				}
				System.out.println("");
			}
			else if (money < 0){
				System.out.println("Mr(s). " + otherPlayers[i] + " has run out of money");	
			}
		}
		total = (randomBet*counter) + bet;
		return card;
	}
	//This method gets the total bets 
	public static double pot(int total,int randomBetFoldSwitch, int bet, int bets, int randomBetFold, int smallBlind, int bigBlind, double potOfRound){
		System.out.println(bet);
		potOfRound = total + bets + bet + smallBlind + bigBlind;
		if ((randomBetFoldSwitch == 1) || (randomBetFold == 1)){
			System.out.println(potOfRound);
		}
		return potOfRound;
	}
	//This method gets the high single
	public static boolean highSingle(String card, int[] rShape, double[] rnumber) {
		benchmark = 2;
		for (int i = 0; i < rShape.length; i++) {
			if (rShape[i] > benchmark) {
				benchmark = rShape[i];
			}
		}
		return true;
	}
	//This method tells you that you have pair
	public static boolean isDouble(String card, int[] rShape, double[] rnumber){			
		int counter = 0;
		for (int i = 0; i < cardValue.length; i++){
			for (int j = i + 1; j < cardValue.length; j++){
				if (rShape[i] == rShape[j]) {
					counter = counter + 1;
					return true;
				}
			}
		}
		return false;
	}
	//This method tells you that you have three of a kind
	public static boolean isTriple(String card, int[] rShape, double[] rnumber){
		int counter = 0;
		for (int i = 0; i < cardValue.length; i++) {
			for ( int j = i + 1; j < cardValue.length; j++) {
				if (rShape[i] == rShape[j]) {
					counter = counter + 1;
				}
			}
			if ((counter == 2)) {
				return true;
			}
			counter = 0;
		}
		return false;
	}
	//This method tells you that you have two pairs
	public static boolean isTwoPair(String card, int[] rShape, double[] rnumber) {
		int counter = 0;
		int counter2 = 0;
		for (int i = 0; i <cardValue.length; i++){
			for (int j = i+1; j < cardValue.length; j++){
				if (rShape[i] == rShape[j]) {
					counter = counter + 1;
					counter2 = counter2 + 1; 
					break;
				}
			}
		}
		if ((counter == 2)&&(counter2 == 2)) {
			return true;
		}
		else { 
			return false;
		}
	}
	//This method tells you that you have a Straight ( 5 cards in a row)
	public static boolean isStraight(String card, int[] rShape, double[] rnumber){
		int i, j;
		int counter = 0;
		for (i = 0; i < 5; i++) {
			for (j = i ; j < 5; j++) {
				if (rShape[i] + 1 == rShape[j]) {
					counter = counter + 1;
				}
			}
		}
		if (counter == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	//This method tells you that you have a Flush ( 5 cards of the same suit)
	public static boolean isFlush(String card, int[] rShape, double[] rnumber){
		int counter = 0;
		boolean flag = true,flag2 = true, flag3 = true, flag4 = true;
		
		for (int i = 0; i < rnumber.length; i++){
			if (!(rnumber[i] <= 13)){
				flag = false;
			}
			if (!((rnumber[i] >= 14) && (rnumber[i] <= 26))){
				flag2 = false;
			}
			if (!((rnumber[i] >= 27) && (rnumber[i] <= 39))){
				flag3 = false;
			}
			if (!((rnumber[i] >= 40) && (rnumber[i] <= 52))){
				flag4 = false;
			}
		}
		return (flag||flag2||flag3||flag4);
	}
	//This method tell you that you have  a two card pair and a triple
	public static boolean isFullHouse(String card, int[] rShape, double[] rnumber){
		return (isFlush(card, rShape, rnumber) && isDouble(card, rShape, rnumber));
	}
	//This method tells you that you have four of the same number, but different suits
	public static boolean isFourOfAKind(String card, int[] rShape, double[] rnumber){
		int counter = 0;
		for (int i = 0; i < cardValue.length; i++) {
			for ( int j = i + 1; j < cardValue.length; j++) {
				if (rShape[i] == rShape[j]) {
					counter = counter + 1;
				}
			}
			if (counter == 3) {
				return true;
			}
			counter = 0;
		}
		return false;
	}
	//This method tells you that you have a straight and a flush
	public static boolean isStraightFlush(String card, int[] rShape, double[] rnumber){
		return (isFlush(card, rShape, rnumber) && (isStraight(card, rShape, rnumber)));
	}
	//This method tells you that you have a flush with 10 , Jack, Queen, King, and Ace
	public static boolean isRoyalFlush(String card, int[] rShape, double[] rnumber){
		boolean flag = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		for (int i = 0; i < 5; i++) {
			if (rShape[i] == 10) {
				flag = true;
			}
			else if (rShape[i] == 11) {
				flag2 = true;
			}
			else if (rShape[i] == 12) {
				flag3 = true;
			}
			else if (rShape[i] == 13) {
				flag4 = true;
			}
			else if (rShape[i] == 14) {
				flag5 = true;
			}
		}
		return (isFlush(card, rShape, rnumber) && flag && flag2 && flag3 && flag4 && flag5);
	}
}
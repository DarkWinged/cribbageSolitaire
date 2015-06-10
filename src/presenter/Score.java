package presenter;

import java.util.ArrayList;
import java.util.Stack;

import model.Card;

public class Score {
	
	public static int scoreCut(Card c1){

		int score = 0;
		
		System.out.println("\nCut: " + c1);
		
		score += knobsFor2(c1);

		System.out.println("Knobs: " + score);
		
		return score;
	}
	
	
	//Tests a hand and returns it's score.
	public static int scoreHand(Card c1, Card c2, Card c3, Card c4, Card c5){
		
		int score = 0;
		
		System.out.println("\nHand: " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", " + c5);
		
		score += pairs(c1,c2,c3,c4,c5);
		score += runs(c1,c2,c3,c4,c5);
		score += suit(c1,c2,c3,c4,c5);
		score += knobs(c1,c2,c3,c4,c5);
		score += fifteen(c1,c2,c3,c4,c5);
		
		System.out.println("Total: " + score);
		
		return score;
	}

	
	public static int scoreHand(Card c1, Card c2, Card c3, Card c4, Card c5, boolean crib){
		
		int score = 0;

		System.out.println("\nCrib: " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", " + c5);
		
		score += pairs(c1,c2,c3,c4,c5);
		score += runs(c1,c2,c3,c4,c5);
		
		if(crib)
			score += cribSuit(c1,c2,c3,c4,c5);
		else
			score += suit(c1,c2,c3,c4,c5);
		
		score += knobs(c1,c2,c3,c4,c5);
		score += fifteen(c1,c2,c3,c4,c5);

		System.out.println("Total: " + score);
		
		return score;
	}
	
	//Tests all possible pairs.
	
	//Method tests all possible pairs.
	private static int pairs(Card c1, Card c2, Card c3, Card c4, Card c5){
		
		int score = 0;
		
		score += scorePairs(c1,c2);
		score += scorePairs(c1,c3);
		score += scorePairs(c1,c4);
		score += scorePairs(c1,c5);
		score += scorePairs(c2,c3);
		score += scorePairs(c2,c4);
		score += scorePairs(c2,c5);
		score += scorePairs(c3,c4);
		score += scorePairs(c3,c5);
		score += scorePairs(c4,c5);
		
		System.out.println("Pairs: " + score);
		
		return score;
	}

	//Returns true if cards form a pair.

	//Method scores pairs.
	private static int scorePairs(Card c1, Card c2) {
		
		if(c1.getFace_value() == c2.getFace_value())
			return 2;
		else
			return 0;
	}
	
	//Methods test all possible runs.

	//Methods for possible runs.
	private static int runs(Card c1, Card c2, Card c3, Card c4, Card c5){
		
		ArrayList<Card[]> invalid = new ArrayList<Card[]>();
		
		int score = 0;
		
		if(sortRuns(c1,c2,c3,c4,c5)){
			score += 5;
			invalid.add(new Card[] {c1,c2,c3,c4,c5});
		}

		System.out.println("Five card run: " + score);
		
		score += runs4th(c1, c2, c3, c4, c5, invalid);
		
		return score;
	}


	private static int runs4th(Card c1, Card c2, Card c3, Card c4, Card c5,
			ArrayList<Card[]> invalid) {
		
		int score = 0;

		if(sortRuns(c1,c2,c3,c4) && invalidCards(c1,c2,c3,c4,invalid)){
			score += 4;
			invalid.add(new Card[] {c1,c2,c3,c4});
		}
		if(sortRuns(c1,c2,c3,c5) && invalidCards(c1,c2,c3,c5,invalid)){
			score += 4;
			invalid.add(new Card[] {c1,c2,c3,c5});
		}
		if(sortRuns(c1,c2,c4,c5) && invalidCards(c1,c2,c4,c5,invalid)){
			score += 4;
			invalid.add(new Card[] {c1,c2,c4,c5});
		}
		if(sortRuns(c1,c3,c4,c5) && invalidCards(c1,c3,c4,c5,invalid)){
			score += 4;
			invalid.add(new Card[] {c1,c3,c4,c5});
		}
		if(sortRuns(c2,c3,c4,c5) && invalidCards(c2,c3,c4,c5,invalid)){
			score += 4;
			invalid.add(new Card[] {c2,c3,c4,c5});
		}
		if(sortRuns(c3,c4,c5,c1) && invalidCards(c3,c4,c5,c1,invalid)){
			score += 4;
			invalid.add(new Card[] {c3,c4,c5,c1});
		}

		System.out.println("Four card run: " + score);
		
		score += runs3rd(c1, c2, c3, c4, c5, invalid);
		
		return score;
	}
	

	private static int runs3rd(Card c1, Card c2, Card c3, Card c4, Card c5,
			ArrayList<Card[]> invalid){
		
		int score = 0;
		
		if(sortRuns(c1,c2,c3) && invalidCards(c1,c2,c3,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c2,c3});
		}
		if(sortRuns(c1,c2,c4) &&  invalidCards(c1,c2,c4,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c2,c4});
		}
		if(sortRuns(c1,c2,c5) &&  invalidCards(c1,c2,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c2,c5});
		}
		if(sortRuns(c1,c3,c4) &&  invalidCards(c1,c3,c4,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c3,c4});
		}
		if(sortRuns(c1,c3,c5) &&  invalidCards(c1,c3,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c3,c5});
		}
		if(sortRuns(c1,c4,c5) &&  invalidCards(c1,c4,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c1,c4,c5});
		}
		if(sortRuns(c2,c3,c4) &&  invalidCards(c2,c3,c4,invalid)){
			score += 3;
			invalid.add(new Card[] {c2,c3,c4});
		}
		if(sortRuns(c2,c3,c5) &&  invalidCards(c2,c3,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c2,c3,c5});
		}
		if(sortRuns(c2,c4,c5) &&  invalidCards(c2,c4,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c2,c4,c5});
		}
		if(sortRuns(c3,c4,c5) &&  invalidCards(c3,c4,c5,invalid)){
			score += 3;
			invalid.add(new Card[] {c3,c4,c5});
		}
		
		System.out.println("Three card run: " + score);
		
		return score;
	}

	//Methods test for repeated runs.
	private static boolean invalidCards(Card c1, Card c2, Card c3, Card c4,
			ArrayList<Card[]> invalid) {
		
		Card[] test = {c1,c2,c3,c4};
		
		boolean result = true;
		
		for(int Iindex = 0, numInvalid = 0; Iindex < invalid.size(); Iindex++){
			for(int index = 0; index < test.length; index++){
				result = test[index].equals(invalid.get(Iindex)[index]);
				if(result == false)
					numInvalid++;
			}
			if(numInvalid == test.length){
				result = false;
				break;
			}
			else
				numInvalid = 0;
		}

		for(int Iindex = 1, numInvalid = 0; Iindex < invalid.size(); Iindex++){
			for(int index = 0; index < test.length; index++){
				result = test[index].equals(invalid.get(Iindex)[index]);
				if(result == false)
					numInvalid++;
			}
			if(numInvalid == test.length){
				result = false;
				break;
			}
			else
				numInvalid = 0;
		}
		
		return result;
	}

	private static boolean invalidCards(Card c1, Card c2, Card c3,
			ArrayList<Card[]> invalid) {
		
		Card[] test = {c1,c2,c3};
		
		boolean result = true;
		
		for(int Iindex = 0, numInvalid = 0; Iindex < invalid.size(); Iindex++){
			for(int index = 0; index < test.length; index++){
				if(test[index] == invalid.get(Iindex)[index])
					result = test[index].equals(invalid.get(Iindex)[index]);
					if(result == false)
						numInvalid++;
			}
			if(numInvalid == test.length){
				result = false;
				break;
			}
			else
				numInvalid = 0;
		}
		
		for(int Iindex = 1, numInvalid = 0; Iindex < invalid.size(); Iindex++){
			for(int index = 0; index < test.length; index++){
				if(test[index] == invalid.get(Iindex)[index])
					result = test[index].equals(invalid.get(Iindex)[index]);
					if(result == false)
						numInvalid++;
			}
			if(numInvalid == test.length){
				result = false;
				break;
			}
			else
				numInvalid = 0;
		}

		for(int Iindex = 2, numInvalid = 0; Iindex < invalid.size(); Iindex++){
			for(int index = 0; index < test.length; index++){
				if(test[index] == invalid.get(Iindex)[index])
					result = test[index].equals(invalid.get(Iindex)[index]);
					if(result == false)
						numInvalid++;
		}
		if(numInvalid == test.length){
			result = false;
			break;
		}
		else
			numInvalid = 0;
		}
		
		return result;
	}

	//Methods sort the cards from least to greatest.
	private static boolean sortRuns(Card c1, Card c2, Card c3, Card c4) {
		
		Stack<Integer> faceStack = new Stack<Integer>();
		
		faceStack.add(c1.getFace_value());
		faceStack.add(c2.getFace_value());
		faceStack.add(c3.getFace_value());
		faceStack.add(c4.getFace_value());
				
		for(int min = 0; min < 3; min++)
			for(int index = 3; index > min; index--){
				if(faceStack.get(min) > faceStack.get(index)){
					faceStack.push(faceStack.get(min));
					faceStack.remove(min);
				}
			}
			
		int cardFace1 = faceStack.get(0), cardFace2 = faceStack.get(1), cardFace3 = faceStack.get(2), cardFace4 = faceStack.get(3);
		
		return scoreRuns(cardFace1,cardFace2,cardFace3,cardFace4);
	}
	
	private static boolean sortRuns(Card c1, Card c2, Card c3, Card c4, Card c5) {
		
		Stack<Integer> faceStack = new Stack<Integer>();
		
		faceStack.add(c1.getFace_value());
		faceStack.add(c2.getFace_value());
		faceStack.add(c3.getFace_value());
		faceStack.add(c4.getFace_value());
		faceStack.add(c5.getFace_value());
				
		for(int min = 0; min < 4; min++)
			for(int index = 4; index > min; index--){
				if(faceStack.get(min) > faceStack.get(index)){
					faceStack.push(faceStack.get(min));
					faceStack.remove(min);
				}
			}
			
		int cardFace1 = faceStack.get(0), cardFace2 = faceStack.get(1), cardFace3 = faceStack.get(2),
			cardFace4 = faceStack.get(3), cardFace5 = faceStack.get(4);
				
		return scoreRuns(cardFace1, cardFace2, cardFace3, cardFace4, cardFace5);
	}

	private static boolean sortRuns(Card c1, Card c2, Card c3) {
		
		Stack<Integer> faceStack = new Stack<Integer>();
		
		faceStack.add(c1.getFace_value());
		faceStack.add(c2.getFace_value());
		faceStack.add(c3.getFace_value());
				
		for(int min = 0; min < 2; min++)
			for(int index = 2; index > min; index--){
				if(faceStack.get(min) > faceStack.get(index)){
					faceStack.push(faceStack.get(min));
					faceStack.remove(min);
				}
			}
			
		int cardFace1 = faceStack.get(0), cardFace2 = faceStack.get(1), cardFace3 = faceStack.get(2);
				
		return scoreRuns(cardFace1, cardFace2, cardFace3);
	}

	//Methods return true if the cards form a run.
	private static boolean scoreRuns(int c1, int c2, int c3, int c4, int c5) {
		
		if(c1 == c2 - 1 && c2 == c3 - 1 && c3 == c4 - 1 && c4 == c5 - 1){
			return true;
		}
		else
			return false;
	}
	
	private static boolean scoreRuns(int c1, int c2, int c3, int c4) {
		
		if(c1 == c2 - 1 && c2 == c3 - 1 && c3 == c4 - 1){
			return true;
		}
		else
			return false;
	}
	
	
	private static boolean scoreRuns(int c1, int c2, int c3) {
		
		if(c1 == c2 - 1 && c2 == c3 - 1){
			return true;
			}
		else
			return false;
	}
	

	//Methods test weather or not the cards are the same suit.
	private static int suit(Card c1, Card c2, Card c3, Card c4, Card c5) {
		
		int score = 0;
		boolean crib;
		
		if(scoreCribSuit(c1,c2,c3,c4,c5)){
			score += 5;
			crib = false;
		}
		else
			crib = true;
		
		while(crib){
			
			if(scoreSuit(c1,c2,c3,c4)){
			score += 4;
			break;
			}

			if(scoreSuit(c1,c2,c3,c5)){
			score += 4;
			break;
			}
			
			if(scoreSuit(c1,c2,c4,c5)){
			score += 4;
			break;
			}

			if(scoreSuit(c1,c3,c4,c5)){
			score += 4;
			break;
			}

			if(scoreSuit(c2,c3,c4,c5)){
			score += 4;
			break;
			}

			if(scoreSuit(c3,c4,c5,c1)){
			score += 4;
			break;
			}
			
			break;
		}

		System.out.println("Matching suit: " + score);
		
		return score;
	}

	private static int cribSuit(Card c1, Card c2, Card c3, Card c4, Card c5) {
		
		int score = 0;
		
		if(scoreCribSuit(c1,c2,c3,c4,c5)){
			score += 5;
		}

		System.out.println("Matching suit: " + score);
		
		return score;
	}
	

	//Methods return true if the cards are the same suit.
	private static boolean scoreSuit(Card c1, Card c2, Card c3, Card c4) {
		
		int suit = c1.getSuit();
		
		if(c1.getSuit() == suit && c2.getSuit() == suit && c3.getSuit() == suit &&
				c4.getSuit() == suit){
			return true;
		}
		else
			return false;
	}

	private static boolean scoreCribSuit(Card c1, Card c2, Card c3, Card c4, Card c5) {
		
		int suit = c1.getSuit();
		
		if(c1.getSuit() == suit && c2.getSuit() == suit && c3.getSuit() == suit &&
				c4.getSuit() == suit && c5.getSuit() == suit){
			return true;
		}
		else
			return false;
	}
	
	
	//Tests for knobs.
	private static int knobs(Card c1, Card c2, Card c3, Card c4, Card c5){

		int score = 0;

		score += knobsFor1(c1,c5);
		score += knobsFor1(c2,c5);
		score += knobsFor1(c3,c5);
		score += knobsFor1(c4,c5);
		
		System.out.println("Knobs: " + score);
		
		return score;
	}

	private static int knobsFor1(Card c1, Card c2) {
		
		if(c1.getFace_value() == 11 && c1.getSuit() == c2.getSuit()){
			return 1;
		}
		else
			return 0;
	}
	

	private static int knobsFor2(Card c1) {
		
		if(c1.getFace_value() == 11){
			return 2;
		}
		else
			return 0;
	}
	

	private static int fifteen(Card c1, Card c2, Card c3, Card c4, Card c5) {
		
		int score = 0;
		
		score += formatFifteen(c1,c2,c3,c4,c5);
		
		System.out.println("Fifteen with five cards :" + score);
		
		score += fifteen4th(c1, c2, c3, c4, c5);
		
		return score;
	}
	

	private static int fifteen4th(Card c1, Card c2, Card c3, Card c4, Card c5) {

		int score = 0;

		score += formatFifteen(c1,c2,c3,c4);
		score += formatFifteen(c1,c2,c3,c5);
		score += formatFifteen(c1,c2,c4,c5);
		score += formatFifteen(c1,c3,c4,c5);
		score += formatFifteen(c2,c3,c4,c5);
		score += formatFifteen(c3,c4,c5,c1);

		System.out.println("Fifteen with four cards :" + score);
		
		score += Fifteen3rd(c1, c2, c3, c4, c5);
		
		return score;
	}
	

	private static int Fifteen3rd(Card c1, Card c2, Card c3, Card c4, Card c5) {

		int score = 0;

		score += formatFifteen(c1,c2,c3);
		score += formatFifteen(c1,c2,c4);
		score += formatFifteen(c1,c2,c5);
		score += formatFifteen(c1,c3,c4);
		score += formatFifteen(c1,c3,c5);
		score += formatFifteen(c1,c4,c5);
		score += formatFifteen(c2,c3,c4);
		score += formatFifteen(c2,c3,c5);
		score += formatFifteen(c2,c4,c5);
		score += formatFifteen(c3,c4,c5);

		System.out.println("Fifteen with Three cards :" + score);
		
		score += Fifteen2nd(c1, c2, c3, c4, c5);
		
		return score;
	}
	

	private static int Fifteen2nd(Card c1, Card c2, Card c3, Card c4, Card c5) {

		int score = 0;
		
		score += formatFifteen(c1,c2);
		score += formatFifteen(c1,c3);
		score += formatFifteen(c1,c4);
		score += formatFifteen(c1,c5);
		score += formatFifteen(c2,c3);
		score += formatFifteen(c2,c4);
		score += formatFifteen(c2,c5);
		score += formatFifteen(c3,c4);
		score += formatFifteen(c3,c5);
		score += formatFifteen(c4,c5);

		System.out.println("Fifteen with two cards :" + score);
		
		return score;
	}
	
	//Methods format cards to be scored.

	private static int formatFifteen(Card c1, Card c2, Card c3, Card c4, Card c5) {
		int C1,C2,C3,C4,C5;
		
		if(c1.getFace_value() > 10)
			C1 = 10;
		else
			C1 = c1.getFace_value();

		if(c2.getFace_value() > 10)
			C2 = 10;
		else
			C2 = c2.getFace_value();

		if(c3.getFace_value() > 10)
			C3 = 10;
		else
			C3 = c3.getFace_value();

		if(c4.getFace_value() > 10)
			C4 = 10;
		else
			C4 = c4.getFace_value();

		if(c5.getFace_value() > 10)
			C5 = 10;
		else
			C5 = c5.getFace_value();
		
		return scoreFifteen(C1,C2,C3,C4,C5);
	}
	

	private static int formatFifteen(Card c1, Card c2, Card c3, Card c4) {
		int C1,C2,C3,C4;
		
		if(c1.getFace_value() > 10)
			C1 = 10;
		else
			C1 = c1.getFace_value();

		if(c2.getFace_value() > 10)
			C2 = 10;
		else
			C2 = c2.getFace_value();

		if(c3.getFace_value() > 10)
			C3 = 10;
		else
			C3 = c3.getFace_value();

		if(c4.getFace_value() > 10)
			C4 = 10;
		else
			C4 = c4.getFace_value();
		
		return scoreFifteen(C1,C2,C3,C4);
	}
	

	private static int formatFifteen(Card c1, Card c2, Card c3) {
		int C1,C2,C3;
		
		if(c1.getFace_value() > 10)
			C1 = 10;
		else
			C1 = c1.getFace_value();

		if(c2.getFace_value() > 10)
			C2 = 10;
		else
			C2 = c2.getFace_value();

		if(c3.getFace_value() > 10)
			C3 = 10;
		else
			C3 = c3.getFace_value();
		
		return scoreFifteen(C1,C2,C3);
	}
	

	private static int formatFifteen(Card c1, Card c2) {
		int C1,C2;
		
		if(c1.getFace_value() > 10)
			C1 = 10;
		else
			C1 = c1.getFace_value();

		if(c2.getFace_value() > 10)
			C2 = 10;
		else
			C2 = c2.getFace_value();
		
		return scoreFifteen(C1,C2);
	}
	

	private static int scoreFifteen(int c1, int c2, int c3, int c4,
			int c5) {
		
		if(c1 + c2 + c3 + c4 + c5 == 15){
			return 2;
		}
		else
			return 0;
	}
	

	private static int scoreFifteen(int c1, int c2, int c3, int c4) {

		if(c1 + c2 + c3 + c4 == 15){
			return 2;
		}
		else
			return 0;
	}
	

	private static int scoreFifteen(int c1, int c2, int c3) {

		if(c1 + c2 + c3 == 15){
			return 2;
		}
		else
			return 0;
	}

	
	private static int scoreFifteen(int c1, int c2) {
		
		if(c1 + c2 == 15){
			return 2;
		}
		else
			return 0;
	}

}

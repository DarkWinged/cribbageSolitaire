package model;


import java.util.Scanner;
import java.util.Stack;

public class Deck {
	protected int max_cards;
	protected Stack<Card> deck;
	
	//Constructors initialize the deck and set it's maximum number of cards.
	public Deck(){
		
		this.max_cards = 52;
		this.deck = new Stack<Card>();
		this.deck.ensureCapacity(max_cards);
	}
	
	public Deck(int max){
		
		this.max_cards = max;
		this.deck = new Stack<Card>();
		this.deck.ensureCapacity(max_cards);
	}
	
	public Deck(Deck newDeck){
		
		this.deck = newDeck.deck;
		this.max_cards = deck.capacity();
	}
	
	public Deck(Stack<Card> newDeck){
		
		this.deck = newDeck;
		this.max_cards = deck.capacity();
	}
	
	public void newDeck(){
		
		deck.clear();
		
		for(int suit = 1; suit <= 4; suit++)
			for(int face = 1; face <= 13; face++){
				addCard(new PlayingCard(face,suit));
				}
	}

	public void newDeck(boolean flipped){
		
		deck.clear();
		
		for(int suit = 1; suit <= 4; suit++)
			for(int face = 1; face <= 13; face++){
				addCard(new PlayingCard(face,suit,flipped));
				}
	}
	
	public boolean addCard(Card card){
		
		if(deck.size() < max_cards)
			return deck.add(card);
		else
			return false;
	}
	
	//Removes the card from the deck and passes it.
	public Card drawCard(){
		
		Card card;
		
		if(!empty()){
			card = deck.lastElement();
			deck.remove(deck.lastElement());
			}
		else
			card = null;
		
		return card;
	}
	
	//Passes the top card without removing it from the deck.
	public Card viewNext(){
		
		Card card;
		
		if(!empty())
			card = deck.lastElement();
		else
			card = null;
		
		return card;
	}
	
	//Shuffles the cards in the deck.
	public void shuffle(){
		
		for(int loops = 0; loops <= deck.size(); loops ++){
			
			Card pushCard = deck.get((int) (Math.random()*deck.size()));
			deck.push(pushCard);
			deck.remove(pushCard);
		}
	}

	//Shuffles the cards multiple times.
	public void shuffle(int shuffles){
		
		while(shuffles > 0){
			for(int loops = 0; loops <= deck.size(); loops ++){
				
				Card pushCard = deck.get((int) (Math.random()*deck.size()));
				deck.push(pushCard);
				deck.remove(pushCard);
		}
		shuffles --;
		}
	}
	
	public boolean empty(){
		
		return deck.empty();
	}
	
	public String save(){

		String result = "";
		
		result += "[Deck]";
		result += "," + max_cards;
		for(int index = 0; index < deck.size(); index++){
			result += "," + deck.elementAt(index).save();
			}
		
		result += ",[/Deck]";
		
		return result;
	}
	
	public void load(String save){
		Scanner scan = new Scanner(save);
		scan.useDelimiter(",");
		
		deck.clear();
		
		String next;
				
		if(scan.next().equals("[Deck]")){
			
			this.max_cards = scan.nextInt();
			this.deck.ensureCapacity(max_cards);
			
			next = scan.next();
			
			do{
				
				PlayingCard card = new PlayingCard();
				
				card.load(next);
				
				addCard(card);
				
				next = scan.next();
				}
			while(scan.hasNext());
			}
		
		scan.close();
	}
	
	public String toString(){
		
		String result = "";
		
		result += deck.size() + "/" + max_cards;
		
		//result += "\n" + deck;
		
		return result;
	}
}

import model.Deck;
import model.PlayingCard;


public class Test {

	
	public static void main(String[] args) {
		
		PlayingCard card = new PlayingCard(13,4,true), card2 = new PlayingCard(5,1,true);
		Deck deck = new Deck(), deck2 = new Deck(5);
		
		deck.newDeck(true);
		deck.shuffle(5);
		
		String save = card.save(); 
		
		System.out.println(save);
		
		System.out.println("\n" + card2);
		
		card2.load(save);
		
		System.out.println("\n" + card2);

		save = deck.save(); 
		
		System.out.println("\n" + save);

		deck2.load(save);
		
		System.out.println("\n" + deck2);
	}
}
package presenter;

import javax.swing.ImageIcon;

import model.Card;
import model.Deck;

public class Card_Presenter {
	
	private java.net.URL imgURL;
	private ImageIcon card_back = new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_CardBack.png")));
	//private ImageIcon card_back_hover = new ImageIcon(imgURL = getClass().getResource("/imageData/SccA_CardBack_Hover.png"));
	private ImageIcon card_slot = new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_CardSlot.png")));
	private ImageIcon card_slot_hover = new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_CardSlot_Hover.png")));

	private ImageIcon[][] list = {{new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Ace_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_2_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_3_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_4_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_5_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_6_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_7_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_8_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_9_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_10_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Jack_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Queen_of_Hearts.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_King_of_Hearts.png"))),},
										{new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Ace_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_2_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_3_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_4_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_5_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_6_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_7_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_8_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_9_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_10_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Jack_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Queen_of_Spades.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_King_of_Spades.png"))),},
										{new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Ace_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_2_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_3_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_4_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_5_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_6_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_7_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_8_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_9_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_10_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Jack_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Queen_of_Diamonds.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_King_of_Diamonds.png"))),},
										{new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Ace_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_2_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_3_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_4_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_5_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_6_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_7_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_8_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_9_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_10_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Jack_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_Queen_of_Clubs.png"))),
										new ImageIcon(setImgURL(getClass().getResource("/imageData/SccA_King_of_Clubs.png"))),}};

	public ImageIcon getIcon(boolean slot, boolean mouse){
		
		if(slot)
			if(mouse)
				return card_slot_hover;
			else
				return card_slot;
		else
			if(mouse)
				return card_back;//card_back_hover;
			else
				return card_back;
	}
	
	public ImageIcon getIcon(Card card){
		
		if(card == null)
			return card_slot;
		else{
			if(card.getFaceUp()){
				return list[card.getSuit()-1][card.getFace_value()-1];
			}
			else{
				return card_back;
			}
		}
	}
	
	public ImageIcon getIcon(Deck deck){
		
		Card card = deck.viewNext();
		
		if(card == null)
			return card_slot;
		else{
			if(card.getFaceUp()){
				return list[card.getSuit()-1][card.getFace_value()-1];
			}
			else{
				return card_back;
			}
		}
	}

	public ImageIcon getIcon(Grid grid){
		
		Card card = grid.getCard();
		
		if(card == null)
			return card_slot;
		else{
			if(card.getFaceUp()){
				return list[card.getSuit()-1][card.getFace_value()-1];
			}
			else{
				return card_back;
			}
		}
	}

	public java.net.URL getImgURL() {
		return imgURL;
	}

	public java.net.URL setImgURL(java.net.URL imgURL) {
		this.imgURL = imgURL;
		return imgURL;
	}

}
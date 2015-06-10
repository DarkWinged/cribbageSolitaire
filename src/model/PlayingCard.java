package model;

/**@author DarkWingedDaemon*/
public class PlayingCard extends Card {

	/**Constructs a default card  object.*/
	public PlayingCard(){
		super();
	}
	
	/**Constructs a card object with the specified <strong>face_value</strong> value.
	 * @param newFace sets the initial value of <strong>face_value</strong>.*/
	public PlayingCard(int newFace){
		super(newFace);
	}

	/**Constructs a card object with the specified <strong>face_value</strong>, and <strong>suit</strong> values.
	 * @param newFace sets the initial value of the field <strong>face_value</strong>.
	 * @param newSuit sets the initial value of the field <strong>suit</strong>.*/
	public PlayingCard(int newFace, int newSuit){
		super(newFace, newSuit);
	}

	/**Constructs a card object with the specified <strong>face_value</strong>, <strong>suit</strong>, and <strong>faceUp</strong> values.
	 * @param newFace sets the initial value of the field <strong>face_value</strong>.
	 * @param newSuit sets the initial value of the field <strong>suit</strong>.
	 * @param newUp sets the initial value of the field <strong>faceUp</strong>.*/
	public PlayingCard(int newFace, int newSuit, boolean newUp){
		super(newFace, newSuit, newUp);
	}

	/**@inheritDoc*/
	public void play() {}

	/**@inheritDoc*/
	public void discard() {}

	/**@inheritDoc*/
	public void exile() {}
	
	/**@inheritDoc*/
	public String toString(){
		
		String result = "";
		
		if(faceUp)
			result += faceToString() + " of " + suitToString();
		else
			result += "Card is face down";
		
		return result;
	}
	
	private String faceToString(){
		
		switch(face_value){
			case 1:
				return "Ace";
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
		}
		
		return Integer.toString(face_value);
	}
	
	private String suitToString(){
		
		switch(suit){
			case 1:
				return "Hearts";
			case 2:
				return "Spades";
			case 3:
				return "Dimonds";
			case 4:
				return "Clubs";
		}
		
		return Integer.toString(suit);
	}

}

package model;

import java.util.Scanner;

/**@author DarkWingedDaemon*/
public abstract class Card {
	
	/**The value used to represent this Card's face.*/
	protected int face_value;
	/**The value used to represent this Card's suit.*/
	protected int suit;
	/**The value used to represent whether or not this Card is face up.*/
	protected boolean faceUp;
	
	/**Constructs a default card  object.*/
	public Card(){
		
		this.face_value = 0;
		this.suit = 0;
		this.faceUp = false;
	}
	
	/**Constructs a Card object with the specified <strong>face_value</strong> value.
	 * @param newFace sets the initial value of <strong>face_value</strong>.*/
	public Card(int newFace){
		
		this.face_value = newFace;
		this.suit = 0;
		this.faceUp = false;
	}
	
	/**Constructs a Card object with the specified <strong>face_value</strong>, and <strong>suit</strong> values.
	 * @param newFace sets the initial value of the field <strong>face_value</strong>.
	 * @param newSuit sets the initial value of the field <strong>suit</strong>.*/
	public Card(int newFace, int newSuit){
		
		this.face_value = newFace;
		this.suit = newSuit;
		this.faceUp = false;
	}

	/**Constructs a Card object with the specified <strong>face_value</strong>, <strong>suit</strong>, and <strong>faceUp</strong> values.
	 * @param newFace sets the initial value of the field <strong>face_value</strong>.
	 * @param newSuit sets the initial value of the field <strong>suit</strong>.
	 * @param newUp sets the initial value of the field <strong>faceUp</strong>.*/
	public Card(int newFace, int newSuit, boolean newUp){
		
		this.face_value = newFace;
		this.suit = newSuit;
		this.faceUp = newUp;
	}
	
	/**Possibly generate an event when the card object is played.*/
	public abstract void play();

	/**Possibly generate an event when the card object is discarded.*/
	public abstract void discard();

	/**Possibly generate an event when the card object is exiled.*/
	public abstract void exile();

	/**Alternates the boolean field faceUp and returns this.
	 * @return this card.*/
	public Card flip(){
		
		if(faceUp)
			faceUp = false;
		else
			faceUp = true;
		
		return this;
	}
	
	/**Returns the value stored in the field <strong>face_value</strong>.*/
	public int getFace_value(){
		
		return face_value;
	}
	
	/**Returns the value stored in the field <strong>suit</strong>.*/
	public int getSuit(){
		
		return suit;
	}

	/**Returns the value stored in the field <strong>faceUp</strong>.*/
	public boolean getFaceUp(){
		
		return faceUp;
	}

	/**Compares the specified object with this Card for equality. Returns true if both <strong>face_value</strong>, and <strong>suit</strong> values are the same on both objects.
	 * @param c The object to be compared for equality with this Card.
	 * @return True if the specified object is equal to this card.*/
	public boolean equals(Card c){
		
		if(c.getFace_value() == face_value && c.getSuit() == suit)
			return true;
		else
			return false;
	}
	

	/**Saves card object as a string.*/
	public String save(){
		
		String result = "";
		
		result += "[Card] " + face_value + " " + suit + " " + faceUp + " [/Card]";
		
		return result;
	}
	

	/**Loads a card object from a string.
	 * @param save The string to be processed into a Card object.*/
	public void load(String save){
		Scanner scan = new Scanner(save);
		
		if(scan.next().equals("[Card]"))
			load(scan.nextInt(), scan.nextInt(), scan.nextBoolean());
		
		scan.close();
	}

	/**Reconstructs this Card with data extracted by the previous load method. 
	 * @param newFace The <strong>face_value</strong> extracted from a string.
	 * @param newSuit The <strong>suit</strong> extracted from a string.
	 * @param newUp The <strong>faceUp</strong> extracted from a string.*/
	protected void load(int newFace, int newSuit, boolean newUp){

		this.face_value = newFace;
		this.suit = newSuit;
		this.faceUp = newUp;
	}

	/**Formats this Card into a string. If the field <strong>faceUp</strong> is true the formatted string is returned, otherwise a default string is returned.
	 * @return A string representation of this Card.*/
	public String toString(){
		
		String result = "";
		
		if(faceUp)
			result += "Card: " + face_value + " of " + suit;
		else
			result += "Card is face down";
		
		return result;
	}
	
}

package presenter;

import java.util.Scanner;

import javax.swing.Icon;

import launcher.Launcher;
import model.Card;


public class Grid {

	private int x,y;
	private Card card = null;
	
	public Grid(int X, int Y, Card newCard){
		x = X;
		y = Y;
		card = newCard;
	}
	
	public Grid(int X, int Y){
		setX(X);
		setY(Y);
		card = null;
	}

	public int getX() {
		return x;
	}

	public void setX(int X) {
		x = X;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card Card) {
		card = Card;
	}

	public int getY() {
		return y;
	}

	public void setY(int Y) {
		y = Y;
	}
	
	public Icon getIcon(){
		return Launcher.P.getIcon(card);
	}

	public String save(){

		String result = "";
		
		result += "[Grid]";
		result += "," + x + "," + y;
		result += "," + card.save();
		
		result += ",[/Grid]";
		
		return result;
	}

	public void load(String save){

		Scanner scan = new Scanner(save);
		scan.useDelimiter(",");
		
		if(scan.next().equals("[Grid]")){
			x = scan.nextInt();
			y = scan.nextInt();
			card.load(scan.next());
		}
		
		scan.close();
	}
	
	public String toString(){
		
		String result = "";
		
		if(getCard() == null)
			result += "N/A";
		else
			result += getCard().toString();
		
		return result;
	}
}

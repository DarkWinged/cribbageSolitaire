package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;

import launcher.Launcher;
import presenter.Grid;
import presenter.Score;



public class Main_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4987952545960223692L;
	private Grid_Panel play, crib_1, crib_2;
	private Deck_Panel deck_panel;
	private Hand_Panel hand_panel;
	private Score_Panel score;
	private Grid inPlay = new Grid(0,0);
	private int draws = 0;
	private int cribs = 0;
	private boolean gameOver;

	public Main_Panel() {
		
		setBackground(new Color(0,12,12));
		
		
		add(score = new Score_Panel());
		score.add(crib_1 = new Grid_Panel(1,4));
		score.add(deck_panel = new Deck_Panel());
		score.add(Box.createRigidArea(new Dimension(5,5)));
		score.add(hand_panel = new Hand_Panel());
		score.add(Box.createRigidArea(new Dimension(5,5)));
		score.add(crib_2 = new Grid_Panel(1,4));
		add(play = new Grid_Panel(4,4,true));
	}

	public void drawCard() {
		
		inPlay.setCard(null);
		
		draws++;
		while(draws <= 4){
			play.getGrid()[draws-1][draws-1].setCard(deck_panel.getDeck().drawCard().flip());
			draws++;
		}
		
		if(draws == 8 || draws == 13 || draws == 18 || draws == 23){
			crib_1.getGrid()[0][cribs].setCard(deck_panel.getDeck().drawCard());
			draws++;
		}

		if(draws == 9 || draws == 14 || draws == 19 || draws == 24){
			crib_2.getGrid()[0][cribs].setCard(deck_panel.getDeck().drawCard());
			draws++;
			cribs++;
		}
		
		if(draws < 25){
			getHand_panel().getHand().setCard(deck_panel.getDeck().drawCard().flip());
			getHand_panel().update();
		}
		
		inPlay.setCard(Launcher.getMain_Panel().getHand_panel().getHand().getCard());
		
		if(draws == 25){
			deck_panel.getDeck().shuffle(5);
			getHand_panel().getHand().setCard(deck_panel.getDeck().drawCard().flip());
			getHand_panel().update();
			endGame();
			gameOver = true;
		}
		
		play.update();
		crib_1.update();
		crib_2.update();
		deck_panel.update();
		hand_panel.update();
		
		if(gameOver){
			hand_panel.gameOver(scoreGame());
		}
	}

	private void endGame() {
		
		for(int X = 0; X < crib_1.getGrid().length; X++)
			for(int Y = 0; Y < crib_1.getGrid()[0].length; Y++){
				crib_1.getGrid()[X][Y].getCard().flip();
			}

		for(int X = 0; X < crib_1.getGrid().length; X++)
			for(int Y = 0; Y < crib_2.getGrid()[0].length; Y++){
				crib_2.getGrid()[X][Y].getCard().flip();
			}	
	}

	private int scoreGame() {
		
		int score = 0;
		
		score += Score.scoreCut(hand_panel.getHand().getCard());
		
		score += Score.scoreHand(crib_1.getGrid()[0][0].getCard(),
								crib_1.getGrid()[0][1].getCard(),
								crib_1.getGrid()[0][2].getCard(),
								crib_1.getGrid()[0][3].getCard(),
								hand_panel.getHand().getCard(), true);

		score += Score.scoreHand(crib_2.getGrid()[0][0].getCard(),
								crib_2.getGrid()[0][1].getCard(),
								crib_2.getGrid()[0][2].getCard(),
								crib_2.getGrid()[0][3].getCard(),
								hand_panel.getHand().getCard(), true);

		for(int column = 0; column < 4; column++){
			score += Score.scoreHand(play.getGrid()[column][0].getCard(),
								play.getGrid()[column][1].getCard(),
								play.getGrid()[column][2].getCard(),
								play.getGrid()[column][3].getCard(),
								hand_panel.getHand().getCard());
		}

		for(int row = 0; row < 4; row++){
			score += Score.scoreHand(play.getGrid()[0][row].getCard(),
								play.getGrid()[1][row].getCard(),
								play.getGrid()[2][row].getCard(),
								play.getGrid()[3][row].getCard(),
								hand_panel.getHand().getCard());
		}

		Launcher.newGame(score);
		
		return score;
	}

	public void playCard(int X, int Y) {
		
		getHand_panel().getHand().setCard(null);
		
		for(int xX = 0; xX < play.getGrid().length; xX++)
			for(int yY = 0; yY < play.getGrid()[0].length; yY++){
				if(play.getGrid()[xX][yY].getCard() != null);
					if(play.getGrid()[xX][yY].getCard() == inPlay.getCard())
						play.getGrid()[xX][yY].setCard(null);
			}
		
		play.getGrid()[X][Y].setCard(inPlay.getCard());
		
		play.update();
		crib_1.update();
		crib_2.update();
		deck_panel.update();
		hand_panel.update();
	}

	public Hand_Panel getHand_panel() {
		return hand_panel;
	}

	public Grid getInPlay() {
		return inPlay;
	}

}

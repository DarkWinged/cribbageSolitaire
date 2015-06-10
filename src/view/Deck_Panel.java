package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Deck;

public class Deck_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3600404306691873639L;
	private Deck deck;
	private DLabel deck_label_1;
	private JLabel deck_label_2;
	private JPanel panel_1;
	
	public Deck_Panel(){
		
		deck = new Deck();
		
		deck.newDeck();

		deck.shuffle(5);
		
		add(panel_1 = new JPanel());
		panel_1.add(Box.createRigidArea(new Dimension(86,86)));
		panel_1.add(deck_label_1 = new DLabel(getDeck(),this));
		panel_1.add(Box.createRigidArea(new Dimension(5,5)));
		panel_1.add(deck_label_2 = new JLabel(getDeck().toString()));
		panel_1.add(Box.createRigidArea(new Dimension(135,135)));
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		panel_1.setBackground(new Color(0,15,15));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		setBackground(new Color(0,15,15));
		setPreferredSize(new Dimension(300,130));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void update() {
		panel_1.revalidate();
		deck_label_1.revalidate();
		deck_label_2.setText(deck.toString());
		revalidate();
	}
	
}

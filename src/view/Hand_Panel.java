package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presenter.Grid;

public class Hand_Panel  extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3645913620139053796L;
	private Grid hand;
	private JLabel hand_label_1, hand_label_2;
	private JPanel panel_1;
	
	public Hand_Panel(){
		
		setHand(new Grid(0,0));
		add(panel_1 = new JPanel());
		panel_1.add(Box.createRigidArea(new Dimension(95,25)));
		panel_1.add(hand_label_1 = new JLabel(getHand().getIcon()));
		panel_1.add(Box.createRigidArea(new Dimension(15,15)));
		panel_1.add(hand_label_2 = new JLabel(getHand().toString()));
		panel_1.add(Box.createHorizontalGlue());
		
		
		panel_1.setBackground(new Color(0,15,15));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		setBackground(new Color(0,15,15));
		setPreferredSize(new Dimension(300,120));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public Grid getHand() {
		return hand;
	}

	public void setHand(Grid hand) {
		this.hand = hand;
	}

	public void update() {
		panel_1.revalidate();
		hand_label_1.setIcon(getHand().getIcon());
		hand_label_2.setText(getHand().toString());
		revalidate();
	}

	public void gameOver(int scoreGame) {
		hand_label_2.setText("Score: " + Integer.toString(scoreGame));
		revalidate();
		
	}
}

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import launcher.Launcher;
import model.Deck;

public class DLabel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7437764111304957754L;
	private Deck_Panel parent;
	private JLabel label;
	
	public DLabel(Deck deck, Deck_Panel deck_Panel) {
		
		parent = deck_Panel;
		
		setPreferredSize(new Dimension(80,120));
		setBackground(new Color(0,15,15));
		add(label = new JLabel(Launcher.P.getIcon(deck.viewNext())));
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		if(Launcher.getMain_Panel().getHand_panel().getHand().getCard() == null)
			Launcher.getMain_Panel().drawCard();
	}

	public void mouseEntered(MouseEvent arg0) {
		removeAll();
		label = new JLabel(Launcher.P.getIcon(false,true));
		add(label);
		revalidate();
	}

	public void mouseExited(MouseEvent arg0) {
		removeAll();
		label = new JLabel(Launcher.P.getIcon(parent.getDeck().viewNext()));
		add(label);
		revalidate();
	}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

}

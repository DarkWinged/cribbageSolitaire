package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import launcher.Launcher;

public class CLabel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1389190153907576032L;
	private int X, Y;
	private JLabel label;
	private Grid_Panel parent;

	public CLabel(Icon image, int xX, int yY, Grid_Panel grid_Panel, boolean enabeled) {
		parent = grid_Panel;
		label = new JLabel(image);
		X = xX;
		Y = yY;
		
		setPreferredSize(new Dimension(80,120));
		setBackground(new Color(0,15,15));
		add(new JLabel(image));
		
		if(enabeled)
			addMouseListener(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		if(Launcher.getMain_Panel().getInPlay().getCard() != null && parent.getGrid()[X][Y].getCard() == null)
			Launcher.getMain_Panel().playCard(X,Y);
		}

	public void mouseEntered(MouseEvent arg0) {
		if(parent.getGrid()[X][Y].getCard() == null){
			removeAll();
			label = new JLabel(Launcher.P.getIcon(true,true));
			add(label);
			revalidate();
		}
	}

	public void mouseExited(MouseEvent arg0) {
		removeAll();
		label = new JLabel(parent.getGrid()[X][Y].getIcon());
		add(label);
		revalidate();
	}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

}

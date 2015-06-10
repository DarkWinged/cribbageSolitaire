package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Score_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2259366208031923100L;

	public Score_Panel(){

		setBackground(new Color(0,15,15));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}

package launcher;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presenter.Card_Presenter;
import view.Main_Panel;


public class Launcher {
	
	private static JPanel panel1 = new JPanel();
	private static Main_Panel panel2;
	public static Card_Presenter P = new Card_Presenter();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cribbage Solitare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1.setBackground(new Color(0,15,15));
		panel1.setLayout(new BorderLayout());
		panel1.add(panel2 =new Main_Panel());
		
		frame.getContentPane().add(panel1);
		frame.pack();
		frame.setVisible(true);
	}

	public static void newGame(int score) {
		if(JOptionPane.showConfirmDialog(panel1, "Score: " + score + "\nPlay Again?") == 0){
			panel1.removeAll();
			panel1.add(panel2  = new Main_Panel());
			panel1.revalidate();
		}
	}

	public static Main_Panel getMain_Panel() {
		return panel2;
	}
}

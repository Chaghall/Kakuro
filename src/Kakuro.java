import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Kakuro {
	private JFrame frame;
	private GrilleCible grilleCible = new GrilleCible();
	public Case[][] grille = new Case[Utilitaires.x][Utilitaires.y];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kakuro window = new Kakuro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Kakuro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel ZoneJeu = new JPanel();
		ZoneJeu.setBounds(0, 0, 287, 262);
		frame.getContentPane().add(ZoneJeu);
		ZoneJeu.setLayout(new GridLayout(0, Utilitaires.y, 0, 0));

		for(int i = 0; i < grilleCible.grille.length; i++)
			for(int j = 0; j < grilleCible.grille[i].length; j++){

				if (grilleCible.grille[i][j].n != 0 ) {
					this.grille[i][j] = new Case(ZoneJeu);
				}
				else
				{
					this.grille[i][j] = new Case(ZoneJeu, grilleCible.grille[i][j].sX, grilleCible.grille[i][j].sY);
				}



				JButton btnNewButton = new JButton("New button");
				btnNewButton.setBounds(297, 11, 127, 41);
				frame.getContentPane().add(btnNewButton);
			}
	}
}

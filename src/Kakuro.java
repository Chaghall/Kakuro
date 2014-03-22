import javax.swing.*;
import java.awt.*;


public class Kakuro {
	JFrame frame;
	GrilleCible grilleCible = new GrilleCible();
	public Case[][] grille = new Case[Utilitaires.x][Utilitaires.y];
	static JButton Bouton1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

				if (grilleCible.grille[i][j].n != 0 )
					this.grille[i][j] = new Case(ZoneJeu, grilleCible.grille[i][j].n);
				else
					this.grille[i][j] = new Case(ZoneJeu, grilleCible.grille[i][j].sX, grilleCible.grille[i][j].sY);

			}
		
		Bouton1 = new JButton("Un bouton");
		Bouton1.setBounds(297, 11, 127, 41);
		frame.getContentPane().add(Bouton1);
	}
}

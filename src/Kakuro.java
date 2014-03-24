import javax.swing.*;
import java.awt.*;


public class Kakuro extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JFrame Kakuro, Menu;
	private JPanel contentPane;
	
	private Grille grll = new Grille();
	static JButton Bouton1;

	/**
	 * Create the application.
	 */
	public Kakuro(JFrame frame) {
		
		Menu = frame;
		Kakuro = this;
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel ZoneJeu = new JPanel();
		ZoneJeu.setBounds(0, 0, 287, 262);
		getContentPane().add(ZoneJeu);
		ZoneJeu.setLayout(new GridLayout(0, Utilitaires.y, 0, 0));

		for(int i = 0; i < grll.grille.length; i++)
			for(int j = 0; j < grll.grille[i].length; j++){
					grll.grille[i][j].affichCase(ZoneJeu);
			}
		
		Bouton1 = new JButton("Un bouton");
		Bouton1.setBounds(297, 11, 127, 41);
		getContentPane().add(Bouton1);
	}
}

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Kakuro extends JFrame{
	/**
	 * 
	 */
	private JFrame Kakuro, Menu, Result;
	private JPanel contentPane;
	private JInternalFrame result;

	private Grille grll = new Grille();
	static JButton Bouton1;

	/**
	 * Create the application.
	 */
	public Kakuro(JFrame frame) {
		
		//Menu = frame;
		//Kakuro = this;

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel ZoneJeu = new JPanel();
		ZoneJeu.setBounds(0, 0, 287, 262);
		getContentPane().add(ZoneJeu);
		ZoneJeu.setLayout(new GridLayout(0, Utilitaires.y, 0, 0));

		for(int i = 0; i < grll.grille.length; i++)
			for(int j = 0; j < grll.grille[i].length; j++)
				grll.grille[i][j].affichCase(ZoneJeu);

		Bouton1 = new JButton("Un bouton");
		Bouton1.setBounds(297, 11, 127, 41);
		getContentPane().add(Bouton1);

		JButton btnSol = new JButton("Solution");
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finJeu();
			}
		});
		btnSol.setBounds(297, 63, 127, 41);
		getContentPane().add(btnSol);
		
		JButton btnVerif = new JButton("V\u00E9rification");
		btnVerif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utilitaires.score < Utilitaires.victoire)
				{
					Result = new Result(Kakuro, false);
					Result.setVisible(true);
				}
				else
				{
					finJeu();
					Result = new Result(Kakuro, true);
					Result.setVisible(true);
				}
					
			}
		});
		btnVerif.setBounds(297, 115, 127, 41);
		getContentPane().add(btnVerif);

	}
	
	public void finJeu()
	{
		for(int i = 0; i < grll.grille.length; i++)
			for(int j = 0; j < grll.grille[i].length; j++){
				//grll.grille[i][j].disable();
				grll.grille[i][j].solution();
			}
	}
}

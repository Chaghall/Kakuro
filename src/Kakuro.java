import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Kakuro extends JFrame{
	/**
	 * 
	 */
	private JFrame Kakuro, Menu, Result;
	private JPanel contentPane;
	private JInternalFrame result;


	private Grille grll = new Grille();
	static JButton Bouton1;

//	FileDialog openDialog = new FileDialog(this, "Open File", FileDialog.LOAD);
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

		JButton btnSauvegarder = new JButton("Sauvegarder");
		final FileDialog openDialog = new FileDialog(this, "Open File", FileDialog.SAVE);
		btnSauvegarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				openDialog.setVisible(true);
				String dir = openDialog.getDirectory();
				Utilitaires save = new Utilitaires();
				save.EcrireSave(x, y, seed, grll, List);
				
			}
		});
		btnSauvegarder.setBounds(307, 167, 106, 23);
		getContentPane().add(btnSauvegarder);

		JButton btnCharger = new JButton("Charger");
		final FileDialog openDialog2 = new FileDialog(this, "Open File", FileDialog.LOAD);
				 
		btnCharger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				


				openDialog2.setVisible(true);
				String dir = openDialog2.getDirectory();
				
				

			}
		});
		btnCharger.setBounds(317, 208, 89, 23);
		getContentPane().add(btnCharger);

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

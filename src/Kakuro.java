import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


public class Kakuro extends JFrame{
	/**
	 * 
	 */
	private JFrame Kakuro, Menu, Result;

	private Grille grll ;
	static JButton Bouton1;

	//	FileDialog openDialog = new FileDialog(this, "Open File", FileDialog.LOAD);
	/**
	 * Create the application.
	 */
	public Kakuro(JFrame frame, Utilitaire utilMenu) {
		setTitle("Kakuro - Jeu");

		Menu = frame;
		Kakuro = this;
		grll = new Grille();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("right:default"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		JPanel ZoneJeu = new JPanel();
		getContentPane().add(ZoneJeu, "2, 2, fill, fill");
		ZoneJeu.setLayout(new GridLayout(Utilitaire.x, Utilitaire.y, 0, 0));

		for(int i = 0; i < grll.grille.length; i++)
			for(int j = 0; j < grll.grille[i].length; j++)
				grll.grille[i][j].affichCase(ZoneJeu);
		final FileDialog openDialog = new FileDialog(this, "Open File", FileDialog.SAVE);

		JPanel Boutons = new JPanel();
		getContentPane().add(Boutons, "3, 2, center, top");
		Boutons.setLayout(new GridLayout(0, 1, 5, 20));

		JButton btnSauvegarder = new JButton("Sauvegarder");
		Boutons.add(btnSauvegarder);
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				try{
					String dir = openDialog.getDirectory()+openDialog.getFile();
					Utilitaire.EcrireSave(dir);
				}
				catch(NullPointerException point)
				{

				}
			}
		});

		JButton btnVerif = new JButton("V\u00E9rification");
		Boutons.add(btnVerif);
		btnVerif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utilitaire.score < Utilitaire.victoire)
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
		
				JButton btnSol = new JButton("Solution");
				Boutons.add(btnSol);
				btnSol.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finJeu();
					}
				});

		JButton btnRetourAuMenu = new JButton("Retour au Menu");
		Boutons.add(btnRetourAuMenu);
		btnRetourAuMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.setVisible(true);
				Kakuro.setVisible(false);
			}
		});

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

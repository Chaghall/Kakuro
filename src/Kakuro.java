import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


public class Kakuro extends JFrame{
	/**
	 * 
	 */
	private JFrame Kakuro, Menu, Result;

	static JButton Bouton1;
	private JPanel ZoneJeu;

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Kakuro(JFrame frame) {
		Menu = frame;
		Kakuro = this;
		initialize();
		new Grille();
		affichGrille(Utilitaire.grille);
	}
	
	
	public Kakuro (JFrame frame, String dir){
		Menu = frame;
		Kakuro = this;
		initialize();
		Utilitaire.charge(dir);
		new Grille();
		affichGrille(Utilitaire.grille);
		Utilitaire.repriseCharge(dir);
	}
	
	/**
	 * Affichage de l'IHM
	 */
	private void initialize() {
		setTitle("Kakuro - Jeu");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		ZoneJeu = new JPanel();
		getContentPane().add(ZoneJeu, "2, 2, fill, fill");
		ZoneJeu.setLayout(new GridLayout(Utilitaire.x, Utilitaire.y, 1, 1));

		final FileDialog openDialog = new FileDialog(this, "Open File", FileDialog.SAVE);

		JPanel Boutons = new JPanel();
		getContentPane().add(Boutons, "4, 2, center, top");
		Boutons.setLayout(new GridLayout(0, 1, 5, 20));

		JButton btnSauvegarder = new JButton("Sauvegarder");
		Boutons.add(btnSauvegarder);
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				try{
					String dir = openDialog.getDirectory()+openDialog.getFile();
					Utilitaire.sauvegarde(dir);
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
		for(int i = 0; i < Utilitaire.grille.length; i++)
			for(int j = 0; j < Utilitaire.grille[i].length; j++){
				//grll.grille[i][j].disable();
				Utilitaire.grille[i][j].solution();
			}
	}
	/**
	 * Affiche grille dans le label ZoneJeu
	 * @param grille
	 */
	public void affichGrille(Case[][] grille)
	{
		for(int i = 0; i < grille.length; i++)
			for(int j = 0; j < grille[i].length; j++)
				grille[i][j].affichCase(ZoneJeu);
	}
}

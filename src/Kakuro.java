import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


public class Kakuro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame Kakuro, Menu, Result;
	private JPanel ZoneJeu;
	private JButton btnSauvegarder;
	private JButton btnVerif;
	private JButton btnSol;

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

		JPanel panBouton = new JPanel();
		getContentPane().add(panBouton, "4, 2, center, center");
		panBouton.setLayout(new GridLayout(0, 1, 5, 20));

		btnVerif = new JButton("V\u00E9rification");
		panBouton.add(btnVerif);
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

		btnSol = new JButton("Solution");
		panBouton.add(btnSol);
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finJeu();
				btnSauvegarder.setEnabled(false);
				btnVerif.setEnabled(false);
				btnSol.setEnabled(false);
			}
		});

		btnSauvegarder = new JButton("Sauvegarder");
		panBouton.add(btnSauvegarder);
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				try{
					String dir = openDialog.getDirectory()+openDialog.getFile();
					Utilitaire.sauvegarde(dir);
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
				}
			}
		});

		JButton btnRetourAuMenu = new JButton("Retour au Menu");
		panBouton.add(btnRetourAuMenu);
		btnRetourAuMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.setVisible(true);
				Kakuro.setVisible(false);
			}
		});

		JButton btnAide = new JButton("Aide");
		panBouton.add(btnAide);
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aide help = new Aide	();
				help.setVisible(true);
			}
		});

	}

	/**
	 * Fonction de fin de partie
	 * Donne la bonne valeur à toute les cases et verrouille la grille
	 */
	public void finJeu()
	{
		for(int i = 0; i < Utilitaire.grille.length; i++)
			for(int j = 0; j < Utilitaire.grille[i].length; j++){
				Utilitaire.grille[i][j].disable();
				Utilitaire.grille[i][j].solution();
			}
	}
	
	/**
	 * Affiche grille dans le label ZoneJeu
	 * @param grille
	 */
	private void affichGrille(Case[][] grille)
	{
		for(int i = 0; i < grille.length; i++)
			for(int j = 0; j < grille[i].length; j++)
				grille[i][j].affichCase(ZoneJeu);
	}
}

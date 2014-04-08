package testUnitaire;
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
	private JPanel ZoneJeu;
	private FileDialog openDialog;


	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Kakuro(JFrame frame) {
		initialize();
		new Grille();
		affichGrille(Utilitaire.grille);
	}


	public Kakuro (JFrame frame, String dir){
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

		openDialog = new FileDialog(this, "Open File", FileDialog.SAVE);
		
		setTitle("Kakuro - Jeu");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JPanel panBouton = new JPanel();
		getContentPane().add(panBouton, "4, 2, center, center");
		panBouton.setLayout(new GridLayout(0, 1, 5, 20));

		JButton btnVerif = new JButton("V\u00E9rification");
		btnVerif.setEnabled(false);
		panBouton.add(btnVerif);
		btnVerif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});

		JButton btnSol = new JButton("Solution");
		panBouton.add(btnSol);
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finJeu();
			}
		});

		JButton btnSauvegarder = new JButton("Sauvegarder");
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

		
		JButton btnCharger = new JButton("Charger une partie");
		btnCharger.setEnabled(false);
		panBouton.add(btnCharger);
		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnAide = new JButton("Aide");
		btnAide.setEnabled(false);
		panBouton.add(btnAide);
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

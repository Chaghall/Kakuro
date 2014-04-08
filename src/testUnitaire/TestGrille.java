package testUnitaire;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class TestGrille {

	private JFrame frame;
	private JTextArea mainPane;
	private JTextField largField;
	private JTextField longField;
	private JTextField seedField;
	private int x, y,seed ;
	private JPanel panParam;
	private JScrollPane panConsole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGrille window = new TestGrille();
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
	public TestGrille() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.LINE_GAP_ROWSPEC,}));
		
		panParam = new JPanel();
		frame.getContentPane().add(panParam, "2, 2, fill, fill");
		panParam.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.LINE_GAP_ROWSPEC,}));
		
		JPanel panText = new JPanel();
		panParam.add(panText, "2, 2, center, center");
		panText.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblLargeur = new JLabel("Largeur");
		panText.add(lblLargeur);
		
		JLabel lblLongueur = new JLabel("Longueur");
		panText.add(lblLongueur);
		
		JLabel lblSeed = new JLabel("Seed");
		panText.add(lblSeed);
		
		JPanel panField = new JPanel();
		panParam.add(panField, "4, 2, center, center");
		panField.setLayout(new GridLayout(3, 1, 5, 5));
		
		largField = new JTextField();
		panField.add(largField);
		largField.setColumns(10);
		
		longField = new JTextField();
		panField.add(longField);
		longField.setColumns(10);
		
		seedField = new JTextField();
		panField.add(seedField);
		seedField.setColumns(10);
		
		JPanel panBtn = new JPanel();
		panParam.add(panBtn, "2, 4, 3, 1, center, center");
		
		JButton btnValid = new JButton("Valider");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x = Integer.valueOf(largField.getText());
				y = Integer.valueOf(longField.getText());
				seed = Integer.valueOf(seedField.getText());
				panParam.setEnabled(false);
				panParam.setVisible(false);
				panConsole.setEnabled(true);
				panConsole.setVisible(true);
				Grille grilleTest = new Grille(x, y , seed);
				affichTab(grilleTest.forme);
				affichTab(grilleTest.valeur);
				affichTab(grilleTest.grille);
			}
		});
		panBtn.add(btnValid);

		
		mainPane = new JTextArea();
		mainPane.setEditable(false);
		
		panConsole = new JScrollPane(mainPane);
		panConsole.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(panConsole, "2, 2, fill, fill");
		panConsole.setVisible(false);
	}


	private void affichTab(int tab[][])
	{
		System.out.println("Tableau de valeurs cibles");
		System.out.println();
		mainPane.append("Tableau de valeurs cibles\r\n\r\n");
		
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++){
				System.out.printf("|%5s", tab[i][j]);
				mainPane.append(String.format("|%5s", tab[i][j]));
			}
			System.out.println("|");
			mainPane.append("|\r\n");
			
		}
	}


	private void affichTab(boolean tab[][])
	{
		System.out.println("Tableau de forme");
		System.out.println();
		mainPane.append("Tableau de forme\r\n\r\n");
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++) {
				System.out.printf("|%5s", tab[i][j]);
				mainPane.append(String.format("|%5s", tab[i][j]));
			}
			System.out.println("|");
			mainPane.append("|\r\n");
		}
	}

	
	private void affichTab(Case tab[][])
	{
		System.out.println("Grille finale");
		System.out.println();
		mainPane.append("Grille finale\r\n\r\n");
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++) {
				System.out.printf("|%6s", tab[i][j]);
				mainPane.append(String.format("|%5s", tab[i][j]));
			}
			System.out.println("|");
			mainPane.append("|\r\n");
		}
	}

}

package testUnitaire;

import java.awt.*;

import javax.swing.*;

import com.jgoodies.forms.layout.*;
import com.jgoodies.forms.factories.*;

import java.awt.event.*;
import java.util.*;

public class TestSauvegardeChargement extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public static JTextArea textArea;
	private Kakuro jeu;
	private FileDialog openDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSauvegardeChargement window = new TestSauvegardeChargement();
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
	public TestSauvegardeChargement() {
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
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.LINE_GAP_ROWSPEC,}));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "2, 2, fill, fill");
		
		openDialog = new FileDialog(this, "Open File", FileDialog.LOAD);

		JButton btnCharger = new JButton("Charger une partie");
		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openDialog.setVisible(true);
				try	{
					String dir = openDialog.getDirectory()+openDialog.getFile();
					Utilitaire.writeln(dir,textArea);
					jeu = new Kakuro(frame,dir);
					jeu.setVisible(true);
				}
				catch(NullPointerException point)
				{

				}
			}
		});
		panel.add(btnCharger);
		
		JButton btnNvlPartie = new JButton("Nouvelle Partie");
		panel.add(btnNvlPartie);
		btnNvlPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random list = new Random();
				int seed = list.nextInt();
				new Utilitaire(Utilitaire.x, Utilitaire.y, seed);
				jeu = new Kakuro(frame);
				jeu.setVisible(true);
			}
		});

		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane, "2, 4, fill, fill");
	}

}

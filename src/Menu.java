import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.util.Random;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Menu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmKakuroMenu;
	private Kakuro Jeu;
	private Param config;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmKakuroMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		config = new Param();

		frmKakuroMenu = new JFrame();
		frmKakuroMenu.setTitle("Kakuro - Menu");
		frmKakuroMenu.setBounds(100, 100, 600, 300);
		frmKakuroMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKakuroMenu.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("10px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		JPanel panHeader = new JPanel();
		frmKakuroMenu.getContentPane().add(panHeader, "2, 2, fill, center");

		JLabel lblNewLabel = new JLabel(new ImageIcon(Menu.class.getResource("/img/KakuroHeadertrans.png")));
		panHeader.add(lblNewLabel);

		final FileDialog openDialog2 = new FileDialog(this, "Open File", FileDialog.LOAD);

		JPanel panBouton = new JPanel();
		frmKakuroMenu.getContentPane().add(panBouton, "4, 2, fill, top");
		panBouton.setLayout(new GridLayout(0, 1, 0, 20));

		JButton btnNewGame = new JButton("Nouvelle Partie");
		panBouton.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random list = new Random();
				int seed = list.nextInt();
				new Utilitaire(Utilitaire.x, Utilitaire.y, seed);
				Jeu = new Kakuro(frmKakuroMenu);
				Jeu.setVisible(true);
				frmKakuroMenu.setVisible(false);
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

		JButton btnCharger = new JButton("Charger");
		panBouton.add(btnCharger);
		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDialog2.setVisible(true);
				try	{
					String dir = openDialog2.getDirectory()+openDialog2.getFile();
					System.out.println(dir);
					Jeu = new Kakuro(frmKakuroMenu,dir);
					Jeu.setVisible(true);
					frmKakuroMenu.setVisible(false);
				}
				catch(NullPointerException point)
				{

				}
			}
		});

		JButton btnParam = new JButton("Param\u00E8tres");
		panBouton.add(btnParam);
		btnParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setVisible(true);
			}
		});
	}
}

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame{
	
	
	private JFrame frmKakuroMenu;
	private Kakuro Jeu;
	private Aide help;
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
		frmKakuroMenu.setBounds(100, 100, 450, 300);
		frmKakuroMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKakuroMenu.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("Nouvelle Partie");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jeu = new Kakuro(frmKakuroMenu);
				Jeu.setVisible(true);
				frmKakuroMenu.setVisible(false);
			}
		});
		btnNewGame.setBounds(297, 19, 127, 41);
		frmKakuroMenu.getContentPane().add(btnNewGame);
		
		JButton btnAide = new JButton("Aide");
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help = new Aide	(frmKakuroMenu);
				help.setVisible(true);
			}
		});
		btnAide.setBounds(297, 199, 127, 41);
		frmKakuroMenu.getContentPane().add(btnAide);
		JButton btnCharger = new JButton("Charger");
		final FileDialog openDialog2 = new FileDialog(this, "Open File", FileDialog.LOAD);

		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				openDialog2.setVisible(true);
				try
				{
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
		btnCharger.setBounds(297, 79, 127, 41);
		frmKakuroMenu.getContentPane().add(btnCharger);
		
		JButton btnParam = new JButton("Param\u00E8tres");
		btnParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setVisible(true);
			}
		});
		btnParam.setBounds(297, 139, 127, 41);
		frmKakuroMenu.getContentPane().add(btnParam);

	}
}

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/KakuroHeadertrans.png")));
		panHeader.add(lblNewLabel);
		final FileDialog openDialog2 = new FileDialog(this, "Open File", FileDialog.LOAD);
		
		JPanel panBouton = new JPanel();
		frmKakuroMenu.getContentPane().add(panBouton, "4, 2, fill, top");
		panBouton.setLayout(new GridLayout(0, 1, 0, 20));
		
		JButton btnNewGame = new JButton("Nouvelle Partie");
		panBouton.add(btnNewGame);
		
		JButton btnAide = new JButton("Aide");
		panBouton.add(btnAide);
		JButton btnCharger = new JButton("Charger");
		panBouton.add(btnCharger);
		
		JButton btnParam = new JButton("Param\u00E8tres");
		panBouton.add(btnParam);
		btnParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setVisible(true);
			}
		});
		
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
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help = new Aide	(frmKakuroMenu);
				help.setVisible(true);
			}
		});
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jeu = new Kakuro(frmKakuroMenu);
				Jeu.setVisible(true);
				frmKakuroMenu.setVisible(false);
			}
		});

	}
}

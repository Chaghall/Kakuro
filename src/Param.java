import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;


public class Param extends JFrame {

	private JPanel contentPane;

	private JFormattedTextField jftfLargeur;
	private JFormattedTextField jftfLongueur = new JFormattedTextField();

	public Utilitaire util = new Utilitaire(6, 6 , 42);

	private NumberFormat largeurFormat;
	private NumberFormat longueurFormat;


	public Param() {

		paramFormat();

		setTitle("Param\u00E8tres");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 170, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jftfLargeur = new JFormattedTextField(
				new DefaultFormatterFactory(
						new NumberFormatter(largeurFormat),
						new NumberFormatter(largeurFormat),
						new NumberFormatter(largeurFormat)));
		jftfLongueur = new JFormattedTextField(
				new DefaultFormatterFactory(
						new NumberFormatter(largeurFormat),
						new NumberFormatter(largeurFormat),
						new NumberFormatter(largeurFormat)));

		JLabel lblTaille = new JLabel("Taille de la grille");
		lblTaille.setBounds(10, 11, 75, 14);
		contentPane.add(lblTaille);

		JLabel lblLargeur = new JLabel("Largeur :");
		lblLargeur.setBounds(20, 36, 65, 14);
		contentPane.add(lblLargeur);

		JLabel lblLongueur = new JLabel("Longueur :");
		lblLongueur.setBounds(20, 56, 65, 14);
		contentPane.add(lblLongueur);

		jftfLargeur.setText(String.valueOf(util.x));
		jftfLargeur.setBounds(95, 33, 49, 20);
		contentPane.add(jftfLargeur);

		jftfLongueur.setText(String.valueOf(util.y));
		jftfLongueur.setBounds(95, 53, 49, 20);
		contentPane.add(jftfLongueur);

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.x = Integer.valueOf(jftfLargeur.getText());
				util.y = Integer.valueOf(jftfLongueur.getText());
			}
		});
		btnValider.setBounds(30, 81, 89, 23);
		contentPane.add(btnValider);
	}
	
	// D�clare les formats des champs de taille de la grille
	private void paramFormat() {
		longueurFormat = NumberFormat.getNumberInstance();
		longueurFormat.setMaximumIntegerDigits(2);
		longueurFormat.setParseIntegerOnly(true);

		largeurFormat = NumberFormat.getNumberInstance();
		largeurFormat.setMaximumIntegerDigits(2);
		largeurFormat.setParseIntegerOnly(true);
	}

}
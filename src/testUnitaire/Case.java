package testUnitaire;
import java.awt.Color;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


public class Case{

	public int n, sX, sY, juste;
	private JFormattedTextField bloc = new JFormattedTextField();
	private	JLabel block = new JLabel();

	/*
	public Case(Utilitaire util1){
		utilGeneral = util1;
	}
	 */


	/**
	 * 
	 * @param n valeur d'une case
	 */
	public Case(int n)
	{
		this.n = n;
	}

	/**
	 * 
	 * @param S indice de Somme
	 * @param or orientation de l'indice de Somme, s'il est vrai, c'est un indice en ligne, sinon, c'est un indice de colonne
	 */
	public Case(int S, boolean or)
	{
		if(or)
			this.sX = S;
		else
			this.sY = S;
	}

	/**
	 * 
	 * @param sX indice de Somme horizontal
	 * @param sY indice de Somme vertical
	 */
	public Case(int sX, int sY)
	{
		this.sX = sX;
		this.sY = sY;
	}


	/**
	 * Affiche les cases de la grille grâce à des JTextField pour les cases à remplir et des JLabel pour les indices de somme dans le JPanel pan
	 * @param pan
	 * @throws NumberFormatException
	 */
	public void affichCase(JPanel pan) throws NumberFormatException{
		if(this.n != 0)
		{
			bloc.setValue(null);
			try{
				MaskFormatter format = new MaskFormatter("#");
				bloc = new JFormattedTextField(format);
			}
			catch(ParseException e2){

			}
			pan.add(bloc);
			bloc.setHorizontalAlignment(SwingConstants.CENTER);
			bloc.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					try{
						if (Integer.valueOf(bloc.getText()) == n){
							Utilitaire.score -= juste;
							juste = 1;
							Utilitaire.score += juste;
						}

						else
						{
							Utilitaire.score -= juste;
							juste = 0;
							Utilitaire.score += juste;
						}
					}
					catch(NumberFormatException e1)
					{

					}
				}
			});
		}
		else
		{
			Utilitaire.score -= juste;
			juste = 1;
			Utilitaire.score += juste;
			if (sX != 0)
				if (sY != 0)
					block.setText(String.format("%2d\\%2d", sX, sY));
				else
					block.setText(String.format("%2d\\  ", sX));
			else
				if (sY != 0)
					block.setText(String.format("  \\%2d", sY));

			block.setHorizontalAlignment(SwingConstants.CENTER);
			block.setBorder(null);
			block.setOpaque(true);
			block.setBackground(Color.BLACK);
			block.setForeground(Color.WHITE);
			pan.add(block);
		}

	}

	public void solution(){
		bloc.setText(String.valueOf(n));
		Utilitaire.score -= juste;
		juste = 1;
		Utilitaire.score += juste;
	}

	/**
	 * Indique si la case est à remplir par l'utilisateur ou non.
	 * @return true si la case est à remplir par l'utilisateur.
	 */
	public boolean aRemplir()
	{
		if (n != 0)
			return true;
		else
			return false;
	}

	/**
	 * Retourne la valeur d'une case
	 * @return Renvoie la valeur d'une case à remplir par l'utilisateur. Si celle-ci est vide, la valeur renvoyée est 0.
	 */
	public String getText()
	{
		if (n != 0)
			if (bloc.getText() != null)
				return bloc.getText();
			else
				return "0";
		else
			return null;
	}

	/**
	 * Donne le texte à la case
	 * @return
	 */
	public void setText(String s)
	{
		if (n != 0)
			bloc.setText(s);
	}


	public String toString()
	{
		if (n != 0)
			return String.format("  %-3d", n);
		else
			if (sX != 0)
				if (sY != 0)
					return String.format("%2d\\%2d", sX, sY);
				else
					return String.format("%2d\\  ", sX);
			else
				if (sY != 0)
					return String.format("  \\%2d", sY);
				else
					return String.format("  \\  ");
	}


	public void disable() {
		bloc.setEditable(false);
	}

}

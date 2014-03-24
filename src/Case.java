import java.awt.event.*;

import javax.swing.*;


public class Case{

	public int n, sX, sY, juste;
	private JTextField bloc = new JTextField();
	private	JLabel block = new JLabel();
	public Case(){

	}


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
			pan.add(bloc);
			bloc.setHorizontalAlignment(SwingConstants.CENTER);
			bloc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (Integer.parseInt(bloc.getText()) == n){
						Utilitaires.score -= juste;
						juste = 1;
						Utilitaires.score += juste;
					}

					else
					{
						Utilitaires.score -= juste;
						juste = 0;
						Utilitaires.score += juste;
					}
					Kakuro.Bouton1.setText(String.valueOf(Utilitaires.score));
				}
			});
		}
		else
		{
			Utilitaires.score -= juste;
			juste = 1;
			Utilitaires.score += juste;
			if (sX != 0)
				if (sY != 0)
					block.setText(String.format("%2d\\%2d", sY, sX));
				else
					block.setText(String.format("%2d\\  ", sX));
			else
				if (sY != 0)
					block.setText(String.format("  \\%2d", sY));

			block.setHorizontalAlignment(SwingConstants.CENTER);
			pan.add(block);
		}

	}

	public void solution(){
		bloc.setText(String.valueOf(n));
		Utilitaires.score -= juste;
		juste = 1;
		Utilitaires.score += juste;
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
	 * @return
	 */
	public String getText()
	{
		if (n != 0)
			return bloc.getText();
		else
			return null;
	}

	/**
	 * Donne le texte à la case
	 * @return
	 */
	public void setText(String s)
	{
		bloc.setText(s);
	}


	public String toString()
	{
		if (n != 0)
			return String.format("  %-3d", n);
		else
			if (sX != 0)
				if (sY != 0)
					return String.format("%2d\\%2d", sY, sX);
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

import java.awt.event.*;

import javax.swing.*;


public class Case{

	public int n;
	public int sX;
	public int sY;
	private JTextField bloc = new JTextField();
	private	JLabel block = new JLabel();
	private int ValeurCible;
	private boolean juste;

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


	public Case(JPanel pan, int n) throws NumberFormatException{
		this.ValeurCible = n;
		this.juste = false;
		pan.add(bloc);
		bloc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Integer.parseInt(bloc.getText()) == ValeurCible)
					juste = true;
				else
					juste = false;
				Kakuro.Bouton1.setText(String.valueOf(juste));
			}
		});

	}

	public Case( JPanel pan, int sX, int sY) {
		this.juste = true;
		if (sX != 0)
			if (sY != 0)
				block.setText(String.format("%2d\\%2d", sY, sX));
			else
				block.setText(String.format("%2d\\  ", sX));
		else
			if (sY != 0)
				block.setText(String.format("  \\%2d", sY));


		pan.add(block);
	}


	public String getText() {
		return bloc.getText();
	}

	public void addKeyListener(Object object) {
		bloc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
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

}

import java.awt.event.*;

import javax.swing.*;


public class Case{

	private JTextField bloc = new JTextField();
	private	JLabel block = new JLabel();
	private int ValeurCible;
	private boolean juste;

	public Case(){

	}

	public Case(JPanel pan, int n){
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
}

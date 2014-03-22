import javax.swing.*;


public class Case {

	public Case(){

	}

	public Case(JPanel pan){
		JTextField bloc = new JTextField();

		pan.add(bloc);
	}

	public Case( JPanel pan, int sX, int sY) {
		JLabel block = new JLabel();

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
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Result extends JFrame {

	private JPanel contentPane;

	public Result(JFrame frame, boolean victoire) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResult, BorderLayout.CENTER);
		
		int reste = Utilitaire.victoire - Utilitaire.score;
		if (victoire)
			lblResult.setText("Bravo, vous avez réussi !");
		else
		{
			lblResult.setText("Hmm, il y a "+reste+" valeurs correctes manquantes");
		}
	}

}

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;


public class Aide extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Aide(JFrame frame) {
		setTitle("Aide");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextPane txtpnHelp = new JTextPane();
		txtpnHelp.setEditable(false);

		java.net.URL helpURL = Aide.class.getResource(
				"/html/Regles.html");
		if (helpURL != null) {
			try {
				txtpnHelp.setPage(helpURL);
			} catch (IOException e) {
				System.err.println("Attempted to read a bad URL: " + helpURL);
			}
		} else {
			System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
		}

		JScrollPane scrollPane = new JScrollPane(txtpnHelp);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}

}

import java.awt.*;

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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnHelp = new JTextPane();
		txtpnHelp.setEditable(false);
		txtpnHelp.setText("Le Kakuro :\r\n\tLe Kakuro est un jeu qui vient du Japon. Ce jeu de logique est souvent d\u00E9fini comme le \"Sudoku pour ceux qui peuvent compter\". Appel\u00E9 \u00E9galement Kakro ou Cross-sum en anglais, c'est un croisement entre le Sudoku et les mots-crois\u00E9s.\r\n\r\nBut et r\u00E8gle du jeu :\r\n\tChaque grille de Kakuro se compose d'un nombre variable de cases \"d'indices\" et de cases \"blocs\". Les cases d'indices sont divis\u00E9s en deux afin de contenir un ou deux indices, lesquels sont situ\u00E9s en face d'un ensemble de blocs.\r\n\tLe but du jeu est de compl\u00E9ter la grille en respectant ces trois r\u00E8gles :\r\n\t\t- Le total des cases de chaque bloc doit \u00EAtre \u00E9gal \u00E0 l'indice situ\u00E9 en face.\r\n\t\t- Vous ne pouvez utiliser que les chiffres de 1 \u00E0 9.\r\n\t\t- Un m\u00EAme chiffre ne peut appara\u00EEtre plus d'une fois sur une m\u00EAme colonne ou un sur une m\u00EAme ligne.\r\n\tMalgr\u00E9 les apparences, le Kakuro ne demande aucune connaissance en math\u00E9matiques, si ce n'est que de savoir additionner deux nombres.\r\n\tComme avec le Sudoku, c'est \u00E0 votre logique et \u00E0 votre concentration qu'il faudra avant tout faire appel. Voyons cela un peu plus en d\u00E9tail ...\r\n\r\nLe principe du Kakuro :\r\n\tDans une grille de mots-crois\u00E9s, un indice permet de trouver un mot. Un mot qui, comme dans tous les autres mots, est une combinaison de lettres, dont le nombres est \u00E9gal au nombre de cases blanches correspondantes.\r\n\tPrenons par exemple cette d\u00E9finition : \"Qui fait feu\" en 4 lettres.\r\n\tLe mot correspondant est ARME, ensemble des lettres (R, M, E, A) dans un ordre pr\u00E9cis qui nous donne la combinaison (A, R, M, E).\r\n\tPrenons ensuite un autre indice \"L\u00E0 o\u00F9 les grenouilles se reposent\", toujours en 4 lettres.\r\n\tIci, le mot \u00E0 trouver pourrait \u00EAtre MARE, ensembes des m\u00EAme lettres qu'ARME, (R, M, E, A) mais dans une combinaison diff\u00E9rentes (M, A, R, E).\r\n\tAu Kakuro, c'est exactement la m\u00EAme chose ... \u00E0 la diff\u00E9rence pr\u00E8s que les indices sont des chiffres et des nombres compris entre 3 et 45.\r\n\tL'objectif du jeu est de trouver la bonne combinaison de chifres de 1 \u00E0 9 qui, en s'additionnant das le nombre de cases donn\u00E9, permettra d'obtenir cet indice. Avec une contrainte, de tailles toutefois : pour le m\u00EAme indice, aucune r\u00E9p\u00E9tition de chifre n'est admise !");
		
		JScrollPane scrollPane = new JScrollPane(txtpnHelp);
		contentPane.add(scrollPane);
	}

}

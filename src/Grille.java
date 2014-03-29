import java.util.Random;


public class Grille {

	/*
	public static void main(String[] args){
		new GrilleCible();
	}
	 */

	public Case[][] grille ;
	public int cible;


	public Grille(Utilitaire util1)
	{
		
		grille = new Case[util1.x][util1.y];
		Random List = new Random(util1.seed);
		boolean[][] forme = formeGrille(util1.x-1, util1.y-1, List);
		int[][] valeur = remplissageGrille(util1.x, util1.y, List, forme);

		for (int i = 0; i < valeur.length; i++)
			for (int j = 0; j < valeur[i].length; j++)
			{
				if (valeur[i][j] != 0)
					grille[i][j] = new Case(valeur[i][j], util1);
				if (valeur[i][j] == 0){
					int SommeX = CalcSommeX(valeur, i, j);
					int SommeY = CalcSommeY(valeur, i, j);

					if (SommeX == 0)
						grille[i][j] = new Case(SommeY, false, util1);
					if (SommeY == 0)
						grille[i][j] = new Case(SommeX, true, util1);
					else
						grille[i][j] = new Case(SommeX, SommeY, util1);
				}

			}
		affichTab(grille);
	}


	/**
	 * Génération d'un tableau de forme de grille par pose de blocs de 2x2
	 * @param x
	 * @param y
	 * @param List
	 * @return
	 */
	private boolean[][] formeGrille(int x, int y, Random List){
		boolean frmGrill[][] = new boolean[x][y];
		/* 
		 * On va générer une suite de nombre qui seront convertis en coordonnées pour la poses de blocs
		 * La même valeur peut retomber plusieurs fois
		 */
		for(int c = 0; c < x * y / 4 ; c++){
			int val = List.nextInt((x-1)*(y-1));
			int j = val % (y-1);
			int i = val / (x-1);

			/*
			 * On va maintenant poser un bloc de 2x2 sur la coordonnée en question
			 */
			for(int i1 = 0; i1 < 2; i1++)
				for(int j1 = 0; j1 < 2; j1++)
					frmGrill[i1+i][j1+j] = true;
		}
		return frmGrill;
	}

	/**
	 * Génération d'un tableau de valeurs et ajout de bordures
	 * @param x
	 * @param y
	 * @param seed
	 * @param tab
	 * @return
	 */
	private int[][] remplissageGrille(int x, int y, Random List, boolean[][] tab) {

		int grill[][] = new int[x][y];		// Tableau de valeur sans bordures

		for(int i = 0 ; i < tab.length; i++)		// Remplissage des valeurs de la grille
			for(int j = 0 ; j < tab[i].length; j++)
				if (tab[i][j]){
					boolean test = false;
					while(!test){
						boolean testI = true, testJ = true;

						int nb = List.nextInt(9) + 1;		// On prend une valeur de 1 à 9

						for(int ii=(i+1); ii>0 && tab[ii-1][j]; ii--)		// Test de la présence ou non du chiffre actuel sur la ligne
							if(nb==grill[ii][j+1])
								testI = false;

						for(int jj=(j+1); jj>0 && tab[i][jj-1]; jj--)		// Test de la présence ou non du chiffre actuel sur la colonne
							if(nb==grill[i+1][jj])
								testJ = false;

						if (testI && testJ){
							test = true;		// Si les tests ont réussi, on place le chiffre actuel dans la case en cours
							grill[i+1][j+1] = nb;
						}						// Autrement, on recommence en prenant une autre valeur
					}
				}				

		return grill;
	}	


	/**
	 * 
	 * @param tabSommes
	 * @param i
	 * @param j
	 * @return Valeur de la somme en dessous
	 */
	private int CalcSommeY(int tabSommes[][], int i, int j)
	{
		int somme = 0;

		// On effectue tant que on ne retombe pas sur un 0 ou que l'on est à la fin du tableau
		for(int jj = (j+1); jj < tabSommes[i].length && tabSommes[i][jj] != 0 ; jj++)
			somme += tabSommes[i][jj];
		return somme;
	}

	/**
	 * 
	 * @param tabSommes
	 * @param i
	 * @param j
	 * @return Valeur de la somme a droite
	 */
	private int CalcSommeX(int tabSommes[][], int i, int j)
	{
		int somme = 0;
		// On effectue tant que on ne retombe pas sur un 0 ou que l'on est à la fin du tableau
		for(int ii = (i+1); ii < tabSommes.length && tabSommes[ii][j] != 0; ii++)
			somme += tabSommes[ii][j];
		return somme;
	}


	@SuppressWarnings("unused")
	private void affichTab(int tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.printf("|%5s", tab[i][j]);
			System.out.println("|");
		}
	}


	@SuppressWarnings("unused")
	private static void affichTab(boolean tab[][])
	{
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.printf("|%6s", tab[i][j]);
			System.out.println("|");
		}
	}

	
	private void affichTab(Case tab[][])
	{
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.printf("|%5s", tab[i][j]);
			System.out.println("|");
		}
	}

}


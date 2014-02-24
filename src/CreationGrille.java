import java.util.Random;

@SuppressWarnings("unused")
public class CreationGrille {

	public static void main(String[] args){
		new CreationGrille();
		
	}


	public CreationGrille()
	{
		int x = 5, y = 5;
		long seed = 42;		// Seed du tableau
		Random List = new Random(seed);
		boolean[][] forme = formeGrille(x, y, List);
		int[][] valeur = remplissageGrille(x, y, List, forme);
		affichTab(valeur);

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
	 * Génération d'un tableau de valeurs sans bordures
	 * @param x
	 * @param y
	 * @param seed
	 * @param tab
	 * @return
	 */
	private int[][] remplissageGrille(int x, int y, Random List, boolean[][] tab) {

		int grill[][] = new int[x][y];		// Tableau de valeur sans bordures

		for(int i=0;i<tab.length; i++)		// Remplissage des valeurs de la grille
			for(int j = 0 ; j< tab[i].length; j++)
				if (tab[i][j]){
					int nb = List.nextInt(9) + 1;
					boolean test = false;
					while(!test){
						boolean testI = true, testJ = true;
						for(int ii=i-1; ii>=0 && grill[ii][j]!=0; ii--)		// Test de la présence ou non du chiffre actuel sur la ligne
							if(grill[ii][j]==nb)
								testI = false;
						for(int jj=j-1; jj>=0 && grill[i][jj]!=0; jj--)		// Test de la présence ou non du chiffre actuel sur la colonne
							if(grill[i][jj]==nb)
								testJ = false;
						if (testI && testJ){
							test = true;		// Si les tests ont réussi, on place le chiffre actuel dans la case en cours
							grill[i][j] = nb;		// On remplit de 1 à 9
						}
						else
							nb = List.nextInt(9) + 1;	// Autrement, on change de valeur
					}
				}
		affichTab(grill);
		CopieTab(grill);
		return grill;
		
	}
	

	private void affichTab(int tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.print("|"+tab[i][j]);
			System.out.println("|");
		}
	}
	
	
	private void affichTab(boolean tab[][])
	{
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.printf("| %6s", tab[i][j]);
			System.out.println("|");
		}
	}
	private void CalcSommeY(int tabSommes[][])
	{
		int somme = 0;
		for(int i =0; i<tabSommes.length; i++)   // on parcours le tableau
		{
			for(int j =0; j<tabSommes.length; j++)
			{
				if(tabSommes[i][j]==0)            //si on trouve un 0 
				{
					for(int j2 = j+1; tabSommes[i][j] == 0 || j == tabSommes.length; j2++ )// on effectue tant que on ne rtombe pas sur un 0 ou que l'on est à la fin du tableau
					{
						 somme = tabSommes[i][j2];
					}
					tabSommes[i][j] = somme;
					
				}
			}
		}
	}
	
	private void CalcSommeX(int tabSommes[][])
	{
		int somme = 0;
		for(int i =0; i<tabSommes.length; i++)   // on parcours le tableau
		{
			for(int j =0; j<tabSommes.length; j++)
			{
				if(tabSommes[i][j]==0)            //si on trouve un 0 
				{
					for(int i2 = i+1; tabSommes[i][j] == 0 || i == tabSommes.length; i2++ )// on effectue tant que on ne rtombe pas sur un 0 ou que l'on est à la fin du tableau
					{
						 somme = tabSommes[i2][j];
					}
					tabSommes[i][j] = somme;
					
				}
			}
		}
	}
	
	private void CopieTab(int grill[][])
	{
		int x=0;
		int y=0;
		int tabSommes[][] = new int[x][y];    //simple copie du tableau de int
		for(int i = 0; i<tabSommes.length; i++)
		{
			for(int j=0; j<tabSommes[i].length; j++ )
			{
				tabSommes[i][j] = grill[i][j];
			}
		}
		affichTab(tabSommes);
	}
	
}


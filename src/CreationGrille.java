import java.util.Random;


public class CreationGrille {

	public static void main(String[] args){
		new CreationGrille();
	}


	public CreationGrille()
	{
		int x = 5, y = 5;
		long seed = 42;		// Seed du tableau
		Random List = new Random(seed);
		//FormeGrille tab = new FormeGrille(x, y, seed);		// Tableau de "forme" de grille
		//boolean tab[][] = {{true, true, false, true, true},{true, true, true, true, true},{false, true, true, true, false},{true, true, true, true, true},{true, true, false, true, true}};
		boolean[][] forme = formeGrille(x, y, List);
		int[][] valeur = remplissageGrille(x, y, List, forme);

	}	

	/**
	 * Génération d'un tableau de forme de grille
	 * @param x
	 * @param y
	 * @param seed
	 * @return
	 */
	private boolean[][] formeGrille(int x, int y, Random List) {

		boolean frmGrll[][] = new boolean[x][y];

		for(int i = 0; i < frmGrll.length ; i++){			//Création du tableau de booléens
			for(int j = 0; j < frmGrll[i].length ; j++){
				frmGrll[i][j] = List.nextBoolean();			// Aléatoire, bien sûr
			}
		}

		//affichTab(frmGrll);

		boolean frmGrllTest[][] = new boolean[x+2][y+2];

		for(int i = 0; i < frmGrll.length ; i++){			// Création d'un second tableau sur lequel on effectue les changements pour obtenir les suites de nombres > 2.
			for(int j = 0; j < frmGrll[i].length ; j++){
				frmGrllTest[i+1][j+1] = frmGrll[i][j];
			}
		}
		if(frmGrllTest[1][1]){		// Optimisation possible, C'est pour ne pas avoir de changements si la première case est vraie
			frmGrllTest[0][1] = true;
			frmGrllTest[1][0] = true;
		}


		for(int i = 1; i < frmGrllTest.length-1 ; i++){		// Création des listes de longueur de sommes
			for(int j = 1; j < frmGrllTest[i].length-1 ; j++){
				int n = 0;
				if(frmGrllTest[i-1][j])
					n += 1;
				if(frmGrllTest[i+1][j])
					n += 1;
				if(frmGrllTest[i][j-1])
					n += 1;
				if(frmGrllTest[i][j+1])
					n += 1;
				if (n>1)
					frmGrllTest[i][j] = true;
				else
					frmGrllTest[i][j] = false;
			}
		}
		//affichTab(frmGrllTest);

		for(int i = 0; i < frmGrll.length ; i++){			// Et on remet dans le premier tableau
			for(int j = 0; j < frmGrll[i].length ; j++){
				frmGrll[i][j] = frmGrllTest[i+1][j+1];
			}
		}
		//affichTab(frmGrll);
		return frmGrll;
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
		return grill;
	}

	private void affichTab(int tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.print("|"+tab[i][j]);
			System.out.println("|");
		}
	}
	private void affichTab(boolean tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.printf("| %6s", tab[i][j]);
			System.out.println("|");
		}
	}
}


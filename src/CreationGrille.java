import java.util.Random;


public class CreationGrille {

	public static void main(String[] args){
		new CreationGrille();
	}


	public CreationGrille()
	{
		int x = 5, y = 5;
		long seed = 42;
		Random List = new Random(seed);		// Seed du tableau
		//boolean tab[][] = new boolean[x][y];		// Tableau de "forme" de grille
		boolean tab[][] = {{true, true, false, true, true},{true, true, true, true, true},{false, true, true, true, false},{true, true, true, true, true},{true, true, false, true, true}};
		int grill[][] = new int[x][y];		// Tableau de valeur sans bordures


		for(int i=0;i<tab.length; i++)		// Remplissage des valeurs de la grille
			for(int j = 0 ; j< tab[i].length; j++)
				if (tab[i][j]){
					int nb = List.nextInt(9) + 1;
					boolean test = false;
					while(!test){
						boolean testI = true, testJ = true;
						for(int ii=i-1; ii>=0 && grill[ii][j]!=0; ii--)		// Test de la pr�sence ou non du chiffre actuel sur la ligne
							if(grill[ii][j]==nb)
								testI = false;
						for(int jj=j-1; jj>=0 && grill[i][jj]!=0; jj--)		// Test de la pr�sence ou non du chiffre actuel sur la colonne
							if(grill[i][jj]==nb)
								testJ = false;
						if (testI && testJ){
							test = true;		// Si les tests ont r�ussi, on place le chiffre actuel dans la case en cours
							grill[i][j] = nb;		// On remplit de 1 � 9
						}
						else
							nb = List.nextInt(9) + 1;	// Autrement, on change de valeur
					}
				}

		AffichTab(grill);
	}	

	private void AffichTab(int tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.print("|"+tab[i][j]);
			System.out.println("|");
		}
	}
}

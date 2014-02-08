import java.util.ArrayList;
import java.util.List;
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

		AffichTab(grill);


		/*
		List<Nombre> grille = new ArrayList<Nombre>();


		for(int cpt1 = 1; cpt1<y ; cpt1++)// initialisé à 1 car deux bords doivent êtres "morts"
		{
			for(int cpt2 =1; cpt2<x ; cpt2++)
			{
				tab[cpt1][cpt2] =List.nextBoolean(); // 0 = mort ; 1 = vivante
			}
		}
		for(int cpt1 = 1; cpt1<x ; cpt1++)
		{
			for(int cpt2 =1; cpt2<x ; cpt2++)
			{
				if(tab[cpt1][cpt2]) // par defaut : TRUE
				{
				for(int gy =cpt1; gy < cpt1 + List.nextInt(7); gy++)
					for(int gx = cpt2; gx < cpt2 + List.nextInt(7); gx++) // 
						{
						grille.add(new Nombre(List.nextInt(10)));


					}
				}
			}
		}
		 */	
	}	

	private void AffichTab(int tab[][]){
		for (int i=0;i<tab.length; i++){
			for (int j=0; j<tab[i].length; j++)
				System.out.print("|"+tab[i][j]);
			System.out.println("|");
		}
	}
}

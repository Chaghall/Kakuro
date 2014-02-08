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
		Random List = new Random(seed);
		//		boolean tab[][] = new boolean[x][y];       // nouveau tableau pour désigné cases morts et vivant
		//		int tab2[][] = {{1,1},{1,2},{2,3},{3,4}};
		boolean tab[][] = {{true, true, false, true, true},{true, true, true, true, true},{false, true, true, true, false},{true, true, true, true, true},{true, true, false, true, true}};
		int grill[][] = new int[x][y];

		for(int i=0;i<tab.length; i++){
			for(int j = 0 ; j< tab[i].length; j++){
				if (tab[i][j])
					grill[i][j] = List.nextInt(9)+1;
			}
		}
		
		System.out.println(tab.length);
		
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
		System.out.println();
	}
}

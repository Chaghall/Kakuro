import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CreationGrille {

	
	public void Creationgrille()
	{
		int x = 0, y = 4;
		Random List = new Random();
		boolean tab[][] = new boolean[x][y];       // nouveau tableau pour désigné mrots et vivant
		
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
						grille.add(null);
					}
				}
			}
		}
	}
}

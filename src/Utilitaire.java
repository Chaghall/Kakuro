import java.io.*;
import java.util.*;


public class Utilitaire
{

	public static int x = 6;
	public static int y = 6;
	public static int victoire, score;
	public static int seed;	// Seed du tableau
	public static Case[][] grille ;
	Random list;

	public Utilitaire(int x1, int y1, int seed1)
	{
		x = x1;
		y = y1;
		seed = seed1;
		list = new Random(seed);
		victoire = x*y;

	}

	public static void  sauvegarde (String dir)
	{
		try
		{
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(dir + ".txt")));
			System.out.println("Début de la sauvegarde sur le fichier "+dir+".txt");
			bfw.write(""+ x + ";" + y + ";"+ seed + "\r\n");
			for(int cpt= 0 ;cpt < grille.length  ; cpt++  )
			{
				for(int cpt2 = 0; cpt2 < grille[cpt].length ; cpt2++)
				{
					if (grille[cpt][cpt2].aRemplir()){
						bfw.write(grille[cpt][cpt2].getText()+";");
						System.out.print(grille[cpt][cpt2].getText()+";");
					}
				}
				bfw.write("\r\n");
				System.out.println();
			}
			bfw.close();
			System.out.println("Sauvegarde réussie");
		}
		catch (IOException e1)
		{

		}

	}


	public static void charge (String filePath)
	{
		BufferedReader bfr;
		try {
			bfr = new BufferedReader(new FileReader(new File(filePath)));
			try
			{
				System.out.println("Début du chargement");
				String[] ligne = bfr.readLine().split(";");
				for (int a = 0; a < ligne.length ; a++)
					System.out.print(ligne[a] + " | ");
				System.out.println();
				x = Integer.parseInt(ligne[0]);
				y = Integer.parseInt(ligne[1]);
				seed = Integer.parseInt(ligne[2]);
				System.out.println("Paramètres de la grille affectés avec succès.");
			}
			catch (EOFException e)
			{
				bfr.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void repriseCharge (String filePath)
	{
		BufferedReader bfr;
		try {
			bfr = new BufferedReader(new FileReader(new File(filePath)));
			try
			{
				System.out.println("Seconde phase du chargement");
				String[] ligne = bfr.readLine().split(";");
				for(int i = 0; i < x; i++)
				{
					System.out.println();
					ligne = bfr.readLine().split(";");
					for (int a = 0; a < ligne.length ; a++)
						System.out.print(ligne[a] + " | ");
					for (int j = 0 , j2 = 0; j < grille[i].length ; j++)
						if (grille[i][j].aRemplir()){							
							grille[i][j].setText(ligne[j2]);
							j2++;
						}
				}
				System.out.println("Chargement complété sans erreurs");
			}
			catch (EOFException e)
			{
				bfr.close();
				System.out.println("Fin de fichier");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

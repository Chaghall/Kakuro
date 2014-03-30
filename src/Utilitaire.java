import java.awt.*;
import java.io.*;
import java.util.*;


public class Utilitaire implements Serializable
{

	public static int x = 6;
	public static int y = 6;
	public int victoire = x*y , score;
	public static long seed =  42;	// Seed du tableau
	public static Case[][] grille ;
	Random list;

	private FileDialog fileDlg;
	private String filePath;
	public Utilitaire(int x1, int y1, int seed1)
	{
		x = x1;
		y = y1;
		seed = seed1;
		list = new Random(seed);

	}
	/*
	public static Vector Lire() throws IOException, ClassNotFoundException
	{
		ObjectInputStream ofR = new ObjectInputStream(new FileInputStream("seed.dat"));
		return (Vector)ofR.readObject();
	}

	public static void Ecrire(Vector vector) throws IOException
	{
		ObjectOutputStream ofW = new ObjectOutputStream(new FileOutputStream("seed.dat"));
		ofW.writeObject(vector);
	}


}
	 */

	public static void  EcrireSave (String dir)
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
			}
			bfw.close();
			System.out.println("Sauvegarde réussie");
		}
		catch (IOException e1)
		{
			
		}

	}

	public void RepriseSave ()
	{

		//	fileDlg = new FileDialog(Kakuro.frame, "Sauvegarde à charger", FileDialog.LOAD);
	}


	public void LireSave ()
	{

		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(filePath));
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

}

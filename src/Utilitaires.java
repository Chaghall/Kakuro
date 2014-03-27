import java.awt.*;
import java.io.*;
import java.util.*;


public class Utilitaires implements Serializable
{

	public static int x = 6;
	public static int y = 6;
	public int victoire = x*y , score;
	public static long seed = 42;	// Seed du tableau
	public static Case[][] grille ;
	Random list;

	private FileDialog fileDlg;
	private String filePath;
	public Utilitaires(int x1, int y1, int seed1)
	{
		x = x1;
		y=y1;
		seed = seed1;
		grille = new Case[x][y];
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

	public static void  EcrireSave ()
	{

		try
		{
			String sauvegarde = "sauvegarde.txt";
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(sauvegarde)));

			bfw.write(""+ x + ";" + y + ";"+ seed + "\n\r");
			for(int cpt= 0 ;cpt < grille.length  ; cpt++  )
			{
				for(int cpt2 = 0; cpt < grille[cpt2].length ; cpt++)
				{
					bfw.write((grille[cpt][cpt2]).getText()+";");
				}
				bfw.write("\n\r");
			}
			bfw.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}

	}

	public void RepriseSave ()
	{

		//	fileDlg = new FileDialog(Kakuro.frame, "Sauvegarde à charger", FileDialog.LOAD);
	}


	public void LireSave ()
	{

		fileDlg.setVisible(true);
		filePath = fileDlg.getDirectory() + fileDlg.getFile();
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

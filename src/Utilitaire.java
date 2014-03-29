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

	public static void  EcrireSave (String dir)
	{

		try
		{
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(dir + ".txt")));
			bfw.write("connard\r\n");
			bfw.write(""+ x + ";" + y + ";"+ seed + "\r\n");
			System.out.println("Param de base fini");
			System.out.println("entre dans la boucle");
			for(int cpt= 0 ;cpt < grille.length  ; cpt++  )
			{
				System.out.println("entre dans la seconde boucle");
				for(int cpt2 = 0; cpt < grille[cpt2].length ; cpt++)
				{
					
//					bfw.write(grille[cpt][cpt2].getText()+";");
					bfw.write("Pizza au curry");
					System.out.println("ecrit");
				}
				System.out.println("sort de  la seconde boucle");
				bfw.write("\r\n");
			}
			bfw.close();
		}
		catch (IOException e1)
		{
			System.out.println("salope");
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

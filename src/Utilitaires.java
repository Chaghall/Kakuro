import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;


public class Utilitaires implements Serializable
{

	public int x = 6;
	public int y = 6;
	public int seed = 42;		// Seed du tableau
	public Case[][] grille = new Case[x][y];
	Random List = new Random(seed);

	private FileDialog fileDlg;
	private String filePath;

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

*/
	
	public static void  EcrireSave (int x, int y, int seed, Case[][] grille, Random List)
	{

		try
		{
			String sauvegarde = "sauvegarde";
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(sauvegarde)));
			
			bfw.write(x + y + seed);
			for(int cpt= 0 ;cpt < grille.length  ; cpt++  )
			{
				for(int cpt2 = 0; cpt < grille[cpt2].length ; cpt++)
				{
				bfw.write(grille[cpt][cpt2].getText);
				}
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
		
		fileDlg = new FileDialog(frame, "Sauvegarde à charger", FileDialog.LOAD);
	}
	
	
	public void LireSave ()
	{
		
		fileDlg.setVisible(true);
		filePath = fileDlg.getDirectory() + fileDlg.getFile();
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(filePath));
		}
		catch
		{
			
		}
	}
	
}

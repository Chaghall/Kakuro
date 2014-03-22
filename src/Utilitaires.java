import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


	public static void sauvegarde (int x, int y, int seed, Case[][] grille, Random List)
	{

		try
		{
			String sauvegarde = "sauvegarde";
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(sauvegarde)));
			String.format(x + y + seed, arg1)
			bfw.write(x + y + seed + List);

		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
}

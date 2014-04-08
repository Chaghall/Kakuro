package testUnitaire;
import java.io.*;
import java.util.*;

import javax.swing.JTextArea;


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
			writeln("Début de la sauvegarde sur le fichier "+dir+".txt",TestSauvegardeChargement.textArea);
			bfw.write(""+ x + ";" + y + ";"+ seed + "\r\n");
			for(int cpt= 0 ;cpt < grille.length  ; cpt++  )
			{
				for(int cpt2 = 0; cpt2 < grille[cpt].length ; cpt2++)
				{
					if (grille[cpt][cpt2].aRemplir()){
						bfw.write(grille[cpt][cpt2].getText()+";");
						write(grille[cpt][cpt2].getText()+";",TestSauvegardeChargement.textArea);
					}
				}
				bfw.write("\r\n");
				writeln("",TestSauvegardeChargement.textArea);
			}
			bfw.close();
			writeln("Sauvegarde réussie",TestSauvegardeChargement.textArea);
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
				writeln("Début du chargement",TestSauvegardeChargement.textArea);
				String[] ligne = bfr.readLine().split(";");
				for (int a = 0; a < ligne.length ; a++)
					write(ligne[a] + " | ",TestSauvegardeChargement.textArea);
				writeln("",TestSauvegardeChargement.textArea);
				x = Integer.parseInt(ligne[0]);
				y = Integer.parseInt(ligne[1]);
				seed = Integer.parseInt(ligne[2]);
				writeln("Paramètres de la grille affectés avec succès.",TestSauvegardeChargement.textArea);
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
				writeln("Seconde phase du chargement",TestSauvegardeChargement.textArea);
				String[] ligne = bfr.readLine().split(";");
				for(int i = 0; i < x; i++)
				{
					ligne = bfr.readLine().split(";");
					for (int a = 0; a < ligne.length ; a++)
						write(" | " + ligne[a],TestSauvegardeChargement.textArea);
					for (int j = 0 , j2 = 0; j < grille[i].length ; j++)
						if (grille[i][j].aRemplir()){							
							grille[i][j].setText(ligne[j2]);
							j2++;
						}
					writeln(" | ",TestSauvegardeChargement.textArea);
				}
				writeln("Chargement complété sans erreurs",TestSauvegardeChargement.textArea);
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

	public static void write (String s, JTextArea area){
		System.out.print(s);
		area.append(s);
	}
	public static void writeln (String s, JTextArea area){
		System.out.println(s);
		area.append(s+"\r\n");
	}
}

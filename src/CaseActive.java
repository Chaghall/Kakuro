public class CaseActive {

	private int n;
	private int sX;
	private int sY;
	
	/**
	 * 
	 * @param n valeur d'une case
	 */
	public CaseActive(int n)
	{
		this.n = n;
	}
	
	/**
	 * 
	 * @param S1 indice de Somme
	 * @param or1 orientation de l'indice de Somme
	 */
	public CaseActive(int S, boolean or1)
	{
		if(or1)
			this.sX = S;
		else
			this.sY = S;
			
	}

	/**
	 * 
	 * @param S1 indice de Somme vertical
	 * @param S2 indice de Somme horizontal
	 */
	public CaseActive(int S1, int S2)
	{
		this.sX = S1;
		this.sY = S2;
	}
	
	

}

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
	 * @param S indice de Somme
	 * @param or orientation de l'indice de Somme
	 */
	public CaseActive(int S, boolean or)
	{
		if(or)
			this.sX = S;
		else
			this.sY = S;
			
	}

	/**
	 * 
	 * @param sX indice de Somme horizontal
	 * @param sY indice de Somme vertical
	 */
	public CaseActive(int sX, int sY)
	{
		this.sX = sX;
		this.sY = sY;
	}
	
	

}

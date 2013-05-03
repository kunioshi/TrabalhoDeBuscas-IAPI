package Buscas;

public class Fila {
	
	private final int TAM = 15;
	private int ini;
	private int fim;
	private int[] vet;
	
	public Fila()
	{
		vet = new int[TAM];
		fim = -1;
		ini = 0;
	}
	
	public int remove()
	{
		int aux = vet[ini++];
		if (ini == TAM)
		{
			ini = 0;
		}
		return aux;
	}
	
	public void insert(int inicio)
	{
		if(fim == TAM-1)
		{
			fim = -1;
			vet[++fim] = inicio;
		}
	}
	
	public boolean empty()
	{
		return ((ini + TAM - 1 == fim) || (fim + 1 == ini));
	}
}

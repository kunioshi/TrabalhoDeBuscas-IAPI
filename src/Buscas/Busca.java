package Buscas;

import java.util.ArrayList;

public class Busca {
	
	public void buscaEmLargura(int inicio, int fim, Mapa lista) {
		// TODO Auto-generated method stub
		Fila fila = new Fila();
		
		fila.insert(inicio);
		
		while (!fila.empty())
		{
			int S = (int) fila.remove();
			if (S == fim)
			{
				System.out.println("Caminho encontrado!");
			}
			//else
			//{
				
			//}
		}
		
	}

	public void buscaEmProfundidade(String string, String string2, Mapa mapa) {
		// TODO Auto-generated method stub
		
	}

	public void buscaAStar(String string, String string2, Mapa mapa) {
		// TODO Auto-generated method stub
		
	}
}

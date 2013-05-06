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

	public void buscaEmProfundidade(Cidade inicio, Cidade destino) {
		
		No estado = new No(inicio);
		Pilha pilha = new Pilha();
		ArrayList<No> explorados = new ArrayList<No>();
		pilha.push(estado);
		
		while(!pilha.isEmpty()) {
			
			estado = pilha.pop();
			explorados.add(estado);
			
			if(estado.getCidade().getNome().equals(inicio.getNome())) {
				break;
			}
			else {
				for (Cidade aux : estado.getCidade().getProx()) {
										
				}
			}
			
		}
		
		
		
		
	}

	public void buscaAStar(String string, String string2, Mapa mapa) {
		// TODO Auto-generated method stub
		
	}
	// Mostra na tela o caminho encontrado
		public float obtemCaminho(No no) {
			if(no.getPai() != null) {
				float custo = (float)Math.sqrt( Math.pow((no.getCidade().getX() - no.getPai().getCidade().getX()), 2) + Math.pow((no.getCidade().getY() - no.getPai().getCidade().getY()), 2) );
				custo += obtemCaminho(no.getPai());
				System.out.print(" -> " + no.getCidade().getNome());
				return custo;
			}
			System.out.print(no.getCidade().getNome());
			
			return 0;
		}
}

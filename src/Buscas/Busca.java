package Buscas;

import java.util.ArrayList;

public class Busca {
	
	public void buscaEmLargura(Cidade inicio, Cidade fim) 
	{
				No estado;
				Fila fila = new Fila();
				ArrayList<No> explorados = new ArrayList<No>();
				fila.enqueue(new No(inicio));
				boolean encontrado = false;
				
				while (!fila.isEmpty())
				{
					estado = fila.dequeue();
					explorados.add(estado);
					
					if (estado.getCidade().getNome().equals(fim.getNome()))
					{
						break;
					}else
						{
							for (Cidade x : estado.getCidade().getProx())
							{
								boolean visitado = false;
								for (No n : explorados)
								{
									if (n.getCidade() == x)
									{
										visitado = true;
									}
									if (!fila.existeCidade(x) && !visitado)
									{
										fila.enqueue(new No(x, estado));
									}
								}
							}
						}
					}
				if(!encontrado)
				{
					System.out.println("Não é possível ir da cidade " + inicio.getNome() + " à cidade " + fim.getNome() + ".");					
				}else{
					float custo = obtemCaminho(explorados.get(explorados.size() - 1));
					System.out.println("\nEste caminho tem o custo de $" + (float)(Math.round(custo*100))/100 + ".");
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

package Buscas;

import java.util.ArrayList;

// Vértice para a busca A*, dava pra fazer melhor extendendo o No e tals.. mas ta funcionando
class Vertice {
	private Cidade _cidade;
	private float _heuristica;
	private float _custo;
	private Vertice _antecessor;
	
	// Constructor
	public Vertice(Cidade cidade) {
		_cidade = cidade;
		_heuristica = 0;
		_custo = 0;
		_antecessor = null;
	}
	public Vertice(Cidade cidade, Vertice antecessor, Cidade fim) {
		_cidade = cidade;
		_heuristica = (float)Math.sqrt( Math.pow((_cidade.getX() - fim.getX()), 2) + Math.pow((_cidade.getY() - fim.getY()), 2) );
		_custo = antecessor.getCusto() + (float)Math.sqrt( Math.pow((_cidade.getX() - antecessor.getCidade().getX()), 2) + Math.pow((_cidade.getY() - antecessor.getCidade().getY()), 2) );
		_antecessor = antecessor;
	}
	
	// Setters & Getters
	public Cidade getCidade() { return _cidade; }
	public float getHeuristica() { return _heuristica; }
	public float getCusto() { return _custo; }
	public Vertice getAntecessor() { return _antecessor; }
}

public class BuscasReferencia {
	// Busca em Largura
	public void buscaEmLargura(Cidade inicio, Cidade fim) {
		No atual; // Variável auxiliar para movimentar entre as cidades
		Fila fila = new Fila();
		ArrayList<No> visitados = new ArrayList<No>();
		fila.enqueue(new No(inicio));
		boolean encontrado = false; // Variável para saber se a cidade "fim" foi encontrada, ou não
		
		while(!fila.isEmpty()) {
			atual = fila.dequeue();
			visitados.add(atual);
			
			if(atual.getCidade().getNome().equals(fim.getNome())) {
				encontrado = true;
				break;
			} else {
				for(Cidade a : atual.getCidade().getProx()) {
					boolean existeVisitados = false;
					for(No n : visitados) {
						if(n.getCidade() == a)
							existeVisitados = true;
					}
					if(!existeVisitados && !fila.existeCidade(a)) {
						fila.enqueue(new No(a, atual));
					}
				}
			}
		}
		
		if(!encontrado)
			System.out.println("Não é possível ir da cidade " + inicio.getNome() + " à cidade " + fim.getNome() + ".");
		else {
			float custo = obtemCaminho(visitados.get(visitados.size() - 1));
			System.out.println("\nEste caminho tem o custo de $" + (float)(Math.round(custo*100))/100 + ".");
		}
	}

	// Busca em Profundidade
	public void buscaEmProfundidade(Cidade inicio, Cidade fim) {
		No atual; // Variável auxiliar para movimentar entre as cidades
		Pilha pilha = new Pilha();
		ArrayList<No> visitados = new ArrayList<No>();
		pilha.push(new No(inicio));
		boolean encontrado = false; // Variável para saber se a cidade "fim" foi encontrada, ou não
		
		while(!pilha.isEmpty()) {
			atual = pilha.pop();
			visitados.add(atual);
			
			if(atual.getCidade().getNome().equals(fim.getNome())) {
				encontrado = true;
				break;
			} else {
				for(Cidade a : atual.getCidade().getProx()) {
					boolean existeVisitados = false;
					for(No n : visitados) {
						if(n.getCidade() == a)
							existeVisitados = true;
					}
					if(!existeVisitados && !pilha.existeCidade(a)) {
						pilha.push(new No(a, atual));
					}
				}
			}
		}
		
		if(!encontrado)
			System.out.println("Não é possível ir da cidade " + inicio.getNome() + " à cidade " + fim.getNome() + ".");
		else {
			float custo = obtemCaminho(visitados.get(visitados.size() - 1));
			System.out.println("\nEste caminho tem o custo de $" + (float)(Math.round(custo*100))/100 + ".");
		}
	}

	// Busca A*
	public void buscaAStar(Cidade inicio, Cidade fim, Mapa mapa) {
		ArrayList<Vertice> lista_aberta = new ArrayList<Vertice>();
		ArrayList<Vertice> lista_fechada = new ArrayList<Vertice>();
		boolean encontrado = false; // Variável para saber se a cidade "fim" foi encontrada, ou não

		lista_aberta.add(new Vertice(inicio));

		while(lista_aberta.size() != 0) {
			Vertice atual;
			atual = menorHeuristica(lista_aberta);
			lista_fechada.add(atual);

			if(atual.getCidade() == fim) {
				encontrado = true;
				break;
			}

			for(Cidade c : atual.getCidade().getProx()) {
				boolean existeFechada = false;
				for(Vertice n : lista_fechada) {
					if(n.getCidade() == c)
						existeFechada = true;
				}
				if(!existeFechada) {
					boolean existeAberta = false;
					for(Vertice n : lista_aberta) {
						if(n.getCidade() == c)
							existeAberta = true;
					}
					if(!existeAberta)
						lista_aberta.add(new Vertice(c, atual, fim));
					else {
						lista_aberta.add(lista_aberta.indexOf(c), new Vertice(c, atual, fim));
					}
				}
			}
		}
		if(!encontrado)
			System.out.println("Não é possível ir da cidade " + inicio.getNome() + " à cidade " + fim.getNome() + ".");
		else {
			obtemCaminho(lista_fechada.get(lista_fechada.size() - 1));
			float custo = lista_fechada.get(lista_fechada.size() - 1).getCusto();
			System.out.println("\nEste caminho tem o custo de $" + (float)(Math.round(custo*100))/100 + ".");
		}
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
	public void obtemCaminho(Vertice vertice) {
		if(vertice.getAntecessor() != null) {
			obtemCaminho(vertice.getAntecessor());
			System.out.print(" -> " + vertice.getCidade().getNome());
		} else {
			System.out.print(vertice.getCidade().getNome());
		}
	}
	
	// Encontra a menor heurística da lista
	public Vertice menorHeuristica(ArrayList<Vertice> lista) {
		int auxIndex = 0;
		for(Vertice c : lista) {
			if(c.getHeuristica() < lista.get(auxIndex).getHeuristica())
				auxIndex = lista.indexOf(c);
		}
		
		return lista.remove(auxIndex);
	}
}

package Buscas;

import java.util.ArrayList;

public class Pilha {
	private ArrayList<No> _pilha;
	
	// Constructor
	public Pilha() {
		_pilha = new ArrayList<No>();
	}
	
	// Setters& Getters
	public ArrayList<No> getpilha() { return _pilha; }
	public No getNo(Cidade cidade) { return _pilha.get(_pilha.indexOf(cidade)); }
	
	// Operações de pilha
	public void push(No no) { _pilha.add(no); }
	public No pop() { return _pilha.remove(_pilha.size() - 1); }
	
	public boolean isEmpty() { return _pilha.isEmpty(); }
	
	public boolean existeCidade(Cidade cidade) {
		for(No n : _pilha) {
			if(n.getCidade() == cidade)
				return true;
		}
		
		return false;
	}
}
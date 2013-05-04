package Buscas;

import java.util.ArrayList;

public class Fila {
	private ArrayList<No> _fila;
	
	// Constructor
	public Fila() {
		_fila = new ArrayList<No>();
	}
	
	// Setters& Getters
	public ArrayList<No> getFila() { return _fila; }
	public No getNo(Cidade cidade) { return _fila.get(_fila.indexOf(cidade)); }
	
	// Operações de Fila
	public void enqueue(No no) { _fila.add(no); }
	public No dequeue() { return _fila.remove(0); }
	
	public boolean isEmpty() { return _fila.isEmpty(); }
	
	public boolean existeCidade(Cidade cidade) {
		for(No n : _fila) {
			if(n.getCidade() == cidade)
				return true;
		}
		
		return false;
	}
}
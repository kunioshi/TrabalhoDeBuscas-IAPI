package Buscas;

import java.util.ArrayList;

public class Cidade {
	private String _nome;
	private int _x, _y;
	private ArrayList<Cidade> _prox;
	
	// Constructor
	public Cidade(String nome, int x, int y) {
		_nome = nome;
		_x = x;
		_y = y;
		_prox = new ArrayList<Cidade>();
	}
	
	// Getters & Setters
	public String getNome() { return _nome; }
	public int getX() { return _x; }
	public int getY() { return _y; }
	public ArrayList<Cidade> getProx() { return _prox; }
	
	public void setProx(Cidade prox) {
		if(!procuraCidade(prox)) {
			_prox.add(prox);
		}
	}
	
	private boolean procuraCidade(Cidade prox) {
		for(Cidade s : _prox) {
			if(s.getNome().equals(prox.getNome())) 
				return true;
		}
		
		return false;
	}
}

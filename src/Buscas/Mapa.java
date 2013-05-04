package Buscas;

import java.util.ArrayList;

public class Mapa {
	private ArrayList<Cidade> _mapa;
	
	// Constructor
	public Mapa() {
		_mapa = new ArrayList<Cidade>();
	}
	
	// Getters & Setters
	public int getLength() { return _mapa.size(); }
	public ArrayList<Cidade> getMapa() { return _mapa; }

	public Cidade getCidade(String nome) {
		for(Cidade c : _mapa) {
			if(c.getNome().equals(nome)) {
				return _mapa.get(_mapa.indexOf(c));
			}
		}
		
		return null;
	}
	public Cidade getCidade(int index) {
		if(index >= 0 && index < _mapa.size())
			return _mapa.get(index);
		
		return null;
	}
	
	public String getNomeCidade(int index) { return _mapa.get(index).getNome(); }
	
	public void addCidade(Cidade novaCidade) { _mapa.add(novaCidade); }
}

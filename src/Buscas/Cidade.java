package Buscas;

public class Cidade {
	private String _nome;
	private int _x, _y;
	private int _ligacoes;
	private Cidade[] _prox;
	
	// Constructor
	public Cidade(String nome, int x, int y) {
		_nome = nome;
		_x = x;
		_y = y;
		_ligacoes = 0;
		_prox = null;
	}
	
	// Getters & Setters
	public String getNome() { return _nome; }
	public int getX() { return _x; }
	public int getY() { return _y; }
	public int getLigacoes() { return _ligacoes; }
	
	public void setProx(Cidade prox) {
		if(procuraCidade(prox)) {
			_ligacoes++;
			Cidade[] auxProx = _prox.clone();
			_prox = new Cidade[_ligacoes];
			for(int i = 0; i < (_ligacoes - 1); i++)
				_prox[i] = auxProx[i];
			_prox[_ligacoes] = prox;
		}
	}
	
	private boolean procuraCidade(Cidade prox) {
		if(_ligacoes > 0) {
			for(int i = 0; i < _ligacoes; i++) {
				if( prox.getNome().equals(_prox[_ligacoes].getNome()) ) return true;
			}
		}
		
		return false;
	}
}

package Buscas;

public class No {
	private Cidade _cidade;
	private No _pai;
	
	// Constructor
	public No(Cidade cidade) {
		_cidade = cidade;
		_pai = null;
	}
	public No(Cidade cidade, No pai) {
		_cidade = cidade;
		_pai = pai;
	}

	// Getters & Setters
	public Cidade getCidade() { return _cidade; }
	public No getPai() { return _pai; }
	
	public void setCidade(Cidade cidade) { _cidade = cidade; }
	public void setPai(Cidade cidade) { _pai = new No(cidade); }
}

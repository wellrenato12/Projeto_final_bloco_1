package projeto_final_bloco_1.model;

public class Livro extends Biblioteca {
	private String autor;
	
	public Livro(String nome, String autor) {
		super(nome);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Autor: "+this.autor);
		System.out.println();
	}
}

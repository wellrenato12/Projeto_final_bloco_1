package projeto_final_bloco_1.model;

public abstract class Biblioteca {
	private String nome;

	public Biblioteca(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void visualizar() {
		System.out.println("Nome: " + this.nome);
	}

}

package projeto_final_bloco_1.model;

public class Leitor extends Biblioteca {
	
	private String email;
	private int idade;

	public Leitor(String nome, String email, int idade) {
		super(nome);
		this.email = email;
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Email: "+this.email);
		System.out.println("Idade: "+this.idade);
	}
}

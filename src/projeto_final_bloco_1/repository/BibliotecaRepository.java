package projeto_final_bloco_1.repository;

import projeto_final_bloco_1.model.Livro;

public interface BibliotecaRepository {
	//CRUD - criar / atualizar / deletar / ler
	public void cadastrar(Livro livro);
	public void atualizar(Livro livro);
	public void deletar(String nome);
	public void mostrar();
	
	//Métodos bibliotecários
	//public void visualizarLeitor();
}

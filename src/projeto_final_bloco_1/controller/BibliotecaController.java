package projeto_final_bloco_1.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_1.model.Livro;
import projeto_final_bloco_1.repository.BibliotecaRepository;

public class BibliotecaController implements BibliotecaRepository {

	private List<Livro> livros = new ArrayList<Livro>();

	@Override
	public void cadastrar(Livro livro) {
		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	@Override
	public void atualizar(Livro livro) {
		var buscarLivro = buscarNaCollection(livro.getNome());

		if (buscarLivro != null) {
			livros.set(livros.indexOf(buscarLivro), livro);
			System.out.println("\nO livro: " + livro.getNome() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO livro: " + livro.getNome() + " não foi encontrado!");
		}

	}

	@Override
	public void deletar(String nome) {
		var livroDeleta = buscarNaCollection(nome);

		if (livroDeleta != null) {
			if (livros.remove(livroDeleta) == true)
				System.out.println("\nO livro " + nome + " foi deletado com sucesso!");
		} else
			System.out.println("\nO livro: " + nome + " não foi encontrado!");
	}

	@Override
	public void mostrar() {
		if (!livros.isEmpty()) {
			for (var livro : livros) {
				livro.visualizar();
			}
		} else {
			System.out.println("Lista de livros vazia!");
		}
	}

	public void iniciarListaLivros() {
		livros.add(new Livro("Dom Casmurro", "Machado de Assis"));
		livros.add(new Livro("Orgulho e Preconceito", "Jane Austen"));
		livros.add(new Livro("1984", "George Orwell"));
		livros.add(new Livro("Cem Anos de Solidão", "Gabriel García Márquez"));
		livros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
		livros.add(new Livro("A Revolução dos Bichos", "George Orwell"));
		livros.add(new Livro("A Menina que Roubava Livros", "Markus Zusak"));
		livros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
		livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski"));
		livros.add(new Livro("A Insustentável Leveza do Ser", "Milan Kundera"));
	}

	public Livro buscarNaCollection(String nome) {
		for (var livro : livros) {
			if (livro.getNome().equalsIgnoreCase(nome)) {
				return livro;
			}
		}
		return null;
	}
}

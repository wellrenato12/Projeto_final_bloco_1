package projeto_final_bloco_1;

import java.io.IOException;

import java.util.InputMismatchException;

import java.util.Scanner;

import projeto_final_bloco_1.controller.BibliotecaController;
import projeto_final_bloco_1.model.Livro;
import projeto_final_bloco_1.util.Cores;

public class Menu {

	public static void main(String[] args) {

		BibliotecaController livros = new BibliotecaController();
		BibliotecaController leitores = new BibliotecaController();

		String nome, autor;
		int opcao;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem vindes a nossa biblioteca!");

		livros.iniciarListaLivros();

		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BIBLIOTECA                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Livro               ");
			System.out.println("            2 - Listar todos os livros                       ");
			System.out.println("            3 - Atualizar Dados da Conta              ");
			System.out.println("            4 - Remover livro             ");
			// System.out.println(" 5 - Remover livro ");
			// System.out.println(" 6 - Sacar ");
			// System.out.println(" 7 - Depositar ");
			// System.out.println(" 8 - Transferir valores entre Contas ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nProjeto final bloco 1 - Biblioteca");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("\nCadastrar: ");

				System.out.println("\nDigite o nome do livro: ");
				scanner.nextLine();
				nome = scanner.nextLine();
				System.out.println("\nDigite o nome do autor: ");
				autor = scanner.nextLine();
				livros.cadastrar(new Livro(nome, autor));
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nListar todos os livros \n\n");
				livros.mostrar();
				keyPress();
			case 3:
				System.out.println("\nAtualiza livro: ");

				System.out.println("\nDigite o nome do livro para atualizar: ");
				scanner.skip("\\R?");
				nome = scanner.nextLine();

				var livroParaAtualizar = livros.buscarNaCollection(nome);

				if (livroParaAtualizar != null) {
					System.out.println("\nLivro encontrado! Vamos atualizar:");

					System.out.println("Digite o novo nome do livro: ");
					String novoNome = scanner.nextLine();

					System.out.println("Digite o novo nome do autor: ");
					String novoAutor = scanner.nextLine();

					livroParaAtualizar.setNome(novoNome);
					livroParaAtualizar.setAutor(novoAutor);
					
					livros.atualizar(livroParaAtualizar);
				} else {
					System.out.println("O livro não foi encontrado!");
				}
				break;
			case 4:
				System.out.println("Remover livro: ");
				System.out.println("Digite o nome do livro: ");
				scanner.nextLine();
				nome = scanner.nextLine();

				livros.deletar(nome);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		} // fim while
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar.");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("Projeto desenvolvidor por: ");
		System.out.println("Wellington Albino - well.renato@hotmail.com");
		System.out.println("github.com/wellrenato12");
		System.out.println("*****************************************************");
	}

}

package br.dev.marcelo.tarefas.dao;

import br.dev.marcelo.tarefas.factory.FileFactory;
import br.dev.marcelo.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	// Método construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;

	}

	public void gravar() {

		FileFactory ff = new FileFactory();

		ff.getBufferedWriter().write("Teste");
	}

}

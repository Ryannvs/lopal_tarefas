package br.dev.marcos.tarefas.dao;

import java.io.BufferedWriter;
import java.io.IOException;

import br.dev.marcos.tarefas.factory.FileFactory;
import br.dev.marcos.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	// Método construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;

	}

	public void gravar() {

		FileFactory ff = new FileFactory();

		try {
			
			BufferedWriter bw = ff.getBufferedWriter();
			
			bw.write(funcionario.toString());
			bw.flush();
		} catch (IOException e) {
			System.out.println();
		}

	}
	
	public void showEmployees() {
		
	}
	
}

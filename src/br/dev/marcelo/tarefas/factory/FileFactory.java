package br.dev.marcelo.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileFactory {

	private FileWriter fw;
	private BufferedWriter bw;

	private String pathFuncionarios = "C:\\Users\\25132758\\tarefas\\funcionarios.csv";

	public BufferedWriter getBufferedWriter() {
		try {
			fw = new FileWriter(pathFuncionarios, true);
			bw = new BufferedWriter(fw);

			return bw;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}

	}

}

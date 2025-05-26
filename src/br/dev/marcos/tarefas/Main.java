package br.dev.marcos.tarefas;


import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import br.dev.marcos.tarefas.dao.FuncionarioDAO;
import br.dev.marcos.tarefas.gui.FrameFuncionario;
import br.dev.marcos.tarefas.gui.FrameListaFuncionario;
import br.dev.marcos.tarefas.model.Funcionario;
import br.dev.marcos.tarefas.model.Tarefa;
import br.dev.marcos.tarefas.utils.Utils;

public class Main {

	// determinando caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132758\\tarefas\\funcionarios.csv";


	public static void main(String[] args) {
		new FrameListaFuncionario();
		//new FrameFuncionario();
		
		
//		
////		List<String> frutas = new ArrayList<String>();
////		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
////		List<Double> numeros = new ArrayList<Double>();
////		
////		frutas.add("Abacaxi");
////		frutas.add("Framboesa");
////		frutas.add("Mirtilo");
////		frutas.add("jabuticaba");
////		
////		numeros.add(4.9);
////		numeros.add(12.78);
////		
////		
////		Funcionario funcionario = new Funcionario();
////		funcionario.setCodigo(Utils.gerarUUID());
////		funcionario.setNome("Thiago Aparecida");
////		funcionario.setTelefone("202121111");
////		funcionario.setEmail("thiagoaparecida@email.com");
////		
////		Funcionario funcionario2 = new Funcionario();
////		funcionario2.setCodigo(Utils.gerarUUID());
////		funcionario2.setNome("Teteca Silva");
////		funcionario2.setTelefone("201921111");
////		funcionario2.setEmail("tetecasilva@email.com");
////		
////		funcionarios.addAll(List.of(funcionario,funcionario2));
////
////		System.out.println(frutas);
////		System.out.println(funcionarios);
////		
////		for (Funcionario f : funcionarios) {
////			System.out.printf(f.getNome() + " - " + f.getEmail() + "/");
////		}
//
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario2);
//		dao.gravar();
//		
//		System.out.println(funcionario2.toString());
//		
	}

	private static void gravarArquivo() {
		
		FileWriter arquivo = null;
		BufferedWriter escritor = null;
		
		try {
			
			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);
			
			escritor.write("Ultima linha por enquanto\n");
			escritor.flush();
			
		} catch (Exception erro) {
			System.out.println(erro);
		}
		
	}

	private static void lerArquivo() {
		

		//abrir arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico!");
			System.out.println(erro.getMessage());
		}
		
		
		
	}

}

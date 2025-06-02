package br.dev.marcos.tarefas.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.marcos.tarefas.dao.FuncionarioDAO;
import br.dev.marcos.tarefas.model.Funcionario;

public class FrameListaFuncionario {

	private JLabel lblTitulo;
	private JTable tblFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;

	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);

	public FrameListaFuncionario() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setBounds(10, 20, 400, 30);
		lblTitulo.setFont(fontTitulo);
		
		btnNovo = new JButton("Cadastrar");
		

		// Criação da tabela
		String[] colunas = { "Código", "Nome", "E-mail" };
		colunas[0] = "Código";
		colunas[1] = "Nome";
		colunas[2] = "E-mail";

		// obter lista de funcionarios
		FuncionarioDAO dao = new FuncionarioDAO(null);

		List<Funcionario> funcionarios = dao.showEmployees();

		// Vetor de vetor, é um elemento dentro de outro elemento
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		
		//For each = pra cada
		//Para cada funcionario, pega um funcionario da lista de funcionarios
		for (Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;

		}

		tblFuncionarios = new JTable(dados, colunas);

		scrollFuncionarios = new JScrollPane(tblFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 500, 300);
		
		btnNovo.setBounds(10, 380, 150, 40);

		painel.add(lblTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		
		
		
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
				
			}
		});
		
		
		
		tela.setVisible(true);
	}

}

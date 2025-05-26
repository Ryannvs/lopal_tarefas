package br.dev.marcos.tarefas.gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		lblTitulo.setBounds(10, 20, 200, 30);
		lblTitulo.setFont(fontTitulo);

		// Criação da tabela
		String[] colunas = { "Código", "Nome", "E-mail" };
		
		Object[][] dados = {
				{"aaa", "aaa", "aaa"},
				{"bbb", "bbb", "bbb"},
				{"ccc", "ccc", "ccc"}
		};
		
		tblFuncionarios = new JTable(dados,colunas);
		
		scrollFuncionarios = new JScrollPane(tblFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 500, 300);

		painel.add(lblTitulo);
		painel.add(scrollFuncionarios);
		tela.setVisible(true);
	}

}

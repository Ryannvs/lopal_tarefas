package br.dev.marcos.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameHome {

	private JLabel lblTitle;
	private JButton btnFuncionario;
	private JButton btnTarefas;
	private JButton btnSair;

	public FrameHome() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de funcionários");
		tela.setSize(400, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		lblTitle = new JLabel("Escolha uma opção!");
		lblTitle.setBounds(140, 10, 300, 30);

		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(35, 60, 150, 70);

		btnFuncionario = new JButton("Funcionários");
		btnFuncionario.setBounds(195, 60, 150, 70);

		btnSair = new JButton("Sair");
		btnSair.setBounds(140, 150, 100, 50);

		painel.add(lblTitle);
		painel.add(btnTarefas);
		painel.add(btnFuncionario);
		painel.add(btnSair);

		btnFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirma ir para \"funcionários\"?", "Sair?",
						JOptionPane.YES_NO_OPTION);

				System.out.println(resposta);
				if (resposta == 0) {
					tela.setVisible(false);
					
					new FrameListaFuncionario();
				}
			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirmar a sáida do sistema?", "Sair do Sistema?",
						JOptionPane.YES_NO_OPTION);

				System.out.println(resposta);
				if (resposta == 0) {
					tela.setVisible(false);
				}
			}
		});

		tela.setVisible(true);

	}
}

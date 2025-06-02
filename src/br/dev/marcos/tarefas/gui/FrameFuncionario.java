package br.dev.marcos.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.marcos.tarefas.dao.FuncionarioDAO;
import br.dev.marcos.tarefas.model.Funcionario;
import br.dev.marcos.tarefas.utils.Utils;

public class FrameFuncionario {
	
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameFuncionario(JFrame telaLista) {
		criarTela(telaLista);
	}
	
	private void criarTela(JFrame telaLista) {
		
		JDialog tela = new JDialog(telaLista, "Cadastro", true);
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaLista);
		
		Container painel = tela.getContentPane();
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 320, 30);
		txtCodigo.setEnabled(false);
		
		lblNome =  new JLabel("Nome");
		lblNome.setBounds(20, 80, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(20, 110, 320, 30);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 140, 320, 30);
		txtTelefone = new JTextField();
		txtTelefone.setBounds(20, 170, 320, 30);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(20, 200, 320, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(20, 230, 320, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 300, 145, 30);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(195, 300, 145, 30);
		
		
		painel.add(lblCodigo);
		painel.add(txtCodigo);
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblTelefone);
		painel.add(txtTelefone);
		painel.add(lblEmail);
		painel.add(txtEmail);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		//Adicionar os ouvintes de ação dos botões
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(Utils.gerarUUID());
				funcionario.setNome(txtNome.getText());
				funcionario.setTelefone(txtTelefone.getText());
				funcionario.setEmail(txtEmail.getText());
				
				FuncionarioDAO dao = new FuncionarioDAO(funcionario);
				dao.gravar();
				
				JOptionPane.showMessageDialog(tela,
						txtNome.getText() + " gravado com sucesso!",
						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
						);
				
				limparFormulario();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela,
						"Confirmar a sáida do sistema?",
						"Sair do Sistema?",
						JOptionPane.YES_NO_OPTION
						);
				
				System.out.println(resposta);
				if(resposta == 0) {
					tela.setVisible(false);
				}
			}
		});
		
		
		
		
		tela.setVisible(true);
	}
	
	public void limparFormulario() {
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtNome.requestFocus();
		
	}
	
}

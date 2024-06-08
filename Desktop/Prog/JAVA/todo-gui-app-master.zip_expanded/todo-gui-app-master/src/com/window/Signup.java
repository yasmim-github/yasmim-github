package com.window;

import com.main.Main;
import com.models.Usuario;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class Signup extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Signup() {
		setResizable(false);
		setFont(new Font("Inter", Font.PLAIN, 14));
		setTitle("Criar Conta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Signup.class.getResource("/assets/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);

		JLabel titulo_screen = new JLabel("Criar Conta");
		titulo_screen.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_screen.setFont(new Font("Inter", Font.BOLD, 32));

		JLabel senha_label = new JLabel("Senha:");
		senha_label.setFont(new Font("Inter", Font.PLAIN, 16));
		JPasswordField senha = new JPasswordField();
		senha.setFont(new Font("Inter", Font.PLAIN, 16));

		JLabel nome_label = new JLabel("Nome:");
		nome_label.setFont(new Font("Inter", Font.PLAIN, 16));
		JTextField nome = new JTextField();
		nome.setFont(new Font("Inter", Font.PLAIN, 16));
		nome.setColumns(10);

		JLabel email_label = new JLabel("Email:");
		email_label.setFont(new Font("Inter", Font.PLAIN, 16));
		JTextField email = new JTextField();
		email.setFont(new Font("Inter", Font.PLAIN, 16));
		email.setColumns(10);

		JLabel conf_senha_label = new JLabel("Conf senha:");
		conf_senha_label.setFont(new Font("Inter", Font.PLAIN, 16));
		JPasswordField conf_senha = new JPasswordField();
		conf_senha.setFont(new Font("Inter", Font.PLAIN, 16));

		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setFont(new Font("Inter", Font.PLAIN, 16));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				dispose();
			}
		});

		JButton criar_conta = new JButton("Criar conta");
		criar_conta.setBackground(new Color(255, 255, 255));
		criar_conta.setFont(new Font("Inter", Font.PLAIN, 16));
		criar_conta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = Main.usuario;
				usuario.criarUsuario(nome, email, senha, conf_senha);
				dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(365)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(180)
			.addComponent(titulo_screen)
			.addPreferredGap(ComponentPlacement.RELATED, 192, GroupLayout.PREFERRED_SIZE))
			.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
			.addComponent(criar_conta))
			.addComponent(conf_senha_label)
			.addComponent(email_label)
			.addComponent(senha_label)
			.addComponent(senha)
			.addComponent(email)
			.addComponent(conf_senha)
			.addComponent(nome, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
			.addComponent(nome_label)))
			.addGap(370))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addContainerGap(118, Short.MAX_VALUE)
			.addComponent(titulo_screen)
			.addGap(61)
			.addComponent(nome_label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(email_label)
			.addGap(18)
			.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(senha_label)
			.addGap(18)
			.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(14)
			.addComponent(conf_senha_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(conf_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(60)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
			.addComponent(criar_conta)
			.addComponent(cancelar))
			.addGap(102))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}

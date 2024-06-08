package com.window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.main.Main;
import com.models.Usuario;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Login() {
		setFont(new Font("Inter", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/assets/favicon.png")));
		setTitle("Entrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel email_label = new JLabel("Email:");
		email_label.setForeground(new Color(24, 24, 24));
		email_label.setFont(new Font("Inter", Font.PLAIN, 16));

		JTextField email = new JTextField();
		email.setForeground(new Color(24, 24, 24));
		email.setFont(new Font("Inter", Font.PLAIN, 16));
		email.setColumns(10);

		JLabel senha_label = new JLabel("Senha:");
		senha_label.setForeground(new Color(24, 24, 24));
		senha_label.setFont(new Font("Inter", Font.PLAIN, 16));

		JPasswordField password = new JPasswordField();
		password.setForeground(new Color(24, 24, 24));
		password.setFont(new Font("Inter", Font.PLAIN, 16));
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setForeground(new Color(24, 24, 24));
		cancelar.setFont(new Font("Inter", Font.PLAIN, 16));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				dispose();
			}
		});

		JButton	entrar = new JButton("Entrar");
		entrar.setBackground(new Color(255, 255, 255));
		entrar.setForeground(new Color(24, 24, 24));
		entrar.setFont(new Font("Inter", Font.PLAIN, 16));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = Main.usuario;			
				usuario.loginUsuario(email, password);
				dispose();
			}
		});
		
		JLabel titulo_screen = new JLabel("Entrar");
		titulo_screen.setForeground(new Color(24, 24, 24));
		titulo_screen.setFont(new Font("Inter", Font.BOLD, 32));
		titulo_screen.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap(410, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(entrar, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
			.addComponent(senha_label)
			.addComponent(password, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
			.addComponent(email_label)
			.addComponent(email))
			.addGap(396))
			.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
			.addGap(572)
			.addComponent(titulo_screen)
			.addContainerGap(613, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(155)
			.addComponent(titulo_screen)
			.addGap(80)
			.addComponent(email_label)
			.addGap(12)
			.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(21)
			.addComponent(senha_label)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(58)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
			.addComponent(cancelar)
			.addComponent(entrar))
			.addGap(142))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}

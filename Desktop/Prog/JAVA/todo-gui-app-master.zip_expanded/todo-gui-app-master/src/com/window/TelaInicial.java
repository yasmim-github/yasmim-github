package com.window;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {		
		setFont(new Font("Inter", Font.PLAIN, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/assets/favicon.png")));
		setTitle("Tela de inicio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		setContentPane(contentPane);

		JButton criar = new JButton("Entrar na sua conta");
		criar.setBackground(new Color(255, 255, 255));
		criar.setForeground(new Color(24, 24, 24));
		criar.setFont(new Font("Inter", Font.PLAIN, 16));
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login signup = new Login();
				signup.setVisible(true);
				dispose();
			}
		});

		JButton entrar = new JButton("Criar conta");
		entrar.setBackground(new Color(255, 255, 255));
		entrar.setForeground(new Color(24, 24, 24));
		entrar.setFont(new Font("Inter", Font.PLAIN, 16));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup login = new Signup();
				login.setVisible(true);
				dispose();
			}
		});

		JLabel titulo_screen = new JLabel("Bem-vind@!");
		titulo_screen.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_screen.setForeground(new Color(24, 24, 24));
		titulo_screen.setFont(new Font("Inter", Font.BOLD, 32));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addContainerGap(145, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(titulo_screen, GroupLayout.PREFERRED_SIZE, 987, GroupLayout.PREFERRED_SIZE)
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addPreferredGap(ComponentPlacement.RELATED, 205, GroupLayout.PREFERRED_SIZE)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
			.addComponent(entrar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(criar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
			.addGap(217)))
			.addGap(134))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addContainerGap(238, Short.MAX_VALUE)
			.addComponent(titulo_screen)
			.addGap(106)
			.addComponent(criar)
			.addGap(18)
			.addComponent(entrar)
			.addGap(237))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}

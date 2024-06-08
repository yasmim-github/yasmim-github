package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.window.Login;
import com.window.Signup;
import com.window.TelaPrincipal;

public class Usuario {
	private int identificador;
	private String nome;
	private String email;
	private String senha;
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void criarUsuario(JTextField textfield_nome, JTextField textfield_email, JPasswordField textfield_senha, JPasswordField textfield_conf_senha) {
		String sql = "INSERT INTO usuario(nome,email,senha) VALUES (?,?,?)";
		
		Signup signup = new Signup();
		
		ConectaBanco factory = new ConectaBanco();
		
		try (Connection c = factory.conectar()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, textfield_nome.getText());
			ps.setString(2, textfield_email.getText());
			ps.setString(3, String.valueOf(textfield_senha.getPassword()));

			String user_name = textfield_nome.getText();
			String email_user = textfield_email.getText();
			String pass = String.valueOf(textfield_senha.getPassword());
			String passconf = String.valueOf(textfield_conf_senha.getPassword());

			if(pass.equals("") || passconf.equals("") || user_name.equals("") || email_user.equals("")) {
				JOptionPane.showMessageDialog(null, "Complete os campos.");
				signup.setVisible(true);
				return;
			} else if (!pass.equals(passconf)) {
				JOptionPane.showMessageDialog(null, "As senhas fornecidas não são identicas");
				signup.setVisible(true);
				return;
			} else if (!Regex.REGEX_EMAIL_VALIDO(email_user)) {
				JOptionPane.showMessageDialog(null, "Email fornecido é inválido");
				signup.setVisible(true);
				return;
			} else if(!Regex.REGEX_SENHA_VALIDA(String.valueOf(textfield_senha.getPassword()))) {
				JOptionPane.showMessageDialog(null, "A senha precisa possuir oito digitos, uma letra maiuscula e um caractere especial e dois numeros.");
				signup.setVisible(true);
				return;
			}
				
			ps.execute();
				
			JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
				
			Login login = new Login();
			login.setVisible(true);
		} catch (SQLException error) {
			if (error.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "Esse email já existe, faça o login.");
			} else {
				JOptionPane.showMessageDialog(null, "Aconteceu algo de errado, tente novamente mais tarde.");						
			}
		}
	}
	
	public void loginUsuario(JTextField email, JPasswordField password) {
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			Login login = new Login();
			
			ps.setString(1, email.getText());
			ps.setString(2, String.valueOf(password.getPassword()));
			
			String email_user = email.getText();
			String pass = String.valueOf(password.getPassword());
			
			if(email_user.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(null, "Complete os campos.");
				login.setVisible(true);
				return;
			} else if(!Regex.REGEX_EMAIL_VALIDO(email_user)) {
				JOptionPane.showMessageDialog(null, "Email fornecido é inválido.");
				login.setVisible(true);
				return;
			} else if(!Regex.REGEX_SENHA_VALIDA(pass)) {
				JOptionPane.showMessageDialog(null, "A senha precisa possuir oito digitos, uma letra maiuscula e um caractere especial e dois numeros.");
				login.setVisible(true);
				return;
			}
				
			ResultSet rs = ps.executeQuery();
				
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "Email ou senha inválidos.");
			} else {
				setIdentificador(rs.getInt("id_usuario"));
				setNome(rs.getString("nome"));
				setEmail(rs.getString("email"));
				setSenha(rs.getString("senha"));
					
				JOptionPane.showMessageDialog(null, "Você entrou no sistema.");
					
				TelaPrincipal homePage = new TelaPrincipal();
				homePage.setVisible(true);
			}
		} catch(SQLException error) {
			error.printStackTrace();
		}
	}
}

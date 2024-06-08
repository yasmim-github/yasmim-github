package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.Main;
import com.window.TelaPrincipal;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tarefa {
	private int identificador;
	private String titulo;
	private String prioridade;
	private String data;
	private String descricao;
	private String etiqueta;
	private boolean concluido;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	public static boolean criar(JTextField titulo, JTextArea descrisao_field, JComboBox prioridade, JComboBox etiqueta, JTextField data) {
		String sql = "INSERT INTO tarefa (titulo, descricao, prioridade, etiqueta, data_estimada_conclusao, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		Boolean status = false;
		
		ConectaBanco factory = new ConectaBanco();
		Usuario usuario = Main.usuario;
				
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, titulo.getText());
			ps.setString(2, descrisao_field.getText());
			ps.setString(3, prioridade.getSelectedItem().toString());
			ps.setString(4, etiqueta.getSelectedItem().toString());
			ps.setString(5, data.getText());
			ps.setInt(6, usuario.getIdentificador());
			ps.execute();
			
			Tarefa tarefa = new Tarefa();
			
			tarefa.setTitulo(titulo.getText());
			tarefa.setDescricao(descrisao_field.getText());
			tarefa.setPrioridade(prioridade.getSelectedItem().toString());
			tarefa.setEtiqueta(etiqueta.getSelectedItem().toString());
			tarefa.setData(data.getText());
			tarefa.setConcluido(false);
			
			Main.tarefas.add(0, tarefa);
			TelaPrincipal.criarConteudo();
	
			JOptionPane.showMessageDialog(null, "Tarefa criada com sucesso.");
			status = true;
		} catch(SQLException error) {
			System.out.println(error);
			
			if(error.getErrorCode() == 1292) {
				JOptionPane.showMessageDialog(null, "Data informada é inválida.");
			} else {
				JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente mais tarde.");
			}
			
			status = false;
		}
		
		return status;
	}
	
	public static void concluir(int identificador) {
		String sql = "UPDATE tarefa SET concluida = ? WHERE id_tarefa = ?";
		
		for(int i = 0; i < Main.tarefas.size(); i++) {
			if(Main.tarefas.get(i).getIdentificador() == identificador) {
				if(Main.tarefas.get(i).getConcluido() == true) {
					Main.tarefas.get(i).setConcluido(false);
				} else {
					Main.tarefas.get(i).setConcluido(true);
				}
				
				ConectaBanco factory = new ConectaBanco();
				
				try(Connection c = factory.conectar()){
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setBoolean(1, Main.tarefas.get(i).getConcluido());
					ps.setInt(2, identificador);
					ps.execute();
				} catch(SQLException error) {
					System.out.println(error);
					JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente mais tarde.");
				}
				
				TelaPrincipal.criarConteudo();
			}
		}
	}

	public static boolean editar(int identificador, String titulo, String descricao, String etiqueta, String prioridade, String data) {
		String sql = "UPDATE tarefa SET titulo = ?, descricao = ?, prioridade = ?, etiqueta = ?, data_estimada_conclusao = ? WHERE id_tarefa = ?";
		Boolean status = false;
		
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, titulo);
			ps.setString(2, descricao);
			ps.setString(3, prioridade);
			ps.setString(4, etiqueta);
			ps.setString(5, data);
			ps.setInt(6, identificador);
			ps.execute();
			
			for(int i = 0; i < Main.tarefas.size(); i++) {
				if(Main.tarefas.get(i).getIdentificador() == identificador) {
					Main.tarefas.get(i).setTitulo(titulo);
					Main.tarefas.get(i).setDescricao(descricao);
					Main.tarefas.get(i).setEtiqueta(etiqueta);
					Main.tarefas.get(i).setPrioridade(prioridade);
					Main.tarefas.get(i).setData(data);
					TelaPrincipal.criarConteudo();
				}
			}
			
			JOptionPane.showMessageDialog(null, "Tarefa editada com sucesso.");
			status = true;
		} catch(SQLException error) {
			System.out.println(error);
			
			if(error.getErrorCode() == 1292) {
				JOptionPane.showMessageDialog(null, "Data informada é inválida.");
			} else {
				JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente mais tarde.");
			}
			
			status = false;
		}
		
		return status;
	}

	public static void excluir(int identificador) {
		String sql = "DELETE FROM tarefa WHERE id_tarefa = ?";
		
		for(int i = 0; i < Main.tarefas.size(); i++) {
			if(Main.tarefas.get(i).getIdentificador() == identificador) {
				Main.tarefas.remove(i);
				
				ConectaBanco factory = new ConectaBanco();
				
				try(Connection c = factory.conectar()){
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setInt(1, identificador);
					ps.execute();
				} catch(SQLException error) {
					System.out.println(error);
					JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente mais tarde.");
				}
				
				TelaPrincipal.criarConteudo();
			}
		}
	}
	
	public static void pesquisar(String query) {
		String sql = "SELECT * FROM tarefa WHERE id_usuario = ? AND "
				+ "(titulo LIKE ? COLLATE utf8mb4_unicode_ci OR "
				+ "descricao LIKE ? COLLATE utf8mb4_unicode_ci OR "
				+ "prioridade LIKE ? COLLATE utf8mb4_unicode_ci OR "
				+ "etiqueta LIKE ? COLLATE utf8mb4_unicode_ci OR "
				+ "data_estimada_conclusao LIKE ? COLLATE utf8mb4_unicode_ci) "
				+ "LIMIT 0, 1000";
		String pesquisar = "%" + query + "%";
		
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			Main.tarefas.clear();
			
			ps.setInt(1, Main.usuario.getIdentificador());
			ps.setString(2, pesquisar);
			ps.setString(3, pesquisar);
			ps.setString(4, pesquisar);
			ps.setString(5, pesquisar);
			ps.setString(6, pesquisar);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int idTarefa = rs.getInt("id_tarefa");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String prioridade = rs.getString("prioridade");
				String etiqueta = rs.getString("etiqueta");
				String data = rs.getDate("data_estimada_conclusao").toString();
				Boolean concluida = rs.getBoolean("concluida");
				
				Tarefa tarefa = new Tarefa();
				tarefa.setIdentificador(idTarefa);
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				tarefa.setPrioridade(prioridade);
				tarefa.setEtiqueta(etiqueta);
				tarefa.setData(data);
				tarefa.setConcluido(concluida);
				
				Main.tarefas.add(tarefa);
			}
			
			TelaPrincipal.criarConteudo();
		} catch(SQLException error) {
			System.out.println(error);
			JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente mais tarde.");
		}
	}
}

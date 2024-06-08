package com.window;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.main.Main;
import com.models.ConectaBanco;
import com.models.Tarefa;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JPanel containerTarefas;

	public TelaPrincipal() {
		setResizable(false);
		setFont(new Font("Inter", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/assets/favicon.png")));
		setTitle("TodoList");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Inter", Font.PLAIN, 14));
		setJMenuBar(menuBar);
		
		JPanel Container_menu = new JPanel();
		menuBar.add(Container_menu);
		Container_menu.setLayout(new MigLayout("", "[640px][640px]", "[32px]"));
		
		JButton novaTarefa = new JButton("Adicionar Tarefa");
		Container_menu.add(novaTarefa, "cell 0 0,alignx right,aligny center");
		
		novaTarefa.setSelectedIcon(null);
		novaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarTarefa criarTarefa = new CriarTarefa();
				criarTarefa.setVisible(true);
			}
		});
		
		novaTarefa.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/assets/plus.png")));
		novaTarefa.setFont(new Font("Inter", Font.PLAIN, 14));
		novaTarefa.setBackground(new Color(255, 255, 255));
		novaTarefa.setForeground(new Color(24, 24, 24));
		
		JPanel pesquisa = new JPanel();
		Container_menu.add(pesquisa, "cell 1 0,alignx left,aligny top");
		pesquisa.setLayout(new MigLayout("", "[30px][300px]", "[32px]"));
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/assets/search.png")));
		pesquisa.add(icon, "cell 0 0,grow");
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setFont(new Font("Inter", Font.PLAIN, 14));
		
		JTextField pesquisarTarefa = new JTextField();
		pesquisarTarefa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Tarefa.pesquisar(pesquisarTarefa.getText());
				}
			}
		});
		pesquisarTarefa.setColumns(14);
		pesquisa.add(pesquisarTarefa, "cell 1 0,alignx left,growy");
		pesquisarTarefa.setToolTipText("");
		pesquisarTarefa.setHorizontalAlignment(SwingConstants.LEFT);
		pesquisarTarefa.setFont(new Font("Inter", Font.PLAIN, 14));
		pesquisarTarefa.setForeground(new Color(24, 24, 24));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		containerTarefas = new JPanel();
		containerTarefas.setLayout(new BoxLayout(containerTarefas, BoxLayout.Y_AXIS));
		containerTarefas.add(Box.createVerticalGlue());
		scrollPane.setViewportView(containerTarefas);
		
		JPanel menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(menu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1595, Short.MAX_VALUE)
			.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1595, Short.MAX_VALUE))
			.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addComponent(menu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			.addGap(18)
			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
			.addContainerGap())
		);
		
		menu.setLayout(new MigLayout("", "[80px,fill][1px:n,fill][][186px,fill][][1px:n,fill][186px,fill][2px:n,fill][][186px,fill][][2px:n][186px,fill][2px:n,fill][][186px,fill][][2px:n,fill][80px,fill][2px:n,fill][][80px,fill][][2:n,fill][12px:n:12px]", "[30px,fill]"));
		
		JLabel conclur_menu = new JLabel("Conclui");
		conclur_menu.setHorizontalAlignment(SwingConstants.CENTER);
		conclur_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		menu.add(conclur_menu, "cell 0 0");
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		menu.add(separator, "cell 2 0");
		
		JLabel titulo_menu = new JLabel("Titulo");
		titulo_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		titulo_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(titulo_menu, "cell 3 0");
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(new Color(0, 0, 0));
		menu.add(separator_3, "cell 4 0");
		
		JLabel descricao_menu = new JLabel("Descrição");
		descricao_menu.setHorizontalAlignment(SwingConstants.CENTER);
		descricao_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		menu.add(descricao_menu, "cell 6 0,alignx trailing");
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menu.add(separator_4, "cell 8 0");
		
		JLabel prioridade_menu = new JLabel("Prioridade");
		prioridade_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		prioridade_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(prioridade_menu, "cell 9 0");
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 0, 0));
		separator_5.setOrientation(SwingConstants.VERTICAL);
		menu.add(separator_5, "cell 10 0");
		
		JLabel etiqueta_menu = new JLabel("Etiqueta");
		etiqueta_menu.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		menu.add(etiqueta_menu, "cell 12 0");
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setForeground(new Color(0, 0, 0));
		menu.add(separator_6, "cell 14 0");
		
		JLabel data_menu = new JLabel("Data do Termino");
		data_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		data_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(data_menu, "cell 15 0");
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 0, 0));
		separator_7.setOrientation(SwingConstants.VERTICAL);
		menu.add(separator_7, "cell 16 0");
		
		JLabel editar_menu = new JLabel("Editar");
		editar_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		editar_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(editar_menu, "cell 18 0");
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setForeground(new Color(0, 0, 0));
		menu.add(separator_8, "cell 20 0");
		
		JLabel excluir_menu = new JLabel("Excluir");
		excluir_menu.setFont(new Font("Inter", Font.PLAIN, 14));
		excluir_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(excluir_menu, "cell 21 0");
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(new Color(0, 0, 0));
		separator_9.setOrientation(SwingConstants.VERTICAL);
		menu.add(separator_9, "cell 22 0");
		
		contentPane.setLayout(gl_contentPane);
		
		selecionarTarefas();
	}
	
	public static void criarConteudo() {
		containerTarefas.removeAll();
		
		for(int i = 0; i < Main.tarefas.size(); i++) {
			TarefaConteudo tarefa = new TarefaConteudo();
			tarefa.setIdentificadorValue(Main.tarefas.get(i).getIdentificador());
			tarefa.setTituloValue(Main.tarefas.get(i).getTitulo());
			tarefa.setDescricaoValue(Main.tarefas.get(i).getDescricao());
			tarefa.setEtiquetaValue(Main.tarefas.get(i).getEtiqueta());
			tarefa.setPrioridadeValue(Main.tarefas.get(i).getPrioridade());
			tarefa.setDataValue(Main.tarefas.get(i).getData());
			tarefa.setConcluida(Main.tarefas.get(i).getConcluido());
			containerTarefas.add(tarefa.TarefaConteudo());
		}
		
		containerTarefas.revalidate();
		containerTarefas.repaint();;
	}
	
	public void selecionarTarefas() {
		String sql = "SELECT * FROM tarefa WHERE id_usuario = ? ORDER BY id_tarefa DESC";
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, Main.usuario.getIdentificador());
			
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
			
			criarConteudo();
		} catch(SQLException error) {
			error.printStackTrace();
		}
	}
}

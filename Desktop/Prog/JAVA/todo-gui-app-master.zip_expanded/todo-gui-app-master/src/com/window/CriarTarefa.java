package com.window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.models.Tarefa;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class CriarTarefa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CriarTarefa() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CriarTarefa.class.getResource("/assets/favicon.png")));
		setTitle("Criar Tarefa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel titulo_screen = new JLabel("Criar tarefa");
		titulo_screen.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_screen.setFont(new Font("Inter", Font.BOLD, 32));
		titulo_screen.setForeground(new Color(24, 24, 24));

		JLabel titulo_label = new JLabel("Título (*)");
		titulo_label.setFont(new Font("Inter", Font.PLAIN, 16));
		titulo_label.setForeground(new Color(24, 24, 24));
				
		JTextField titulo = new JTextField();
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setFont(new Font("Inter", Font.PLAIN, 16));
		titulo.setForeground(new Color(24, 24, 24));
		titulo.setColumns(10);
		
		JLabel data_label = new JLabel("Data (*)");
		data_label.setFont(new Font("Inter", Font.PLAIN, 16));
		data_label.setForeground(new Color(24, 24, 24));
		
		JTextField data = new JTextField();
		data.setHorizontalAlignment(SwingConstants.LEFT);
		data.setFont(new Font("Inter", Font.PLAIN, 16));
		data.setColumns(10);
						
		JLabel etiqueta_label = new JLabel("Etiqueta");
		etiqueta_label.setFont(new Font("Inter", Font.PLAIN, 16));
		etiqueta_label.setForeground(new Color(24, 24, 24));
						
		JComboBox etiqueta = new JComboBox();
		etiqueta.setFont(new Font("Inter", Font.PLAIN, 16));
		etiqueta.setForeground(new Color(24, 24, 24));
		etiqueta.setModel(new DefaultComboBoxModel(new String[] { "Trabalho", "Casa", "Estudo", "Lazer", "Compras" }));
		etiqueta.setMaximumRowCount(5);							
				
		JLabel prioridade_label = new JLabel("Prioridade");
		prioridade_label.setFont(new Font("Inter", Font.PLAIN, 16));
		prioridade_label.setForeground(new Color(24, 24, 24));
		
		JComboBox prioridade = new JComboBox();
		prioridade.setFont(new Font("Inter", Font.PLAIN, 16));
		prioridade.setForeground(new Color(24, 24, 24));
		prioridade.setModel(new DefaultComboBoxModel(new String[] { "Desejável", "Importante", "Essencial" }));
		prioridade.setMaximumRowCount(3);
				
		JTextArea descricao = new JTextArea();
		descricao.setBackground(new Color(255, 255, 255));
		descricao.setFont(new Font("Inter", Font.PLAIN, 16));
		descricao.setForeground(new Color(24, 24, 24));
				
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setFont(new Font("Inter", Font.PLAIN, 16));
		cancelar.setForeground(new Color(24, 24, 24));
		cancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton adicionar_tarefa = new JButton("Adicionar");
		adicionar_tarefa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(titulo.toString().trim().equals("") || descricao.toString().trim().equals("") || data.toString().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete os campos.");
					return;
				}
			
				boolean status = Tarefa.criar(titulo, descricao, prioridade, etiqueta, data);
				
				if(status == true) {
					dispose();
				}
			}
		});
				
		adicionar_tarefa.setBackground(new Color(255, 255, 255));
		adicionar_tarefa.setFont(new Font("Inter", Font.PLAIN, 16));
		adicionar_tarefa.setForeground(new Color(24, 24, 24));
		
		JLabel prioridade_label_1 = new JLabel("Descrição");
		prioridade_label_1.setForeground(new Color(24, 24, 24));
		prioridade_label_1.setFont(new Font("Inter", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(424)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(prioridade_label_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
			.addContainerGap())
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addComponent(descricao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
			.addComponent(data_label, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
			.addComponent(titulo_label, Alignment.LEADING)
			.addComponent(data, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
			.addComponent(titulo, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
			.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
			.addComponent(cancelar)
			.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
			.addComponent(adicionar_tarefa))
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
			.addComponent(etiqueta_label)
			.addComponent(prioridade_label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
			.addComponent(etiqueta, 0, 458, Short.MAX_VALUE)
			.addComponent(prioridade, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			.addGap(406))))
			.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addContainerGap(560, Short.MAX_VALUE)
			.addComponent(titulo_screen)
			.addGap(550))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(85)
			.addComponent(titulo_screen)
			.addGap(43)
			.addComponent(titulo_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(data_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(etiqueta_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(etiqueta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(prioridade_label)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(prioridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(23)
			.addComponent(prioridade_label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(descricao, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
			.addGap(18)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
			.addComponent(cancelar)
			.addComponent(adicionar_tarefa))
			.addGap(29))
		);
			
		contentPane.setLayout(gl_contentPane);
	}
}

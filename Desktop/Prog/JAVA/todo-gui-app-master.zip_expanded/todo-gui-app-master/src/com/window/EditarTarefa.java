package com.window;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.models.Tarefa;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarTarefa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public EditarTarefa(int identificadorValue, String tituloValue, String descrisaoValue, String etiquetaValue, String prioridadeValue, String dataValue) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarTarefa.class.getResource("/assets/favicon.png")));
		setFont(new Font("Inter", Font.PLAIN, 16));
		setTitle("Editar Tarefa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		JLabel titulo_screen = new JLabel("Editar tarefa");
		titulo_screen.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_screen.setFont(new Font("Inter", Font.BOLD, 32));
		titulo_screen.setForeground(new Color(24, 24, 24));

		JTextField titulo = new JTextField();
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		titulo.setFont(new Font("Inter", Font.PLAIN, 16));
		titulo.setForeground(new Color(24, 24, 24));
		titulo.setColumns(10);
		titulo.setText(tituloValue);
		
		JLabel titulo_label = new JLabel("Título (*)");
		titulo_label.setFont(new Font("Inter", Font.PLAIN, 16));
		titulo_label.setForeground(new Color(24, 24, 24));
		
		JLabel data_label = new JLabel("Data (*)");
		data_label.setFont(new Font("Inter", Font.PLAIN, 16));
		data_label.setForeground(new Color(24, 24, 24));
		
		JTextField data = new JTextField();
		data.setHorizontalAlignment(SwingConstants.LEFT);
		data.setFont(new Font("Inter", Font.PLAIN, 16));
		data.setColumns(10);
		data.setText(dataValue);
				
		JLabel etiqueta_label = new JLabel("Etiqueta");
		etiqueta_label.setFont(new Font("Inter", Font.PLAIN, 16));
		etiqueta_label.setForeground(new Color(24, 24, 24));
				
		JComboBox etiqueta = new JComboBox();
		etiqueta.setFont(new Font("Inter", Font.PLAIN, 16));
		etiqueta.setForeground(new Color(24, 24, 24));
		etiqueta.setModel(new DefaultComboBoxModel(new String[] { "Trabalho", "Casa", "Estudo", "Lazer", "Compras" }));
		etiqueta.setMaximumRowCount(5);
		etiqueta.setSelectedItem(etiquetaValue);
		
		JLabel prioridade_label = new JLabel("Prioridade");
		prioridade_label.setFont(new Font("Inter", Font.PLAIN, 16));
		prioridade_label.setForeground(new Color(24, 24, 24));

		JComboBox prioridade = new JComboBox();
		prioridade.setFont(new Font("Inter", Font.PLAIN, 16));
		prioridade.setForeground(new Color(24, 24, 24));
		prioridade.setModel(new DefaultComboBoxModel(new String[] { "Desejável", "Importante", "Essencial" }));
		prioridade.setMaximumRowCount(3);
		prioridade.setSelectedItem(prioridadeValue);
		
		JTextArea descrisao = new JTextArea();
		descrisao.setBackground(new Color(255, 255, 255));
		descrisao.setFont(new Font("Inter", Font.PLAIN, 16));
		descrisao.setForeground(new Color(24, 24, 24));
		descrisao.setText(descrisaoValue);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setFont(new Font("Inter", Font.PLAIN, 16));
		cancelar.setForeground(new Color(24, 24, 24));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton editar_tarefa = new JButton("Salvar");
		editar_tarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = Tarefa.editar(identificadorValue, titulo.getText(), descrisao.getText(), etiqueta.getSelectedItem().toString(), prioridade.getSelectedItem().toString(), data.getText());
				
				if(status == true) {
					dispose();
				}
			}
		});
		
		editar_tarefa.setBackground(new Color(255, 255, 255));
		editar_tarefa.setFont(new Font("Inter", Font.PLAIN, 16));
		editar_tarefa.setForeground(new Color(24, 24, 24));
		
		JLabel etiqueta_label_1 = new JLabel("Descrição");
		etiqueta_label_1.setForeground(new Color(24, 24, 24));
		etiqueta_label_1.setFont(new Font("Inter", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(406)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addComponent(etiqueta_label)
			.addComponent(etiqueta, 0, 452, Short.MAX_VALUE)
			.addComponent(prioridade_label)
			.addComponent(prioridade, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(cancelar)
			.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
			.addComponent(editar_tarefa))
			.addComponent(data, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
			.addComponent(data_label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
			.addComponent(titulo, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
			.addComponent(titulo_label)
			.addComponent(etiqueta_label_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
			.addComponent(descrisao, Alignment.TRAILING)))
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(536)
			.addComponent(titulo_screen)))
			.addContainerGap(408, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(75)
			.addComponent(titulo_screen)
			.addGap(51)
			.addComponent(titulo_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(data_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(prioridade_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(prioridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(etiqueta_label)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(etiqueta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(29)
			.addComponent(etiqueta_label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(descrisao, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
			.addGap(18)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
			.addComponent(cancelar)
			.addComponent(editar_tarefa))
			.addContainerGap(78, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
		setContentPane(contentPane);
	}
}

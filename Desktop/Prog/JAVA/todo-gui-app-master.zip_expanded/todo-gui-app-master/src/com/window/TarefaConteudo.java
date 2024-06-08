package com.window;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import com.models.Tarefa;
import net.miginfocom.swing.MigLayout;

public class TarefaConteudo extends JPanel {
	public TarefaConteudo() {
	}
	private final long serialVersionUID = 1L;
	private int identificadorValue; 
	private String tituloValue;
	private String descricaoValue;
	private String etiquetaValue;
	private String prioridadeValue;
	private String dataValue;
	private Boolean concluidaValue;
	
	public int getIdentificadorValue() {
		return identificadorValue;
	}

	public void setIdentificadorValue(int identificadorValue) {
		this.identificadorValue = identificadorValue;
	}

	public String getTituloValue() {
		return tituloValue;
	}

	public void setTituloValue(String tituloValue) {
		this.tituloValue = tituloValue;
	}

	public String getDescricaoValue() {
		return descricaoValue;
	}

	public void setDescricaoValue(String descricaoValue) {
		this.descricaoValue = descricaoValue;
	}

	public String getEtiquetaValue() {
		return etiquetaValue;
	}

	public void setEtiquetaValue(String etiquetaValue) {
		this.etiquetaValue = etiquetaValue;
	}

	public String getPrioridadeValue() {
		return prioridadeValue;
	}

	public void setPrioridadeValue(String prioridadeValue) {
		this.prioridadeValue = prioridadeValue;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	
	public boolean getConcluida() {
		return concluidaValue;
	}

	public void setConcluida(Boolean concluidaValue) {
		this.concluidaValue = concluidaValue;
	}

	public JPanel TarefaConteudo() {
		JPanel tarefa = new JPanel();
		tarefa.setBorder(UIManager.getBorder("ToolTip.border"));
		tarefa.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
		
		JLabel titulo = new JLabel(getTituloValue());
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Inter", Font.PLAIN, 12));
		
		JLabel descrisao = new JLabel(getDescricaoValue());
		descrisao.setHorizontalAlignment(SwingConstants.CENTER);
		descrisao.setFont(new Font("Inter", Font.PLAIN, 12));
		tarefa.setLayout(new MigLayout("", "[80px:80px,fill][186px:186px,fill][186px:186px,fill][186px:186px,fill][186px:186px,fill][186px:186px,fill][80px:80px,fill][80px:80px,fill]", "[60px:60px]"));
		
		JCheckBox concluir = new JCheckBox("Concluir");
		concluir.setHorizontalAlignment(SwingConstants.CENTER);
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tarefa.concluir(getIdentificadorValue());
				concluir.setSelected(getConcluida());
			}
		});
		concluir.setFont(new Font("Inter", Font.PLAIN, 12));
		concluir.setSelected(getConcluida());
		
		JLabel data_termino = new JLabel(dataValue);
		data_termino.setHorizontalAlignment(SwingConstants.CENTER);
		data_termino.setFont(new Font("Inter", Font.PLAIN, 12));
		
		tarefa.add(concluir, "cell 0 0,alignx center,aligny center");
		tarefa.add(titulo, "cell 1 0,alignx center,aligny center");
		tarefa.add(descrisao, "cell 2 0,alignx center,aligny center");
		
		JLabel prioridade = new JLabel(getPrioridadeValue());
		prioridade.setHorizontalAlignment(SwingConstants.CENTER);
		prioridade.setFont(new Font("Inter", Font.PLAIN, 12));
		tarefa.add(prioridade, "cell 3 0");
		
		JLabel etiqueta = new JLabel(getEtiquetaValue());
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("Inter", Font.PLAIN, 12));
		tarefa.add(etiqueta, "cell 4 0");
		tarefa.add(data_termino, "cell 5 0,alignx center,aligny center");
		
		JButton editar = new JButton("");
		editar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/assets/edit.png")));
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTituloValue().trim().equals("") || getDataValue().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete os campos.");
					return;
				}
				
				EditarTarefa editarTarefa = new EditarTarefa(getIdentificadorValue(), getTituloValue(), getDescricaoValue(), getEtiquetaValue(), getPrioridadeValue(), getDataValue());
				editarTarefa.setVisible(true);
			}
		});
		
		editar.setFont(new Font("Inter", Font.PLAIN, 12));
		tarefa.add(editar, "cell 6 0,alignx center,aligny center");
		
		//botao de excluir
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] opcoes = { "Sim", "Não"};
				int selecao = JOptionPane.showOptionDialog(null, "Deseja realmente excluir a tarefa?", "Excluir tarefa", 
				                                                      0, 2, null, opcoes, opcoes[0]);
				if(selecao == 0) {
					Tarefa.excluir(getIdentificadorValue());					
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/assets/delete.png")));
		tarefa.add(btnNewButton, "cell 7 0");
		
		return tarefa;
	}
	

}

package gUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPMesas extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private static ArrayList <String> nombreColumnas;

	public JPMesas() {
		setLayout(new BorderLayout(0, 0));
		
		nombreColumnas = new <String> ArrayList();
		nombreColumnas.add("Numero");
		nombreColumnas.add("Capacidad");
		nombreColumnas.add("Estado");
		nombreColumnas.add("Consumo");
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0 de Mesa", "Capacidad", "Estado", "Consumo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(138);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(247);
		table.getColumnModel().getColumn(3).setPreferredWidth(278);
		scrollPane.setViewportView(table);

	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public void actualizarTabla(){
		
	}
}

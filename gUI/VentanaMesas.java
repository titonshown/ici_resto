package gUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import iciresto.Administrador;

import javax.swing.border.LineBorder;

public class VentanaMesas extends VentanaReferencial implements ActionListener {

	private JPanel contentPane;
	private JButton btnAgregarMesa;
	private JPMesas jPmesas;

	public VentanaMesas(int x, int y) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jPmesas = new JPMesas();
		jPmesas.setToolTipText("Para modificar algun valor cliquee la casilla correspondiente");
		jPmesas.setBounds(123, 86, 771, 496);
		contentPane.add(jPmesas);

		btnAgregarMesa = new JButton("Agregar Mesa");
		btnAgregarMesa.setBounds(616, 634, 123, 25);
		contentPane.add(btnAgregarMesa);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(789, 634, 97, 25);
		contentPane.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

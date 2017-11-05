package gUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import iciresto.Login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JDLogin extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnIngresar;
	private Ventana ventanaPrincipal;

	public JDLogin(Ventana ventana, boolean b) {
		super(ventana, b);
		this.ventanaPrincipal = ventana;
		setResizable(false);
		setTitle("Login");
		setBounds(this.getParent().getX() + 600, this.getParent().getY() + 350, 325, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 2, 5, 40));
		{
			JLabel lblNewLabel = new JLabel("Usuario:");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:\r\n");
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			contentPanel.add(lblNewLabel_2);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			contentPanel.add(btnIngresar);
		}
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			Login login = new Login(textField.getText(), textField_1.getText());
			if (login.usuarioExiste()) {
				VentanaMesas ventanaMesas = new VentanaMesas(ventanaPrincipal.getX(),ventanaPrincipal.getY());
				ventanaMesas.setVisible(true);
				ventanaPrincipal.dispose();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "El Usuario no existe");
				this.textField.setText("");
				this.textField_1.setText("");
			}
		}
	}
}

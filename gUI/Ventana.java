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

import iciresto.Administrador;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnLogin;
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		this.setTitle("ICI-Resto");
		this.setResizable(false);
		
		JLabel lblIciresto = new JLabel("ICI-Resto");
		lblIciresto.setBounds(302, 310, 413, 113);
		lblIciresto.setFont(new Font("Arial Black", Font.PLAIN, 80));
		lblIciresto.setForeground(Color.RED);
		contentPane.add(lblIciresto);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(770, 632, 97, 25);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.RED);
		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnLogin==e.getSource()){
			JDLogin login = new JDLogin(this, true);
			login.setVisible(true);
		}
	}
}

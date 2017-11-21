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
		setBounds(100,0, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		this.setTitle("ICI-Resto");
		this.setResizable(false);
		
		JLabel lblIciresto = new JLabel("ICI-Resto");
		lblIciresto.setBounds(302, 310, 413, 113);
		lblIciresto.setFont(new Font("Arial Black", Font.PLAIN, 80));
		lblIciresto.setForeground(new Color(218, 165, 32));
		contentPane.add(lblIciresto);
		
		JLabel creators = new JLabel("C.Garay, B.Lebrecht, H.Sepulveda (2017)");
		creators.setBounds(360,436,500,100);
		creators.setFont(new Font("Arial Black", Font.PLAIN, 12));
		creators.setForeground(new Color(218, 165, 32));
		contentPane.add(creators);
		
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(770, 632, 97, 25);
		btnLogin.setForeground(new Color(120,20,40));
		btnLogin.setBackground(new Color(230, 200, 130));
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

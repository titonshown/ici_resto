package gUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Window.Type;

public class JDEstadoMesa extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public JDEstadoMesa() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 314, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblElijaElNuevo = new JLabel("Elija el nuevo estado de la mesa");
		lblElijaElNuevo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblElijaElNuevo.setBounds(25, 13, 269, 16);
		contentPanel.add(lblElijaElNuevo);
		
		JRadioButton rdbtnNoHabilitada = new JRadioButton("NO HABILITADA");
		rdbtnNoHabilitada.setBounds(48, 38, 127, 25);
		contentPanel.add(rdbtnNoHabilitada);
		
		JRadioButton rdbtnLibre = new JRadioButton("LIBRE");
		rdbtnLibre.setBounds(48, 68, 127, 25);
		contentPanel.add(rdbtnLibre);
		
		JRadioButton rdbtnAsignada = new JRadioButton("ASIGNADA");
		rdbtnAsignada.setBounds(48, 98, 127, 25);
		contentPanel.add(rdbtnAsignada);
		
		JRadioButton rdbtnAtendida = new JRadioButton("ATENDIDA");
		rdbtnAtendida.setBounds(48, 128, 127, 25);
		contentPanel.add(rdbtnAtendida);
		
		JRadioButton rdbtnReservada = new JRadioButton("RESERVADA");
		rdbtnReservada.setBounds(48, 155, 127, 25);
		contentPanel.add(rdbtnReservada);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

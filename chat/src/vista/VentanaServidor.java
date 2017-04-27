package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.PrincipalServidor;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VentanaServidor extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea txtArea;
	JButton btnIniciarServidor;


	/**
	 * Create the frame.
	 */
	public VentanaServidor() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Servidor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(this);
		contentPane.add(btnIniciarServidor, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnIniciarServidor)
		{
			PrincipalServidor.iniciarServidor();
		}
	}

}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.PrincipalCliente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VentanaCliente extends JFrame implements ActionListener{

	private JPanel contentPane;
	JScrollPane scrollPane;
	public static JTextArea txtArea;
	JButton btnConectar;
	String ip = "127.0.0.1";
	
	/**
	 * Create the frame.
	 */
	public VentanaCliente() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		contentPane.add(btnConectar, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConectar)
		{
			PrincipalCliente.iniciarCliente(ip);
		}
		
	}

}

package controlador;

import modelo.ConectorServidor;
import vista.VentanaServidor;

public class PrincipalServidor {
	
	public static ConectorServidor servidor;
	
	public static void main(String[] args) 
	{
		VentanaServidor ventanaServidor = new VentanaServidor();
		ventanaServidor.setVisible(true);
	}
	
	
	public static void iniciarServidor()
	{
		servidor = new ConectorServidor();
	}
	
	
	
	
	

}

package controlador;

import modelo.ConectorCliente;
import modelo.ConectorServidor;
import vista.VentanaCliente;
import vista.VentanaServidor;

public class PrincipalCliente {
	
	public static ConectorCliente cliente;
	
	public static void main(String[] args) 
	{
		cliente = new ConectorCliente("");
	}
	
	public static void iniciarCliente(String ip)
	{
		cliente = new ConectorCliente(ip);
	}
	

}

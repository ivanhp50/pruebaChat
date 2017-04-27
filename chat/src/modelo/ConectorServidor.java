package modelo;

import vista.VentanaServidor;
import java.net.*;
import java.io.*;

public class ConectorServidor extends Thread{
	
	private Socket socket;
	private ServerSocket serverSocket;
	private InputStreamReader entradaSocket;
	private BufferedReader entrada;
	final int puerto = 8000;
	
	/**
	 * 
	 */
	public ConectorServidor() 
	{
		try 
		{
			serverSocket = new ServerSocket(puerto);
			socket = serverSocket.accept();
			
			entradaSocket = new InputStreamReader(socket.getInputStream());
			entrada = new BufferedReader(entradaSocket);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}	
	}
		
	/**
	 * 
	 * @return
	 */
	public String leerMensaje()
	{
		try 
		{
			return entrada.readLine();
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	
	@Override
	public void run() 
	{
		String text = "test";
		try 
		{
			this.serverSocket = new ServerSocket(puerto);
			this.socket = serverSocket.accept();
			
			this.entradaSocket = new InputStreamReader (socket.getInputStream());
			this.entrada = new BufferedReader(entradaSocket);
			
			while(true)
			{
				text = this.entrada.readLine();
				System.out.println(text);
				VentanaServidor.txtArea.setText(VentanaServidor.txtArea.getText()+"\n"+text);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
}

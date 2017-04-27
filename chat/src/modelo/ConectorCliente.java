package modelo;

import java.net.*;

import vista.VentanaCliente;

import java.io.*;


public class ConectorCliente extends Thread{
	
	private Socket socket;
	private ServerSocket serverSocket;
	private InputStreamReader entradaSocket;
	private DataOutputStream salida;
	private BufferedReader entrada;
	final int puerto = 9000;
	
	/**
	 * 
	 * @param ip
	 */
	public ConectorCliente(String ip) 
	{
		try 
		{
			this.socket = new Socket(ip, this.puerto);
			
			this.entradaSocket = new InputStreamReader(socket.getInputStream());
			this.entrada = new BufferedReader(entradaSocket);
			
			this.salida = new DataOutputStream(socket.getOutputStream());
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param mensaje
	 */
	public void enviarMensaje(String mensaje) 
	{
		System.out.println("enviando");
		try 
		{
			this.salida = new DataOutputStream(socket.getOutputStream());
			this.salida.writeUTF(mensaje+"\n");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void desconectar()
	{
		try 
		{
			this.socket.close();
			this.serverSocket.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void run() 
	{
		String texto;
		while(true)
		{
			try 
			{
				texto = entrada.readLine();
				VentanaCliente.txtArea.setText(VentanaCliente.txtArea.getText()+"\n"+texto);
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	

}

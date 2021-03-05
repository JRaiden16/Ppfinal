/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import org.apache.xmlrpc.WebServer;

/**
 *
 * @author FAMILIA
 */
public class Server_Principal {
    public static void main(String[] args) {       
        try{        
	     System.out.println("Iniciando el servidor XML-RPC...");	     
	     WebServer server = new WebServer(5005);
	     Control_Server op = new Control_Server();
	     server.addHandler("miServidor", op);
	     server.start();
             op.Inicia_Servidores();
	     System.out.println("Inicio exitoso del Servidor, queda en espera de peticiones del cliente...");	     
	} 
        catch (Exception exception) {
	     System.err.println("Server: " + exception);
	}
    }
}
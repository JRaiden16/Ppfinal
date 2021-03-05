/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author FAMILIA
 */
public class Socket_Server {
   public void Iniciar() throws IOException {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor Sockets iniciado");
            String id="c1";
            while (true) {
                Socket clienteConectado = servidor.accept();
               
                ControClienteSocket clientesEntrantes = new ControClienteSocket(clienteConectado,id);
                Thread hilo = new Thread(clientesEntrantes);
                hilo.start();
            }
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

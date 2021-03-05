/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPC;

import org.apache.xmlrpc.WebServer;

/**
 *
 * @author FAMILIA
 */
public class Server_RPC {
   public void Iniciar(){
      try {

         System.out.println("Iniciando RPC Server...");
         //Declaracion del servidor y la clase Lugares donde se encuentran los metodos
         WebServer server = new WebServer(80);
         frameMatriz lg = new frameMatriz();
         server.addHandler("server", lg);
         //Inicio de servidor
         server.start();
         
      } catch (Exception exception){
         System.err.println("JavaServer: " + exception);
      }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.net.Socket;

/**
 *
 * @author FAMILIA
 */
public class ControClienteSocket extends Thread  {
    Socket clinteConectado;
    String id;
    
    public ControClienteSocket(Socket clinteConectado, String id) {
        this.clinteConectado = clinteConectado;
        this.id=id;
    }
    
    public void run() {
        
    }
    
}

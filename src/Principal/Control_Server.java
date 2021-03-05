/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import RMI.Server_RMI;
import RPC.Server_RPC;
import Socket.Socket_Server;
import java.io.IOException;

/**
 *
 * @author FAMILIA
 */
public class Control_Server {
    public String Seleccion(String id, String tipo) throws IOException{
        System.out.println("Cliente con id: "+ id+" conectandose a:"+tipo);
       return "Desconectado del servidor "+ tipo;
    }
    
    public void Inicia_Servidores() throws IOException {
        Socket_Server socSer = new Socket_Server();
        Server_RPC rcpSer = new Server_RPC();
        Server_RMI rmiSER = new Server_RMI();
        rcpSer.Iniciar();
        rmiSER.Iniciar();
        socSer.Iniciar();
    }
    
    public String Saludo(String id){
        System.out.println("Cliente con identificador :" + id + " conectado");
        return "Del siguiente menu escriba el numero de la opcion a conexion";
    }
}

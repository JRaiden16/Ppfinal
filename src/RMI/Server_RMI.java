/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author FAMILIA
 */
public class Server_RMI {
    public void Iniciar(){
        try{
            Registry reg = LocateRegistry.createRegistry(1235);
            reg.bind("Luagares", new matricesImp());
            System.out.println("Servidor RMI iniciado");
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author FAMILIA
 */
public class matricesImp extends java.rmi.server.UnicastRemoteObject 
implements matrices {
   public matricesImp() throws RemoteException {
        super();
       }
    
	public Vector<Integer> creaMatriz(int n) throws java.rmi.RemoteException{
		
		    int tamanioMat = n;

	        //Creando Matriz
	        int matriz[][] = new int[tamanioMat][tamanioMat];
	        Vector<Integer> arreglo = new Vector<Integer>();
	        
	        for (int i = 0; i < matriz.length; i++) 
	        { 
	            for (int j = 0; j < matriz.length; j++) 
	            {
	                int elemento = (int) (Math.random() * tamanioMat + 1);  
	                matriz[i][j] = elemento;
	                arreglo.add(elemento);
	            } 
	        }
	        return(arreglo);
	}
	

//    public boolean ciclo(String S){
//        String respuesta = S;
//        boolean bandera = false;
//        
//        if(respuesta.equals("SI")) {
//        	bandera = true;
//        }
//        return(bandera);
//    }
	
}
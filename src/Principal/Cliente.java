/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import RMI.frameMatriz;
import RMI.matrices;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

/**
 *
 * @author FAMILIA
 */
public class Cliente {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException, IOException, InterruptedException {
        XmlRpcClient cliente = new XmlRpcClient("http://localhost:80/");
        Vector<String> params = new Vector<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un identificador para el cliente");
        String id=sc.nextLine();
        params.add(id);
        Object result = null;
        String tipoConexion="";
        while (!tipoConexion.equalsIgnoreCase("salir")) {
            params.clear();
            params.add(id);
            result = cliente.execute("miServidor.Saludo", params);
            System.out.println(result);
            tipoConexion = Menu();
            params.add(tipoConexion);
            if(!tipoConexion.equals("salir")){
                result = cliente.execute("miServidor.Seleccion", params);
            }
            
            switch (tipoConexion) {
                case "Sockets":
                    Conexion_Sockets(id);
                    System.out.println(result);
                    break;
                case "RPC":
                    Conexion_RPC(id);
                    System.out.println(result);
                    break;
                case "RMI":
                    Conexion_RMI(id);
                    System.out.println(result);
                    break;
                default:
                    System.out.println("Secion terminada");
                    break;
            }
           
            
        }
        
    }
    
    public static void Conexion_Sockets(String id) throws IOException, InterruptedException{
        
    }
    
   public static void Conexion_RPC(String id){
       try {
			XmlRpcClient client = new XmlRpcClient("http://localhost:80/");

//			Vector params = new Vector();  //PRIMERO HAY QUE LEER EL PARAMETRO
//			params.addElement(new Integer(2));
			
			System.out.println("Conexión con el servidor establecida\"");
			System.out.println("\nIntroduzca un número entero para el tamaño de la matriz");

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
		
//			String id = sc.nextLine();
//			params.addElement(id);
//			Object result = client.execute("server.Saludo", params);
//			System.out.println(result.toString());

			Vector<Integer> params = new Vector<Integer>();
			params.addElement(n);
			
			Object oper = client.execute("operServer.creaMatriz", params);
			Vector<Integer> matrizCreada = (Vector<Integer>) oper;
			
            int tamanio = params.get(0);

	        frameMatriz tablero = new frameMatriz(tamanio, matrizCreada);
	        Dimension dmFrame = Toolkit.getDefaultToolkit().getScreenSize();
	        tablero.setLocation(dmFrame.width / 2 - tablero.getSize().width / 2, dmFrame.height / 2 - tablero.getSize().height / 2);
	        tablero.show(true);
			
//			while (sum.equals("SI")) {
//				params.addElement(id);
//				params.addElement(ms);
//
//				result = client.execute("server.Buscar", params);
//
//				sum = result.toString();
//				System.out.println(sum);
//
//			}
	        boolean banderaOtro = true;

			System.out.println("Desea crear otra matriz? SI/NO ");
			String resp = sc.nextLine();
			  
			while(resp.equals("SI")||resp.equals("si")) 
	 	    {
		        tablero.show(false);

				System.out.println("\nIntroduzca un número entero para el tamaño de la matriz");
				n = sc.nextInt();
				sc.nextLine();
				params = new Vector<Integer>();
				params.addElement(n);
				
				oper = client.execute("operServer.creaMatriz", params);
				matrizCreada = (Vector<Integer>) oper;
				
	            tamanio = params.get(0);

				 tablero = new frameMatriz(tamanio, matrizCreada);
			     dmFrame = Toolkit.getDefaultToolkit().getScreenSize();
			     tablero.setLocation(dmFrame.width / 2 - tablero.getSize().width / 2, dmFrame.height / 2 - tablero.getSize().height / 2);
			     tablero.show(true);
				
			    System.out.println("Desea crear otra matriz? SI/NO ");
				resp = sc.nextLine();
	 	    }

			System.out.println("Sesión Finalizada. Hasta luego!");
			tablero.show(false);
			sc.close();

		} catch (Exception exception) {
			System.err.println("Error en el Cliente: " + exception);
		}

	}
    

public static void Conexion_RMI(String id) throws RemoteException{
try {
     matrices mat = (matrices) Naming.lookup("rmi://localhost:1099/matricesSrv");
		 
		 	System.out.println("Conexión con el servidor establecida\"");
			System.out.println("\nIntroduzca un número entero para el tamaño de la matriz");
			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();
			sc.nextLine();
		
//			String id = sc.nextLine();
//			params.addElement(id);
//			Object result = client.execute("server.Saludo", params);
//			System.out.println(result.toString());

	        frameMatriz tablero = new frameMatriz(n, mat.creaMatriz(n));
	        Dimension dmFrame = Toolkit.getDefaultToolkit().getScreenSize();
	        tablero.setLocation(dmFrame.width / 2 - tablero.getSize().width / 2, dmFrame.height / 2 - tablero.getSize().height / 2);
	        tablero.show(true);
			
//			while (sum.equals("SI")) {
//				params.addElement(id);
//				params.addElement(ms);
//
//				result = client.execute("server.Buscar", params);
//
//				sum = result.toString();
//				System.out.println(sum);
//
//			}
			System.out.println("Desea crear otra matriz? SI/NO ");
			String resp = sc.nextLine();
			  
			while(resp.equals("SI")||resp.equals("si")) 
	 	    {
		        tablero.show(false);

				System.out.println("\nIntroduzca un número entero para el tamaño de la matriz");
				n = sc.nextInt();
				sc.nextLine();
				
//				params = new Vector<Integer>();
//				params.addElement(n);
//				oper = client.execute("operServer.creaMatriz", params);
//				matrizCreada = (Vector<Integer>) oper;
//	            tamanio = params.get(0);

				 tablero = new frameMatriz(n, mat.creaMatriz(n));
			     dmFrame = Toolkit.getDefaultToolkit().getScreenSize();
			     tablero.setLocation(dmFrame.width / 2 - tablero.getSize().width / 2, dmFrame.height / 2 - tablero.getSize().height / 2);
			     tablero.show(true);
				
			    System.out.println("Desea crear otra matriz? SI/NO ");
				resp = sc.nextLine();
	 	    }

			System.out.println("Sesión Finalizada. Hasta luego!");
			tablero.show(false);
			sc.close();
	} catch (Exception e) {
            
        }

}

public static String Menu() {
        System.out.println("1.- Sockets");
        System.out.println("2.- RPC");
        System.out.println("3.- RMI");
        System.out.println("4.- Salir");
        Scanner sc = new Scanner(System.in);
        
        String opcion = "";
        boolean comprueba = false;
        while (!comprueba) {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    opcion = "Sockets";
                    comprueba = true;
                    break;
                case 2:
                    opcion = "RPC";
                    comprueba = true;
                    break;
                case 3:
                    opcion = "RMI";
                    comprueba = true;
                    break;
                case 4:
                    opcion = "salir";
                    comprueba = true;
                    break;
                default:
                    System.out.println("Opcion no aceptada");
                    break;
            }
        }
        return opcion;
    }








}



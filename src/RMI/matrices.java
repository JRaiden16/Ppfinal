/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.util.Vector;

/**
 *
 * @author FAMILIA
 */
public interface matrices extends java.rmi.Remote {
    public Vector<Integer> creaMatriz(int n) throws java.rmi.RemoteException;
}

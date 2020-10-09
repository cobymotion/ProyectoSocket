package com.tecmm.proyectosocket;

import com.tecmm.proyectosocket.cliente.ManejadorCliente;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiscobian
 */
public class ServidorMain {
    
    public static void main(String[] args) {
        
        System.out.println("Iniciando el servidor");
        try { 
            ServerSocket server = new ServerSocket(5001);
            while(true)
            {
                Socket socket = server.accept(); 
                System.out.println("Se conecto un cliente");
                ManejadorCliente mc = new ManejadorCliente(socket);
                Thread hi = new Thread(mc); 
                hi.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecmm.proyectosocket.cliente;

import com.tecmm.proyectosocket.facade.PersonaServicio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.file.Files;

/**
 *
 * @author luiscobian
 */
public class ManejadorCliente implements Runnable {
    
    DataOutputStream output; 
    DataInputStream input; 
    
    public ManejadorCliente(Socket socket ){
        try{
        output = new DataOutputStream(socket.getOutputStream()); 
        input = new DataInputStream(socket.getInputStream()); 
        }catch(Exception e)
        {
            System.out.println("Fue imposible abrir los flujos");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if(output!=null && input!=null){
            try {
                while(true){
                    String msg = input.readUTF();
                    String response = PersonaServicio.mensaje(msg); 
                    output.writeUTF(response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}

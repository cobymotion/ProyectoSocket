package com.tecmm.proyectosocket.facade;

import com.tecmm.proyectosocket.db.controller.DaoPersonas;
import com.tecmm.proyectosocket.db.model.Personas;
import java.util.List;

/**
 *
 * @author luiscobian
 */
public class PersonaServicio {
    
    // agregar$nombre$correo
    // recibir$filtro
    
    public static String mensaje(String msg){
        String partes[] = msg.split("\\$");
        String response = ""; 
        switch(partes[0]){
            case "agregar": 
                response = addPersona(partes[1], partes[2]);
                break; 
            case "recibir":
                response = getDatos(); 
                break;
            default:
                System.out.println("Invalido");
        }
        return response;
    }
    
    private static String addPersona(String nombre, String correo){
        Personas p = new Personas(); 
        p.setNombre(nombre);
        p.setCorreo(correo);
        boolean res = new DaoPersonas().addPersona(p); 
        return String.valueOf(res);
    }
    
    // R1$id$nombre$correo#R2$.......
    private static String getDatos(){
        List<Personas> datos = new DaoPersonas().getTodos(); 
        String datosString = ""; 
        
        int num=1; 
        for(Personas p: datos){     
            datosString= datosString + "R" + num + "$"+ p.getId()+"$"+p.getNombre()+"$"+p.getCorreo()+"#"; 
            num = num +1; 
        }
        return datosString; 
    }
    
}

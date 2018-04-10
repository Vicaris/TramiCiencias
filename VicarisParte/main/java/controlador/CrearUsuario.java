/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import modelo.*;
import lombok.*;

/**
 *
 * @author dixego
 */
@ViewScoped
@ManagedBean
public class CrearUsuario {
    @Getter @Setter private String correo;
    @Getter @Setter private String nombreUsuario;
    @Getter @Setter private Date fechaNacimiento;
    @Getter @Setter private boolean esAdmin;
    @Getter @Setter private String contrasena;
      
    public void crearUsuario() {
        Usuario u = Usuario.builder().correo(correo)
                .nombreUsuario(nombreUsuario)
                .fechaNacimiento(fechaNacimiento)
                .esAdmin(esAdmin)
                .contrasena(contrasena).build();
        UsuarioDAO udao = new UsuarioDAO();
        udao.guardar(u);
    }
    
}

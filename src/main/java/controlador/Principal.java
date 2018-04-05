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
import java.util.List;


/**
 *
 * @author vicaris
 */
@ViewScoped
@ManagedBean
public class Principal {
    @Getter @Setter private String busqueda;
    @Getter @Setter private List<Pregunta> preguntas;
    
    PreguntaDAO pdao = new PreguntaDAO();
    
    public String buscarPregunta(){
      preguntas = pdao.buscar(busqueda);
      return "resultadosbusqueda?faces-redirect=true";
    }
    
    public Pregunta visitar(int id){
      
      return null;
    }
    
    
    
    
}

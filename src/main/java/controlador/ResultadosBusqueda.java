/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author vicaris
 */
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import modelo.*;
import lombok.*;

@ViewScoped
@ManagedBean
public class ResultadosBusqueda {
    
    @Getter @Setter private String busqueda;
    @Getter @Setter private List<Pregunta> preguntas;
    @Getter @Setter private Pregunta preguntaEncontrada;
    
    PreguntaDAO pdao = new PreguntaDAO();
   
    public String visitar(int id){
      preguntaEncontrada = pdao.buscar(id);
      return "pregunta?pr="+preguntaEncontrada;
    }
    
    public String buscarPregunta(){
      preguntas = pdao.buscar(busqueda);
      return "resultadosbusqueda?bus="+busqueda+"?prgs="+preguntas;
    }
}

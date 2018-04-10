package modelo;
// Generated mar 20, 2018 3:48:40 p.m. by Hibernate Tools 4.3.1



/**
 * Pregunta generated by hbm2java
 */
public class Pregunta  implements java.io.Serializable {


     private int idPregunta;
     private String correoUsuario;
     private String texto;
     private String titulo;

    public Pregunta() {
    }
    
    public Pregunta(int idPregunta, String correoUsuario, String texto, String titulo) {
       this.idPregunta = idPregunta;
       this.correoUsuario = correoUsuario;
       this.texto = texto;
       this.titulo = titulo;
    }
   
    public int getIdPregunta() {
        return this.idPregunta;
    }
    
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




}



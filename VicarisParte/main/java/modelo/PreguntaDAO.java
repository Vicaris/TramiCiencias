/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vicaris
 */
public class PreguntaDAO {
    SessionFactory sf;
    
    public PreguntaDAO() {
        this.sf = HibernateUtil.getSessionFactory();
    }
    
    public List<Pregunta> buscar(String abuscar){
      List<Pregunta> result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql;
            hql = "from Pregunta\n"+"where titulo like '%"+abuscar+"%'";
            Query query = session.createQuery(hql);
            result = (List<Pregunta>)query.list();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }
    
    public Pregunta buscar(int id){
       Pregunta result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql = "from Pregunta where idPregunta="+id;
            Query query = session.createQuery(hql);
            result = (Pregunta) query.list().get(0);
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }
    
     public List<Pregunta> verPreguntas(){
      List<Pregunta> result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql;
            hql = "from Pregunta";
            Query query = session.createQuery(hql);
            result = (List<Pregunta>)query.list();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }
    
    
    public void guardar(Pregunta p){
        Session s = sf.openSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.persist(p);
            tx.commit();
        } catch(Exception ex) {
            if (tx != null)
                tx.rollback();
            ex.printStackTrace();
        } finally {
            s.close();
        }
    }
    
    public void borrar(Pregunta p){
        Session s = sf.openSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.delete(p);
            tx.commit();
        } catch(Exception ex) {
            if (tx != null)
                tx.rollback();
            ex.printStackTrace();
        } finally {
            s.close();
        }
    }
}

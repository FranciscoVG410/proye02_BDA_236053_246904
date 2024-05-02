/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import EntidadesJPA.EntidadLicencia;
import EntidadesJPA.EntidadPersona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
public class LicenciaDAO {

    public EntidadLicencia obtenerPorPersona(Long idPersona) throws Exception {

        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT l FROM EntidadLicencia l WHERE l.persona.id= :idPersona ORDER BY l.tramite.id DESC";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", idPersona);
        List<EntidadLicencia> licencia = (List<EntidadLicencia>) query.getResultList();
        
        if (idPersona == null) {
            throw new Exception("No se encontró la persona con el rfc establecido, favor de revisar que la informacion este correcta ");
        }
        if(licencia.size() > 0){
        return licencia.get(0);
        }else{
        return null;
        }
    }

    public EntidadLicencia obtenerPorInfo(Long id) throws Exception {

        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        EntidadLicencia licencia = em.find(EntidadLicencia.class, id);
        if (licencia == null) {
            throw new Exception("No se encontró la licencia con la informacion establecida, favor de revisar que la informacion este correcta ");
        }
        return licencia;
    }

    public void crearLicencia(EntidadLicencia licencia, EntidadPersona p) {
        try {
            // Creamos el entity manager factory.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
            // Creamos el entity manager.
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            EntidadLicencia rec = obtenerPorPersona(p.getId());
            rec.setEstado(false);
            em.merge(p);
            em.merge(rec);
            em.getTransaction().commit();
            //System.out.println(filasAct);
        } catch (Exception ex) {
            Logger.getLogger(LicenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(licencia);

        em.getTransaction().commit();
        em.refresh(licencia);

        em.close();
        emf.close();

    }
    
    public static List<EntidadLicencia> obtenerLicenciasPorPersona(Long id) throws Exception {
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "SELECT l FROM EntidadLicencia l WHERE l.persona.id= :idPersona ORDER BY l.tramite.id DESC";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", id);
        List<EntidadLicencia> licencias = (List<EntidadLicencia>) query.getResultList();
        if(licencias.size() > 0){
        return licencias;
        }else{
            throw new Exception("No se encontraron licencias a nombre de esta persona");
        }
    }
}

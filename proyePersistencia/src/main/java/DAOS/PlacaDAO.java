/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import EntidadesJPA.EntidadPersona;
import EntidadesJPA.EntidadPlaca;
import EntidadesJPA.EntidadVehiculo;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
public class PlacaDAO {

    public static EntidadPlaca obtenerPlacasPorVehiculo(EntidadVehiculo vehiculo_ent) {
         // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "SELECT pl FROM EntidadPlaca pl WHERE pl.persona.id= :idPersona AND pl.vehiculo.serie = :serie ORDER BY pl.tramite.id DESC";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", vehiculo_ent.getPersona().getId());
        query.setParameter("serie", vehiculo_ent.getSerie());

        List<EntidadPlaca> placas = (List<EntidadPlaca>) query.getResultList();
        if(placas.size() > 0){
        return placas.get(0);
        }else{
            return null;
        }
        
    }

    public static List<EntidadPlaca> obtenerPlacasPorPersona(Long id) throws Exception {
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "SELECT pl FROM EntidadPlaca pl WHERE pl.persona.id= :idPersona ORDER BY pl.tramite.id DESC";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", id);
        List<EntidadPlaca> placas = (List<EntidadPlaca>) query.getResultList();
        if(placas.size() > 0){
        return placas;
        }else{
            throw new Exception("No se encontraron placas a nombre de esta persona");
        }
    }
    public EntidadPlaca obtenerPorPersona(Long idPersona) throws Exception {

        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "SELECT pl FROM EntidadPlaca pl WHERE pl.persona.id= :idPersona ORDER BY pl.tramite.id DESC";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", idPersona);
        List<EntidadPlaca> licencia = (List<EntidadPlaca>) query.getResultList();

        if (idPersona == null) {
            throw new Exception("No se encontró la persona con el rfc establecido, favor de revisar que la informacion este correcta ");
        }

        EntidadPlaca ultimaPlaca = licencia.get(0);

        return ultimaPlaca;
    }

    
    public EntidadPlaca obtenerPorPlaca(String placa) throws Exception {
        
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        
        EntidadPlaca placas = em.find(EntidadPlaca.class, placa);
        
        if (placas == null) {
            throw new Exception("No se encontró la placa establecida, favor de revisar que sea la correcta");
        }
        
        return placas;
    }
    
    public void crearPlaca(EntidadPlaca placa, EntidadPersona p) {
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Date hoy = new Date();
        placa.setFechaTramite(hoy.toString());
        placa.setPersona(p);
        //placa.setEstadoPlaca(true);
        placa.getVehiculo().setPersona(p);
        EntidadPlaca obtenida = obtenerPlacasPorVehiculo(placa.getVehiculo());
        if(obtenida == null){
             placa.setPrecioPlaca(1500f);
             
        }else{
            placa.setPrecioPlaca(1000f);
            obtenida.setEstadoPlaca(false);
            EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("ConexionJPA");
            // Creamos el entity manager.
            EntityManager em1 = emf1.createEntityManager();
            em1.getTransaction().begin();
            em1.merge(obtenida);
            em1.getTransaction().commit();
            
            em1.close();
            emf1.close();
        }
        em.persist(placa);
        
        em.getTransaction().commit();
        em.refresh(placa);

        em.close();
        emf.close();
    }
}

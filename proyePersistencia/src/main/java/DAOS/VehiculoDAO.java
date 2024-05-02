/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import EntidadesJPA.EntidadVehiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
public class VehiculoDAO {
    public EntidadVehiculo obtenerPorPersona(EntidadVehiculo v) throws Exception {
        EntidadVehiculo vehiculo; 
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT v FROM EntidadVehiculo v WHERE v.persona.id = :idPersona AND v.serie = :serie";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", v.getPersona().getId());
        query.setParameter("serie", v.getSerie());
        try{
            vehiculo = (EntidadVehiculo) query.getSingleResult();
        }catch(NoResultException ex){
            vehiculo = null;
        }

        return vehiculo;
    }

    
    public EntidadVehiculo obtenerPorTipo(String tipo) throws Exception {
        
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        
        EntidadVehiculo placas = em.find(EntidadVehiculo.class, tipo);
        
        if (placas == null) {
            throw new Exception("No se encontró la placa establecida, favor de revisar que sea la correcta");
        }
        
        return placas;
    }
    public void crearVehiculo(EntidadVehiculo v){
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(v);

        em.getTransaction().commit();
        em.refresh(v);

        em.close();
        emf.close();

    }
}

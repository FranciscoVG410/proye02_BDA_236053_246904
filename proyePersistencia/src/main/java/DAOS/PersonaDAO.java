/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import EntidadesJPA.EntidadPersona;
import EntidadesJPA.EntidadTramite;
import EntidadesJPA.EntidadVehiculo;
import java.util.List;
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
public class PersonaDAO {

        public static List<EntidadVehiculo> obtenerListaVehiculos(EntidadPersona persona_entidad) throws Exception {
        List<EntidadVehiculo> obtenidos;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpqlQuery = "SELECT v FROM EntidadVehiculo v WHERE v.persona.id = :idPersona";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("idPersona", persona_entidad.getId());
        obtenidos = (List<EntidadVehiculo>) query.getResultList();
        if (obtenidos.size() > 0) {
            return obtenidos;
        } else {
            throw new Exception("La persona no tiene ningún vehículo al cual generarle placas");
        }
    }

    public EntidadPersona obtenerPorRFC(String rfc) throws Exception {
        EntidadPersona persona;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpqlQuery = "SELECT p FROM EntidadPersona p WHERE p.rfc = :rfc";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("rfc", rfc);
        try {
            persona = (EntidadPersona)query.getSingleResult();
        } catch(NoResultException ex) {
            throw new Exception("No se encontró la persona con el RFC establecido, favor de revisar que la información esté correcta");
        }
        return persona;
    }

    public List<EntidadPersona> obtenerPorNombresSimilares(String nombres) throws Exception {
        List<EntidadPersona> obtenidas;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpqlQuery = "SELECT p FROM EntidadPersona p WHERE p.nombres LIKE :nombre";
        Query query = em.createQuery(jpqlQuery, EntidadPersona.class);
        query.setParameter("nombre", "%" + nombres + "%");
        obtenidas = (List<EntidadPersona>) query.getResultList();
        if (obtenidas.size() > 0) {
            return obtenidas;
        } else {
            throw new Exception("No se encontraron coincidencias");
        }
    }

    public EntidadPersona obtenerPorDatos(String rfc, String nombres, String apellidoP, String apellidoM, String fechaNacimiento, Long tel, boolean discapacidad, List<EntidadVehiculo> info, List<EntidadTramite> infoTramite) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        EntidadPersona rfcPersona = em.find(EntidadPersona.class, rfc);
        EntidadPersona nombresPersona = em.find(EntidadPersona.class, nombres);
        EntidadPersona apellidoPPersona = em.find(EntidadPersona.class, apellidoP);
        EntidadPersona apellidoMPersona = em.find(EntidadPersona.class, apellidoM);
        EntidadPersona fechaNacimientoPersona = em.find(EntidadPersona.class, fechaNacimiento);
        EntidadPersona telefonoPersona = em.find(EntidadPersona.class, tel);
        EntidadPersona vehiculoPersona = em.find(EntidadPersona.class, apellidoP);
        EntidadPersona tramitePPersona = em.find(EntidadPersona.class, apellidoP);
        if (rfcPersona == null || nombresPersona == null || apellidoPPersona == null || apellidoMPersona == null || fechaNacimientoPersona == null || telefonoPersona == null || vehiculoPersona == null || tramitePPersona == null) {
            throw new Exception("No se encontró la persona con los datos establecidos, favor de revisar que la información esté correcta");
        }
        return rfcPersona;
    }

    public List<EntidadPersona> obtenerPorFechaNacimiento(String fecha) throws Exception {
        List<EntidadPersona> obtenidas;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpqlQuery = "SELECT p FROM EntidadPersona p WHERE p.fechaNacimiento LIKE :fecha";
        Query query = em.createQuery(jpqlQuery, EntidadPersona.class);
        query.setParameter("fecha", "%" + fecha + "%");
        obtenidas = (List<EntidadPersona>) query.getResultList();
        if (obtenidas.size() > 0) {
            return obtenidas;
        } else {
            throw new Exception("No se encontraron coincidencias");
        }
    }
}

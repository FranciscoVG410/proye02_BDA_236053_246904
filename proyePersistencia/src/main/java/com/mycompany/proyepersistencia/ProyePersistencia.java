/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyepersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
public class ProyePersistencia {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = null;
        EntityManager entityManager = null;
        try {
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (managerFactory != null) {
                managerFactory.close();
            }
        }
    }
}

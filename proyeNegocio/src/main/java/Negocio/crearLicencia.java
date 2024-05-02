/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.LicenciaDAO;
import DTO.LicenciaDTO;
import EntidadesJPA.EntidadLicencia;
import EntidadesJPA.EntidadPersona;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class crearLicencia {
    LicenciaDAO licenciaDAO = new LicenciaDAO();
    public void crearLicencia(LicenciaDTO licenciaDTO, EntidadPersona p){
        EntidadLicencia crearLicencia = convertirLicenciaDTO(licenciaDTO);
        licenciaDAO.crearLicencia(crearLicencia, p);
    }
    
    public EntidadLicencia convertirLicenciaDTO(LicenciaDTO licenciaDTO) {
        EntidadLicencia entidadLicencia = new EntidadLicencia(
        licenciaDTO.getTramite(),
        licenciaDTO.getVigencia(),
        licenciaDTO.getCosto(),
        licenciaDTO.isEstado());
        return entidadLicencia;
    }
}

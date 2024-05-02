/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.LicenciaDAO;
import DTO.LicenciaDTO;
import EntidadesJPA.EntidadLicencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class ObtenerLicencia {
    LicenciaDAO licenciaDAO = new LicenciaDAO();
    public LicenciaDTO obtenerPorPersona(Long idPersona) throws Exception {
        try {
            if (idPersona<1) {
                throw new Exception("El id no puede ser menor o igual a 0");
            }
            EntidadLicencia licenciaEntidad = licenciaDAO.obtenerPorPersona(idPersona);
            if(licenciaEntidad != null){
            LicenciaDTO licenciaDTO = convertirLicenciaEntidad(licenciaEntidad);
            return licenciaDTO;
            }else{
            return null;
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<LicenciaDTO> obtenerLicenciasPorPersona(Long id) throws Exception{
        List<EntidadLicencia> lista_licencias;
        try{
                lista_licencias = LicenciaDAO.obtenerLicenciasPorPersona(id);
                List<LicenciaDTO> licenciaDTO = new ArrayList<>();
                for (EntidadLicencia lic : lista_licencias) {
                   licenciaDTO.add(convertirLicenciaEntidad(lic));
                }
                return licenciaDTO;
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public LicenciaDTO convertirLicenciaEntidad(EntidadLicencia licenciaEntidad) {
        LicenciaDTO LicenciaDTO = new LicenciaDTO(
                licenciaEntidad.getTramite(),
                licenciaEntidad.getVigencia(), 
                licenciaEntidad.getCosto(),
                licenciaEntidad.isEstado(),
                licenciaEntidad.getFechaVencimiento());
                licenciaEntidad.setId(licenciaEntidad.getId());
        return LicenciaDTO;
    }
}

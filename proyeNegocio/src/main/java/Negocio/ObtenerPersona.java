/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.PersonaDAO;
import DTO.PersonaDTO;
import EntidadesJPA.EntidadPersona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
public class ObtenerPersona {
    PersonaDAO personaDAO = new PersonaDAO();
    
    public PersonaDTO obtenerPersona(String rfc) throws Exception {
        try {
            if (rfc.isEmpty()) {
                throw new Exception("El RFC no puede estar vacio");
            }
            EntidadPersona personaEntidad = personaDAO.obtenerPorRFC(rfc);
            PersonaDTO personaDTO = convertirPersonaEntidad(personaEntidad);
            return personaDTO;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<PersonaDTO> obtenerPorNombresSimilares(String nombres) throws Exception{
        try{
            if(nombres.isBlank()){
                throw new Exception("El campo no puede estar vacio");
            }
            List<EntidadPersona> listaObtenidas = personaDAO.obtenerPorNombresSimilares(nombres);
            List<PersonaDTO> listaDTOs = new ArrayList<>();
            for (EntidadPersona p : listaObtenidas) {
                listaDTOs.add(convertirPersonaEntidad(p));
            }
          return listaDTOs;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    
    }
    
    public List<PersonaDTO> obtenerPorFechaNacimiento(String fecha) throws Exception{
        try{
            if(fecha.isBlank()){
                throw new Exception("El campo no puede estar vacio");
            }
            List<EntidadPersona> listaObtenidas = personaDAO.obtenerPorFechaNacimiento(fecha);
            List<PersonaDTO> listaDTOs = new ArrayList<>();
            for (EntidadPersona p : listaObtenidas) {
                listaDTOs.add(convertirPersonaEntidad(p));
            }
          return listaDTOs;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    
    }
    
    public PersonaDTO convertirPersonaEntidad(EntidadPersona personaEntidad) {
        PersonaDTO personaDTO = new PersonaDTO(
                personaEntidad.getId(),
                personaEntidad.getRfc(),
                personaEntidad.getNombres(),
                personaEntidad.getApellidoP(),
                personaEntidad.getApellidoM(),
                String.valueOf(personaEntidad.getFechaNacimiento()),
                personaEntidad.getTel(),
                personaEntidad.isDiscapacidad(),
                personaEntidad.getInfo(),
                personaEntidad.getInfoTramite());
        personaEntidad.setId(personaEntidad.getId());
        return personaDTO;
    }
}

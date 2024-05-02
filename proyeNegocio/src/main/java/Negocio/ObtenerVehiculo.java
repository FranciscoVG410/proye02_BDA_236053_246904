/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.PersonaDAO;
import DAOS.VehiculoDAO;
import DTO.PersonaDTO;
import DTO.VehiculoDTO;
import EntidadesJPA.EntidadPersona;
import EntidadesJPA.EntidadVehiculo;
import java.util.List;

/**
 *
 * @author franc
 */
public class ObtenerVehiculo {
    VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public EntidadVehiculo convertirVehiculoEntidad(VehiculoDTO vehiculo) {
        EntidadVehiculo vehiculoDTO = new EntidadVehiculo(
                vehiculo.getSerie(),
                vehiculo.getPersona()
                );
        return vehiculoDTO;
    }

    public EntidadVehiculo obtenerVehiculo(VehiculoDTO vehiculo) throws Exception {
        EntidadVehiculo vehiculoEntidad;
        try {
            if(vehiculo.getSerie().isBlank()){
              throw new Exception("Ingresa un numero de serie valido");

            }else{
            if (vehiculo.getPersona().getId() < 1) {
                throw new Exception("El id no puede ser menor o igual a 0");
            }else{
                EntidadVehiculo vehiculoEnt = convertirVehiculoEntidad(vehiculo);
                vehiculoEntidad = vehiculoDAO.obtenerPorPersona(vehiculoEnt);
            
            }
            }
          return vehiculoEntidad;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<EntidadVehiculo> obtenerListaPorPersona(PersonaDTO p) throws Exception{
        List<EntidadVehiculo> lista_vehiculos;
        
        try{
            if(p.getId()<1){
                throw new Exception("El id no puede ser menor o igual a 0");
            }else{
                EntidadPersona persona_entidad = convertirPersonaEntidad(p);
                lista_vehiculos = PersonaDAO.obtenerListaVehiculos(persona_entidad);
            }
            return lista_vehiculos;
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        
       
    }
    
    public EntidadPersona convertirPersonaEntidad(PersonaDTO persona) {
        EntidadPersona personaEnt = new EntidadPersona(
                persona.getId());
        return personaEnt;
    }


}

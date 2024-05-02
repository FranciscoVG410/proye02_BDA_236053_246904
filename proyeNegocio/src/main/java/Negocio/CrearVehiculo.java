/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.VehiculoDAO;
import DTO.VehiculoDTO;
import EntidadesJPA.EntidadVehiculo;

/**
 *
 * @author franc
 */
public class CrearVehiculo {
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    public void crearVehiculo(VehiculoDTO vehiculoDTO){
        // Agregar validaciones aqui
        //
        EntidadVehiculo crearVehiculo = convertirVehiculoDTO(vehiculoDTO);
        vehiculoDAO.crearVehiculo(crearVehiculo);
        
        
    }
   
    public EntidadVehiculo convertirVehiculoDTO(VehiculoDTO vehiculoDTO) {
    EntidadVehiculo entidadVehiculo = new EntidadVehiculo(
    vehiculoDTO.getSerie(),
    vehiculoDTO.getColor(),
    vehiculoDTO.getMarca(),
    vehiculoDTO.getModelo(),
    vehiculoDTO.isNuevo(),
    vehiculoDTO.getTipo(),
    vehiculoDTO.getPersona());
    return entidadVehiculo;
   }
}

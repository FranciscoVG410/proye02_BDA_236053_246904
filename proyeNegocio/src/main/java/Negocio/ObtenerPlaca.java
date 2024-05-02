/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.PlacaDAO;
import DTO.PlacaDTO;
import DTO.VehiculoDTO;
import EntidadesJPA.EntidadPlaca;
import EntidadesJPA.EntidadVehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class ObtenerPlaca {
    public EntidadPlaca obtenerPlacasPorVehiculo(VehiculoDTO vehiculo) throws Exception{
        EntidadPlaca lista_placas;
        try{
                EntidadVehiculo vehiculo_ent = convertirPlacaEntidad(vehiculo);
                lista_placas = PlacaDAO.obtenerPlacasPorVehiculo(vehiculo_ent);
                return lista_placas;
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }
    
    public List<PlacaDTO> obtenerPlacasPorPersona(Long id) throws Exception{
        List<EntidadPlaca> lista_placas;
        try{
                lista_placas = PlacaDAO.obtenerPlacasPorPersona(id);
                List<PlacaDTO> placasDTO = new ArrayList<>();
                for (EntidadPlaca placa : lista_placas) {
                   placasDTO.add(convertirPlacaDTO(placa));
                }
                return placasDTO;

        //return lista_placas;
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
        
    private EntidadVehiculo convertirPlacaEntidad(VehiculoDTO vehiculo) {
        EntidadVehiculo vehi = new EntidadVehiculo(
                vehiculo.getSerie(),
                vehiculo.getPersona()
        );
        return vehi;
    }
    
     private PlacaDTO convertirPlacaDTO(EntidadPlaca placa) {
        PlacaDTO vehi = new PlacaDTO(
                placa.getPlaca(),
                placa.getPrecioPlaca(),
                placa.getEstadoPlaca()
        );
        return vehi;
    }
    
    
    }


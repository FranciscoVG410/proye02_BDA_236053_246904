/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.PlacaDAO;
import DTO.PlacaDTO;
import EntidadesJPA.EntidadPersona;
import EntidadesJPA.EntidadPlaca;
import EntidadesJPA.EntidadTramite;
import java.util.Date;

/**
 *
 * @author franc
 */
public class CrearPlaca {
    PlacaDAO placaDAO = new PlacaDAO();
    EntidadPersona p;
    public void crearPlaca(PlacaDTO placaDTO, EntidadPersona p){
        EntidadPlaca crearPlaca = convertirPlacaDTO(placaDTO, p);
        placaDAO.crearPlaca(crearPlaca, p);
    }
    
        public EntidadPlaca convertirPlacaDTO(PlacaDTO placaDTO, EntidadPersona p) {
        EntidadTramite tramite = new EntidadTramite(
                new Date().toString(),
                p,
                1
        );
        EntidadPlaca entidadPlaca= new EntidadPlaca(
        tramite,
        placaDTO.getPlaca(),
        true,
        0.0f,
        placaDTO.getVehiculo());
        return entidadPlaca;
    }
}

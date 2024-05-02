/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOS.TramiteDAO;
import DTO.TramiteDTO;
import EntidadesJPA.EntidadTramite;

/**
 *
 * @author franc
 */
public class CrearTramite {
    public EntidadTramite convertirTramiteDTO(TramiteDTO tramiteDTO) {
    
    EntidadTramite entidadTramite = new EntidadTramite(
        7L,
        tramiteDTO.getFechaTramite(),
        tramiteDTO.getPersona());
        return entidadTramite;
    }

    
}

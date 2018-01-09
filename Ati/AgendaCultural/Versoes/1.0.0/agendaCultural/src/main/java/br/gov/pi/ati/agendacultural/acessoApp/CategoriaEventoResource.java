/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp;

import br.gov.pi.ati.agendacultural.bo.eventos.CategoriaEventoBO;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juniel
 */
@Path("/categoriaEvento")
public class CategoriaEventoResource {

    @EJB
    private CategoriaEventoBO tipoBO;

    @Path("listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaEvento> listarAtivas() {
        List<CategoriaEvento> categoriasTemp = tipoBO.getDAO().list("ativo", true, "descricao");
        return categoriasTemp;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp;

import br.gov.pi.ati.adapi.bo.cadastro.SinalClinicoBO;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;
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
@Path("/sinaisClinicos")
public class SinalClinicoResource {

    @EJB
    private SinalClinicoBO sinalBO;

    @Path("listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SinalClinico> listarAnimaisAtivos() {
        return sinalBO.getDAO().list("ativo", true, "id");
    }

}

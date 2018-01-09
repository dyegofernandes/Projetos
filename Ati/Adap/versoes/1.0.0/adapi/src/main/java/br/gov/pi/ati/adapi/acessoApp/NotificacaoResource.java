/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp;

import br.gov.pi.ati.adapi.acessoApp.vos.NotificacaoVO;
import br.gov.pi.ati.adapi.acessoApp.vos.SinalClinicoVO;
import br.gov.pi.ati.adapi.bo.cadastro.SinalClinicoBO;
import br.gov.pi.ati.adapi.bo.notificacao.NotificacaoBO;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juniel
 */
@Path("/notificacao")
public class NotificacaoResource {

    @EJB
    private NotificacaoBO notificacaoBO;

    @EJB
    private SinalClinicoBO sinalClinicoBO;

    @POST
    @Path("salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(final String json) {
        Gson gson = new Gson();
        NotificacaoVO notificacaoVO = gson.fromJson(json, NotificacaoVO.class);

        System.out.println("Anonimo: " + notificacaoVO.getAnonimo());

        System.out.println("------------ Sinais Clinicos: -------------");
        for (SinalClinicoVO sinal : notificacaoVO.getSinaisClinicos()) {
            System.out.println("Código sinal: " + sinal.getId());
        }

        return Response.status(200).entity("Denúncia realizada com Sucesso!").header("CustomHeader", "CustomValue").build();
    }

}

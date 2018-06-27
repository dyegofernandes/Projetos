/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.webservices.app;

import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.util.Utils;
import com.google.gson.Gson;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Juniel
 */
@Path("/pedido")
public class PedidoResource {

    @EJB
    private PedidoBO pedidoBO;

    @POST
    @Path("confirmarPresenca")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmarPedido(final String json) {
        Gson gson = new Gson();
        FiltroPedido filtros = gson.fromJson(json, FiltroPedido.class);

        Pedido pedidoTemp = pedidoBO.pedidoPeloCNPJouCpfEPedido(filtros.getPedidoID(), filtros.getCnpjCpf());

        try {

            if (pedidoTemp != null) {
//                if (pedidoTemp.getInicioAtendimento() == null) {
//                    pedidoTemp.setInicioAtendimento(new Date());
//                }
//                pedidoBO.getDAO().saveOrMerge(pedidoTemp);

                return Response.status(200).entity("Presença confirmada! Aguarde ser chamado!").header("CustomHeader", "CustomValue").build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }

        } catch (Exception e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @Path("buscaPorProtocolo/{protocolo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response pedidoExiste(@PathParam("protocolo") String protocolo) {
        Gson gson = new Gson();

        FiltroPedido filtros = gson.fromJson(protocolo, FiltroPedido.class);

        if (!Utils.isNullOrEmpty(filtros.getProtocolo())) {
            Pedido pedidoTemp = pedidoBO.pedidoPeloProtocolo(filtros.getProtocolo());

            if (pedidoTemp != null) {
                String pedidoJson = "{id:".concat(pedidoTemp.getId().toString().concat("}"));
                return Response.status(Status.OK).entity(pedidoJson).build();
            }
        }
        return Response.status(Status.NOT_FOUND).build();
    }

}

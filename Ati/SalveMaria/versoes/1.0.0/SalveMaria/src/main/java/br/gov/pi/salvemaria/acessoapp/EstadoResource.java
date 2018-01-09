/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.EstadoBO;
import br.gov.pi.salvemaria.dao.cadastro.EstadoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
import br.gov.pi.salvemaria.modelo.vos.EstadoVO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juniel
 */
@Path("/estado")
public class EstadoResource {

    @EJB
    private EstadoBO estadoBO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EstadoVO pegaEstadoPeloId(@PathParam("id") Long id) {

        EstadoVO estadoVO = new EstadoVO();

        Estado estado = estadoBO.getDAO().unique("id", id);
        if (estado != null) {
            estadoVO.setId(estado.getId());
            estadoVO.setNome(estado.getNome());
            estadoVO.setSigla(estado.getSigla());
        }

        return estadoVO;
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EstadoVO> listarEstados() {
        List<Estado> estados = estadoBO.listarEstados(null, null);
        List<EstadoVO> listaEstadoVO = new ArrayList<EstadoVO>();

        for (Estado estado : estados) {
            EstadoVO estadoVO = new EstadoVO();
            estadoVO.setId(estado.getId());
            estadoVO.setNome(estado.getNome());
            estadoVO.setSigla(estado.getSigla());

            listaEstadoVO.add(estadoVO);
        }

        return listaEstadoVO;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.vos.CidadeVO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juniel
 */
@Path("/cidade")
public class CidadeResource {

    @EJB
    private CidadeBO cidadeBO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CidadeVO pegaCidadePeloId(@PathParam("id") Long id) {
        CidadeVO cidadeVO = new CidadeVO();

        Cidade cidade = cidadeBO.getDAO().unique("id", id);
        
        if (cidade != null) {
            cidadeVO.setId(cidade.getId());
            cidadeVO.setNome(cidade.getNome());
        }

        return cidadeVO;

    }

    @Path("listar/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CidadeVO> listarCidadePeloIdEstado(@PathParam("id") Long idEstado) {
        List<CidadeVO> cidadesVO = new ArrayList<CidadeVO>();
        List<Cidade> cidades = cidadeBO.getDAO().list("estado_id", idEstado, "nome");

        for (Cidade cidade : cidades) {
            CidadeVO cidadeVO = new CidadeVO();
            cidadeVO.setId(cidade.getId());
            cidadeVO.setNome(cidade.getNome());
            cidadesVO.add(cidadeVO);
        }

        return cidadesVO;
    }

}

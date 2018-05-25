/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.vos.CidadeVO;
import com.google.gson.Gson;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

    @Path("listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CidadeVO> listar(final String json) {
        Gson gson = new Gson();
        Filtros filtrosDeBusca = gson.fromJson(json, Filtros.class);

        Restrictions restrictions = new Restrictions();

        if (filtrosDeBusca.getCidade_id() != null) {
            restrictions.add("cidade.id", filtrosDeBusca.getCidade_id());
        }

        List<CidadeVO> cidadesVO = new ArrayList<CidadeVO>();
        List<Cidade> cidades = cidadeBO.getDAO().getQueryBuilder().from(Cidade.class, "cidade").leftJoinFetch("cidade.estado", "estado").add(restrictions)
                .orderBy("estado, cidade.nome").getResultList();

        for (Cidade cidade : cidades) {
            CidadeVO cidadeVO = new CidadeVO();
            cidadeVO.setId(cidade.getId());
            cidadeVO.setNome(cidade.getNome());
            cidadesVO.add(cidadeVO);
        }

        return cidadesVO;
    }

}

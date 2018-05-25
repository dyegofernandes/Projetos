/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.vos.UnidadeVO;
import com.google.gson.Gson;
import com.xpert.persistence.query.Restrictions;
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
@Path("/unidade")
public class UnidadeResource {

    @EJB
    private UnidadeBO unidadeBO;

    @Path("listar/{filtros}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UnidadeVO> listar(@PathParam("filtros") String filtros) {
        Gson gson = new Gson();
        Filtros filtrosDeBusca = gson.fromJson(filtros, Filtros.class);

        Restrictions restrictions = new Restrictions();

        if (filtrosDeBusca.getUnidade_id() != null) {
            restrictions.add("unidade.id", filtrosDeBusca.getUnidade_id());
        }

        List<UnidadeVO> unidades = new ArrayList<UnidadeVO>();

        List<Unidade> unidadesTemp = unidadeBO.getDAO().getQueryBuilder().from(Unidade.class, "unidade").add(restrictions).orderBy("unidade.nome")
                .getResultList();

        for (Unidade unidadesTemp1 : unidadesTemp) {
            UnidadeVO unidade = new UnidadeVO();

            unidade.setId(unidadesTemp1.getId());

            unidade.setNome(unidadesTemp1.getNome());

            unidade.setSigla(unidadesTemp1.getSigla());

            unidades.add(unidade);
        }

        return unidades;
    }
}

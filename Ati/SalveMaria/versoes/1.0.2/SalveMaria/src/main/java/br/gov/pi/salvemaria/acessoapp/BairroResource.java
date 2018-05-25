/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.vos.BairroVO;
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
@Path("/bairro")
public class BairroResource {

    @EJB
    private BairroBO bairroBO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BairroVO pegarBairroPeloId(@PathParam("id") Long id) {
        Bairro bairro = bairroBO.getDAO().unique("id", id);
        BairroVO bairroVO = new BairroVO();

        if (bairro != null) {
            bairroVO.setId(bairro.getId());
            bairroVO.setNome(bairro.getNome());
            bairroVO.setCidade(bairroBO.getDAO().getInitialized(bairro.getCidade()).getNome());
        }

        return bairroVO;
    }

    @Path("listar/{filtros}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BairroVO> listarBairroPeloIdCidade(@PathParam("filtros") String filtros) {
        Gson gson = new Gson();
        Filtros filtrosDeBusca = gson.fromJson(filtros, Filtros.class);

        Restrictions restrictions = new Restrictions();

        if (filtrosDeBusca.getCidade_id() != null) {
            restrictions.add("cidade.id", filtrosDeBusca.getCidade_id());
        }

        List<Bairro> bairros = bairroBO.getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro").leftJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("cidade, bairro.nome").getResultList();
        List<BairroVO> bairrosVO = new ArrayList<BairroVO>();
        for (Bairro bairro : bairros) {
            BairroVO bairroVO = new BairroVO();
            bairroVO.setId(bairro.getId());
            bairroVO.setNome(bairro.getNome());
            bairroVO.setCidade_id(bairro.getCidade().getId());
            bairroVO.setCidade(bairro.getCidade().getNome());
            bairrosVO.add(bairroVO);
        }

        return bairrosVO;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.vos.BairroVO;
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
            bairroVO.setRegiao(bairroBO.getDAO().getInitialized(bairro.getRegiao()).getNome());
        }

        return bairroVO;
    }

    @Path("listar/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BairroVO> listarBairroPeloIdCidade(@PathParam("id") Long idCidade) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("cidade.id", idCidade);
        List<Bairro> bairros = bairroBO.getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro").innerJoinFetch("bairro.regiao", "regiao")
                .innerJoinFetch("regiao.cidade", "cidade").add(restrictions).orderBy("bairro.nome").getResultList();
        List<BairroVO> bairrosVO = new ArrayList<BairroVO>();
        for (Bairro bairro : bairros) {
            BairroVO bairroVO = new BairroVO();
            bairroVO.setId(bairro.getId());
            bairroVO.setNome(bairro.getNome());
            bairroVO.setRegiao(bairroBO.getDAO().getInitialized(bairro.getRegiao()).getNome());
            bairrosVO.add(bairroVO);
        }

        return bairrosVO;
    }

}

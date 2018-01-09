/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp;

import br.gov.pi.ati.agendacultural.acessoApp.vos.TipoLocalEventoVO;
import br.gov.pi.ati.agendacultural.bo.cadastro.TipoLocalBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import java.util.ArrayList;
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
@Path("/tipoLocalEvento")
public class TipoLocalResource {
    
    @EJB
    private TipoLocalBO tipoBO;
    
    @Path("listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoLocalEventoVO> listarAtivos() {
        List<TipoLocalEventoVO> tipos = new ArrayList<TipoLocalEventoVO>();
        List<TipoLocal> tiposTemp = tipoBO.getDAO().list("ativo", true, "descricao");
        for (TipoLocal tiposTemp1 : tiposTemp) {
            TipoLocalEventoVO tipo = new TipoLocalEventoVO();
            tipo.setAssento(tiposTemp1.isAssento());
            tipo.setDescricao(tiposTemp1.getDescricao());
            tipo.setId(tiposTemp1.getId());
            tipos.add(tipo);
        }
        
        return tipos;
    }
    
}

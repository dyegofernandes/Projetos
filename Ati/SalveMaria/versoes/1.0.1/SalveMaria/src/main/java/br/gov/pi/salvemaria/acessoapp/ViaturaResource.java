/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.ViaturaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Viatura;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
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
@Path("/viatura")
public class ViaturaResource {
    
    @EJB
    private ViaturaBO viaturaBO;
    
    @POST
    @Path("atualizarLtdLgt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(final String json) throws ParseException, MalformedURLException, IOException {
        Gson gson = new Gson();
        Viatura viaturaApp = gson.fromJson(json, Viatura.class);
        
        Viatura viatura = viaturaBO.getDAO().unique("codigo", viaturaApp.getCodigo());
        
        if (viatura != null) {
            viatura.setImei(viaturaApp.getImei());
            viatura.setLatitude(viaturaApp.getLatitude());
            viatura.setLongitude(viaturaApp.getLongitude());
            viatura.setTelefone(viaturaApp.getTelefone());
            viaturaBO.getDAO().saveOrMerge(viatura);
        } else {
            return Response.status(500).entity("Viatura não encontrada!").header("CustomHeader", "CustomValue").build();
        }
        
        return Response.status(200).entity("Sucesso!").header("CustomHeader", "CustomValue").build();
        
    }
}

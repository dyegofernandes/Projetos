/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp;

import br.gov.pi.ati.adapi.modelo.enums.AreaDeAtuacao;
import br.gov.pi.ati.adapi.modelo.enums.PerfilNotificador;
import br.gov.pi.ati.adapi.modelo.enums.SimOuNao;
import br.gov.pi.ati.adapi.modelo.enums.TipoProfissional;
import br.gov.pi.ati.adapi.modelo.vos.EnumVO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juniel
 */
@Path("/enums")
public class EnumsResource {

    @Path("simOuNao")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnumVO> getSimOuNao() {

        List<EnumVO> lista = new ArrayList<EnumVO>();

        for (SimOuNao obj : SimOuNao.values()) {
            EnumVO temp = new EnumVO();
            temp.setChave(obj.toString());
            temp.setNome(obj.getDescricao());
            lista.add(temp);
        }
        return lista;
    }

    @Path("areaDeAtuacao")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnumVO> getAreaDeAtuacao() {
        List<EnumVO> lista = new ArrayList<EnumVO>();

        for (AreaDeAtuacao obj : AreaDeAtuacao.values()) {
            EnumVO temp = new EnumVO();
            temp.setChave(obj.toString());
            temp.setNome(obj.getDescricao());
            lista.add(temp);
        }
        return lista;
    }

    @Path("perfilNotificador")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnumVO> getPerfilNotificador() {
        List<EnumVO> lista = new ArrayList<EnumVO>();

        for (PerfilNotificador obj : PerfilNotificador.values()) {
            EnumVO temp = new EnumVO();
            temp.setChave(obj.toString());
            temp.setNome(obj.getDescricao());
            lista.add(temp);
        }
        return lista;
    }

    @Path("tipoProfissional")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnumVO> getTipoProfissional() {
        List<EnumVO> lista = new ArrayList<EnumVO>();

        for (TipoProfissional obj : TipoProfissional.values()) {
            EnumVO temp = new EnumVO();
            temp.setChave(obj.toString());
            temp.setNome(obj.getDescricao());
            lista.add(temp);
        }
        return lista;
    }
}

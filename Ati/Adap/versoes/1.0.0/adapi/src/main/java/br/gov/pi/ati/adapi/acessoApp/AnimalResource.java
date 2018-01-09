/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp;

import br.gov.pi.ati.adapi.acessoApp.vos.AnimalVO;
import br.gov.pi.ati.adapi.acessoApp.vos.EspecieVO;
import br.gov.pi.ati.adapi.bo.cadastro.AnimalBO;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import br.gov.pi.ati.adapi.modelo.cadastro.Especie;
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
@Path("/animal")
public class AnimalResource {

    @EJB
    private AnimalBO animalBO;

    @Path("listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalVO> listarAnimaisAtivos() {
        List<AnimalVO> animais = new ArrayList<AnimalVO>();

        List<Animal> animaisTemp = animalBO.getDAO().list("ativo", true, "nome");

        for (Animal temp : animaisTemp) {
            AnimalVO animalVO = new AnimalVO();
            animalVO.setId(temp.getId());
            animalVO.setNome(temp.getNome());
            Especie especieTemp = animalBO.getDAO().getInitialized(temp.getEspecie());

            EspecieVO especieVO = new EspecieVO();
            especieVO.setId(especieTemp.getId());
            especieVO.setNome(especieTemp.getNome());

            animalVO.setEspecie(especieVO);

            animais.add(animalVO);
        }

        return animais;
    }

}

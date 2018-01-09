/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.acessoapp;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.bo.cadastro.EstadoBO;
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.vos.ArquivoVO;
import br.gov.pi.salvemaria.modelo.vos.DenunciaVO;
import br.gov.pi.salvemaria.util.Utils;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juniel
 */
@Path("/denuncia")
public class DenunciaResource {

    @EJB
    private BairroBO bairroBO;

    @EJB
    private EstadoBO estadoBO;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private ArquivoBO arquivoBO;

    private Utils util = new Utils();

    @POST
    @Path("salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(final String json) throws ParseException, MalformedURLException, IOException {
        Gson gson = new Gson();
        DenunciaVO denunciaVO = gson.fromJson(json, DenunciaVO.class);
        Denuncia denuncia = new Denuncia();
        Endereco endereco = new Endereco();
        Estado estado = null;
        Cidade cidade = null;
        Bairro bairro = null;
        URL url = null;
        String stringDeBusca = "";

        denuncia.setTipo(util.tipoDenunciaPeloNome(denunciaVO.getTipo()));

        if (denuncia.getTipo() == TipoDenuncia.DENUNCIA) {
            estado = estadoBO.estadoPorNome(denunciaVO.getEstado());
            cidade = cidadeBO.cidadePeloNomeEestado(denunciaVO.getCidade(), estado);
            bairro = bairroBO.bairroPeloNomeECidade(denunciaVO.getBairro(), cidade);
            denuncia.setDescricao(denunciaVO.getDescricao());
            denuncia.setHoraDenuncia(util.converterStringParaDate(denunciaVO.getHoraDenuncia(), "HH:mm"));
            denuncia.setObservacao(denunciaVO.getObservacao());
            denuncia.setFormaDeViolencia(util.formaViolenciaPeloNome(denunciaVO.getFormaDeViolencia()));
            denuncia.setVitima(denunciaVO.getVitima());
            denuncia.setIdadeVitima(denunciaVO.getIdadeVitima());
            denuncia.setAgressor(denunciaVO.getAgressor());
            denuncia.setIdadeAgressor(denunciaVO.getIdadeAgressor());
            endereco.setCep(denunciaVO.getCep());
            endereco.setComplemento(denunciaVO.getComplemento());
            endereco.setEndereco(denunciaVO.getEndereco());
            endereco.setNumero(denunciaVO.getNumero());
            denuncia.setDataDenuncia(util.converterStringParaDate(denunciaVO.getDataDenuncia(), "dd/MM/yyyy"));
            stringDeBusca = stringDeBusca.concat(denunciaVO.getEndereco()).concat(", ").concat(denunciaVO.getNumero()).concat(", ").concat(denunciaVO.getBairro())
                    .concat(",").concat(denunciaVO.getCidade()).concat(", ").concat(denunciaVO.getEstado());
            url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=BUSCA_PELO_VALOR&sensor=false".replace("BUSCA_PELO_VALOR", stringDeBusca.replace(" ", "+")));

            String stringJson = util.pegarRetornoUrlGoogle(url);

            if (stringJson != null) {
                JSONObject jsonObjTest = new JSONObject(stringJson);

                JSONArray jsonArray = jsonObjTest.getJSONArray("results");

                if (jsonArray.length() > 0) {
                    endereco.setLatitude(util.pegarLatitude(stringJson));
                    endereco.setLongitude(util.pegarLongitude(stringJson));
                }
            }

        } else {
            if (denuncia.getTipo() == TipoDenuncia.PANICO) {
                stringDeBusca = stringDeBusca.concat(denunciaVO.getLatitude()).concat(",").concat(denunciaVO.getLongitude());
                url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=BUSCA_PELO_VALOR".replace("BUSCA_PELO_VALOR", stringDeBusca));

                String stringJson = util.pegarRetornoUrlGoogle(url);

                if (stringJson != null) {
                    if (!stringJson.equals("")) {
                        JSONObject jsonObjTest = new JSONObject(stringJson);

                        JSONArray jsonArray = jsonObjTest.getJSONArray("results");

                        if (jsonArray.length() > 0) {
                            String jsonEndereco = jsonArray.get(0).toString();
                            JSONObject jsonObj = new JSONObject(jsonEndereco);
                            estado = estadoBO.estadoPorNome(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Estado"));
                            cidade = cidadeBO.cidadePeloNomeEestado(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Cidade"), estado);
                            bairro = bairroBO.bairroPeloNomeECidade(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Bairro"), cidade);
                            endereco.setCep(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Cep"));
                            endereco.setComplemento(null);
                            endereco.setEndereco(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Endereco"));
                            endereco.setNumero(util.enderecoPorNomeAtributoJson(jsonObj.getJSONArray("address_components"), "Numero"));
                        } else {
                            return Response.status(503).entity("Endereço não localizado").header("CustomHeader", "CustomValue").build();
                        }

                    } else {
                        return Response.status(503).entity("Endereço não localizado").header("CustomHeader", "CustomValue").build();
                    }
                } else {
                    return Response.status(503).entity("Endereço não localizado").header("CustomHeader", "CustomValue").build();
                }

                denuncia.setDescricao("Denúncia Feita através do botão Pânico");
                denuncia.setObservacao(("Denúncia Feita através do botão Pânico com as seguintes coordenadas Latidude: ".
                        concat(denunciaVO.getLatitude()).concat(" Longitude: ").concat(denunciaVO.getLongitude())));

                denuncia.setDataDenuncia(new Date());
                denuncia.setHoraDenuncia(new Date());

                endereco.setLatitude(denunciaVO.getLatitude());
                endereco.setLongitude(denunciaVO.getLongitude());

                denuncia.setFormaDeViolencia(FormasDeViolencia.FISICA);
            } else {
                return Response.status(501).entity("Tipo de Denuncia não existe").header("CustomHeader", "CustomValue").build(); //se o tipo nao for encontrado
            }
        }

        endereco.setBairro(bairro);

        denuncia.setEndereco(endereco);

        denuncia.setUnidade(unidadeBO.unidadePelaRegiao(bairro != null ? bairro.getRegiao() : null));

        try {
            denunciaBO.getDAO().saveOrMerge(denuncia);
            if (denunciaVO.getArquivos() != null) {
                for (ArquivoVO arquivoVO : denunciaVO.getArquivos()) {
                    Arquivo arquivo = new Arquivo();
                    arquivo.setNome(arquivoVO.getNome());
                    arquivo.setDenuncia(denuncia);
                    arquivo.setExtensao(arquivoVO.getExtensao());
                    arquivo.setConteudo(arquivoVO.getConteudo());
                    arquivoBO.getDAO().saveOrMerge(arquivo);
                }
            }
            return Response.status(200).entity("Denúncia realizada com Sucesso!").header("CustomHeader", "CustomValue").build();
        } catch (Exception e) {
            return Response.status(412).entity("Campos Obrigatórios não preenchidos!").header("CustomHeader", "CustomValue").build();
        }

    }
}

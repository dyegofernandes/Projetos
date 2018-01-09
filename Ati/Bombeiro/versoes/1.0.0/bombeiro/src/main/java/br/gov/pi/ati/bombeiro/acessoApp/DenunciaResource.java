/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.bombeiro.acessoApp;

import br.gov.pi.ati.bombeiro.bo.denuncia.DenunciaBO;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Arquivo;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Denuncia;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Endereco;
import br.gov.pi.ati.bombeiro.modelo.enums.Tipo;
import br.gov.pi.ati.bombeiro.util.Utils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juniel
 */
@Path("/denuncia")
public class DenunciaResource {

    @EJB
    private DenunciaBO denunciaBO;

    @POST
    @Path("salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(final String json) throws IOException, ParseException {
        if (!Utils.isNullOrEmpty(json)) {
            JSONObject jsonObj = new JSONObject(json);
            Denuncia denuncia = new Denuncia();
            denuncia.setDescricao(jsonObj.getString("descricao"));
            try {
                String dataDenuncia = jsonObj.getString("dataDenuncia");
                if (Utils.isNullOrEmpty(dataDenuncia)) {
                    denuncia.setDataDenuncia(Utils.convertStringToDate(dataDenuncia, "dd/MM/yyyy"));
                }
            } catch (Exception e) {
            }

            try {
                String horaDenuncia = jsonObj.getString("horaDenuncia");
                if (Utils.isNullOrEmpty(horaDenuncia)) {
                    denuncia.setHoraDenuncia(Utils.convertStringToDate(jsonObj.getString("horaDenuncia"), "HH:hh"));
                }
            } catch (Exception e) {
            }

            try {
                denuncia.setObservacao(jsonObj.getString("observacao"));
            } catch (Exception e) {
            }

            try {
                Tipo tipo;
                try {
                    tipo = Utils.tipoDenunciaPeloNome(jsonObj.getString("tipo"));

                    denuncia.setTipo(tipo);
                } catch (Exception e) {
                    return Response.status(503).entity("O tipo da denúncia é obrigatório!").header("CustomHeader", "CustomValue").build();

                }
                String enderecoString = null;
                try {
                    enderecoString = jsonObj.getString("endereco");
                } catch (Exception e) {
                }
                if (enderecoString == null) {
                    return Response.status(503).entity("Endereço não encontrado!").header("CustomHeader", "CustomValue").build();

                }
                Endereco enderecoTemp = endereco(tipo, enderecoString);

                if (enderecoTemp != null) {
                    denuncia.setEndereco(enderecoTemp);
                    denuncia.setNomeDenunciado(jsonObj.getString("nomeDenunciado"));
                    denuncia.setImei(jsonObj.getString("imei"));
                    denuncia.setCpfUsuario(jsonObj.getString("cpfUsuario"));

                    JSONArray arquivosJson = jsonObj.getJSONArray("arquivos");

                    for (Object arquivoObj : arquivosJson) {
                        JSONObject arquivoJson = (JSONObject) arquivoObj;
                        Arquivo arquivo = new Arquivo();
                        arquivo.setNome(arquivoJson.getString("nome"));
                        arquivo.setExtensao(arquivoJson.getString("extensao"));
                        arquivo.setConteudo(arquivoJson.getString("conteudo"));
                        denuncia.getArquivos().add(arquivo);
                    }

                    denunciaBO.getDAO().saveOrMerge(denuncia);
                    return Response.status(200).entity("Denúncia realizada com Sucesso!").header("CustomHeader", "CustomValue").build();
                } else {
                    return Response.status(503).entity("Endereço não encontrado!").header("CustomHeader", "CustomValue").build();
                }
            } catch (Exception e) {
                return Response.status(503).entity("Endereço não encontrado!").header("CustomHeader", "CustomValue").build();
            }
        } else {
            return Response.status(503).entity("String Json vazia!").header("CustomHeader", "CustomValue").build();

        }
    }

    private Endereco endereco(Tipo tipo, String enderecoString) throws MalformedURLException, IOException {
        Endereco endereco = new Endereco();
        JSONObject enderecoJson;
        if (tipo == null) {
            return null;
        }
        if (tipo == Tipo.DENUNCIA) {
            String urlString = "http://maps.googleapis.com/maps/api/geocode/json?address=:BUSCA&sensor=false";

            URL url = new URL(urlString.replace(":BUSCA", enderecoString.replace(" ", "%20")));

            enderecoJson = new JSONObject(Utils.pegarRetornoUrlGoogle(url));

            if (enderecoJson.getString("status").equals("OK")) {
                JSONArray jsonArray = enderecoJson.getJSONArray("results");
                for (Object jsonArray1 : jsonArray) {
                    JSONArray enderecoComponentes = (JSONArray) ((JSONObject) jsonArray1).get("address_components");
                    endereco.setLogradouro(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Endereco"));
                    endereco.setNumero(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Numero"));
                    endereco.setBairro(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Bairro"));
                    endereco.setCidade(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Cidade"));
                    endereco.setEstado(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Estado"));
                    endereco.setPais(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Pais"));
                    endereco.setCep(Utils.enderecoPorNomeAtributoJson(enderecoComponentes, "Cep"));

                    String enderecoFormatado = ((JSONObject) jsonArray1).get("formatted_address").toString();
                    endereco.setEnderecoFormatado(enderecoFormatado);
                    JSONObject geometrico = (JSONObject) ((JSONObject) jsonArray1).get("geometry");
                    JSONObject localizacao = (JSONObject) geometrico.get("location");
                    endereco.setLatitude(localizacao.getDouble("lat"));
                    endereco.setLongitude(localizacao.getDouble("lng"));
                }
            } else {
                return null;
            }

        } else {
            String urlString = "http://maps.googleapis.com/maps/api/geocode/json?latlng=:BUSCA";

            URL url = new URL(urlString.replace(":BUSCA", enderecoString.replace(" ", "%20")));

            enderecoJson = new JSONObject(Utils.pegarRetornoUrlGoogle(url));

            if (enderecoJson.getString("status").equals("OK")) {
                JSONArray jsonArray = enderecoJson.getJSONArray("results");
                JSONArray enderecoJsonTemp = (JSONArray) ((JSONObject) jsonArray.get(0)).get("address_components");
                endereco.setLogradouro(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Endereco"));
                endereco.setNumero(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Numero"));
                endereco.setBairro(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Bairro"));
                endereco.setCidade(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Cidade"));
                endereco.setEstado(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Estado"));
                endereco.setPais(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Pais"));
                endereco.setCep(Utils.enderecoPorNomeAtributoJson(enderecoJsonTemp, "Cep"));

                String enderecoFormatado = ((JSONObject) jsonArray.get(0)).get("formatted_address").toString();
                endereco.setEnderecoFormatado(enderecoFormatado);
                JSONObject geometrico = (JSONObject) ((JSONObject) jsonArray.get(0)).get("geometry");
                JSONObject localizacao = (JSONObject) geometrico.get("location");
                endereco.setLatitude(localizacao.getDouble("lat"));
                endereco.setLongitude(localizacao.getDouble("lng"));
            } else {
                return null;
            }

        }
        return endereco;
    }

}

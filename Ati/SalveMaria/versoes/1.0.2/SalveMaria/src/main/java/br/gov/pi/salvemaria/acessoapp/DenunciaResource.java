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
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.vos.ArquivoVO;
import br.gov.pi.salvemaria.modelo.vos.DenunciaLdtAndLgtVO;
import br.gov.pi.salvemaria.modelo.vos.DenunciaVO;
import br.gov.pi.salvemaria.util.Utils;
import com.google.gson.Gson;
import com.xpert.persistence.query.Restrictions;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

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
        
        TipoDenuncia tipo = Utils.tipoDenunciaPeloNome(denunciaVO.getTipo());
        
        if (Utils.isNullOrEmpty(json)) {
            return Response.status(503).entity("String Json vazia!").header("CustomHeader", "CustomValue").build();
        } else {
            if (tipo != null) {
                estado = estadoBO.estadoPorNome("Piauí");
                cidade = cidadeBO.cidadePeloNomeEestado(denunciaVO.getCidade(), estado);
                bairro = bairroBO.bairroPeloNomeECidade(denunciaVO.getBairro(), cidade);
                
                if (bairro == null) {
                    bairro = bairroBO.bairrosPrincipalPela(cidade);
                    
                    endereco.setComplemento((endereco.getComplemento() != null ? endereco.getComplemento() : "")
                            .concat(" O bairro:".concat(denunciaVO.getBairro()).
                                    concat(" não consta na basae de dados!").concat(new Date().toString())));
                }
                
                if (denunciaVO.getHoraDenuncia() != null) {
                    if (!denunciaVO.getHoraDenuncia().equals("")) {
                        denuncia.setHoraDenuncia(Utils.convertStringToDate(denunciaVO.getHoraDenuncia(), "HH:mm:ss"));
                    }
                }
                
                if (denunciaVO.getDataDenuncia() != null) {
                    if (!denunciaVO.getDataDenuncia().equals("")) {
                        denuncia.setDataDenuncia(Utils.convertStringToDate(denunciaVO.getDataDenuncia(), "yy-MM-dd"));
                    }
                }
                
                denuncia.setObservacao(denunciaVO.getObservacao());
                
                if (!Utils.isNullOrEmpty(denunciaVO.getFormaDeViolencia())) {
                    denuncia.setFormaDeViolencia(Utils.formaViolenciaPeloNome(denunciaVO.getFormaDeViolencia()));
                }
                
                denuncia.setVitima(denunciaVO.getVitima());
                
                if (!Utils.isNullOrEmpty(denunciaVO.getIdadeVitima())) {
                    denuncia.setIdadeVitima(new Integer(denunciaVO.getIdadeVitima()));
                }
                
                denuncia.setAgressor(denunciaVO.getAgressor());
                
                if (!Utils.isNullOrEmpty(denunciaVO.getIdadeAgressor())) {
                    denuncia.setIdadeAgressor(new Integer(denunciaVO.getIdadeAgressor()));
                    
                }
                
                if (!Utils.isNullOrEmpty(denunciaVO.getDemandante())) {
                    denuncia.setDemandante(Utils.demandantePeloNome(denunciaVO.getDemandante()));
                }
                
                if (!Utils.isNullOrEmpty(denunciaVO.getCep())) {
                    endereco.setCep(denunciaVO.getCep().length() < 9 ? "64000-000" : denunciaVO.getCep());
                }
                
                endereco.setComplemento(denunciaVO.getComplemento());
                
                endereco.setBairro(bairro);
                
                endereco.setEndereco(denunciaVO.getEndereco());
                
                endereco.setNumero(denunciaVO.getNumero());
                
                if (!Utils.isNullOrEmpty(denunciaVO.getLatitude())) {
                    endereco.setLatitude(denunciaVO.getLatitude());
                }
                
                if (Utils.isNullOrEmpty(denunciaVO.getLongitude())) {
                    endereco.setLongitude(denunciaVO.getLongitude());
                }
                
                if (tipo == TipoDenuncia.DENUNCIA) {
                    
                    if (!Utils.isNullOrEmpty(denunciaVO.getDescricao())) {
                        denuncia.setDescricao(denunciaVO.getDescricao());
                    } else {
                        denuncia.setDescricao("Denúncia feita através do preenchimento do Formulário no Celular!");
                    }

                    stringDeBusca = stringDeBusca.concat(denunciaVO.getEndereco() != null ? denunciaVO.getEndereco() : "").concat(", ")
                            .concat(denunciaVO.getNumero() != null ? denunciaVO.getNumero() : "").concat(", ")
                            .concat(denunciaVO.getBairro()).concat(",").concat(denunciaVO.getCidade()).concat(", ").concat(denunciaVO.getEstado());

                    url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=BUSCA_PELO_VALOR".
                            replace("BUSCA_PELO_VALOR", stringDeBusca.replace(" ", "+")));

                    String stringJson = Utils.pegarRetornoUrlGoogle(url);

                    if (!Utils.isNullOrEmpty(stringJson)) {
                        JSONObject jsonObjTest = new JSONObject(stringJson);

                        JSONArray jsonArray = jsonObjTest.getJSONArray("results");

                        if (jsonArray.length() > 0) {
                            endereco.setLatitude(Utils.pegarLatitude(stringJson));
                            endereco.setLongitude(Utils.pegarLongitude(stringJson));
                        }
                    } else {
                        return Response.status(503).entity("Nenhum resultado encontrado para latitude e longitude informadados!").
                                header("CustomHeader", "CustomValue").build();
                    }
                } else {
                    if (tipo == TipoDenuncia.PANICO) {
                        denuncia.setDescricao("Botão Pânico!! Latidude: ".concat(denunciaVO.getLatitude()).concat(" Longitude: ").concat(denunciaVO.getLongitude()));
                    }
                }
                
                endereco.setBairro(bairro);
                
                denuncia.setTipo(tipo);
                denuncia.setEndereco(endereco);
                denuncia.setImei(denunciaVO.getImei());
                denuncia.setCpfUsuario(denunciaVO.getCpfUsuario());
                denuncia.setUnidade(unidadeBO.unidadePeloBairro(bairro, tipo, denuncia.getIdadeVitima(), denuncia.getIdadeAgressor()));
                
                try {
                    List<Arquivo> arquivos = new ArrayList<Arquivo>();
                    if (denunciaVO.getArquivos() != null) {
                        for (ArquivoVO arquivoVO : denunciaVO.getArquivos()) {
                            Arquivo arquivo = new Arquivo();
                            arquivo.setNome(arquivoVO.getNome());
                            arquivo.setExtensao(arquivoVO.getExtensao());
                            arquivo.setConteudo(arquivoVO.getConteudo());
                            arquivos.add(arquivo);
                        }
                    }
                    denuncia.setArquivos(arquivos);
                    denunciaBO.getDAO().saveOrMerge(denuncia);
                    return Response.status(200).entity("Denúncia realizada com Sucesso!").header("CustomHeader", "CustomValue").build();
                } catch (Exception e) {
                    return Response.status(412).entity("Campos Obrigatórios não preenchidos! ".concat(e.getMessage())).header("CustomHeader", "CustomValue").build();
                }
            } else {
                return Response.status(501).entity("Tipo de Denuncia não existe").header("CustomHeader", "CustomValue").
                        build(); //se o tipo nao for encontrado
            }
        }
        
    }
    
    @Path("listar/{filtros}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DenunciaLdtAndLgtVO> listarDenuncias(@PathParam("filtros") String filtros) throws ParseException {
        
        String campos[] = filtros.split(",");
        String tipo = new String(campos[0]);
        String dataInicial = new String(campos[1]);
        String dataFinal = new String(campos[2]);
        
        List<DenunciaLdtAndLgtVO> lista = new ArrayList<DenunciaLdtAndLgtVO>();
        
        List<Denuncia> denuncias = new ArrayList<Denuncia>();
        
        Restrictions restrictions = new Restrictions();
        
        if (!tipo.equals("")) {
            restrictions.add("tipo", Utils.tipoDenunciaPeloNome(tipo));
        }
        
        if (!dataInicial.equals("")) {
            restrictions.greaterEqualsThan("dataDenuncia", Utils.convertStringToDate(dataInicial, "dd-MM-yyyy"));
        }
        if (!dataFinal.equals("")) {
            restrictions.lessEqualsThan("dataDenuncia", Utils.convertStringToDate(dataFinal, "dd-MM-yyyy"));
        }
        
        restrictions.isNotNull("endereco.latitude");
        
        restrictions.isNotNull("endereco.longitude");
        
        denuncias = denunciaBO.getDAO().list(restrictions, "dataDenuncia");
        
        for (Denuncia denuncia : denuncias) {
            DenunciaLdtAndLgtVO denunciaVO = new DenunciaLdtAndLgtVO();
            denunciaVO.setTipo(denuncia.getTipo().getDescricao());
            denunciaVO.setDataDenuncia(Utils.convertDateToString(denuncia.getDataDenuncia(), "dd/MM/yyyy"));
            denunciaVO.setHoraDenuncia(Utils.convertDateToString(denuncia.getHoraDenuncia(), "HH:mm"));
            Endereco endereco = denunciaBO.getDAO().getInitialized(denuncia.getEndereco());
            denunciaVO.setLgt(endereco.getLongitude());
            denunciaVO.setLtd(endereco.getLatitude());
            
            lista.add(denunciaVO);
        }
        
        return lista;
    }
}

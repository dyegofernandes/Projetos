/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp;

import br.gov.pi.ati.agendacultural.acessoApp.vos.AgendaEventoVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.CategoriaEventoVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.DiasVisitacaoVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.EventoVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.FoneVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.ValorEventoVO;
import br.gov.pi.ati.agendacultural.bo.eventos.CategoriaEventoBO;
import br.gov.pi.ati.agendacultural.bo.eventos.EventoBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import br.gov.pi.ati.agendacultural.modelo.eventos.AgendaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import br.gov.pi.ati.agendacultural.modelo.eventos.ValorEvento;
import br.gov.pi.ati.agendacultural.util.Utils;
import com.xpert.persistence.query.Restrictions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author Juniel
 */
@Path("/evento")
public class EventoResource {

    @EJB
    private EventoBO eventoBO;

    @EJB
    private CategoriaEventoBO categoriaBO;

    SimpleDateFormat formataData;

    /**
     *
     * @author Juniel
     * @param json {id, titulo,descricao, localId, localNome,
     * logradouro,bairro,cidade,dataInicio,dataFim,horaInicio,horaFim
     * list<ids>}
     * @return List<PortfolioVO>
     *
     */
    @Path("listar/{json}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventoVO> listar(@PathParam("json") String json) throws ParseException {
        Restrictions restrictions = new Restrictions();

        Long id = null;
        String titulo = null;
        String descricao = null;
        Long localId = null;
        String localNome = null;
        String logradouro = null;
        String bairro = null;
        String cidade = null;
        Date dataInicio = null;
        Date dataFim = null;
        Date horaInicio = null;
        Date horaFim = null;
        JSONArray categoriasId = null;
        List<Long> idsCategoria = new ArrayList<Long>();

        List<EventoVO> eventos = new ArrayList<EventoVO>();

        if (!Utils.isNullOrEmpty(json)) {
            JSONObject jsonObj = new JSONObject(json);

            if (jsonObj.length() > 0) {
                String idTemp = Utils.getValorJson(jsonObj, "id");
                if (!Utils.isNullOrEmpty(idTemp)) {
                    id = new Long(idTemp);
                }
                titulo = Utils.getValorJson(jsonObj, "titulo");
                descricao = Utils.getValorJson(jsonObj, "descricao");

                localId = Utils.isNullOrEmpty(Utils.getValorJson(jsonObj, "localId")) ? null : new Long(Utils.getValorJson(jsonObj, "localId"));
                localNome = Utils.getValorJson(jsonObj, "localNome");
                logradouro = Utils.getValorJson(jsonObj, "logradouro");
                bairro = Utils.getValorJson(jsonObj, "bairro");
                cidade = Utils.getValorJson(jsonObj, "cidade");
                dataInicio = Utils.convertStringToDate(Utils.getValorJson(jsonObj, "dataInicio"), "dd/MM/yyyy");
                dataFim = Utils.convertStringToDate(Utils.getValorJson(jsonObj, "dataFim"), "dd/MM/yyyy");
                horaInicio = Utils.convertStringToDate(Utils.getValorJson(jsonObj, "horaInicio"), "HH:mm");
                horaFim = Utils.convertStringToDate(Utils.getValorJson(jsonObj, "horaFim"), "HH:mm");

                String categoriasIdTemp = Utils.getValorJson(jsonObj, "categoriasId");
                if (!Utils.isNullOrEmpty(categoriasIdTemp)) {
                    categoriasId = jsonObj.getJSONArray("categoriasId");
                    if (categoriasId.length() > 0) {
                        for (int i = 0; i < categoriasId.length(); i++) {
                            Long idCategoria = categoriasId.getJSONObject(i).getLong("id");
                            idsCategoria.add(idCategoria);
                        }
                    }
                }
            }
        }
        if (id != null) {
            restrictions.add("evento.id", id);
        }
        if (titulo != null) {
            restrictions.like("evento.titulo", titulo.toUpperCase());
        }
        if (descricao != null) {
            restrictions.like("evento.descricao", descricao.toUpperCase());
        }

        if (localId != null) {
            restrictions.add("localEvento.id", localId);
        }

        if (localNome != null) {
            restrictions.add("localEvento.nome", localNome);
        }

        if (logradouro != null) {
            restrictions.like("endereco.logradouro", logradouro.toUpperCase());
        }

        if (bairro != null) {
            restrictions.like("endereco.bairro", bairro.toUpperCase());
        }

        if (cidade != null) {
            restrictions.like("endereco.cidade", cidade.toUpperCase());
        }

        if (dataInicio != null) {
            restrictions.greaterEqualsThan("evento.dataInicio", dataInicio);
        }

        if (dataFim != null) {
            restrictions.lessEqualsThan("evento.dataFim", dataFim);
        }

        if (horaInicio != null) {
            restrictions.greaterEqualsThan("evento.horaInicio", horaInicio);
        }

        if (horaFim != null) {
            restrictions.lessEqualsThan("evento.horaFim", horaFim);
        }

        if (idsCategoria.size() > 0) {
            restrictions.in("catId.id", idsCategoria);
        }

        List<Evento> eventoTemp = eventoBO.getDAO().getQueryBuilder().select("evento").from(Evento.class, "evento")
                .leftJoinFetch("evento.localEvento", "localEvento").leftJoinFetch("localEvento.endereco", "endereco")
                .leftJoinFetch("localEvento.tipo", "tipo").leftJoinFetch("evento.categorias", "catId").add(restrictions)
                .orderBy("evento.dataInicio DESC, evento.horaInicio DESC, localEvento.nome").getResultList();

        for (Evento evento : eventoTemp) {
            EventoVO eventoVO = new EventoVO();
            LocalEvento localEvento = eventoBO.getDAO().getInitialized(evento.getLocalEvento());
            Endereco endereco = eventoBO.getDAO().getInitialized(localEvento.getEndereco());
            TipoLocal tipo = eventoBO.getDAO().getInitialized(localEvento.getTipo());

            eventoVO.setId(evento.getId());
            eventoVO.setTitulo(evento.getTitulo());
            eventoVO.setDescricao(evento.getDescricao());

            eventoVO.getLocal().setId(localEvento.getId());
            eventoVO.getLocal().setNome(localEvento.getNome());
            eventoVO.getLocal().getTipo().setId(tipo.getId());
            eventoVO.getLocal().getTipo().setDescricao(tipo.getDescricao());
            eventoVO.getLocal().getTipo().setAssento(tipo.isAssento());
            eventoVO.getLocal().getEndereco().setId(endereco.getId());
            eventoVO.getLocal().getEndereco().setLogradouro(endereco.getEndereco());
            eventoVO.getLocal().getEndereco().setNumero(endereco.getNumero());
            eventoVO.getLocal().getEndereco().setBairro(endereco.getBairro());
            eventoVO.getLocal().getEndereco().setCep(endereco.getCep());
            eventoVO.getLocal().getEndereco().setCidade(endereco.getCidade());
            eventoVO.getLocal().getEndereco().setComplemento(endereco.getComplemento());
            eventoVO.getLocal().getEndereco().setLtd(endereco.getLatitude() != null ? endereco.getLatitude().replace(",", ".") : endereco.getLatitude());
            eventoVO.getLocal().getEndereco().setLgt(endereco.getLongitude() != null ? endereco.getLongitude().replace(",", ".") : endereco.getLongitude());

            List<DiaVisitacaoPortfolio> diasVisitacao = eventoBO.getDAO().getInitialized(localEvento.getDiaHoraVisitacao());
            for (DiaVisitacaoPortfolio diaVisitacao : diasVisitacao) {
                DiasVisitacaoVO diaVO = new DiasVisitacaoVO();
                diaVO.setDiaSemana(diaVisitacao.getDiaSemana().getDescricao());
                formataData = new SimpleDateFormat("HH:mm");
                diaVO.setHorarioInicial(formataData.format(diaVisitacao.getHorarioInicial()));
                diaVO.setHorarioFinal(formataData.format(diaVisitacao.getHorarioFinal()));
                eventoVO.getLocal().getHorarioFuncionamento().add(diaVO);
            }

            List<Fone> fones = eventoBO.getDAO().getInitialized(localEvento.getFones());
            for (Fone fone : fones) {
                FoneVO foneVO = new FoneVO();
                foneVO.setDdd(fone.getDdd());
                foneVO.setId(fone.getId());
                foneVO.setNumero(fone.getNumero());
                eventoVO.getLocal().getFones().add(foneVO);
            }

            List<AgendaEvento> agendas = eventoBO.getDAO().getInitialized(evento.getAgenda());
            for (AgendaEvento agenda : agendas) {
                AgendaEventoVO agendaVO = new AgendaEventoVO();
                formataData = new SimpleDateFormat("dd/MM/yyyy");
                agendaVO.setDataFim(formataData.format(agenda.getDataFim()));
                agendaVO.setDataInicio(formataData.format(agenda.getDataInicio()));
                agendaVO.setDescricao(agenda.getDescricao());
                formataData = new SimpleDateFormat("HH:mm");
                agendaVO.setHoraFim(formataData.format(agenda.getHoraFim()));
                agendaVO.setHoraInicio(formataData.format(agenda.getHoraInicio()));
                eventoVO.getAgenda().add(agendaVO);
            }

            List<CategoriaEvento> categorias = eventoBO.getDAO().getInitialized(evento.getCategorias());
            for (CategoriaEvento categoria : categorias) {
                CategoriaEventoVO categoriaVO = new CategoriaEventoVO();
                categoriaVO.setDescricao(categoria.getDescricao());
                categoriaVO.setId(categoria.getId());
                eventoVO.getCategorias().add(categoriaVO);
            }

            List<ValorEvento> valores = eventoBO.getDAO().getInitialized(evento.getValores());
            for (ValorEvento valor : valores) {
                ValorEventoVO valorVO = new ValorEventoVO();
                valorVO.setDescricao(valor.getDescricao());
                valorVO.setId(valorVO.getId());
                valorVO.setValor(valor.getValor());
                valorVO.setValorMeia(valor.getMeiaEntrada());
                eventoVO.getValores().add(valorVO);
            }

//            if (categoriasPesquisa.size() > 0) {
//                for (CategoriaEvento categBusca : categoriasPesquisa) {
//                    for (CategoriaEvento categ : categorias) {
//
//                    }
//                }
//            } else {
            eventos.add(eventoVO);
//            }

        }

        return eventos;
    }
}

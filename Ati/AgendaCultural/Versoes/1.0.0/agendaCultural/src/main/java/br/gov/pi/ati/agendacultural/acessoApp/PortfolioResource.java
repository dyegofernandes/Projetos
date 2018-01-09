/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp;

import br.gov.pi.ati.agendacultural.acessoApp.vos.DiasVisitacaoVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.FotosVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.HistoricosVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.LinksVideosVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.PortfolioVO;
import br.gov.pi.ati.agendacultural.acessoApp.vos.FoneVO;
import br.gov.pi.ati.agendacultural.bo.eventos.PortfolioBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Arquivo;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.HistoricoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.LinkPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import br.gov.pi.ati.agendacultural.util.Utils;
import com.xpert.persistence.query.Restrictions;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONObject;

/**
 *
 * @author Juniel
 */
@Path("/portfolio")
public class PortfolioResource {

    @EJB
    private PortfolioBO portfolioBO;
    SimpleDateFormat formataData;

    /**
     *
     * @author Juniel
     * @param json {id, tipoId, localPortfolio, logradouro, bairro, cidade}
     * @return List<PortfolioVO>
     *
     */
    @Path("listar/{json}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public List<PortfolioVO> listar(@PathParam("json") String json) {

        formataData = new SimpleDateFormat("HH:mm");

        List<PortfolioVO> portfolios = new ArrayList<PortfolioVO>();
        Restrictions restrictions = new Restrictions();

        Long id = null;
        Long tipoId = null;
        String localPortfolio = null;
        String logradouro = null;
        String bairro = null;
        String cidade = null;

        if (!Utils.isNullOrEmpty(json)) {
            JSONObject jsonObj = new JSONObject(json);
            if (jsonObj.length() > 0) {
                String tipoTemp = Utils.getValorJson(jsonObj, "tipoId");
                if (!Utils.isNullOrEmpty(tipoTemp)) {
                    tipoId = new Long(tipoTemp);
                }
                String idTemp = Utils.getValorJson(jsonObj, "id");
                if (!Utils.isNullOrEmpty(idTemp)) {
                    id = new Long(idTemp);
                }
                localPortfolio = Utils.getValorJson(jsonObj, "localPortfolio");
                logradouro = Utils.getValorJson(jsonObj, "logradouro");
                bairro = Utils.getValorJson(jsonObj, "bairro");
                cidade = Utils.getValorJson(jsonObj, "cidade");
            }

            if (id != null) {
                restrictions.add("portfolio.id", id);
            }
            if (tipoId != null) {
                restrictions.add("tipo.id", tipoId);
            }

            if (localPortfolio != null) {
                restrictions.like("portfolio.localPortfolio", localPortfolio.toUpperCase());
            }

            if (logradouro != null) {
                restrictions.like("endereco.endereco", logradouro.toUpperCase());
            }

            if (bairro != null) {
                restrictions.like("endereco.bairro", bairro.toUpperCase());
            }

            if (cidade != null) {
                restrictions.like("endereco.cidade", cidade.toUpperCase());
            }
        }

        List<Portfolio> portfoliosTemp = portfolioBO.getDAO().getQueryBuilder().select("portfolio").from(Portfolio.class, "portfolio")
                .leftJoinFetch("portfolio.tipo", "tipo").leftJoin("portfolio.endereco", "endereco")
                .add(restrictions).orderBy("portfolio.localPortfolio").getResultList();

        for (Portfolio portfolio : portfoliosTemp) {
            PortfolioVO portfolioVO = new PortfolioVO();
            portfolioVO.setId(portfolio.getId());
            portfolioVO.setLocalPortfolio(portfolio.getLocalPortfolio());
            TipoLocal tipo = portfolioBO.getDAO().getInitialized(portfolio.getTipo());
            portfolioVO.getTipo().setId(tipo.getId());
            portfolioVO.getTipo().setDescricao(tipo.getDescricao());
            portfolioVO.getTipo().setAssento(tipo.isAssento());
            Endereco endereco = portfolioBO.getDAO().getInitialized(portfolio.getEndereco());
            portfolioVO.getEndereco().setLogradouro(endereco.getEndereco());
            portfolioVO.getEndereco().setComplemento(endereco.getComplemento());
            portfolioVO.getEndereco().setBairro(endereco.getBairro());
            portfolioVO.getEndereco().setCidade(endereco.getCidade());
            portfolioVO.getEndereco().setCep(endereco.getCep());
            portfolioVO.getEndereco().setLtd(endereco.getLatitude());
            portfolioVO.getEndereco().setLgt(endereco.getLongitude());

            List<Fone> fonesTemp = portfolioBO.getDAO().getInitialized(portfolio.getFones());
            for (Fone fone : fonesTemp) {
                FoneVO foneVO = new FoneVO();
                foneVO.setId(fone.getId());
                foneVO.setDdd(fone.getDdd());
                foneVO.setNumero(fone.getNumero());
                portfolioVO.getFones().add(foneVO);
            }

            List<DiaVisitacaoPortfolio> diasTemp = portfolioBO.getDAO().getInitialized(portfolio.getDiaHoraVisitacao());
            for (DiaVisitacaoPortfolio diaTemp : diasTemp) {
                DiasVisitacaoVO diasVO = new DiasVisitacaoVO();

                diasVO.setDiaSemana(diaTemp.getDiaSemana().getDescricao());

                if (diaTemp.getHorarioInicial() != null) {
                    diasVO.setHorarioInicial(formataData.format(diaTemp.getHorarioInicial()));
                }

                if (diaTemp.getHorarioFinal() != null) {
                    diasVO.setHorarioFinal(formataData.format(diaTemp.getHorarioFinal()));
                }

                portfolioVO.getHorarios().add(diasVO);
            }

            List<HistoricoPortfolio> historicosTemp = portfolioBO.getDAO().getInitialized(portfolio.getHistoricos());
            for (HistoricoPortfolio historico : historicosTemp) {
                HistoricosVO historicoVO = new HistoricosVO();
                historicoVO.setDescricao(historico.getHistorico());

                portfolioVO.getHistoricos().add(historicoVO);
            }

            List<LinkPortfolio> linksTemp = portfolioBO.getDAO().getInitialized(portfolio.getLinks());

            for (LinkPortfolio link : linksTemp) {
                LinksVideosVO linksVO = new LinksVideosVO();
                linksVO.setDescricaoLink(link.getDescricaoLink());
                linksVO.setUrl(link.getLink());

                portfolioVO.getUrlVideos().add(linksVO);
            }

            List<Arquivo> arquivosTemp = portfolioBO.getDAO().getInitialized(portfolio.getArquivos());
            for (Arquivo arquivo : arquivosTemp) {
                FotosVO fotosVO = new FotosVO();
                fotosVO.setNome(arquivo.getNome());
                fotosVO.setExtensao(arquivo.getExtensao());
                fotosVO.setConteudo(arquivo.getConteudo());

                portfolioVO.getFotos().add(fotosVO);
            }

            portfolios.add(portfolioVO);
        }

        return portfolios;

    }
}

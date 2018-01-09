package br.gov.pi.ati.siopm.bo.ocorrencia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.ocorrencia.OcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.PatrulhaAux;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVO;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class OcorrenciaBO extends AbstractBusinessObject<Ocorrencia> {

    @EJB
    private OcorrenciaDAO ocorrenciaDAO;

    @Override
    public OcorrenciaDAO getDAO() {
        return ocorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo", "ano");
    }

    @Override
    public void validate(Ocorrencia ocorrencia) throws BusinessException {

        List<NaturezaOcorrencia> naturezas = getDAO().getInitialized(ocorrencia.getNaturezas());

        List<Solicitante> solicitantes = getDAO().getInitialized(ocorrencia.getSolicitantes());

        List<PatrulhaAux> patrulhas = getDAO().getInitialized(ocorrencia.getPatrulhas());

        if (ocorrencia.getClassificacaoChamada().equals(ClassificacaoChamada.OCORRENCIA) && naturezas.size() < 1) {
            throw new BusinessException("Natureza da ocorrência é obrigatória!");
        }

//        if (ocorrencia.getClassificacaoChamada().equals(ClassificacaoChamada.TROTE) && naturezas.size() > 0) {
//            throw new BusinessException("Ocorrência classificada como Trote não necessita de Natureza da Ocorrência!");
//        }
        if (solicitantes.size() < 1) {
            throw new BusinessException("Solicitante da ocorrência é obrigatório!");
        }

        if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCAMINHADA_VIATURA) {
            if (ocorrencia.getPatrulhas().size() < 1) {
                throw new BusinessException("Guarnições para ocorrência é obrigatória!");
            }

            if (ocorrencia.getDataAtendimento() == null || ocorrencia.getHoraAtendimento() == null) {
                throw new BusinessException("Data e hora do atendimento são obrigatórias!");
            } else {
                //Falta verificar se a data encaminhamento é menor q a data do atendimento
            }
        } else {
            if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCERRADA) {

                if (Utils.isNullOrEmpty(ocorrencia.getHistorioFinal())) {
                    throw new BusinessException("Histório final é obrigatório!");
                }

                if (ocorrencia.getClassificacaoChamada() == ClassificacaoChamada.OCORRENCIA) {

                    if (patrulhas.size() < 1) {
                        throw new BusinessException("Guarnição para ocorrência é  obrigatória!");
                    } else {
                        for (PatrulhaAux patrulha : patrulhas) {
                            if (patrulha.getDataDespacho() == null) {
                                throw new BusinessException("Data do Despacho da Guarnição é obrigatória!");
                            }

                            if (patrulha.getHoraDespacho() == null) {
                                throw new BusinessException("Hora do Despacho da Guarnição é obrigatória!");
                            }

                            if (patrulha.getHoraChegadaLocal() == null) {
                                throw new BusinessException("Hora chegada ao Local da Guarnição é obrigatória!");
                            }

                            if (patrulha.getHoraSaidaLocal() == null) {
                                throw new BusinessException("Hora saída ao Local da Guarnição é obrigatória!");
                            }
                        }
                    }

                    if (ocorrencia.getResultados().size() < 1) {
                        throw new BusinessException("Resultados da Ocorrência é obrigatório!");
                    }
                }

                if (ocorrencia.getDataEncerramento() == null || ocorrencia.getHoraEncerramento() == null) {
                    throw new BusinessException("Data e hora do encerramento são obrigatórias!");
                }
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Integer getUltimoCodigo(Integer ano) {
        return (Integer) getDAO().getQueryBuilder().from(Ocorrencia.class).add("ano", ano).max("codigo");
    }

    public List<Ocorrencia> ocorrenciasPelaSituacao(SituacaoOcorrencia situacao) {
        return getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoinFetch("ocorrencia.endereco", "endereco").leftJoinFetch("ocorrencia.solicitantes", "solicitantes").
                add("ocorrencia.situacao", situacao).getResultList();
    }

    public List<Ocorrencia> ocorrenciasPelaSituacoes(List<SituacaoOcorrencia> situacoes, Usuario usuario) {

        List<Organizacao> organizacoes = getDAO().getInitialized(usuario.getOrganizacoes());

        Restrictions restrictions = new Restrictions();
        if (organizacoes.size() > 0) {
            List<Long> ids = new ArrayList<Long>();
            for (Organizacao org : organizacoes) {
                ids.add(org.getId());
            }
            restrictions.in("organizacoes.id", ids);
        }

        restrictions.in("ocorrencia.situacao", situacoes);

        return getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoinFetch("ocorrencia.endereco", "endereco").leftJoinFetch("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.organizacoes", "organizacoes").
                add(restrictions).getResultList();
    }

    public List<Ocorrencia> ocorrenciasPorBairroEData(String bairro, Date dataOcorrencia) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("ocorrencia.dataOcorrencia", dataOcorrencia);
        restrictions.add("endereco.bairro", bairro);

        return getDAO().getQueryBuilder().select("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoinFetch("ocorrencia.endereco", "endereco").add(restrictions).getResultList();
    }

    public List<OcorrenciaVO> ocorrenciasVO(FiltrosVO filtros) {
        Restrictions restrictions = new Restrictions();

        List<OcorrenciaVO> ocorrencias = new ArrayList<OcorrenciaVO>();

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("ocorrencia.dataOcorrencia", filtros.getDataInicial(), TemporalType.DATE);
        }

        if (filtros.getHoraInicial() != null) {
            restrictions.greaterEqualsThan("solicitantes.horarioSolicitacao", filtros.getHoraInicial(), TemporalType.TIME);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("ocorrencia.dataOcorrencia", filtros.getDataFinal(), TemporalType.DATE);

        }

        if (filtros.getHoraFinal() != null) {
            restrictions.lessEqualsThan("solicitantes.horarioSolicitacao", filtros.getHoraFinal(), TemporalType.TIME);
        }

        if (!Utils.isNullOrEmpty(filtros.getLogradouro())) {
            restrictions.like("logradouro", filtros.getLogradouro());
        }

        if (!Utils.isNullOrEmpty(filtros.getBairro())) {
            restrictions.add("endereco.bairro", filtros.getBairro());
        }

        if (!Utils.isNullOrEmpty(filtros.getCidade())) {
            restrictions.add("endereco.cidade", filtros.getCidade());
        }

        if (!Utils.isNullOrEmpty(filtros.getCodigo())) {
            restrictions.add("ocorrencia.codigo", new Integer(filtros.getCodigo().substring(4, filtros.getCodigo().length())));
            restrictions.add("ocorrencia.ano", new Integer(filtros.getCodigo().substring(0, 4)));
        }

        if (filtros.getOpms() != null) {
            if (filtros.getOpms().size() > 0) {
                List<Long> ids = new ArrayList<Long>();

                for (Opm opm : filtros.getOpms()) {
                    ids.add(opm.getId());
                }
                restrictions.in("organizacoes.id", ids);
            }
        }

        List<Ocorrencia> ocorrenciasTemp = getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoinFetch("ocorrencia.endereco", "endereco")
                .leftJoinFetch("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.organizacoes", "organizacoes")
                .add(restrictions)
                .orderBy("ocorrencia.dataOcorrencia")
                .getResultList();

        for (Ocorrencia ocorrencia : ocorrenciasTemp) {
            for (Solicitante solicitante : ocorrencia.getSolicitantes()) {
                OcorrenciaVO ocorrenciaVO = new OcorrenciaVO();
                ocorrenciaVO.setId(ocorrencia.getId());
                ocorrenciaVO.setIdSolicitante(solicitante.getId());
                ocorrenciaVO.setDataOcorrencia(Utils.convertDateToString(ocorrencia.getDataOcorrencia(), "dd/MM/yyy"));
                ocorrenciaVO.setHoraOcorrencia(Utils.convertDateToString(solicitante.getHorarioSolicitacao(), "HH:mm"));
                ocorrenciaVO.setEnderecoFormatado(ocorrencia.getEndereco().getEnderecoFormatado());
                ocorrenciaVO.setLogradouro(ocorrencia.getEndereco().getLogradouro());
                ocorrenciaVO.setNumero(ocorrencia.getEndereco().getNumero());
                ocorrenciaVO.setBairro(ocorrencia.getEndereco().getBairro());
                ocorrenciaVO.setCidade(ocorrencia.getEndereco().getCidade());

                ocorrenciaVO.setSituacao(ocorrencia.getSituacao().getDescricao());

                ocorrenciaVO.setCodigo(ocorrencia.getAno().toString().concat(ocorrencia.getCodigo().toString()));
                ocorrencias.add(ocorrenciaVO);
            }

        }

        return ocorrencias;
    }

    public List<OcorrenciaVO> ocorrencias(FiltrosVO filtros) {

        List<OcorrenciaVO> ocorrencias = new ArrayList<OcorrenciaVO>();
        Restrictions restrictions = new Restrictions();

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("ocorrencia.dataOcorrencia", filtros.getDataInicial(), TemporalType.DATE);
        }

        if (filtros.getHoraInicial() != null) {
            restrictions.greaterEqualsThan("solicitantes.horarioSolicitacao", filtros.getHoraInicial(), TemporalType.TIME);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("ocorrencia.dataOcorrencia", filtros.getDataFinal(), TemporalType.DATE);

        }

        if (filtros.getHoraFinal() != null) {
            restrictions.lessEqualsThan("solicitantes.horarioSolicitacao", filtros.getHoraFinal(), TemporalType.TIME);
        }

        if (!Utils.isNullOrEmpty(filtros.getLogradouro())) {
            restrictions.like("logradouro", filtros.getLogradouro());
        }

        if (!Utils.isNullOrEmpty(filtros.getBairro())) {
            restrictions.add("endereco.bairro", filtros.getBairro());
        }

        if (!Utils.isNullOrEmpty(filtros.getCidade())) {
            restrictions.add("endereco.cidade", filtros.getCidade());
        }

        if (!Utils.isNullOrEmpty(filtros.getCodigo())) {
            restrictions.add("ocorrencia.codigo", new Integer(filtros.getCodigo().substring(4, filtros.getCodigo().length())));
            restrictions.add("ocorrencia.ano", new Integer(filtros.getCodigo().substring(0, 4)));
        }

        if (filtros.getOpms() != null) {
            if (filtros.getOpms().size() > 0) {
                List<Long> ids = new ArrayList<Long>();

                for (Opm opm : filtros.getOpms()) {
                    ids.add(opm.getId());
                }
                restrictions.in("organizacoes.id", ids);
            }
        }

        if (filtros.getNaturezas() != null) {
            if (filtros.getNaturezas().size() > 0) {
                List<Long> ids = new ArrayList<Long>();

                for (NaturezaOcorrencia natureza : filtros.getNaturezas()) {
                    ids.add(natureza.getId());
                }

                restrictions.in("naturezas.id", ids);
            }
        }

        if (filtros.getResultados() != null) {
            if (filtros.getResultados().size() > 0) {
                List<Long> ids = new ArrayList<Long>();

                for (ResultadoOcorrencia resultado : filtros.getResultados()) {
                    ids.add(resultado.getId());
                }

                restrictions.in("resultados.id", ids);
            }
        }

        List<Ocorrencia> ocorrenciasTemp = getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoin("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.endereco", "endereco")
                .leftJoin("ocorrencia.organizacoes", "organizacoes")
                .leftJoin("ocorrencia.patrulhas", "patrulhas")
                .leftJoin("ocorrencia.naturezas", "naturezas")
                .leftJoin("ocorrencia.pessoasEnvolvidas", "pessoasEnvolvidas")
                .leftJoin("ocorrencia.qualificacoesVeiculos", "qualificacoesVeiculos")
                .leftJoin("ocorrencia.armas", "armas")
                .leftJoin("ocorrencia.locaisIntermediarios", "locaisIntermediarios")
                .leftJoin("ocorrencia.drogas", "drogas")
                .leftJoin("ocorrencia.resultados", "resultados")
                .add(restrictions)
                .orderBy("ocorrencia.id")
                .getResultList();

        for (Ocorrencia ocorrencia : ocorrenciasTemp) {
            OcorrenciaVO ocorrenciaVO = new OcorrenciaVO();
            String nomeOpms = "";
            String nomeNaturezas = "";
            String nomeResultados = "";
            String horaOcorrencia = "";

            ocorrenciaVO.setDataOcorrencia(Utils.convertDateToString(ocorrencia.getDataOcorrencia(), "dd/MM/yyyy"));

            if (ocorrencia.getDataAtendimento() != null) {
                ocorrenciaVO.setDataAtendimento(Utils.convertDateToString(ocorrencia.getDataAtendimento(), "dd/MM/yyyy"));
            } else {
                ocorrenciaVO.setDataAtendimento(" - ");
            }

            if (ocorrencia.getHoraAtendimento() != null) {
                ocorrenciaVO.setHoraAtendimento(Utils.convertDateToString(ocorrencia.getHoraAtendimento(), "HH:mm"));
            } else {
                ocorrenciaVO.setHoraAtendimento(" - ");
            }

            if (ocorrencia.getDataEncerramento() != null) {
                ocorrenciaVO.setDataEncerramento(Utils.convertDateToString(ocorrencia.getDataEncerramento(), "dd/MM/yyyy"));
            } else {
                ocorrenciaVO.setDataEncerramento(" - ");
            }

            if (ocorrencia.getHoraEncerramento() != null) {
                ocorrenciaVO.setHoraEncerramento(Utils.convertDateToString(ocorrencia.getHoraEncerramento(), "HH:mm"));
            } else {
                ocorrenciaVO.setHoraEncerramento(" - ");
            }

            Endereco endereco = getDAO().getInitialized(ocorrencia.getEndereco());

            ocorrenciaVO.setLogradouro(endereco.getLogradouro());
            ocorrenciaVO.setBairro(endereco.getBairro());
            ocorrenciaVO.setNumero(endereco.getNumero());
            ocorrenciaVO.setCidade(endereco.getCidade());

            ocorrenciaVO.setId(ocorrencia.getId());
            ocorrenciaVO.setCodigo(ocorrencia.getAno().toString().concat(ocorrencia.getCodigo().toString()));
            ocorrenciaVO.setSituacao(ocorrencia.getSituacao().getDescricao());
            ocorrenciaVO.setTipoChamada(ocorrencia.getTipoChamada().getDescricao());
            ocorrenciaVO.setClassificacaoChamada(ocorrencia.getClassificacaoChamada().getDescricao());
            ocorrenciaVO.setClassificacaoOcorrencia(ocorrencia.getClassificacaoOcorrencia().getDescricao());

            List<Solicitante> solicitantes = getDAO().getInitialized(ocorrencia.getSolicitantes());

            for (Solicitante solicitante : solicitantes) {
                horaOcorrencia = horaOcorrencia.concat(Utils.convertDateToString(solicitante.getHorarioSolicitacao(), "HH:mm")).concat("; ");
            }

            ocorrenciaVO.setHoraOcorrencia(horaOcorrencia);

            if (filtros.getOpms() .size()>0) {
                for (Opm opm : filtros.getOpms()) {
                    nomeOpms = nomeOpms.concat(opm.getSigla()).concat("; ");
                }
            } else {
                List<Organizacao> organizacoes = getDAO().getInitialized(ocorrencia.getOrganizacoes());
                for (Organizacao organizacao : organizacoes) {
                    if (organizacao instanceof Opm) {
                        nomeOpms = nomeOpms.concat(organizacao.getSigla()).concat("; ");
                    }
                }
            }

            if (filtros.getNaturezas().size()>0) {
                for (NaturezaOcorrencia natureza : filtros.getNaturezas()) {
                    nomeNaturezas = nomeNaturezas.concat(natureza.getNome()).concat("; ");
                }
            } else {
                List<NaturezaOcorrencia> naturezas = getDAO().getInitialized(ocorrencia.getNaturezas());
                for (NaturezaOcorrencia natureza : naturezas) {
                    nomeNaturezas = nomeNaturezas.concat(natureza.getNome()).concat("; ");
                }
            }

            if (filtros.getResultados() .size()>0) {
                for (ResultadoOcorrencia resultado : filtros.getResultados()) {
                    nomeResultados = nomeResultados.concat(resultado.getNome()).concat("; ");
                }
            } else {
                List<ResultadoOcorrencia> resultados = getDAO().getInitialized(ocorrencia.getResultados());
                for (ResultadoOcorrencia resultado : resultados) {
                    nomeResultados = nomeResultados.concat(resultado.getNome()).concat("; ");
                }
            }

            ocorrenciaVO.setOpm(nomeOpms);
            ocorrenciaVO.setNatureza(nomeNaturezas);
            ocorrenciaVO.setResultado(nomeResultados);

            ocorrencias.add(ocorrenciaVO);
        }

        return ocorrencias;
    }
}

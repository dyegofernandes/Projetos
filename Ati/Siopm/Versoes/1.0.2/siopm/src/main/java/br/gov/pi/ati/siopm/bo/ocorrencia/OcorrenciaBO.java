package br.gov.pi.ati.siopm.bo.ocorrencia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.ocorrencia.OcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaDeArma;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.PatrulhaAux;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
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
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaArmaVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaPessoaEnvolvidaVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVeiculoVO;
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

            List<Solicitante> solicitantes = getDAO().getInitialized(ocorrencia.getSolicitantes());

            for (Solicitante solicitante : solicitantes) {
                horaOcorrencia = horaOcorrencia.concat(Utils.convertDateToString(solicitante.getHorarioSolicitacao(), "HH:mm")).concat("; ");
            }

            ocorrenciaVO.setHoraOcorrencia(horaOcorrencia);

            if (filtros.getOpms().size() > 0) {
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

            if (filtros.getNaturezas().size() > 0) {
                for (NaturezaOcorrencia natureza : filtros.getNaturezas()) {
                    nomeNaturezas = nomeNaturezas.concat(natureza.getNome()).concat("; ");
                }
            } else {
                List<NaturezaOcorrencia> naturezas = getDAO().getInitialized(ocorrencia.getNaturezas());
                for (NaturezaOcorrencia natureza : naturezas) {
                    nomeNaturezas = nomeNaturezas.concat(natureza.getNome()).concat("; ");
                }
            }

            if (filtros.getResultados().size() > 0) {
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

    public List<OcorrenciaVeiculoVO> veiculosPorOcorrencias(FiltrosVO filtros) {

        List<OcorrenciaVeiculoVO> ocorrencias = new ArrayList<OcorrenciaVeiculoVO>();
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

        if (!Utils.isNullOrEmpty(filtros.getPlaca())) {
            restrictions.add("veiculos.placa", filtros.getPlaca());
        }

        if (!Utils.isNullOrEmpty(filtros.getChassi())) {
            restrictions.add("veiculos.chassi", filtros.getChassi());
        }

        if (filtros.getSituacaoVeiculo() != null) {
            restrictions.add("veiculos.situacao", filtros.getSituacaoVeiculo());
        }

        List<Ocorrencia> ocorrenciasTemp = getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoin("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.endereco", "endereco")
                .leftJoin("ocorrencia.qualificacoesVeiculos", "veiculos")
                .add(restrictions)
                .orderBy("ocorrencia.id")
                .getResultList();

        for (Ocorrencia ocorrencia : ocorrenciasTemp) {

            List<QualificacaoDeVeiculo> veiculos = getDAO().getInitialized(ocorrencia.getQualificacoesVeiculos());

            for (QualificacaoDeVeiculo veiculo : veiculos) {
                OcorrenciaVeiculoVO ocorrenciaVO = new OcorrenciaVeiculoVO();

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
                ocorrenciaVO.setSituacaoOcorrencia(ocorrencia.getSituacao().getDescricao());

                ocorrenciaVO.setPlaca(veiculo.getPlaca());
                ocorrenciaVO.setChassi(veiculo.getChassi());
                ocorrenciaVO.setModelo(getDAO().getInitialized(veiculo.getModelo()).getNome());
                ocorrenciaVO.setCor(veiculo.getCor());
                ocorrenciaVO.setMunicipio(veiculo.getMunicipio());
                ocorrenciaVO.setFabricacaoAno(veiculo.getFabricacaoAno().toString());
                ocorrenciaVO.setModeloAno(veiculo.getModeloAno().toString());
                ocorrenciaVO.setProprietario(veiculo.getProprietario());
                ocorrenciaVO.setTelefonePropietario(veiculo.getProprietario());

                ocorrencias.add(ocorrenciaVO);
            }

        }

        return ocorrencias;
    }

    public List<OcorrenciaArmaVO> armasPorOcorrencias(FiltrosVO filtros) {

        List<OcorrenciaArmaVO> ocorrencias = new ArrayList<OcorrenciaArmaVO>();
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

        if (filtros.getCalibre() != null) {
            restrictions.add("armas.calibre", filtros.getCalibre());
        }

        if (filtros.getCapacidade() != null) {
            restrictions.add("armas.capacidade", filtros.getCapacidade());
        }

        if (!Utils.isNullOrEmpty(filtros.getModeloArma())) {
            restrictions.add("armas.nomeModelo", filtros.getModeloArma());
        }

        if (!Utils.isNullOrEmpty(filtros.getModeloArma())) {
            restrictions.add("armas.nomeModelo", filtros.getModeloArma());
        }

        if (filtros.getMarca() != null) {
            restrictions.add("armas.marca", filtros.getMarca());
        }

        if (filtros.getTipoArma() != null) {
            restrictions.add("armas.tipo", filtros.getTipoArma());
        }

        List<Ocorrencia> ocorrenciasTemp = getDAO().getQueryBuilder().select("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoin("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.endereco", "endereco")
                .leftJoin("ocorrencia.armas", "armas")
                .add(restrictions)
                .orderBy("ocorrencia.id")
                .getResultList();

        for (Ocorrencia ocorrencia : ocorrenciasTemp) {

            List<Arma> armas = getDAO().getInitialized(ocorrencia.getArmas());

            for (Arma arma : armas) {
                OcorrenciaArmaVO ocorrenciaVO = new OcorrenciaArmaVO();

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
                ocorrenciaVO.setSituacaoOcorrencia(ocorrencia.getSituacao().getDescricao());

                ocorrenciaVO.setArmaDaPolicia(arma.getArmaDaPolicia().getDescricao());
                ocorrenciaVO.setCalibre(arma.getCalibre());
                ocorrenciaVO.setCapacidade(arma.getCapacidade());
                ocorrenciaVO.setQuantidadeDeflagrada(arma.getQuantidadeDeflagrada());
                ocorrenciaVO.setNumeracao(arma.getNumeracao());
                ocorrenciaVO.setNomeModelo(arma.getNomeModelo());
                ocorrenciaVO.setTipo(arma.getTipo().getDescricao());

                MarcaDeArma marca = getDAO().getInitialized(arma.getMarca());

                ocorrenciaVO.setMarca(marca.getNome());

                ocorrencias.add(ocorrenciaVO);
            }

        }

        return ocorrencias;
    }

    public List<OcorrenciaPessoaEnvolvidaVO> pessoasPorOcorrencias(FiltrosVO filtros) {

        List<OcorrenciaPessoaEnvolvidaVO> ocorrencias = new ArrayList<OcorrenciaPessoaEnvolvidaVO>();
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

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.add("pessoas.situacao", filtros.getNome());
        }

        if (!Utils.isNullOrEmpty(filtros.getRg())) {
            restrictions.add("pessoas.rg", filtros.getRg());
        }

        if (!Utils.isNullOrEmpty(filtros.getCpf())) {
            restrictions.add("pessoas.cpf", filtros.getCpf());
        }

        if (!Utils.isNullOrEmpty(filtros.getCnh())) {
            restrictions.add("pessoas.cnh", filtros.getCnh());
        }

        List<Ocorrencia> ocorrenciasTemp = getDAO().getQueryBuilder().selectDistinct("ocorrencia").from(Ocorrencia.class, "ocorrencia")
                .leftJoin("ocorrencia.solicitantes", "solicitantes")
                .leftJoin("ocorrencia.endereco", "endereco")
                .leftJoin("ocorrencia.pessoasEnvolvidas", "pessoas")
                .add(restrictions)
                .orderBy("ocorrencia.id")
                .getResultList();

        for (Ocorrencia ocorrencia : ocorrenciasTemp) {

            List<PessoaEnvolvida> pessoas = getDAO().getInitialized(ocorrencia.getPessoasEnvolvidas());

            for (PessoaEnvolvida pessoa : pessoas) {
                OcorrenciaPessoaEnvolvidaVO ocorrenciaVO = new OcorrenciaPessoaEnvolvidaVO();

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
                ocorrenciaVO.setSituacaoOcorrencia(ocorrencia.getSituacao().getDescricao());

                ocorrenciaVO.setCpf(pessoa.getCpf());
                ocorrenciaVO.setRg(pessoa.getRg());
                ocorrenciaVO.setNome(pessoa.getNome());
                ocorrenciaVO.setCnh(pessoa.getCnh());

                ocorrencias.add(ocorrenciaVO);
            }

        }

        return ocorrencias;
    }
}

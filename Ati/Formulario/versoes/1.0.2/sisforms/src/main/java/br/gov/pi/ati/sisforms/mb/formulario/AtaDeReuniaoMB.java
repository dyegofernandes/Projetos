package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.AtaDeReuniaoBO;
import br.gov.pi.ati.sisforms.bo.formulario.DeliberacaoBO;
import br.gov.pi.ati.sisforms.bo.formulario.ObservacaoBO;
import br.gov.pi.ati.sisforms.bo.formulario.ParticipanteBO;
import br.gov.pi.ati.sisforms.bo.formulario.PautaDaReuniaoBO;
import br.gov.pi.ati.sisforms.bo.formulario.PendenciaIdentificadaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.modelo.vos.ParticipanteVO;
import br.gov.pi.ati.sisforms.modelo.vos.PendenciaVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AtaDeReuniaoMB extends AbstractBaseBean<AtaDeReuniao> implements Serializable {

    @EJB
    private AtaDeReuniaoBO ataDeReuniaoBO;

    @EJB
    private ParticipanteBO participanteBO;

    @EJB
    private PautaDaReuniaoBO pautaDaReuniaoBO;

    @EJB
    private DeliberacaoBO deliberacaoBO;

    @EJB
    private ObservacaoBO observacaoBO;

    @EJB
    private PendenciaIdentificadaBO pendenciaBO;

    private List<Participante> participantes = new ArrayList<Participante>();

    private List<PautaDaReuniao> pautasReuniao = new ArrayList<PautaDaReuniao>();

    private List<Deliberacao> deliberacoes = new ArrayList<Deliberacao>();

    private List<Observacao> observacoes = new ArrayList<Observacao>();

    private List<PendenciaIdentificada> pendencias = new ArrayList<PendenciaIdentificada>();

    private List<Participante> participantesDeletadas = new ArrayList<Participante>();

    private List<PautaDaReuniao> pautasReuniaoDeletadas = new ArrayList<PautaDaReuniao>();

    private List<Deliberacao> deliberacoesDeletadas = new ArrayList<Deliberacao>();

    private List<Observacao> observacoesDeletadas = new ArrayList<Observacao>();

    private List<PendenciaIdentificada> pendenciasDeletadas = new ArrayList<PendenciaIdentificada>();

    private List<AtaDeReuniao> atas = new ArrayList<AtaDeReuniao>();

    private Orgao orgaoParticipante;

    private String nomeParticipante = null;

    private String areaFuncaoParticipante = null;

    private String telefoneParticipante = null;

    private String emailParticipante = null;

    private String assuntoPauta = null;

    private String resumoPauta = null;

    private String assuntoDeliberacao = null;

    private String deliberacao = null;

    private String assuntoObservacao = null;

    private String observacao = null;

    private Orgao orgaoPendencia;

    private String pendencia = null;

    private String responsavelPendencia = null;

    private Date dataPendencia = null;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtros = new FiltrosVO();

    @Override
    public void init() {

        if (!usuarioAtual.isSuperUsuario()) {
            filtros.setUsuario(usuarioAtual);
        }

        buscar();
        updateHoraTermino();

        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
        } else {
            carregarListas(getEntity());
        }
    }

    @Override
    public void save() {
        super.save();

        for (Participante participante : participantes) {
            participanteBO.getDAO().saveOrMerge(participante, true);
        }

        for (PautaDaReuniao pauta : pautasReuniao) {
            pautaDaReuniaoBO.getDAO().saveOrMerge(pauta, true);
        }

        for (Deliberacao deliberacaoTem : deliberacoes) {
            deliberacaoBO.getDAO().saveOrMerge(deliberacaoTem, true);
        }

        for (Observacao obs : observacoes) {
            observacaoBO.getDAO().saveOrMerge(obs, true);
        }

        for (PendenciaIdentificada pendenciaTem : pendencias) {
            pendenciaBO.getDAO().saveOrMerge(pendenciaTem, true);
        }

        for (Participante participante : participantesDeletadas) {
            try {
                participanteBO.getDAO().remove(participante, true);
            } catch (DeleteException ex) {
                Logger.getLogger(AtaDeReuniaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (PautaDaReuniao pauta : pautasReuniaoDeletadas) {
            try {
                pautaDaReuniaoBO.getDAO().remove(pauta, true);
            } catch (DeleteException ex) {
                Logger.getLogger(AtaDeReuniaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (Deliberacao deliberacaoTem : deliberacoesDeletadas) {
            try {
                deliberacaoBO.getDAO().remove(deliberacaoTem, true);
            } catch (DeleteException ex) {
                Logger.getLogger(AtaDeReuniaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (Observacao obs : observacoesDeletadas) {
            try {
                observacaoBO.getDAO().remove(obs, true);
            } catch (DeleteException ex) {
                Logger.getLogger(AtaDeReuniaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (PendenciaIdentificada pendenciaTem : pendenciasDeletadas) {
            try {
                pendenciaBO.getDAO().remove(pendenciaTem, true);
            } catch (DeleteException ex) {
                Logger.getLogger(AtaDeReuniaoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public AtaDeReuniaoBO getBO() {
        return ataDeReuniaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void addParticipante() {
        if (nomeParticipante != null) {
            if (!nomeParticipante.equals("")) {
                if (areaFuncaoParticipante != null) {
                    if (!areaFuncaoParticipante.equals("")) {
                        Participante participante = new Participante();
                        participante.setAreaFuncao(areaFuncaoParticipante);
                        participante.setNome(nomeParticipante);
                        participante.setOrgao(orgaoParticipante);
                        participante.setEmail(emailParticipante);
                        participante.setTelefone(telefoneParticipante);
                        participante.setAtaDeReuniao(getEntity());
                        participantes.add(participante);

                        nomeParticipante = null;
                        areaFuncaoParticipante = null;
                        orgaoParticipante = null;
                        emailParticipante = null;
                        telefoneParticipante = null;
                    } else {
                        FacesMessageUtils.error("Área/Função do Participante é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Área/Função do Participante é Obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Nome do Participante é Obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Nome do Participante é Obrigatório!");
        }
    }

    public void removerParticipante(Participante participante) {
        if (participante.getId() != null) {
            participantesDeletadas.add(participante);
        }
        participantes.remove(participante);
    }

    public void addPautaDaReuniao() {
        if (assuntoPauta != null) {
            if (!assuntoPauta.equals("")) {
                if (resumoPauta != null) {
                    if (!resumoPauta.equals("")) {
                        PautaDaReuniao pauta = new PautaDaReuniao();
                        pauta.setAssunto(assuntoPauta);
                        pauta.setResumoAssunto(resumoPauta);
                        pauta.setAtaDeReuniao(getEntity());
                        pautasReuniao.add(pauta);

                        assuntoPauta = null;
                        resumoPauta = null;
                    } else {
                        FacesMessageUtils.error("Resumo Assunto da Pauta da Reunião é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Resumo Assunto da Pauta da Reunião é Obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Assunto da Pauta da Reunião é Obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Assunto da Pauta da Reunião é Obrigatório!");
        }
    }

    public void removerPautaDaReuniao(PautaDaReuniao pauta) {
        if (pauta.getId() != null) {
            pautasReuniaoDeletadas.add(pauta);
        }
        pautasReuniao.remove(pauta);
    }

    public void addDeliberacao() {
        if (assuntoDeliberacao != null) {
            if (!assuntoDeliberacao.equals("")) {
                if (deliberacao != null) {
                    if (!deliberacao.equals("")) {
                        Deliberacao deliberacaoTemp = new Deliberacao();
                        deliberacaoTemp.setAssunto(assuntoDeliberacao);
                        deliberacaoTemp.setDeliberacao(deliberacao);
                        deliberacaoTemp.setAtaDeReuniao(getEntity());
                        deliberacoes.add(deliberacaoTemp);

                        assuntoDeliberacao = null;
                        deliberacao = null;
                    } else {
                        FacesMessageUtils.error("Deliberação é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Deliberação é Obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Assunto da Deliberação é Obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Assunto da Deliberação é Obrigatória!");
        }
    }

    public void removerDeliberacao(Deliberacao deliberacao) {
        if (deliberacao.getId() != null) {
            deliberacoesDeletadas.add(deliberacao);
        }
        deliberacoes.remove(deliberacao);
    }

    public void addObservacao() {
        if (assuntoObservacao != null) {
            if (!assuntoObservacao.equals("")) {
                if (observacao != null) {
                    if (!observacao.equals("")) {
                        Observacao observacaoTemp = new Observacao();
                        observacaoTemp.setAssunto(assuntoObservacao);
                        observacaoTemp.setObservacao(observacao);
                        observacaoTemp.setAtaDeReuniao(getEntity());
                        observacoes.add(observacaoTemp);

                        assuntoObservacao = null;
                        observacao = null;
                    } else {
                        FacesMessageUtils.error("Observação é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Observação é Obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Assunto da Observação é Obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Assunto da Observação é Obrigatória!");
        }
    }

    public void removerObservacao(Observacao observacao) {
        if (observacao.getId() != null) {
            observacoesDeletadas.add(observacao);
        }
        observacoes.remove(observacao);
    }

    public void addPendencia() {
        if (pendencia != null) {
            if (!pendencia.equals("")) {
                if (responsavelPendencia != null) {
                    if (!responsavelPendencia.equals("")) {
                        PendenciaIdentificada pendenciaTemp = new PendenciaIdentificada();
                        pendenciaTemp.setAtaDeReuniao(getEntity());
                        pendenciaTemp.setOrgao(orgaoPendencia);
                        pendenciaTemp.setDataPrevista(dataPendencia);
                        pendenciaTemp.setPendencia(pendencia);
                        pendenciaTemp.setResponsavel(responsavelPendencia);

                        pendencias.add(pendenciaTemp);

                        orgaoPendencia = null;
                        pendencia = null;
                        responsavelPendencia = null;
                        dataPendencia = null;
                    } else {
                        FacesMessageUtils.error("Responsável pela Pendência é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Responsável pela Pendência é Obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Pendência é Obrigatória!");
            }
        } else {
            FacesMessageUtils.error("Pendência é Obrigatória!");
        }
    }

    public void removerPendencia(PendenciaIdentificada pendencia) {
        if (pendencia.getId() != null) {
            pendenciasDeletadas.add(pendencia);
        }
        pendencias.remove(pendencia);
    }

    public void carregarListas(AtaDeReuniao ata) {
        if (ata != null) {
            participantes = participanteBO.getDAO().list("ataDeReuniao", ata, "nome");
            pautasReuniao = pautaDaReuniaoBO.getDAO().list("ataDeReuniao", ata, "assunto");
            deliberacoes = deliberacaoBO.getDAO().list("ataDeReuniao", ata, "assunto");
            observacoes = observacaoBO.getDAO().list("ataDeReuniao", ata, "assunto");
            pendencias = pendenciaBO.getDAO().list("ataDeReuniao", ata, "pendencia");
        }
    }

    public void gerarPdf(AtaDeReuniao form) {
        HashMap params = new HashMap();
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");
        String dirSubReports = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/report/formulario/");

        params.put("LOGO_ATI", imgLogoAti);
        params.put("ORGAO", ataDeReuniaoBO.getDAO().getInitialized(form.getOrgao()).getNome());

        if (form.getDataDaReuniao() != null) {
            params.put("DATA_REUNIAO", Utils.convertDateToString(form.getDataDaReuniao(), 1));
        }
        if (form.getHoraInicio() != null) {
            params.put("HORA_INICIO", Utils.convertDateToString(form.getHoraInicio(), 3));
        }
        if (form.getHoraTermino() != null) {
            params.put("HORA_TERMINO", Utils.convertDateToString(form.getHoraTermino(), 3));
        }
        params.put("LOCAL", form.getLocalReuniao());
        params.put("REDATOR", form.getRedator());
        params.put("ASSUNTO", form.getAssunto());
        params.put("RESUMO", form.getResumoReuniao());
        if (form.getDataDaProximaReuniao() != null) {
            params.put("PROX_DATA", Utils.convertDateToString(form.getDataDaProximaReuniao(), 1));
        }
        if (form.getHoraDaProximaReuniao() != null) {
            params.put("PROX_HORA", Utils.convertDateToString(form.getHoraDaProximaReuniao(), 3));
        }
        params.put("PROX_LOCAL", form.getLocalProximaReuniao());
        params.put("SUBREPORT_DIR", dirSubReports);
        carregarListas(form);

        List<ParticipanteVO> participantesVO = new ArrayList<ParticipanteVO>();

        List<PendenciaVO> pendenciasVO = new ArrayList<PendenciaVO>();

        for (Participante participante : participantes) {
            ParticipanteVO participanteTempVO = new ParticipanteVO();
            participanteTempVO.setOrgao(getBO().getDAO().getInitialized(participante.getOrgao()).getNome());
            participanteTempVO.setAreaFuncao(participante.getAreaFuncao());
            participanteTempVO.setEmail(participante.getEmail());
            participanteTempVO.setNome(participante.getNome());
            participanteTempVO.setTelefone(participante.getTelefone());
            participantesVO.add(participanteTempVO);
        }

        for (PendenciaIdentificada pendenciaTemp : pendencias) {
            PendenciaVO pendenciaVO = new PendenciaVO();
            pendenciaVO.setOrgao(getBO().getDAO().getInitialized(pendenciaTemp.getOrgao()).getNome());
            pendenciaVO.setPendencia(pendenciaTemp.getPendencia());
            pendenciaVO.setDataPrevista(Utils.convertDateToString(pendenciaTemp.getDataPrevista(), 1));
            pendenciaVO.setResponsavel(pendenciaTemp.getResponsavel());
            pendenciasVO.add(pendenciaVO);
        }

        params.put("PARTICIPANTES", participantesVO);
        params.put("PAUTAS", pautasReuniao);
        params.put("DELIBERACOES", deliberacoes);
        params.put("OBSERVACOES", observacoes);
        params.put("PENDENCIAS", pendenciasVO);

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/ataDeReuniao.jasper", "Ata de Reuniao" + ".pdf");

    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<PautaDaReuniao> getPautasReuniao() {
        return pautasReuniao;
    }

    public void setPautasReuniao(List<PautaDaReuniao> pautasReuniao) {
        this.pautasReuniao = pautasReuniao;
    }

    public List<Deliberacao> getDeliberacoes() {
        return deliberacoes;
    }

    public void setDeliberacoes(List<Deliberacao> deliberacoes) {
        this.deliberacoes = deliberacoes;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public List<PendenciaIdentificada> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<PendenciaIdentificada> pendencias) {
        this.pendencias = pendencias;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public String getAreaFuncaoParticipante() {
        return areaFuncaoParticipante;
    }

    public void setAreaFuncaoParticipante(String areaFuncaoParticipante) {
        this.areaFuncaoParticipante = areaFuncaoParticipante;
    }

    public String getAssuntoPauta() {
        return assuntoPauta;
    }

    public void setAssuntoPauta(String assuntoPauta) {
        this.assuntoPauta = assuntoPauta;
    }

    public String getResumoPauta() {
        return resumoPauta;
    }

    public void setResumoPauta(String resumoPauta) {
        this.resumoPauta = resumoPauta;
    }

    public String getAssuntoDeliberacao() {
        return assuntoDeliberacao;
    }

    public void setAssuntoDeliberacao(String assuntoDeliberacao) {
        this.assuntoDeliberacao = assuntoDeliberacao;
    }

    public String getDeliberacao() {
        return deliberacao;
    }

    public void setDeliberacao(String deliberacao) {
        this.deliberacao = deliberacao;
    }

    public String getAssuntoObservacao() {
        return assuntoObservacao;
    }

    public void setAssuntoObservacao(String assuntoObservacao) {
        this.assuntoObservacao = assuntoObservacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(String pendencia) {
        this.pendencia = pendencia;
    }

    public String getResponsavelPendencia() {
        return responsavelPendencia;
    }

    public void setResponsavelPendencia(String responsavelPendencia) {
        this.responsavelPendencia = responsavelPendencia;
    }

    public Date getDataPendencia() {
        return dataPendencia;
    }

    public void setDataPendencia(Date dataPendencia) {
        this.dataPendencia = dataPendencia;
    }

    public Orgao getOrgaoParticipante() {
        return orgaoParticipante;
    }

    public void setOrgaoParticipante(Orgao orgaoParticipante) {
        this.orgaoParticipante = orgaoParticipante;
    }

    public String getTelefoneParticipante() {
        return telefoneParticipante;
    }

    public void setTelefoneParticipante(String telefoneParticipante) {
        this.telefoneParticipante = telefoneParticipante;
    }

    public String getEmailParticipante() {
        return emailParticipante;
    }

    public void setEmailParticipante(String emailParticipante) {
        this.emailParticipante = emailParticipante;
    }

    public Orgao getOrgaoPendencia() {
        return orgaoPendencia;
    }

    public void setOrgaoPendencia(Orgao orgaoPendencia) {
        this.orgaoPendencia = orgaoPendencia;
    }

    public List<AtaDeReuniao> getAtas() {
        return atas;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public void buscar() {
        atas = getBO().listar(filtros);
    }

    public void updateHoraTermino() {
        if (getEntity().getId() == null) {
            getEntity().setHoraTermino(new Date());
        }
    }

}

package br.gov.pi.ati.agendacultural.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.cadastro.LocalEventoBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Assento;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Setor;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import br.gov.pi.ati.agendacultural.modelo.enums.DiaSemana;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LocalEventoMB extends AbstractBaseBean<LocalEvento> implements Serializable {

    @EJB
    private LocalEventoBO localEventoBO;

    private List<DiaSemana> dias;

    private List<DiaSemana> diasSelected;

    private Date horaInicial;

    private Date horaFinal;

    private List<DiaVisitacaoPortfolio> diasVisitacao;

    private Setor setorAdd;

    private Assento assentoAdd;

    private Fone foneAdd;

    private List<Setor> setores;

    private List<Fone> fones;

    private Endereco endereco;

    @Override
    public LocalEventoBO getBO() {
        return localEventoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        dias = Arrays.asList(DiaSemana.values());
        diasSelected = new ArrayList<DiaSemana>();
        diasVisitacao = new ArrayList<DiaVisitacaoPortfolio>();
        foneAdd = new Fone();
        assentoAdd = new Assento();
        setorAdd = new Setor();
        setores = new ArrayList<Setor>();
        fones = new ArrayList<Fone>();
        endereco = new Endereco();

        if (getEntity().getId() != null) {
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
            diasVisitacao = getBO().getDAO().getInitialized(getEntity().getDiaHoraVisitacao());
            setores = getBO().getDAO().getInitialized(getEntity().getSetores());
            fones = getBO().getDAO().getInitialized(getEntity().getFones());
        }
    }

    @Override
    public void save() {
        getEntity().setDiaHoraVisitacao(diasVisitacao);
        getEntity().setEndereco(endereco);
        getEntity().setSetores(setores);
        getEntity().setFones(fones);
        super.save();
    }

    public void addDias() {
        if (diasSelected.size() > 0) {
            if (horaInicial != null && horaFinal != null) {
                if (horaInicial.after(horaFinal) || horaInicial.equals(horaFinal)) {
                    FacesMessageUtils.error("Hora inicial deve ser menor que a hora final!");
                } else {
                    for (DiaSemana dia : diasSelected) {
                        DiaVisitacaoPortfolio diaAdd = new DiaVisitacaoPortfolio();
                        diaAdd.setDiaSemana(dia);
                        diaAdd.setHorarioFinal(horaFinal);
                        diaAdd.setHorarioInicial(horaInicial);

                        diasVisitacao.add(diaAdd);
                    }

                    diasSelected = new ArrayList<DiaSemana>();
                    horaFinal = null;
                    horaInicial = null;
                }
            } else {
                FacesMessageUtils.error("Hora inicial e Final são obrigatórias!");
            }
        } else {
            FacesMessageUtils.error("Seleciona ao menos um dia!");
        }
    }

    public void removerDia(DiaVisitacaoPortfolio dia) {
        diasVisitacao.remove(dia);
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Setor getSetorAdd() {
        return setorAdd;
    }

    public void setSetorAdd(Setor setorAdd) {
        this.setorAdd = setorAdd;
    }

    public Fone getFoneAdd() {
        return foneAdd;
    }

    public void setFoneAdd(Fone foneAdd) {
        this.foneAdd = foneAdd;
    }

    public Assento getAssentoAdd() {
        return assentoAdd;
    }

    public void setAssentoAdd(Assento assentoAdd) {
        this.assentoAdd = assentoAdd;
    }

    public void addFones() {
        if (Utils.isNullOrEmpty(foneAdd.getDdd())) {
            FacesMessageUtils.error("DDD é Obrigatório!");
        } else {
            if (Utils.isNullOrEmpty(foneAdd.getNumero())) {
                FacesMessageUtils.error("Número é Obrigatório!");
            } else {
                fones.add(foneAdd);
                foneAdd = new Fone();
            }
        }
    }

    public void removerFone(Fone fone) {
        fones.remove(fone);
    }

    public void addSetores() {
        if (setorAdd != null) {
            if (setorAdd.getAssentos().size() > 0) {
                if (Utils.isNullOrEmpty(setorAdd.getNome())) {
                    FacesMessageUtils.error("Nome do setor é obrigatório!");
                } else {
                    if (setorJaAdicionado(setorAdd.getNome())) {
                        FacesMessageUtils.error("Já existe um setor com esse nome!");
                    } else {
                        if (setorAdd.getQuantidadeColunas() != null && setorAdd.getQuantidadeLinhas() != null) {
                            setores.add(setorAdd);
                            setorAdd = new Setor();
                        } else {
                            FacesMessageUtils.error("Quantidades de linhas e colunas para setor são obrigatórias!");
                        }
                    }
                }
            } else {
                FacesMessageUtils.error("Setor deverá possuir assentos!");
            }
        } else {
            FacesMessageUtils.error("Setor é Obrigatório!");
        }
    }

    public void removerSetor(Setor setor) {
        setores.remove(setor);
    }

    public void addAssentos() {
        if (assentoAdd != null) {
            if (Utils.isNullOrEmpty(assentoAdd.getColuna()) || Utils.isNullOrEmpty(assentoAdd.getLinha())) {
                FacesMessageUtils.error("Quantidades de linhas e colunas para o Assento são obrigatórias!");
            } else {
                if (assentoJaAdicinado(assentoAdd.getLinha(), assentoAdd.getColuna())) {
                    FacesMessageUtils.error("Já existe assento com essa numeração!");
                } else {
                    setorAdd.getAssentos().add(assentoAdd);
                    assentoAdd = new Assento();
                }
            }
        } else {
            FacesMessageUtils.error("Assento é Obrigatório!");
        }
    }

    public void removerAssento(Assento assento) {
        setorAdd.getAssentos().remove(assento);
    }

    public boolean assentoJaAdicinado(String linha, String coluna) {
        for (Assento assento : setorAdd.getAssentos()) {
            if (assento.getColuna().equals(coluna) && assento.getLinha().equals(linha)) {
                return true;
            }
        }
        return false;
    }

    public boolean setorJaAdicionado(String nome) {
        for (Setor setore : setores) {
            if (setore.getNome().equals(nome)) {
                return true;
            }
        }

        return false;
    }

    public boolean isFlagAssento() {
        if (getEntity().getTipo() != null) {
            TipoLocal tipoTemp = getBO().getDAO().getInitialized(getEntity().getTipo());

            return tipoTemp.isAssento();
        }
        return false;
    }

    public List<DiaSemana> getDias() {
        return dias;
    }

    public void setDias(List<DiaSemana> dias) {
        this.dias = dias;
    }

    public List<DiaSemana> getDiasSelected() {
        return diasSelected;
    }

    public void setDiasSelected(List<DiaSemana> diasSelected) {
        this.diasSelected = diasSelected;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<DiaVisitacaoPortfolio> getDiasVisitacao() {
        return diasVisitacao;
    }

    public void setDiasVisitacao(List<DiaVisitacaoPortfolio> diasVisitacao) {
        this.diasVisitacao = diasVisitacao;
    }

}

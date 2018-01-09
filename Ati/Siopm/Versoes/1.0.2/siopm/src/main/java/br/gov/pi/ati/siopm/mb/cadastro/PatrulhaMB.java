package br.gov.pi.ati.siopm.mb.cadastro;

import br.gov.pi.ati.siopm.bo.cadastro.CidadeBO;
import br.gov.pi.ati.siopm.bo.cadastro.GuarnicaoViaturaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.PatrulhaBO;
import br.gov.pi.ati.siopm.bo.cadastro.ViaturaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.ItemViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Operacao;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.cadastro.StatusViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import br.gov.pi.ati.siopm.webservices.inforfolha.server.ServerWebservices;
import br.gov.pi.ati.siopm.webservices.inforfolha.server.ServerWebservicesPortType;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.thoughtworks.xstream.XStream;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PatrulhaMB extends AbstractBaseBean<Patrulha> implements Serializable {

    @EJB
    private PatrulhaBO patrulhaBO;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private ViaturaBO viaturaBO;

    private Operacao operacao;

    private Viatura viatura;

    private StatusViatura status;

    private String cpf = "";

    private String matricula = "";

    ItemViatura itemAdd = new ItemViatura();

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<GuarnicaoViatura> guarnicoes = new ArrayList<GuarnicaoViatura>();

    @Override
    public void init() {
        guarnicoes = new ArrayList<GuarnicaoViatura>();
        if (getEntity().getId() != null) {
            guarnicoes = getBO().getDAO().getInitialized(getEntity().getGuarnicoes());

        }
    }

    @Override
    public void save() {
        getEntity().setGuarnicoes(guarnicoes);
        super.save();
    }

    @Override
    public PatrulhaBO getBO() {
        return patrulhaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public StatusViatura getStatus() {
        return status;
    }

    public void setStatus(StatusViatura status) {
        this.status = status;
    }

    public ItemViatura getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(ItemViatura itemAdd) {
        this.itemAdd = itemAdd;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<GuarnicaoViatura> getGuarnicoes() {
        return guarnicoes;
    }

    public void setGuarnicoes(List<GuarnicaoViatura> guarnicoes) {
        this.guarnicoes = guarnicoes;
    }

    public void addComponenteGuarnicao() {
        if (!matricula.equals("")) {
            Viatura viaturaTemp = getBO().getDAO().getInitialized(getEntity().getViatura());
            if (viaturaTemp != null) {
                if (guarnicoes.size() < viaturaTemp.getLotacao()) {
                    if (componenteJaExiste(matricula)) {
                        FacesMessageUtils.error("O componente da Guarnição já foi adicionado para essa Patrulha!");
                    } else {
                        ServidorVO servidorVO = new ServidorVO();
                        GuarnicaoViatura componente = new GuarnicaoViatura();

                        XStream xstreamJason = new XStream();

                        ServerWebservices servicorService = new ServerWebservices();
                        ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

                        String xmlString = servidor.servidorativoxml2((matricula
                                .replace("-", "")));

                        xstreamJason.alias("servidor", ServidorVO.class);
                        String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));
                        if (!xml.equals(xmlString)) {
                            servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);
                            componente = new GuarnicaoViatura();
                            componente.setMatricula(servidorVO.getMatricula());
                            componente.setCpf(servidorVO.getCpf());
                            componente.setNome(servidorVO.getNome());
                            componente.setCargoFuncao(!servidorVO.getFuncao().equals("") ? servidorVO.getFuncao() : servidorVO.getCargo());
                            componente.setEmail(servidorVO.getEmail());
                            componente.setTelefone(servidorVO.getTelefone());

                            guarnicoes.add(componente);
                            matricula = "";

                        } else {
                            FacesMessageUtils.error("Componente não encontrado na base dados do Estado!");
                        }
                    }
                } else {
                    FacesMessageUtils.error("Lotação máxima da viatura já foi atingida!");
                }
            } else {
                FacesMessageUtils.error("Viatura é obrigatória!");
            }

        } else {
            FacesMessageUtils.error("Matrícula do Componente da Guarnição é obrigatório!");
        }

    }

    public void removerComponenteGuarnicao(GuarnicaoViatura componente) {
        guarnicoes.remove(componente);
    }

    public void seViaturaIgualNulo() {
        if (getEntity().getViatura() == null) {
            guarnicoes = new ArrayList<GuarnicaoViatura>();
        }
    }

    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadePeloEstado(17L);
    }

    private boolean componenteJaExiste(String matricula) {
        for (GuarnicaoViatura guarnicao : guarnicoes) {
            if (guarnicao.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Patrulha> autocompletePeloNomeEOpms(String nome) {
        List<Opm> opms = new ArrayList<Opm>();

        for (Organizacao org : usuarioAtual.getOrganizacoes()) {
            if (org instanceof Opm) {
                opms.add((Opm) org);
            }
        }
        return getBO().patrulhasPeloNomeEOpmAtivas(nome, opms);
    }

    public List<String> apelidosViatura() {
        return viaturaBO.apelidosPorViatura(getEntity().getViatura());
    }

}

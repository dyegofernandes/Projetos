package br.gov.pi.ati.siopm.mb.cadastro;

import br.gov.pi.ati.siopm.bo.cadastro.BairroBO;
import br.gov.pi.ati.siopm.bo.cadastro.CidadeBO;
import br.gov.pi.ati.siopm.bo.cadastro.LogradouroBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.OpcBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.Logradouro;
import br.gov.pi.ati.siopm.modelo.cadastro.Opc;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.TipoTelefone;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.XpertResourceBundle;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OpcMB extends AbstractBaseBean<Opc> implements Serializable {

    @EJB
    private OpcBO opCBO;
    @EJB
    private BairroBO bairroBO;

    @EJB
    private LogradouroBO logradouroBO;

    @EJB
    private CidadeBO cidadeBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private DualListModel<Circunscricao> bairrosDualList;

    private DualListModel<Circunscricao> cidadeDualList;

    private String numeroTelefone = "";

    private TipoTelefone tipoTelefone;

    private boolean emCascata;
    private TreeNode opcs;

    private FiltrosVO filtrosOpc;
    private FiltrosVO filtrosBairro;
    
     private Territorio territorioAdd;

    private List<Territorio> territorios;

    private Telefone telefoneAdd;

    private List<Telefone> telefones;

    private Endereco endereco;

    @Override
    public void init() {

        filtrosOpc = new FiltrosVO();
        filtrosBairro = new FiltrosVO();

        filtrosOpc.setUsuario(usuarioAtual);
        
        telefoneAdd = new Telefone();
        telefones = new ArrayList<Telefone>();
        territorioAdd = new Territorio();
        territorios = new ArrayList<Territorio>();
        endereco = new Endereco();

        if (getEntity().getId() != null) {
            territorios = getBO().getDAO().getInitialized(getEntity().getTerritorios());
            telefones = getBO().getDAO().getInitialized(getEntity().getTelefones());
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
        }

        carregarTree();
//        criarPickListInicial();
    }

    @Override
    public OpcBO getBO() {
        return opCBO;
    }

    @Override
    public String getDataModelOrder() {
        return "opc.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("opc")
                .leftJoinFetch("opc.endereco", "endereco");
    }

    @Override
    public void save() {
        getEntity().setEndereco(endereco);
        getEntity().setTerritorios(territorios);
        getEntity().setTelefones(telefones);
        super.save();

    }

    public DualListModel<Circunscricao> getBairrosDualList() {
        return bairrosDualList;
    }

    public void setBairrosDualList(DualListModel<Circunscricao> bairrosDualList) {
        this.bairrosDualList = bairrosDualList;
    }

    public DualListModel<Circunscricao> getCidadeDualList() {
        return cidadeDualList;
    }

    public void setCidadeDualList(DualListModel<Circunscricao> cidadeDualList) {
        this.cidadeDualList = cidadeDualList;
    }

    public FiltrosVO getFiltrosOpc() {
        return filtrosOpc;
    }

    public void setFiltrosOpc(FiltrosVO filtrosOpc) {
        this.filtrosOpc = filtrosOpc;
    }

    public FiltrosVO getFiltrosBairro() {
        return filtrosBairro;
    }

    public void setFiltrosBairro(FiltrosVO filtrosBairro) {
        this.filtrosBairro = filtrosBairro;
    }

    public Territorio getTerritorioAdd() {
        return territorioAdd;
    }

    public void setTerritorioAdd(Territorio territorioAdd) {
        this.territorioAdd = territorioAdd;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }

    public Telefone getTelefoneAdd() {
        return telefoneAdd;
    }

    public void setTelefoneAdd(Telefone telefoneAdd) {
        this.telefoneAdd = telefoneAdd;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Bairro> getBairros() {
        List<Bairro> bairros = null;
        if (filtrosBairro.getCidade() != null) {
            bairros = bairroBO.listarBairros(filtrosBairro);
        }

        return bairros;
    }

    public List<Logradouro> getLogradouros() {
        List<Logradouro> logradouros = null;

//        if (getEntity().getEndereco().getBairro() != null) {
//            logradouros = logradouroBO.listarLogradouroPeloBairro(getEntity().getEndereco().getBairro());
//        }
        return logradouros;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public boolean isEmCascata() {
        return emCascata;
    }

    public void setEmCascata(boolean emCascata) {
        this.emCascata = emCascata;
    }

    public TreeNode getOpcs() {
        return opcs;
    }

    public void setOpcs(TreeNode opcs) {
        this.opcs = opcs;
    }

    public void setarPai(Opc opc) {
        if (opc != null) {
            getEntity().setOrganizacaoPai(opc);
            picakListPelaUnidadePai(opc);
        }
    }

    private void picakListPelaUnidadePai(Opc opc) {
        List<Circunscricao> circunscricoesBairroSource = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesCidadeSource = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesBairroTarget = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesCidadeTarget = new ArrayList<Circunscricao>();

//        if (opc != null) {
//
//            Organizacao pai = getBO().getDAO().getInitialized(opc);
//
//            List<Circunscricao> circunscricoesCidadeTemp = getBO().getDAO().getInitialized(pai.getCircunscricoes());
//
//            for (Circunscricao circunscricoes : circunscricoesCidadeTemp) {
//                if (circunscricoes instanceof Cidade) {
//                    circunscricoesCidadeSource.add(circunscricoes);
//                }
//            }
//        } else {
//            circunscricoesCidadeSource = cidadeBO.listarCidadesComoCircunscricao(17L);
//        }
//
//        cidadeDualList = new DualListModel<Circunscricao>(circunscricoesCidadeSource, circunscricoesCidadeTarget);
//        bairrosDualList = new DualListModel<Circunscricao>(circunscricoesBairroSource, circunscricoesBairroTarget);
    }

    public void criarPickListInicial() {
        List<Circunscricao> circunscricoesBairroSource = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesCidadeSource = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesBairroTarget = new ArrayList<Circunscricao>();
        List<Circunscricao> circunscricoesCidadeTarget = new ArrayList<Circunscricao>();

//        circunscricoesCidadeSource = cidadeBO.listarCidadesComoCircunscricao(17L);

//        if (getEntity().getId() != null) {
//            Logradouro logradouro = getBO().getDAO().getInitialized(getEntity().getEndereco().getLogradouro());
////            Bairro bairro = getBO().getDAO().getInitialized(getEntity().getEndereco().getBairro());
//            Cidade cidade = getBO().getDAO().getInitialized(logradouro.getCidade());
//            filtrosBairro.setCidade(cidade);
////            filtrosBairro.setBairro(bairro);
//            List<Circunscricao> circunscricoes = opCBO.getDAO().getInitialized(getEntity().getCircunscricoes());
//            for (Circunscricao circunscricao : circunscricoes) {
//                if (circunscricao instanceof Cidade) {
//                    circunscricoesCidadeTarget.add(circunscricao);
//                }
//                if (circunscricao instanceof Bairro) {
//                    circunscricoesBairroTarget.add(circunscricao);
//                }
//            }
//        }
//        circunscricoesBairroSource = bairroBO.listarBairrosPorCidades(circunscricoesCidadeTarget);
//
//        circunscricoesCidadeSource.removeAll(circunscricoesCidadeTarget);
//        circunscricoesBairroSource.removeAll(circunscricoesBairroTarget);
//
//        cidadeDualList = new DualListModel<Circunscricao>(circunscricoesCidadeSource, circunscricoesCidadeTarget);
//        bairrosDualList = new DualListModel<Circunscricao>(circunscricoesBairroSource, circunscricoesBairroTarget);
    }

    public void criarPickListBairrosPorCidades() {
//        List<Circunscricao> bairrosSelecionados = new ArrayList<Circunscricao>();
//        List<Circunscricao> bairrosNaoSelecionados = bairroBO.listarBairrosPorCidades(cidadeDualList.getTarget());
//        for (Circunscricao circunsCidade : cidadeDualList.getTarget()) {
//            for (Circunscricao circunsBairro : bairrosDualList.getTarget()) {
//                if (((Bairro) circunsBairro).getCidade().equals(((Cidade) circunsCidade))) {
//                    bairrosSelecionados.add(circunsBairro);
//                }
//            }
//        }
//        bairrosNaoSelecionados.removeAll(bairrosSelecionados);
//        bairrosDualList = new DualListModel<Circunscricao>(bairrosNaoSelecionados, bairrosSelecionados);
    }

    public void addTelefone() {
        if (numeroTelefone.equals("")) {
            FacesMessageUtils.error("Número do Telefone é Obrigatório!");
        } else {
            if (tipoTelefone != null) {
                Telefone telefone = new Telefone();
                telefone.setNumero(numeroTelefone);
                telefone.setTipo(tipoTelefone);
                getEntity().getTelefones().add(telefone);

                numeroTelefone = "";
                tipoTelefone = null;
            } else {
                FacesMessageUtils.error("Tipo do Telefone é Obrigatório!");
            }
        }
    }

    public void removerTelefone(Telefone telefone) {

        getEntity().getTelefones().remove(telefone);
    }

    public void salvarOrdenacao() {
        opCBO.salvarOrdenacao(opcs);
        carregarTree();
        FacesMessageUtils.sucess();
    }

    public void ativar() {
        opCBO.ativar(getEntity(), emCascata);
        carregarTree();
        FacesMessageUtils.sucess();
        emCascata = false;
    }

    public void inativar() {
        opCBO.inativar(getEntity(), emCascata);
        carregarTree();
        FacesMessageUtils.sucess();
        emCascata = false;
    }

    public void deleteArvore() {
        try {
            Object id = getId();
            if (getId() != null) {
                getBO().delete(id);
                FacesMessageUtils.sucess();
                id = null;
                //recarregar tree
                carregarTree();
            }
        } catch (DeleteException ex) {
            FacesMessageUtils.error(XpertResourceBundle.get("objectCannotBeDeleted"));
        }
    }

    public void carregarTree() {
        opcs = opCBO.getTreeNode();
    }

    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadePeloEstado(17L);
    }
    
    public void addTerritorio() {
        if (territorioAdd != null) {
            if (territorioJahAdd(territorioAdd)) {
                FacesMessageUtils.error("Território já foi adicionado!");
            } else {
                territorios.add(territorioAdd);
                territorioAdd = new Territorio();
            }
        } else {
            FacesMessageUtils.error("Território é obrigatório!");
        }
    }

    public void removerTerritorio(Territorio territorio) {
        territorios.remove(territorio);
    }

    private boolean territorioJahAdd(Territorio territorio) {
        for (Territorio territorio1 : territorios) {
            if (territorio1.equals(territorio)) {
                return true;
            }
        }
        return false;
    }
}

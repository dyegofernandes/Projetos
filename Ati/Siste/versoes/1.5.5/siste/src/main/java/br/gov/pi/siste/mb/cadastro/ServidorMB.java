package br.gov.pi.siste.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CadastroPessoalBO;
import br.gov.pi.siste.bo.cadastro.CargoBO;
import br.gov.pi.siste.bo.cadastro.ServidorBO;
import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.Endereco;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import br.gov.pi.siste.util.Utils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ServidorMB extends AbstractBaseBean<Servidor> implements Serializable {

    @EJB
    private ServidorBO servidorBO;

    @EJB
    private CadastroPessoalBO cadastroPessoalBO;

    @EJB
    private CargoBO cargoBO;

    @EJB
    private UnidadeBO unidadeBO;

    private FiltrosVO filtros;

    private Usuario usuarioAtual;

    private List<Servidor> servidores;

    private List<Cargo> cargos = null;

    private List<Unidade> unidades = null;

    private String cpf;

    private Utils util = new Utils();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public List<Cargo> getCargos() {
        return cargoBO.listarCargos(filtros);
    }

    public List<Unidade> getUnidades() {
        return unidadeBO.listarUnidades(filtros);
    }

    @Override
    public ServidorBO getBO() {
        return servidorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

//        unidades = unidadeBO.listarUnidades(filtros);
//        cargos = cargoBO.listarCargos(filtros);
        if (!usuarioAtual.isSuperUsuario() && getEntity().getId() == null) {
            getEntity().getDadosFuncionais().setUnidade(usuarioAtual.getUnidade());
        }
    }

    @Override
    public void postSave() {
        setEntity(new Servidor());
        if (!usuarioAtual.isSuperUsuario()) {
            getEntity().getDadosFuncionais().setUnidade(usuarioAtual.getUnidade());
        }
    }

    public void carregarUnidadesECargosPorOrgao(Orgao orgao) {
        if (orgao != null) {
            unidades = unidadeBO.unidadesPorOrgao(filtros.getOrgao());
            cargos = cargoBO.listarCargos(orgao);
        } else {
            filtros.setUnidade(new Unidade());
            filtros.setCargo(new Cargo());
            unidades = new ArrayList<Unidade>();
            cargos = new ArrayList<Cargo>();
        }
    }

    public void carregarDadosServidor() {
        CadastroPessoal cadastroPessoal = cadastroPessoalBO.listarCadastro(cpf);

        if (cadastroPessoal != null) {
            getEntity().setEstrangeiro(cadastroPessoal.getEstrangeiro());
            getEntity().setNaturalidadeEstrangeira(cadastroPessoal.getNaturalidadeEstrangeira());
            getEntity().setNome(cadastroPessoal.getNome());
            getEntity().setCpf(cadastroPessoal.getCpf());
            getEntity().setSexo(cadastroPessoal.getSexo());
            getEntity().setDataNascimento(cadastroPessoal.getDataNascimento());
            getEntity().setNacionalidade(cadastroPessoal.getNacionalidade());
            getEntity().setNaturalidade(cadastroPessoal.getNaturalidade());
            getEntity().setEstadoCivil(cadastroPessoal.getEstadoCivil());
            getEntity().setGrauDeInstrucao(cadastroPessoal.getGrauDeInstrucao());
            getEntity().setFormacaoProfissional(cadastroPessoal.getFormacaoProfissional());
            getEntity().setPai(cadastroPessoal.getPai());
            getEntity().setMae(cadastroPessoal.getMae());
            getEntity().setRg(cadastroPessoal.getRg());
            getEntity().setCarteiraDeTrabalho(cadastroPessoal.getCarteiraDeTrabalho());
            getEntity().setTitulo(cadastroPessoal.getTitulo());
            getEntity().setEndereco(cadastroPessoal.getEndereco());
            getEntity().setTelefone1(cadastroPessoal.getTelefone1());
            getEntity().setTelefone2(cadastroPessoal.getTelefone2());
            getEntity().setEmail(cadastroPessoal.getEmail());
            getEntity().setFax(cadastroPessoal.getFax());
        } else {
            FacesMessageUtils.error("Não existe dados para esse Cpf: ".concat(util.format("###.###.###-##", cpf).concat(" cadastrado!")));
            getEntity().setCpf(cpf);
            cpf = "";
        }
    }

    public void buscarServidor() {
        servidores = servidorBO.listarServidores(filtros);
    }

    @Override
    public void remove() {
        super.remove();
        servidores = servidorBO.listarServidores(filtros);
    }

    public String getCidade() {
        if (getEntity().getDadosFuncionais().getUnidade() != null) {
            Endereco endereco = servidorBO.getDAO().getInitialized(getEntity().getDadosFuncionais().getUnidade().getEndereco());
            return servidorBO.getDAO().getInitialized(endereco.getCidade()).toString();
        }
        return null;
    }

}

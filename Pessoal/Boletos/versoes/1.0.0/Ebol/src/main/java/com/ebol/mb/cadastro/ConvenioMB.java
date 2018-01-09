package com.ebol.mb.cadastro;

import com.ebol.bo.cadastro.CidadeBO;
import com.ebol.bo.cadastro.ContatoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.ConvenioBO;
import com.ebol.bo.cadastro.PessoaOpBO;
import com.ebol.bo.cadastro.SocioBO;
import com.ebol.modelo.cadastro.Cidade;
import com.ebol.modelo.cadastro.Contato;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.PessoaOp;
import com.ebol.modelo.cadastro.Socio;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ConvenioMB extends AbstractBaseBean<Convenio> implements Serializable {

    @EJB
    private ConvenioBO convenioBO;

    @EJB
    private ContatoBO contatoBO;

    @EJB
    private SocioBO socioBO;

    @EJB
    private PessoaOpBO pessoaBO;

    @EJB
    private CidadeBO cidadeBO;

    private Contato contatoAdd;

    private PessoaOp pessoaAdd;

    private Socio socioAdd;

    private List<PessoaOp> pessoas;

    private List<PessoaOp> pessoasDeletadas;

    private List<Socio> socios;

    private List<Socio> sociosDeletados;

    private List<Contato> contatos;

    private List<Contato> contatosDeletados;

    private List<Cidade> cidades;

    private List<Convenio> convenios;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltroBusca filtros;

    public void buscar() {
        convenios = convenioBO.listarConvenios(filtros);
    }

    public Contato getContatoAdd() {
        return contatoAdd;
    }

    public List<Convenio> getConvenios() {
        convenios = convenioBO.listarConvenios(filtros);
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public void setContatoAdd(Contato contatoAdd) {
        this.contatoAdd = contatoAdd;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Contato> getContatosDeletados() {
        return contatosDeletados;
    }

    public void setContatosDeletados(List<Contato> contatosDeletados) {
        this.contatosDeletados = contatosDeletados;
    }

    @Override
    public void init() {
        filtros = new FiltroBusca();
        filtros.setUsuario(usuarioAtual);
        contatoAdd = new Contato();
        contatosDeletados = new ArrayList<Contato>();
        contatos = new ArrayList<Contato>();
        socioAdd = new Socio();
        socios = new ArrayList<Socio>();
        sociosDeletados = new ArrayList<Socio>();
        pessoaAdd = new PessoaOp();
        pessoas = new ArrayList<PessoaOp>();
        pessoasDeletadas = new ArrayList<PessoaOp>();

        if (getEntity().getId() != null) {
            contatos = contatoBO.contatosPorConvenio(getEntity());
            socios = socioBO.sociosPorConvenio(getEntity());
            pessoas = pessoaBO.pessoasPorConvenio(getEntity());
        }
    }

    @Override
    public void save() {
        super.save();
        salvandoComplementos();
    }

    public List<Cidade> getCidades() {
        cidades = cidadeBO.cidades();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public PessoaOp getPessoaAdd() {
        return pessoaAdd;
    }

    public void setPessoaAdd(PessoaOp pessoaAdd) {
        this.pessoaAdd = pessoaAdd;
    }

    public Socio getSocioAdd() {
        return socioAdd;
    }

    public void setSocioAdd(Socio socioAdd) {
        this.socioAdd = socioAdd;
    }

    public List<PessoaOp> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaOp> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public FiltroBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroBusca filtros) {
        this.filtros = filtros;
    }

    @Override
    public ConvenioBO getBO() {
        return convenioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void adicionarContato() {
        if (contatoAdd.getNome().equals("") || contatoAdd.getNome() == null) {
            FacesMessageUtils.error("Nome é obrigatório!");
        } else {
            if (verificarNomeContatos(contatoAdd.getNome())) {
                FacesMessageUtils.error("Já foi adicionado um contato com esse nome!");
            } else {
                if (contatoAdd.getTelefones().equals("") || contatoAdd.getTelefones() == null) {
                    FacesMessageUtils.error("Telefone é obrigatório!");
                } else {
                    contatoAdd.setConvenio(getEntity());
                    contatos.add(contatoAdd);
                    contatoAdd = new Contato();
                }
            }
        }
    }

    public void removerContato(Contato contatoRemovido) {
        if (contatoRemovido.getId() != null) {
            contatosDeletados.add(contatoRemovido);
        }
        contatos.remove(contatoRemovido);
    }

    private boolean verificarNomeContatos(String nome) {
        for (Contato contato : contatos) {
            if (nome.toUpperCase().equals(contato.getNome().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void adicionarSocio() {
        if (socioAdd.getNome().equals("") || socioAdd.getNome() == null) {
            FacesMessageUtils.error("Nome é obrigatório!");
        } else {
            if (verificarNomeSocio(socioAdd.getNome())) {
                FacesMessageUtils.error("Já foi adicionado um sócio com esse nome!");
            } else {
                if (socioAdd.getTelefones().equals("") || socioAdd.getTelefones() == null) {
                    FacesMessageUtils.error("Telefone é obrigatório!");
                } else {
                    socioAdd.setConvenio(getEntity());
                    socios.add(socioAdd);
                    socioAdd = new Socio();
                }
            }
        }
    }

    public void removerSocio(Socio socioRemovido) {
        if (socioRemovido.getId() != null) {
            sociosDeletados.add(socioRemovido);
        }
        socios.remove(socioRemovido);
    }

    private boolean verificarNomeSocio(String nome) {
        for (Socio socio : socios) {
            if (nome.toUpperCase().equals(socio.getNome().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void adicionarPessoa() {
        if (pessoaAdd.getNome().equals("") || pessoaAdd.getNome() == null) {
            FacesMessageUtils.error("Nome é obrigatório!");
        } else {
            if (pessoaAdd.getCpf().equals("") || pessoaAdd.getCpf() == null) {
                FacesMessageUtils.error("CPF é obrigatório!");
            } else {
                if (pessoaAdd.getRg().equals("") || pessoaAdd.getRg() == null) {
                    FacesMessageUtils.error("RG é obrigatório!");
                } else {
                    if (verificarNomePessoa(pessoaAdd.getNome())) {
                        FacesMessageUtils.error("Já foi adicionado uma Pessoa com esse nome!");
                    } else {
                        if (verificarCpfPessoa(pessoaAdd.getCpf())) {
                            FacesMessageUtils.error("Já foi adicionado uma Pessoa com esse cpf!");
                        } else {
                            if (verificarRgPessoa(pessoaAdd.getRg())) {
                                FacesMessageUtils.error("Já foi adicionado uma Pessoa com esse RG!");
                            } else {
                                pessoaAdd.setConvenio(getEntity());
                                pessoas.add(pessoaAdd);
                                pessoaAdd = new PessoaOp();
                            }
                        }
                    }
                }

            }

        }
    }

    public void removerPessoa(PessoaOp pessoaRemovido) {
        if (pessoaRemovido.getId() != null) {
            pessoasDeletadas.add(pessoaRemovido);
        }
        pessoas.remove(pessoaRemovido);
    }

    private boolean verificarNomePessoa(String nome) {
        for (PessoaOp pessoa : pessoas) {
            if (nome.toUpperCase().equals(pessoa.getNome().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarCpfPessoa(String cpf) {
        for (PessoaOp pessoa : pessoas) {
            if ((cpf.replace(".", "").replace("-", "")).equals(pessoa.getCpf())) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarRgPessoa(String rg) {
        for (PessoaOp pessoa : pessoas) {
            if ((rg.replace(".", "").replace("-", "")).equals(pessoa.getRg().replace(".", ""))) {
                return true;
            }
        }
        return false;
    }

    private void salvandoComplementos() {
        for (Contato contato : contatos) {
            contatoBO.getDAO().saveOrMerge(contato, true);
        }

        for (Contato contato : contatosDeletados) {
            try {
                contatoBO.remove(contato);
            } catch (DeleteException ex) {
                Logger.getLogger(ConvenioMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (Socio socio : socios) {
            socioBO.getDAO().saveOrMerge(socio, true);
        }

        for (Socio socio : sociosDeletados) {
            try {
                socioBO.remove(socio);
            } catch (DeleteException ex) {
                Logger.getLogger(ConvenioMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (PessoaOp pessoa : pessoas) {
            pessoaBO.getDAO().saveOrMerge(pessoa, true);
        }

        for (PessoaOp pessoa : pessoasDeletadas) {
            try {
                pessoaBO.remove(pessoa);
            } catch (DeleteException ex) {
                Logger.getLogger(ConvenioMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

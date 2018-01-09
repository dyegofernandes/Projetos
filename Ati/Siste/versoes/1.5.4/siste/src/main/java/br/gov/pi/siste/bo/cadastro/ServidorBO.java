package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.ServidorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.dao.cadastro.CadastroPessoalDAO;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.Utils;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class ServidorBO extends AbstractBusinessObject<Servidor> {

    @EJB
    private ServidorDAO servidorDAO;

    @EJB
    private CadastroPessoalDAO cadastroPessoalDAO;

    private Utils util = new Utils();

    @Override
    public ServidorDAO getDAO() {
        return servidorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("dadosFuncionais.unidade", "cpf").add("dadosFuncionais.unidade", "carteiraDeTrabalho.pisPasepNit");
    }

    @Override
    public void validate(Servidor servidor) throws BusinessException {
        CarteiraTrabalho carteira = new CarteiraTrabalho();

        carteira = getDAO().getInitialized(servidor.getCarteiraDeTrabalho());

        if (!util.validatePIS(carteira.getPisPasepNit())) {
            throw new BusinessException("Pis/Pasep inválido!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(Servidor object) throws BusinessException {

        validate(object);
        validateUniqueFields(object);
        //Colocado o merge pois estava bugando com o save por causa dos cascade 
        object = getDAO().merge(object, true);

        Restrictions restrictions = new Restrictions();
        restrictions.add("cpf", object.getCpf());

        CadastroPessoal cadastroPessoal = cadastroPessoalDAO.unique(restrictions);

        if (cadastroPessoal == null) {
            cadastroPessoal = new CadastroPessoal();
            cadastroPessoal.setNome(object.getNome());
            cadastroPessoal.setCpf(object.getCpf());
            cadastroPessoal.setSexo(object.getSexo());
            cadastroPessoal.setDataNascimento(object.getDataNascimento());

            cadastroPessoal.setNacionalidade(object.getNacionalidade());

            cadastroPessoal.setNaturalidade(object.getNaturalidade());
            cadastroPessoal.setEstadoCivil(object.getEstadoCivil());

            cadastroPessoal.setGrauDeInstrucao(object.getGrauDeInstrucao());

            cadastroPessoal.setFormacaoProfissional(object.getFormacaoProfissional());
            cadastroPessoal.setPai(object.getPai());
            cadastroPessoal.setMae(object.getMae());
            cadastroPessoal.setRg(object.getRg());

            cadastroPessoal.setCarteiraDeTrabalho(object.getCarteiraDeTrabalho());
            cadastroPessoal.setTitulo(object.getTitulo());

            cadastroPessoal.setEndereco(object.getEndereco());
            cadastroPessoal.setTelefone1(object.getTelefone1());
            cadastroPessoal.setTelefone2(object.getTelefone2());
            cadastroPessoal.setEmail(object.getEmail());
            cadastroPessoal.setFax(object.getFax());

            cadastroPessoalDAO.saveOrMerge(cadastroPessoal, true);
        }
    }

    @Override
    public void delete(Object id) throws DeleteException {
        try {
            super.delete(id);
        } catch (DeleteException ex) {
            Servidor servidor = getDAO().unique("id", id);

            if (servidor != null) {
                servidor.setAtivo(false);
                getDAO().saveOrMerge(servidor, true);
            }
        }
    }

    public Servidor getServidorPeloCodigo(Unidade unidade, String codigo) {
        Restrictions restrictions = new Restrictions();

        if (unidade != null) {
            restrictions.add("dados.unidade", unidade);
        }

        restrictions.add("servidor.cpf", codigo);

//        return getDAO().unique(restrictions);
        return (Servidor) servidorDAO.getQueryBuilder().select("servidor").from(Servidor.class, "servidor").innerJoinFetch("servidor.carteiraDeTrabalho", "carteira")
                .innerJoinFetch("servidor.rg", "rg").innerJoinFetch("servidor.dadosFuncionais", "dados").innerJoinFetch("dados.cargo", "cargo")//.setMaxResults(500)
                .innerJoinFetch("dados.unidade", "unidade").innerJoinFetch("unidade.orgao", "orgao").add(restrictions).getSingleResult();

    }

    public List<Servidor> listarServidores(FiltrosVO filtros) {
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Unidade unidade = null;
        Orgao orgao = null;
        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            orgao = getDAO().getInitialized(usuario.getOrgao());
            restrictions.add("orgao", orgao);
            if (usuario.getUnidade() != null) {
                unidade = getDAO().getInitialized(usuario.getUnidade());
                restrictions.add("unidade", unidade);
            } else {
                if (filtros.getUnidade() != null) {
                    unidade = getDAO().getInitialized(filtros.getUnidade());
                    restrictions.add("unidade", unidade);
                }
            }

        } else {
            if (filtros.getOrgao() != null) {
                orgao = getDAO().getInitialized(filtros.getOrgao());
                restrictions.add("orgao", orgao);
            }
            if (filtros.getUnidade() != null) {
                unidade = getDAO().getInitialized(filtros.getUnidade());
                restrictions.add("unidade", unidade);
            }
        }

        List<Servidor> servidores = new ArrayList<Servidor>();
        if (filtros.getRg() != null && !filtros.getRg().equals("")) {
            restrictions.add("rg.numero", filtros.getRg());
        }

        if (filtros.getCpf() != null && !filtros.getCpf().equals("")) {
            restrictions.add("servidor.cpf", filtros.getCpf());
        }

        if (filtros.getPis() != null && !filtros.getPis().equals("")) {
            restrictions.add("carteira.pisPasepNit", filtros.getPis());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("servidor.nome", filtros.getNome());
        }

        if (filtros.getCargo() != null) {
            restrictions.add("cargo", filtros.getCargo());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("dados.dataInclusao", filtros.getDataInicial(), TemporalType.DATE);
        }
        
        if(filtros.getDataFinal()!=null){
            restrictions.lessEqualsThan("dados.dataInclusao", filtros.getDataFinal(), TemporalType.DATE);
        }

        servidores = servidorDAO.getQueryBuilder().select("servidor").from(Servidor.class, "servidor").innerJoinFetch("servidor.carteiraDeTrabalho", "carteira")
                .innerJoinFetch("servidor.rg", "rg").innerJoinFetch("servidor.dadosFuncionais", "dados").innerJoinFetch("dados.cargo", "cargo")//.setMaxResults(500)
                .innerJoinFetch("dados.unidade", "unidade").innerJoinFetch("unidade.orgao", "orgao").add(restrictions).orderBy("orgao, unidade, servidor.nome").getResultList();

        return servidores;
    }
}

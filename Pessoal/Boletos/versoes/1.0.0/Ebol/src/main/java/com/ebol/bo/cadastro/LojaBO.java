package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.LojaDAO;
import com.ebol.modelo.cadastro.Banco;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class LojaBO extends AbstractBusinessObject<Loja> {
    
    @EJB
    private LojaDAO lojaDAO;
    
    @Override
    public LojaDAO getDAO() {
        return lojaDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }
    
    @Override
    public void validate(Loja loja) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Loja> listarLoja(FiltroBusca filtros) {
        List<Loja> lojas = null;
        Restrictions restrictions = new Restrictions();
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        if (!usuario.isSuperUsuario()) {
            restrictions.add("banco", getDAO().getInitialized(usuario.getBanco()));
        } else {
            if (filtros.getBanco() != null) {
                restrictions.add("banco", filtros.getBanco());
            }
        }
        
        if (filtros.getCpfCnpj() != null) {
            restrictions.add("loja.cnpj", filtros.getCpfCnpj());
        }
        
        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                restrictions.equals("loja.razaosocial", filtros.getNome());
            }
        }
        
        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }
        
        if (filtros.getAtivo() != null) {
            restrictions.add("loja.ativo", filtros.getAtivo());
        }
        
        lojas = getDAO().getQueryBuilder().select("loja").from(Loja.class, "loja").leftJoinFetch("loja.banco", "banco")
                .leftJoinFetch("loja.cidade", "cidade").orderBy("loja, nome")
                .getResultList();
        
        return lojas;
    }
    
}

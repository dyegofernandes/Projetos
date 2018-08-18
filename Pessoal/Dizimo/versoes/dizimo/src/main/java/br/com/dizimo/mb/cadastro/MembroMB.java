package br.com.dizimo.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.MembroBO;
import br.com.dizimo.modelo.cadastro.Membro;
import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.enums.EstadoCivil;
import br.com.dizimo.util.SessaoUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MembroMB extends AbstractBaseBean<Membro> implements Serializable {
    
    @EJB
    private MembroBO membroBO;
    
    private Usuario usuarioAtual;
    
    @Override
    public MembroBO getBO() {
        return membroBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "membro.nome";
    }
    
    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("membro")
                .leftJoinFetch("membro.sede", "sede")
                .leftJoinFetch("membro.endereco", "endereco");
    }
    
    @Override
    public void init() {
        
        usuarioAtual = SessaoUtils.getUser();
        
        if (getEntity().getId() == null) {
            getEntity().setSede(usuarioAtual.getSede());
        }
    }
    
    @Override
    public void save() {
        getEntity().setDataAtualizacao(new Date());
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void mudarEstadoCivil() {
        if (getEntity().getEstadoCivil() == EstadoCivil.SOLTEIRO || getEntity().getEstadoCivil() == EstadoCivil.VIUVO
                || getEntity().getEstadoCivil() == EstadoCivil.SEPARADO || getEntity().getEstadoCivil() == EstadoCivil.DIVORCIADO) {
            getEntity().setDataCasamento(null);
            getEntity().setNomeConjuge(null);
        }
    }
}

package br.gov.pi.salvemaria.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.denuncia.DenunciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class DenunciaBO extends AbstractBusinessObject<Denuncia> {

    @EJB
    private DenunciaDAO denunciaDAO;

    @Override
    public DenunciaDAO getDAO() {
        return denunciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Denuncia denuncia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Denuncia> listar(Filtros filtros) {
        List<Denuncia> denuncias = new ArrayList<Denuncia>();

        Restrictions restrictions = new Restrictions();
        
//        if(filtros.getUsuario().isSuperUsuario()){
//            if(filtros.getUnidade()!=null){
//                restrictions.add("unidade", filtros.getUnidade());
//            }
//        }else{
//            restrictions.add("unidade", getDAO().getInitialized(filtros.getUsuario()).getu);
//        }

        if (filtros.getTipo() != null) {
            restrictions.add("denuncia.tipo", filtros.getTipo());
        }

        if (filtros.getSituacao() != null) {
            restrictions.add("denuncia.situacao", filtros.getSituacao());
        }

        denuncias = denunciaDAO.getQueryBuilder().select("denuncia").from(Denuncia.class, "denuncia").innerJoinFetch("denuncia.unidade", "unidade").innerJoinFetch("denuncia.endereco", "endereco").
                innerJoinFetch("endereco.bairro", "bairro").add(restrictions).orderBy("denuncia.dataDenuncia DESC, denuncia.horaDenuncia DESC").getResultList();

        return denuncias;
    }
}

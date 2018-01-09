package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.CidadeDAO;
import br.gov.pi.ati.siopm.dao.cadastro.CircunscricaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;
import com.xpert.core.validation.UniqueFields;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeBO extends AbstractBusinessObject<Cidade> {

    @EJB
    private CidadeDAO cidadeDAO;

    @EJB
    private CircunscricaoDAO circunscricaoDAO;

    @Override
    public CidadeDAO getDAO() {
        return cidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("estado", "nome");
    }

    @Override
    public void validate(Cidade cidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Circunscricao> listarCidadesComoCircunscricao(Long id_Estado) {
        List<Circunscricao> circunscricoes = new ArrayList<Circunscricao>();
        List<Cidade> cidades = getDAO().list("estado_id", id_Estado, "nome");

//        for (Cidade cidade : cidades) {
//            circunscricoes.add((Circunscricao) cidade);
//        }

        return circunscricoes;

    }

    public List<Cidade> listarCidadePeloEstado(Long id_Estado) {
        return getDAO().list("estado_id", id_Estado, "nome");
    }

}

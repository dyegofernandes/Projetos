package br.gov.pi.ati.sisdh.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.denuncia.DenunciaDAO;
import br.gov.pi.ati.sisdh.modelo.FiltroVO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import br.gov.pi.ati.sisdh.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;
import javax.persistence.TemporalType;

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
        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(new UniqueField("numeroDenuncia").setMessage("Número da Denúncia já foi encontrado no Sistema, clique novamente em salvar para gerar outro número!!!"));
        return uniqueFields;
    }

    @Override
    public void validate(Denuncia denuncia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarCodigo() {
        String dataAtualString = Utils.convertDateToString(new Date(), "yyyyMMdd");
        Long id = (Long) getDAO().getQueryBuilder().from(Denuncia.class).max("id");

        Denuncia denuncia = getDAO().unique("id", id);

        if (denuncia != null) {
            if (denuncia.getNumeroDenuncia().substring(0, 8).equals(dataAtualString)) {
                Integer codigoTemp = new Integer(denuncia.getNumeroDenuncia()) + 1;
                return codigoTemp.toString();
            }
        }

        return dataAtualString.concat("000001");
    }

    public List<Denuncia> consultar(FiltroVO filtros) {

        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(filtros.getCodigo())) {
            restrictions.add("denuncia.protocolo", filtros.getCodigo());
        }

        if (!Utils.isNullOrEmpty(filtros.getNumero())) {
            restrictions.add("denuncia.numeroDenuncia", filtros.getNumero());
        }

        if (filtros.getDataInicial1() != null) {
            restrictions.greaterEqualsThan("denuncia.dataDenuncia", filtros.getDataInicial1(), TemporalType.DATE);
        }

        if (filtros.getDataFinal1() != null) {
            restrictions.lessEqualsThan("denuncia.dataDenuncia", filtros.getDataFinal1(), TemporalType.DATE);
        }
        
        

        return getDAO().getQueryBuilder().select("denuncia").from(Denuncia.class, "denuncia").leftJoinFetch("denuncia.grupoDeViolacao", "grupoDeViolacao")
                .leftJoinFetch("denuncia.naturezaDaViolacao", "naturezaDaViolacao").leftJoinFetch("denuncia.enderecoDenuncia", "endereco")
                .leftJoin("denuncia.unidadeOrigem", "unidadeOrigem").leftJoinFetch("denuncia.unidadeResponsavel", "unidadeResponsavel")
                .add(restrictions).orderBy("denuncia.dataDenuncia").getResultList();
    }

}

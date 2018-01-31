package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.OrgaoDAO;
import br.com.weblicita.modelo.cadastro.Fornecedor;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Orgao;
import br.com.weblicita.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoBO extends AbstractBusinessObject<Orgao> {

    @EJB
    private OrgaoDAO orgaoDAO;

    @Override
    public OrgaoDAO getDAO() {
        return orgaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Orgao orgao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarCodigo() {
//OR.ANO.10 
        String codigo = "OR.";

        String anoAtual = Utils.getAno(new Date());

        Long id = (Long) getDAO().getQueryBuilder().from(Orgao.class).max("id");

        Orgao orgao = getDAO().unique("id", id);

        if (orgao != null) {
            String[] codigoTemp = new String[3];

            codigoTemp = orgao.getCodigo().split("\\.");

            String anoOrgao = codigoTemp[1];

            Integer sequencial = new Integer(codigoTemp[2]);

            if (anoAtual.equals(anoOrgao)) {
                sequencial++;
                codigo = codigo.concat(anoOrgao).concat(".").concat(Utils.inserirZeroDireita(sequencial.toString(), 10));
            } else {
                codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
            }

        } else {
            codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
        }

        return codigo;
    }

    public List<Orgao> orgaoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.add("cnpj", nome.replace(".", "").replace("/", "").replace("-", ""));
            } else {
                restrictions.like("nome", nome);
            }
        }

        return getDAO().list(restrictions, "nome");
    }
}

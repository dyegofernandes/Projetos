package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.BoletoDAO;
import br.com.pagcontascarne.modelo.dados.Banco;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Boleto;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoBO extends AbstractBusinessObject<Boleto> {

    @EJB
    private BoletoDAO boletoDAO;

    @Override
    public BoletoDAO getDAO() {
        return boletoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nossonumero").add("cb");
    }

    @Override
    public void validate(Boleto boleto) throws BusinessException {
        if (boleto.getDt_vencimento().before(new Date())) {
            throw new BusinessException("Data do Vencimento do Boleto não pode ser interior a Data Atual!");
        }

        if (boleto.getQtd_total_parcela() < boleto.getNr_parcela()) {
            throw new BusinessException("Quantidade de Parcelas não pode ser menor que o Número de Parcelas!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String getCodigoDeBarrasSicoob(Boleto boleto) {
        StringBuilder stringBuilder = new StringBuilder();
        if (boleto == null) {
            return null;
        }

        Banco banco = getDAO().getInitialized(boleto.getBanco());
//        Cliente cliente = getDAO().getInitialized(boleto.getCliente());

        stringBuilder.append(Utils.inserirZeroEsquerda(banco.getCodigo(), 3));
        stringBuilder.append(Utils.inserirZeroEsquerda(banco.getCodigo(), 3));
        stringBuilder.append(Utils.inserirZeroEsquerda("9", 1));
        stringBuilder.append(Utils.inserirZeroEsquerda(Utils.fatorVencimento(boleto.getDt_vencimento()).toString(), 4));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getVl_nominal().toString().replace(".", "").replace(",", ""), 10));
        stringBuilder.append(Utils.inserirZeroEsquerda("1", 1));
        stringBuilder.append(Utils.inserirZeroEsquerda("4353", 4));
        stringBuilder.append(Utils.inserirZeroEsquerda("1", 2));
        stringBuilder.append(Utils.inserirZeroEsquerda("0031020", 7));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getNossonumero().toString(), 8));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getNr_parcela().toString(), 3));

        String dv = String.valueOf(Utils.getMod11(stringBuilder.toString()));

        return stringBuilder.insert(4, dv).toString();
    }

    public String linhaEditavel(String cb) {

        StringBuilder stringBuilder = new StringBuilder();

        String codigoBanco = cb.substring(0, 4);
        String codigoMoeda = cb.substring(3, 4);
        String dv11 = cb.substring(4, 5);
        String fatorVencimento = cb.substring(5, 9);
        String valorNominal = cb.substring(9, 19);
        String carteira = cb.substring(19, 20);
        String codigoCoper = cb.substring(20, 24);
        String modalidade = cb.substring(24, 26);
        String codigoCliente = cb.substring(26, 33);
        String numeroTitulo = cb.substring(33, 41);
        String parcela = cb.substring(41, 44);

        stringBuilder.append(codigoBanco);
        stringBuilder.append(codigoMoeda);
        stringBuilder.append(carteira);
        stringBuilder.append(codigoCoper);
        stringBuilder.append(modalidade);
        stringBuilder.append(codigoCliente);
        stringBuilder.append(numeroTitulo);
        stringBuilder.append(parcela);

        stringBuilder.insert(9, Utils.getMod10(stringBuilder.substring(0, 9)));
        stringBuilder.insert(5, ".");
        stringBuilder.insert(11, " ");

        stringBuilder.insert(22, Utils.getMod10(stringBuilder.substring(12, 22)));
        stringBuilder.insert(23, " ");
        stringBuilder.insert(34, Utils.getMod10(stringBuilder.substring(24, 34)));

        stringBuilder.insert(29, ".");
        stringBuilder.insert(36, " ");
        stringBuilder.insert(37, dv11);
        stringBuilder.insert(38, " ");
        stringBuilder.append(fatorVencimento);
        stringBuilder.append(valorNominal);

        return stringBuilder.toString();
    }

    public Long proximoNossoNumero() {
        Long nossoNum = 1L;
        Long id = (Long) getDAO().getQueryBuilder().from(Boleto.class).max("id");

        Boleto boletoTemp = getDAO().unique("id", id);

        if (boletoTemp != null) {
            nossoNum = boletoTemp.getNossonumero() + 1;
        }

        return nossoNum;
    }

    public List<Boleto> listar(FiltrosBusca filtros) {

        Restrictions restrictions = new Restrictions();

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (filtros.getCliente() != null) {
            restrictions.add("cliente", filtros.getCliente());
        }

        if (filtros.getProduto() != null) {
            restrictions.add("produto", filtros.getProduto());
        }

        if (filtros.getBanco1() != null) {
            restrictions.add("banco", filtros.getBanco1());
        }

        if (filtros.getDeposito() != null) {
            restrictions.add("deposito", filtros.getDeposito());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("boleto.dt_vencimento", filtros.getDataInicial(), TemporalType.DATE);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("boleto.dt_vencimento", filtros.getDataFinal(), TemporalType.DATE);
        }

        return getDAO().getQueryBuilder().from(Boleto.class, "boleto").leftJoinFetch("boleto.cliente", "cliente")
                .leftJoinFetch("boleto.produto", "produto").leftJoinFetch("boleto.convenio", "convenio").leftJoinFetch("boleto.deposito", "deposito")
                .leftJoinFetch("boleto.banco", "banco").add(restrictions).orderBy("boleto.convenio, boleto.dt_vencimento").getResultList();
    }
}

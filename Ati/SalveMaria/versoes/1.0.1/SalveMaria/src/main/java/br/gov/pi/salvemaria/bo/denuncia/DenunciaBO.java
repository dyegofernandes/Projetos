package br.gov.pi.salvemaria.bo.denuncia;

import br.gov.pi.salvemaria.bo.cadastro.CircunscricaoBO;
import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.denuncia.DenunciaDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.FaixaEtaria;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.vos.DenunciaPorTerritorioAuxVO;
import br.gov.pi.salvemaria.modelo.vos.DenunciaPorTerritorioPrincipalVO;
import br.gov.pi.salvemaria.modelo.vos.DestribuicaoViolenciaPorTDVO;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.modelo.vos.QtdDenunciaPorFormaViolenciaVO;
import br.gov.pi.salvemaria.modelo.vos.QtdDenunciaPorTerritorioVO;
import br.gov.pi.salvemaria.modelo.vos.QtdDenunciaPorUnidadeVO;
import br.gov.pi.salvemaria.util.Utils;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.persistence.query.Restrictions;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author Juniel
 */
@Stateless
public class DenunciaBO extends AbstractBusinessObject<Denuncia> {

    @EJB
    private DenunciaDAO denunciaDAO;

    @EJB
    private CircunscricaoBO territorioBO;

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
        if (denuncia.getId() == null && denuncia.getTipo() == TipoDenuncia.PANICO) {
            throw new BusinessException("Denúnca do tipo Pânico só pode ser criada pelo Aplicativo!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Denuncia> listar(Filtros filtros) {

        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());

        List<Denuncia> denuncias = new ArrayList<Denuncia>();

        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            Unidade unidade = getDAO().getInitialized(usuario.getUnidade());
            if (unidade != null) {
                Circunscricao circu = getDAO().getInitialized(unidade.getCircunscricao());
                Circunscricao_Bairro circuBairro = getDAO().getInitialized(unidade.getCircunscricaoBairro());
                if (circuBairro != null) {
                    restrictions.add("circunscricaoBairro", circuBairro);
                } else {
                    restrictions.add("circunscricao", circu);
                }

                if (unidade.getFaixaEtariaDeDenuncias() == FaixaEtaria.IDOSO) {
                    restrictions.greaterEqualsThan("denuncia.idadeVitima", 60);
                }

                if (unidade.getFaixaEtariaDeDenuncias() == FaixaEtaria.MENOR_DE_IDADE) {
                    restrictions.greaterEqualsThan("denuncia.idadeVitima", 0);
                    restrictions.lessThan("denuncia.idadeVitima", 18);
                }

                if (unidade.getFaixaEtariaDeDenuncias() == FaixaEtaria.MAIOR_DE_IDADE_OU_SEM_IDADE) {
                    restrictions.startGroup().startGroup().greaterEqualsThan("denuncia.idadeVitima", 18).lessThan("denuncia.idadeVitima", 60).endGroup()
                            .or().isNull("denuncia.idadeVitima").endGroup();
                }

                if (unidade.getVisualizarDenunciaNormal() != null && unidade.getVisualizarDenunciaPanico() != null) {
                    if (unidade.getVisualizarDenunciaNormal() && unidade.getVisualizarDenunciaPanico()) {
                        restrictions.startGroup().add("denuncia.tipo", TipoDenuncia.DENUNCIA).or().
                                add("denuncia.tipo", TipoDenuncia.PANICO).endGroup();
                    }

                    if (!unidade.getVisualizarDenunciaNormal() && unidade.getVisualizarDenunciaPanico()) {
                        restrictions.add("denuncia.tipo", TipoDenuncia.PANICO);
                    }

                    if (unidade.getVisualizarDenunciaNormal() && !unidade.getVisualizarDenunciaPanico()) {
                        restrictions.add("denuncia.tipo", TipoDenuncia.DENUNCIA);
                    }
                } else {
                    restrictions.startGroup().add("denuncia.tipo", TipoDenuncia.DENUNCIA).or().
                            add("denuncia.tipo", TipoDenuncia.PANICO).endGroup();
                }
            }

            if (filtros.getTipo() != null) {
                restrictions.add("denuncia.tipo", filtros.getTipo());
            }
        }

        if (filtros.getUnidade() != null) {
            Unidade unidade = getDAO().getInitialized(filtros.getUnidade());
            Circunscricao circu = getDAO().getInitialized(unidade.getCircunscricao());
            Circunscricao_Bairro circuBairro = getDAO().getInitialized(unidade.getCircunscricaoBairro());
            if (circuBairro != null) {
                restrictions.add("circunscricaoBairro", circuBairro);
            } else {
                restrictions.add("circunscricao", circu);
            }

        }

        if (filtros.getFaixaEtaria() != null) {
            if (filtros.getFaixaEtaria() == FaixaEtaria.IDOSO) {
                restrictions.greaterEqualsThan("denuncia.idadeVitima", 60);
            }

            if (filtros.getFaixaEtaria() == FaixaEtaria.MENOR_DE_IDADE) {
                restrictions.greaterEqualsThan("denuncia.idadeVitima", 0);
                restrictions.lessThan("denuncia.idadeVitima", 18);
            }
            if (filtros.getFaixaEtaria() == FaixaEtaria.MAIOR_DE_IDADE_OU_SEM_IDADE) {
                restrictions.startGroup().startGroup().greaterEqualsThan("denuncia.idadeVitima", 18).lessThan("denuncia.idadeVitima", 60).endGroup()
                        .or().isNull("denuncia.idadeVitima").endGroup();
            }
        }

        if (filtros.getTipo() != null) {
            restrictions.add("denuncia.tipo", filtros.getTipo());
        }

        if (filtros.getFormaDeViolencia() != null) {
            restrictions.add("denuncia.formaDeViolencia", filtros.getFormaDeViolencia());
        }

        if (filtros.getSituacao() != null) {
            restrictions.add("denuncia.situacao", filtros.getSituacao());
        }

        if (filtros.getDataDenunciaInicial() != null) {
            restrictions.greaterEqualsThan("denuncia.dataDenuncia", filtros.getDataDenunciaInicial());
        }

        if (filtros.getDataDenunciaFinal() != null) {
            restrictions.lessEqualsThan("denuncia.dataDenuncia", filtros.getDataDenunciaFinal());
        }

        if (filtros.getId() != null) {
            restrictions.add("denuncia.id", filtros.getId());
        }

        if (filtros.getVitima() != null) {
            if (!filtros.getVitima().equals("")) {
                restrictions.like("denuncia.vitima", filtros.getVitima());
            }
        }

        if (filtros.getCpfVitima() != null) {
            if (!filtros.getCpfVitima().equals("")) {
                restrictions.like("denuncia.cpfVitima", filtros.getCpfVitima().replace(".", "").replace("-", ""));
            }
        }

        if (filtros.getCpfAgressor() != null) {
            if (!filtros.getCpfAgressor().equals("")) {
                restrictions.like("denuncia.cpfAgressor", filtros.getCpfAgressor().replace(".", "").replace("-", ""));
            }
        }

        if (filtros.getRgVitima() != null) {
            if (!filtros.getRgVitima().equals("")) {
                restrictions.like("denuncia.rgVitima", filtros.getRgVitima());
            }
        }

        if (filtros.getRgAgressor() != null) {
            if (!filtros.getRgAgressor().equals("")) {
                restrictions.like("denuncia.rgAgressor", filtros.getRgAgressor());
            }
        }

        if (filtros.getCnhVitima() != null) {
            if (!filtros.getCnhVitima().equals("")) {
                restrictions.like("denuncia.cnhVitima", filtros.getCnhVitima());
            }
        }

        if (filtros.getCnhAgressor() != null) {
            if (!filtros.getCnhAgressor().equals("")) {
                restrictions.like("denuncia.cnhAgressor", filtros.getCnhAgressor());
            }
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }
        
        if(filtros.getBairro()!=null){
            restrictions.add("bairro", filtros.getBairro());
        }

        if (filtros.getAgressor() != null) {
            if (!filtros.getAgressor().equals("")) {
                restrictions.like("denuncia.agressor", filtros.getAgressor());
            }
        }

        if (filtros.getCircunscricao() != null) {
            restrictions.add("circunscricao", filtros.getCircunscricao());
        }

        if (filtros.getCircunscricaoBairro() != null) {
            restrictions.add("circunscricaoBairro", filtros.getCircunscricaoBairro());
        }

        denuncias = denunciaDAO.getQueryBuilder().select("denuncia").from(Denuncia.class, "denuncia").leftJoinFetch("denuncia.endereco", "endereco")
                .leftJoinFetch("denuncia.unidade", "unidade").leftJoinFetch("endereco.bairro", "bairro").leftJoinFetch("bairro.circunscricao_Bairro", "circunscricaoBairro")
                .leftJoinFetch("bairro.cidade", "cidade").leftJoinFetch("cidade.circunscricao", "circunscricao").add(restrictions)
                .orderBy("denuncia.dataDenuncia DESC, denuncia.horaDenuncia DESC").getResultList();
        return denuncias;
    }

    public List<QtdDenunciaPorUnidadeVO> qtdDenunciaPorUnidade(Unidade unidade, Date dataInicial, Date dataFinal) {

        String unidade_Id = "";
        if (unidade != null) {
            unidade_Id = unidade_Id.concat("u.id=").concat(unidade.getId().toString()).concat(" and ");
        }

        if (dataInicial == null && dataFinal == null) {
            dataInicial = Utils.setarData(1, 0, 2017);
            dataFinal = new Date();
        }

        if (dataInicial != null && dataFinal == null) {
            dataFinal = new Date();
        }

        if (dataInicial == null && dataFinal != null) {
            dataInicial = Utils.setarData(1, 0, 2017);
        }

        List<QtdDenunciaPorUnidadeVO> denuncias = new ArrayList<QtdDenunciaPorUnidadeVO>();

        String queryString = "select u.nome, count(*) as total from denuncia d left join unidade u on (d.unidade_id=u.id) "
                + "where UNIDADE_COND d.datadenuncia>='DATA_INICIAL' and d.datadenuncia<='DATA_FINAL' "
                + "group by u.nome order by u.nome";

        queryString = queryString.replace("DATA_INICIAL", Utils.convertDateToString(dataInicial, "yyyy-MM-dd"))
                .replace("DATA_FINAL", Utils.convertDateToString(dataFinal, "yyyy-MM-dd")).replace("UNIDADE_COND", unidade_Id);

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            QtdDenunciaPorUnidadeVO denuncia = new QtdDenunciaPorUnidadeVO();
            denuncia.setNomeUnidade((String) tupla[0]);
            denuncia.setQuantidade(((BigInteger) tupla[1]).intValue());

            denuncias.add(denuncia);
        }

        return denuncias;
    }

    public List<QtdDenunciaPorTerritorioVO> qtdDenunciaPorTerritorio(Circunscricao territorio, Date dataInicial, Date dataFinal) {
        List<QtdDenunciaPorTerritorioVO> denuncias = new ArrayList<QtdDenunciaPorTerritorioVO>();
        String territorio_id = "";
        if (territorio != null) {
            territorio_id = ("c.id=" + territorio.getId() + " and");
        }

        if (dataInicial == null && dataFinal == null) {
            dataInicial = Utils.setarData(1, 0, 2017);
            dataFinal = new Date();
        }

        if (dataInicial != null && dataFinal == null) {
            dataFinal = new Date();
        }

        if (dataInicial == null && dataFinal != null) {
            dataInicial = Utils.setarData(1, 0, 2017);
        }

        String queryString = "select c.nome, count(*) as total from denuncia d left join unidade u on (d.unidade_id=u.id) "
                + "left join circunscricao c on (c.id=u.circunscricao_id) "
                + "where TERRITORIO_ID d.datadenuncia>='DATA_INICIAL' and d.datadenuncia<='DATA_FINAL' "
                + "group by c.nome order by c.nome";

        queryString = queryString.replace("DATA_INICIAL", Utils.convertDateToString(dataInicial, "yyyy-MM-dd"))
                .replace("DATA_FINAL", Utils.convertDateToString(dataFinal, "yyyy-MM-dd")).replace("TERRITORIO_ID", territorio_id);

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            QtdDenunciaPorTerritorioVO denuncia = new QtdDenunciaPorTerritorioVO();
            denuncia.setNomeTerritorio((String) tupla[0]);
            denuncia.setQuantidade(((BigInteger) tupla[1]).intValue());

            denuncias.add(denuncia);
        }

        return denuncias;

    }

    public List<QtdDenunciaPorFormaViolenciaVO> qtdDenunciaPorFormaDeViolencia(FormasDeViolencia violencia, Date dataInicial, Date dataFinal) {
        List<QtdDenunciaPorFormaViolenciaVO> denuncias = new ArrayList<QtdDenunciaPorFormaViolenciaVO>();

        String numeroViolencia = "";

        if (violencia != null) {
            numeroViolencia = "d.formaDeViolencia=" + violencia.getNum() + " and";
        }

        if (dataInicial == null && dataFinal == null) {
            dataInicial = Utils.setarData(1, 0, 2017);
            dataFinal = new Date();
        }

        if (dataInicial != null && dataFinal == null) {
            dataFinal = new Date();
        }

        if (dataInicial == null && dataFinal != null) {
            dataInicial = Utils.setarData(1, 0, 2017);
        }

        String queryString = "select d.formadeviolencia, count(*) as total from denuncia d "
                + "where NUMERO_VIOLENCIA d.datadenuncia>='DATA_INICIAL' and d.datadenuncia<='DATA_FINAL' "
                + "group by d.formadeviolencia order by d.formadeviolencia";

        queryString = queryString.replace("DATA_INICIAL", Utils.convertDateToString(dataInicial, "yyyy-MM-dd"))
                .replace("DATA_FINAL", Utils.convertDateToString(dataFinal, "yyyy-MM-dd")).replace("NUMERO_VIOLENCIA", numeroViolencia);

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            QtdDenunciaPorFormaViolenciaVO denuncia = new QtdDenunciaPorFormaViolenciaVO();
            denuncia.setNomeFormaViolencia(Utils.getFormaDeViolencia(((Integer) tupla[0])).getDescricao());
            denuncia.setQuantidade(((BigInteger) tupla[1]).intValue());

            denuncias.add(denuncia);
        }

        return denuncias;

    }

    public List<DenunciaPorTerritorioPrincipalVO> qtdDenunciasPorTerritorioEFormaDeViolencia(Date dataInicial, Date dataFinal) {
        List<DenunciaPorTerritorioPrincipalVO> denuncias = new ArrayList<DenunciaPorTerritorioPrincipalVO>();
        List<Circunscricao> territorios = territorioBO.getDAO().listAll("nome");

        if (dataInicial == null && dataFinal == null) {
            dataInicial = Utils.setarData(1, 0, 2017);
            dataFinal = new Date();
        }

        if (dataInicial != null && dataFinal == null) {
            dataFinal = new Date();
        }

        if (dataInicial == null && dataFinal != null) {
            dataInicial = Utils.setarData(1, 0, 2017);
        }

        String queryString = "select c.id, c.nome, d.formadeviolencia, count(*) as total from denuncia d left join unidade u on (d.unidade_id=u.id) "
                + "left join circunscricao c on (c.id=u.circunscricao_id) "
                + "where d.datadenuncia>='DATA_INICIAL' and d.datadenuncia<='DATA_FINAL' "
                + "group by c.id, c.nome, d.formadeviolencia order by c.nome, d.formadeviolencia";

        queryString = queryString.replace("DATA_INICIAL", Utils.convertDateToString(dataInicial, "yyyy-MM-dd"))
                .replace("DATA_FINAL", Utils.convertDateToString(dataFinal, "yyyy-MM-dd"));

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();
        for (Circunscricao territorioFor : territorios) {
            DenunciaPorTerritorioPrincipalVO denuncia = new DenunciaPorTerritorioPrincipalVO();
            Circunscricao territorioTemp = getDAO().getInitialized(territorioFor);
            Integer total = 0;

            denuncia.setId(territorioTemp.getId());
            denuncia.setNome(territorioTemp.getNome());

            List<DenunciaPorTerritorioAuxVO> denunciasAux = new ArrayList<DenunciaPorTerritorioAuxVO>();

            for (Object[] tupla : resultado) {
                Circunscricao territorioAprocurar = territorioBO.getDAO().unique("id", ((BigInteger) tupla[0]).longValue());
                DenunciaPorTerritorioAuxVO denunciaAux = new DenunciaPorTerritorioAuxVO();

                if (territorioTemp.equals(territorioAprocurar)) {
                    denunciaAux.setViolencia(Utils.getFormaDeViolencia(((Integer) tupla[2])).getDescricao());
                    denunciaAux.setTotal(((BigInteger) tupla[3]).intValue());
                    total += ((BigInteger) tupla[3]).intValue();
                    denunciasAux.add(denunciaAux);
                }
            }

            denuncia.setViolencias(denunciasAux);
            denuncia.setTotal(total);

            if (denuncia.getViolencias().size() > 0) {
                denuncias.add(denuncia);
            }

        }

        return denuncias;
    }

    public List<DestribuicaoViolenciaPorTDVO> designacaoPorFormaViolenciaPorTD(Date dataInicial, Date dataFinal) {
        List<DestribuicaoViolenciaPorTDVO> denuncias = new ArrayList<DestribuicaoViolenciaPorTDVO>();

        if (dataInicial == null && dataFinal == null) {
            dataInicial = Utils.setarData(1, 0, 2017);
            dataFinal = new Date();
        }

        if (dataInicial != null && dataFinal == null) {
            dataFinal = new Date();
        }

        if (dataInicial == null && dataFinal != null) {
            dataInicial = Utils.setarData(1, 0, 2017);
        }

        String queryString = "select c.id, c.nome, d.formadeviolencia, count(*) as total from denuncia d left join unidade u on (d.unidade_id=u.id) "
                + "left join circunscricao c on (c.id=u.circunscricao_id) "
                + "where d.datadenuncia>='DATA_INICIAL' and d.datadenuncia<='DATA_FINAL' "
                + "group by c.id, c.nome, d.formadeviolencia order by c.nome, d.formadeviolencia";

        queryString = queryString.replace("DATA_INICIAL", Utils.convertDateToString(dataInicial, "yyyy-MM-dd"))
                .replace("DATA_FINAL", Utils.convertDateToString(dataFinal, "yyyy-MM-dd"));

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            DestribuicaoViolenciaPorTDVO denuncia = new DestribuicaoViolenciaPorTDVO();

            denuncia.setId(((BigInteger) tupla[0]).longValue());
            denuncia.setNomeTerritorio((String) tupla[1]);
            denuncia.setTipoViolencia(Utils.getFormaDeViolencia(((Integer) tupla[2])).getDescricao());
            denuncia.setTotal(((BigInteger) tupla[3]).intValue());

            denuncias.add(denuncia);

        }

        return denuncias;
    }
}

package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.OpmDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.Ponto;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.modelo.vos.PoligonoValorVO;
import br.gov.pi.ati.siopm.modelo.vos.PontoValorVO;
import br.gov.pi.ati.siopm.util.GeometryUtils;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.persistence.query.Restrictions;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.persistence.Query;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@Stateless
public class OpmBO extends AbstractBusinessObject<Opm> {

    @EJB
    private OpmDAO opmDAO;

    @EJB
    private PoligonoBO poligonoBO;

    @EJB
    private TerritorioBO territorioBO;

    @Override
    public OpmDAO getDAO() {
        return opmDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Opm opm) throws BusinessException {
        //Orgao não pode ser pai dele mesmo
        if (opm.getId() != null && opm.getOrganizacaoPai() != null) {
            if (opm.getId().equals(opm.getOrganizacaoPai().getId())) {
                throw new BusinessException("OPM não pode ser pai dela mesmo!!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Opm> listarOpm(FiltrosVO filtro) {
        Restrictions restrictions = new Restrictions();
        List<Opm> opms;

        if (filtro.getNome() != null) {
            if (!filtro.getNome().equals("")) {
                restrictions.like("opm.nome", filtro.getNome());
            }
        }

        if (filtro.getCidade() != null) {
            restrictions.add("cidade", filtro.getCidade());
        }

        if (filtro.getCodigo() != null) {
            restrictions.add("opm.codigo", filtro.getCodigo());
        }

        opms = getDAO().getQueryBuilder().select("opm").from(Opm.class, "opm").leftJoinFetch("opm.endereco", "endereco")
                .leftJoinFetch("endereco.logradouro", "logradouro").leftJoinFetch("endereco.bairro", "bairro")
                .leftJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("opm.nome").getResultList();

        return opms;
    }

    public List<Opm> opmPelasCoordenadas(double latitude, double longitude) {

//        List<Poligono> poligonosAll = poligonoBO.getDAO().list("ativo", true);
        List<Poligono> poligonosAll = getDAO().getQueryBuilder().select("poligono").from(Poligono.class, "poligono").leftJoinFetch("poligono.pontos", "pontos")
                .add("poligono.ativo", true).getResultList();
        List<Poligono> poligonosContemPonto = new ArrayList<Poligono>();

        for (Poligono poligono : poligonosAll) {
//            List<Ponto> pontos = getDAO().getInitialized(poligono.getPontos());
            PoligonoValorVO poli = new PoligonoValorVO();
            for (Ponto ponto : poligono.getPontos()) {
                PontoValorVO pontoX1 = new PontoValorVO(ponto.getLongitude());
                PontoValorVO pontoY1 = new PontoValorVO(ponto.getLatitude());
                poli.getPontosX().add(pontoX1);
                poli.getPontosY().add(pontoY1);
            }

            double[] vetorX = new double[poli.getPontosX().size()];
            double[] vetorY = new double[poli.getPontosY().size()];

            for (int i = 0; i < poli.getPontosX().size(); i++) {
                vetorX[i] = poli.getPontosX().get(i).getValor();
                vetorY[i] = poli.getPontosY().get(i).getValor();
            }

            if (GeometryUtils.isPointInsidePolygon(vetorX, vetorY, longitude, latitude)) {
                poligonosContemPonto.add(poligono);
            }
        }

        List<Territorio> territorios = territorioBO.territorioPelosPoligonos(poligonosContemPonto);

        if (territorios.size() < 1) {
            return null;
        }

        List<Opm> opms = opmPelosTerritorios(territorios);

        if (opms.size() < 1) {
            return null;
        }

        return opms;
    }

    public List<Opm> opmPelosTerritorios(List<Territorio> territorios) {

        List<Long> idsTerritorios = new ArrayList<Long>();
        Restrictions restrictions = new Restrictions();

        if (territorios != null) {
            if (territorios.size() < 1) {
                return null;
            } else {
                for (Territorio territorio : territorios) {
                    idsTerritorios.add(territorio.getId());
                }
            }
        } else {
            return null;
        }

        if (idsTerritorios.size() > 0) {
            restrictions.in("territorios.id", idsTerritorios);
        }

        return getDAO().getQueryBuilder().select("opm").from(Opm.class, "opm").leftJoinFetch("opm.territorios", "territorios")
                .add(restrictions).getResultList();
    }

    /**
     * Metodo que carrega a arvore para uma lista de opm
     *
     * @param root
     * @param opms
     * @param opmsParaSelecionar
     * @param opmsSelecionaveis
     * @return
     */
    public TreeNode criarTreeNode(TreeNode root, List<Opm> opms, List<Opm> opmsParaSelecionar, List<Opm> opmsSelecionaveis) {

        boolean nullRoot = false;
        if (root == null) {
            root = new DefaultTreeNode();
            root.setExpanded(true);
            nullRoot = true;
        }

        if (opms != null) {
            //ordernar permissoes
            ordernar(opms);
            for (Opm opm : opms) {
                TreeNode node = new DefaultTreeNode(opm, root);
                //expandir apenas os primeiros filhos
                node.setExpanded(nullRoot);
                //se as selecionaveis forem nulas ou 
                if (opmsSelecionaveis == null || opmsSelecionaveis.contains(opm)) {
                    node.setSelectable(true);
                } else {
                    node.setSelectable(false);
                }
                if (opmsParaSelecionar != null && opmsParaSelecionar.contains(opm)) {
                    node.setSelected(true);
                }

                List<Organizacao> filhosTemp = opmDAO.getInitialized(opm.getFilhos());
                List<Opm> filhos = new ArrayList<Opm>();

                for (Organizacao filho : filhosTemp) {
                    Opm opmFilho = (Opm) filho;
                    filhos.add(opmFilho);
                }

                if (filhos != null) {
                    //chamada recursiva para adicionar os filhos
                    criarTreeNode(node, filhos, opmsParaSelecionar, opmsSelecionaveis);
                    root.getChildren().add(node);
                }
            }
        }

        return root;
    }

    /**
     * Ordena a lista de orgaos baseada no campo ordenacao (do menor para o
     * maior)
     *
     * @param opms
     */
    public static void ordernar(List<Opm> opms) {
        if (opms != null) {
            Comparator<Opm> comparator = new Comparator<Opm>() {
                @Override
                public int compare(Opm o1, Opm o2) {
                    Integer v1 = o1.getOrdenacao() != null ? o1.getOrdenacao() : 0;
                    Integer v2 = o2.getOrdenacao() != null ? o2.getOrdenacao() : 0;
                    return v1.compareTo(v2);
                }
            };
            Collections.sort(opms, comparator);
        }
    }

    /**
     * Retorna uma arvore de permissoes de um determinado perfil. A arvore
     * possui todas as permissoes, porem so estarao selecionados as permissoes
     * que o perfil possui. O perfil pode ser passado como nulo tambem
     *
     * @param perfil
     * @return
     */
    public TreeNode getTreeNode() {

        //pegar todos os orgaos raiz
        List<Opm> opms = getOPMRaiz();

        //o null eh o root, que nao precisa ser passado
//        return criarTreeNode(null, opms);
        return criarTreeNode(null, opms, null, null);
    }

    /**
     *
     * @param root
     * @param opms
     * @param opmsParaSelecionar
     * @param opmsSelecionaveis
     * @return
     */
    public List<Opm> getOPMRaiz() {
        return opmDAO.getQueryBuilder()
                .from(Opm.class)
                .isNull("organizacaoPai")
                .orderBy("nome").getResultList();
    }

    /**
     * salva a ordenacao das permissoes baseado na posicao na arvore
     *
     * @param permissoes
     */
    public void salvarOrdenacao(TreeNode opms) {
        atualizarOrdenacao(opms.getChildren());
    }

    /**
     * metodo que seta a permissao pai e a ordenacao no menu, baseado na arvore
     * que foi montada na view
     *
     * @param nodes
     */
    public void atualizarOrdenacao(List<TreeNode> nodes) {
        if (nodes != null) {
            int count = 0;
            for (TreeNode node : nodes) {
                Opm opm = (Opm) node.getData();
                //se o no possuir pai, entao salvar a permissao pai, senao setar nulo
                if (node.getParent() != null) {
                    opm.setOrganizacaoPai((Opm) node.getParent().getData());
                } else {
                    opm.setOrganizacaoPai(null);
                }
                opm.setOrdenacao(count);
                atualizarOrdenacao(node.getChildren());
                count++;
                //atualizar no banco
                opmDAO.merge(opm);
            }
        }
    }

    /**
     * Inativa um orgao
     *
     * @param orgao
     * @param emCascata Indica se os orgaos filhos sera inativadas tambem (e os
     * filhos dos filhos)
     */
    public void inativar(Opm opm, boolean emCascata) {
        //passar ativo = false
        alterarStatus(opm, false, emCascata);
    }

    /**
     * Ativa um orgao
     *
     * @param orgao
     * @param emCascata Indica se os orgao filhas sera ativados tambem (e os
     * filhos dos filhos)
     */
    public void ativar(Opm opm, boolean emCascata) {
        //passar ativo = true
        alterarStatus(opm, true, emCascata);
    }

    /**
     * Muda o status de um orgao
     *
     * @param opm
     * @param ativo Indica se o status desejado eh o ativo ou nao
     * @param emCascata Indica se os orgaos filhos sera afetadas tambem (e os
     * filhos dos filhos)
     */
    public void alterarStatus(Opm opm, boolean ativo, boolean emCascata) {
        opm.setAtivo(ativo);
        opmDAO.merge(opm);
        if (emCascata == true) {
            List<Opm> filhos = (List<Opm>) (Opm) opmDAO.getInitialized(opm.getFilhos());
            if (filhos != null) {
                for (Opm filho : filhos) {
                    alterarStatus(filho, ativo, emCascata);
                }
            }
        }
    }

    public List<Opm> opmPeloBairroOuCidade(Bairro bairro) {
        if (bairro == null) {
            return null;
        }

        List<Opm> opmsBairro = opmPeloBairroId(bairro.getId());

        List<Opm> opmsCidade = opmPelaCidadeId(bairro.getCidade().getId());

        if (opmsBairro.size() > 0) {
            return opmsBairro;
        }

        if (opmsCidade.size() > 0) {
            return opmsCidade;
        }

        return null;
    }

    public List<Opm> opmPeloBairroId(Long bairroId) {
        if (bairroId == null) {
            return null;
        }

        String queryString = "select distinct opm.id from opm opm left join organizacaopolicial_circunscricao op on (opm.id = op.organizacaopolicial_id) where (op.circunscricoes_id=BAIRRO_ID)";

        queryString = queryString.replace("BAIRRO_ID", bairroId.toString());

        List<Opm> opms = new ArrayList<Opm>();

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<BigInteger> resultado = query.getResultList();

        for (BigInteger tupla : resultado) {
            Opm opm = new Opm();
            Long id = tupla.longValue();
            opm = getDAO().unique("id", id);

            opms.add(opm);
        }

        return opms;
    }

    public List<Opm> opmPelaCidadeId(Long cidadeId) {
        if (cidadeId == null) {
            return null;
        }

        String queryString = "select distinct opm.id from opm opm left join organizacaopolicial_circunscricao op on (opm.id = op.organizacaopolicial_id) where (op.circunscricoes_id=CIDADE_ID)";

        queryString = queryString.replace("CIDADE_ID", cidadeId.toString());

        List<Opm> opms = new ArrayList<Opm>();

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<BigInteger> resultado = query.getResultList();

        for (BigInteger tupla : resultado) {
            Opm opm = new Opm();
            Long id = tupla.longValue();
            opm = getDAO().unique("id", id);

            opms.add(opm);
        }

        return opms;
    }

}

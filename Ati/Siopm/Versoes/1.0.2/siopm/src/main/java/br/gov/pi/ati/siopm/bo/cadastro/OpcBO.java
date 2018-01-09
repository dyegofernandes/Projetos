package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.OpcDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Opc;
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
public class OpcBO extends AbstractBusinessObject<Opc> {

    @EJB
    private OpcDAO opCDAO;

    @EJB
    private PoligonoBO poligonoBO;

    @EJB
    private TerritorioBO territorioBO;

    @Override
    public OpcDAO getDAO() {
        return opCDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Opc opc) throws BusinessException {
        //Orgao não pode ser pai dele mesmo
        if (opc.getId() != null && opc.getOrganizacaoPai() != null) {
            if (opc.getId().equals(opc.getOrganizacaoPai().getId())) {
                throw new BusinessException("OPC não pode ser pai dela mesmo!!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Opc> listarOpc(FiltrosVO filtro) {
        Restrictions restrictions = new Restrictions();
        List<Opc> opcs;

        if (filtro.getNome() != null) {
            if (!filtro.getNome().equals("")) {
                restrictions.like("opc.nome", filtro.getNome());
            }
        }

        if (filtro.getCidade() != null) {
            restrictions.add("cidade", filtro.getCidade());
        }

        if (filtro.getCodigo() != null) {
            restrictions.add("opc.codigo", filtro.getCodigo());
        }

        opcs = getDAO().getQueryBuilder().select("opc").from(Opc.class, "opc").leftJoinFetch("opc.endereco", "endereco")
                .leftJoinFetch("endereco.logradouro", "logradouro").leftJoinFetch("logradouro.bairro", "bairro")
                .leftJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("opc.nome").getResultList();

        return opcs;
    }

    /**
     * Metodo que carrega a arvore para uma lista de orgaos
     *
     * @param root
     * @param opcs
     * @param opcsParaSelecionar
     * @param opcsSelecionaveis
     * @return
     */
    public TreeNode criarTreeNode(TreeNode root, List<Opc> opcs, List<Opc> opcsParaSelecionar, List<Opc> opcsSelecionaveis) {

        boolean nullRoot = false;
        if (root == null) {
            root = new DefaultTreeNode();
            root.setExpanded(true);
            nullRoot = true;
        }

        if (opcs != null) {
            //ordernar permissoes
            ordernar(opcs);
            for (Opc opc : opcs) {
                TreeNode node = new DefaultTreeNode(opc, root);
                //expandir apenas os primeiros filhos
                node.setExpanded(nullRoot);
                //se as selecionaveis forem nulas ou 
                if (opcsSelecionaveis == null || opcsSelecionaveis.contains(opc)) {
                    node.setSelectable(true);
                } else {
                    node.setSelectable(false);
                }
                if (opcsParaSelecionar != null && opcsParaSelecionar.contains(opc)) {
                    node.setSelected(true);
                }

                List<Organizacao> filhosTemp = opCDAO.getInitialized(opc.getFilhos());
                List<Opc> filhos = new ArrayList<Opc>();

                for (Organizacao filho : filhosTemp) {
                    Opc opmFilho = (Opc) filho;
                    filhos.add(opmFilho);
                }

                if (filhos != null) {
                    //chamada recursiva para adicionar os filhos
                    criarTreeNode(node, filhos, opcsParaSelecionar, opcsSelecionaveis);
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
     * @param opcs
     */
    public static void ordernar(List<Opc> opcs) {
        if (opcs != null) {
            Comparator<Opc> comparator = new Comparator<Opc>() {
                @Override
                public int compare(Opc o1, Opc o2) {
                    Integer v1 = o1.getOrdenacao() != null ? o1.getOrdenacao() : 0;
                    Integer v2 = o2.getOrdenacao() != null ? o2.getOrdenacao() : 0;
                    return v1.compareTo(v2);
                }
            };
            Collections.sort(opcs, comparator);
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

        //pegar todos as opms raiz
        List<Opc> opcs = getOPCRaiz();

        //o null eh o root, que nao precisa ser passado
        return criarTreeNode(null, opcs, null, null);
    }

    public List<Opc> getOPCRaiz() {
        return opCDAO.getQueryBuilder()
                .from(Opc.class)
                .isNull("organizacaoPai")
                .orderBy("nome").getResultList();
    }

    /**
     * salva a ordenacao das permissoes baseado na posicao na arvore
     *
     * @param permissoes
     */
    public void salvarOrdenacao(TreeNode opcs) {
        atualizarOrdenacao(opcs.getChildren());
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
                Opc opc = (Opc) node.getData();
                //se o no possuir pai, entao salvar a permissao pai, senao setar nulo
                if (node.getParent() != null) {
                    opc.setOrganizacaoPai((Opc) node.getParent().getData());
                } else {
                    opc.setOrganizacaoPai(null);
                }
                opc.setOrdenacao(count);
                atualizarOrdenacao(node.getChildren());
                count++;
                //atualizar no banco
                opCDAO.merge(opc);
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
    public void inativar(Opc opc, boolean emCascata) {
        //passar ativo = false
        alterarStatus(opc, false, emCascata);
    }

    /**
     * Ativa um orgao
     *
     * @param opc
     * @param emCascata Indica se os orgao filhas sera ativados tambem (e os
     * filhos dos filhos)
     */
    public void ativar(Opc opc, boolean emCascata) {
        //passar ativo = true
        alterarStatus(opc, true, emCascata);
    }

    /**
     * Muda o status de um orgao
     *
     * @param opc
     * @param ativo Indica se o status desejado eh o ativo ou nao
     * @param emCascata Indica se os orgaos filhos sera afetadas tambem (e os
     * filhos dos filhos)
     */
    public void alterarStatus(Opc opc, boolean ativo, boolean emCascata) {
        opc.setAtivo(ativo);
        opCDAO.merge(opc);
        if (emCascata == true) {
            List<Opc> filhos = (List<Opc>) (Opc) opCDAO.getInitialized(opc.getFilhos());
            if (filhos != null) {
                for (Opc filho : filhos) {
                    alterarStatus(filho, ativo, emCascata);
                }
            }
        }
    }

    public List<Opc> opcPeloBairroOuCidade(Bairro bairro) {
        if (bairro == null) {
            return null;
        }

        Bairro bairroTemp = getDAO().getInitialized(bairro);

        String queryString = "select distinct opc.id from opc opc left join organizacaopolicial_circunscricao op on (opc.id = op.organizacaopolicial_id) where (op.circunscricoes_id=BAIRRO_ID or op.circunscricoes_id=CIDADE_ID)";

        queryString = queryString.replace("BAIRRO_ID", bairro.getId().toString());
        queryString = queryString.replace("CIDADE_ID", bairro.getCidade().getId().toString());

        List<Opc> opcs = new ArrayList<Opc>();

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<BigInteger> resultado = query.getResultList();

        for (BigInteger tupla : resultado) {
            Opc opc = new Opc();
            Long id = tupla.longValue();
            opc = getDAO().unique("id", id);

            opcs.add(opc);
        }

        return opcs;
    }

    public List<Opc> opmPelasCoordenadas(double latitude, double longitude) {

//        List<Poligono> poligonosAll = poligonoBO.getDAO().list("ativo", true);
        List<Poligono> poligonosAll = getDAO().getQueryBuilder().select("poligono").from(Poligono.class, "poligono").leftJoinFetch("poligono.pontos", "pontos")
                .add("poligono.ativo", true).getResultList();
        List<Poligono> poligonosContemPonto = new ArrayList<Poligono>();

        for (Poligono poligono : poligonosAll) {
            List<Ponto> pontos = getDAO().getInitialized(poligono.getPontos());
            PoligonoValorVO poli = new PoligonoValorVO();
            for (Ponto ponto : pontos) {
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

        List<Opc> opcs = opcPelosTerritorios(territorios);

        if (opcs.size() < 1) {
            return null;
        }

        return opcs;
    }

    public List<Opc> opcPelosTerritorios(List<Territorio> territorios) {

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

        return getDAO().getQueryBuilder().select("opc").from(Opc.class, "opc").leftJoinFetch("opc.territorios", "territorios")
                .add(restrictions).getResultList();
    }

}

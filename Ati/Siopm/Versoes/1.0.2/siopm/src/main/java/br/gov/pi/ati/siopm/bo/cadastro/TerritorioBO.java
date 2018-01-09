package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.TerritorioDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.Ponto;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.vos.PoligonoValorVO;
import br.gov.pi.ati.siopm.modelo.vos.PontoValorVO;
import br.gov.pi.ati.siopm.util.GeometryUtils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioBO extends AbstractBusinessObject<Territorio> {

    @EJB
    private TerritorioDAO territorioDAO;

    @Override
    public TerritorioDAO getDAO() {
        return territorioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("nome");
    }

    @Override
    public void validate(Territorio territorio) throws BusinessException {
        List<Poligono> poligonos = getDAO().getInitialized(territorio.getPoligonos());

        if (poligonos.size() < 1) {
            throw new BusinessException("Um território deve possuir um ou mais polígonos!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
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
    public TreeNode criarTreeNode(TreeNode root, List<Territorio> territorios, List<Territorio> territoriosParaSelecionar, List<Territorio> territoriosSelecionaveis) {

        boolean nullRoot = false;
        if (root == null) {
            root = new DefaultTreeNode();
            root.setExpanded(true);
            nullRoot = true;
        }

        if (territorios != null) {
            //ordernar permissoes
            ordernar(territorios);
            for (Territorio territorio : territorios) {
                TreeNode node = new DefaultTreeNode(territorio, root);
                //expandir apenas os primeiros filhos
                node.setExpanded(nullRoot);
                //se as selecionaveis forem nulas ou 
                if (territoriosSelecionaveis == null || territoriosSelecionaveis.contains(territorio)) {
                    node.setSelectable(true);
                } else {
                    node.setSelectable(false);
                }
                if (territoriosParaSelecionar != null && territoriosParaSelecionar.contains(territorio)) {
                    node.setSelected(true);
                }

                List<Territorio> filhosTemp = getDAO().getInitialized(territorio.getFilhos());
                List<Territorio> filhos = new ArrayList<Territorio>();

                for (Territorio filho : filhosTemp) {
                    Territorio opmFilho = (Territorio) filho;
                    filhos.add(opmFilho);
                }

                if (filhos != null) {
                    //chamada recursiva para adicionar os filhos
                    criarTreeNode(node, filhos, territoriosParaSelecionar, territoriosSelecionaveis);
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
    public static void ordernar(List<Territorio> territorios) {
        if (territorios != null) {
            Comparator<Territorio> comparator = new Comparator<Territorio>() {
                @Override
                public int compare(Territorio o1, Territorio o2) {
                    Integer v1 = o1.getOrdenacao() != null ? o1.getOrdenacao() : 0;
                    Integer v2 = o2.getOrdenacao() != null ? o2.getOrdenacao() : 0;
                    return v1.compareTo(v2);
                }
            };
            Collections.sort(territorios, comparator);
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
        List<Territorio> territorios = getTerritorioRaiz();

        //o null eh o root, que nao precisa ser passado
//        return criarTreeNode(null, opms);
        return criarTreeNode(null, territorios, null, null);
    }

    /**
     *
     * @return
     */
    public List<Territorio> getTerritorioRaiz() {
        return getDAO().getQueryBuilder()
                .from(Territorio.class)
                .isNull("territorioPai")
                .orderBy("nome").getResultList();
    }

    /**
     * salva a ordenacao das permissoes baseado na posicao na arvore
     *
     * @param permissoes
     */
    public void salvarOrdenacao(TreeNode arvore) {
        atualizarOrdenacao(arvore.getChildren());
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
                Territorio territorio = (Territorio) node.getData();
                //se o no possuir pai, entao salvar a permissao pai, senao setar nulo
                if (node.getParent() != null) {
                    territorio.setTerritorioPai((Territorio) node.getParent().getData());
                } else {
                    territorio.setTerritorioPai(null);
                }
                territorio.setOrdenacao(count);
                atualizarOrdenacao(node.getChildren());
                count++;
                //atualizar no banco
                getDAO().merge(territorio);
            }
        }
    }

    /**
     * Inativa um orgao
     *
     * @param territorio
     * @param emCascata Indica se os orgaos filhos sera inativadas tambem (e os
     * filhos dos filhos)
     */
    public void inativar(Territorio territorio, boolean emCascata) {
        //passar ativo = false
        alterarStatus(territorio, false, emCascata);
    }

    /**
     * Ativa um orgao
     *
     * @param territorio
     * @param emCascata Indica se os orgao filhas sera ativados tambem (e os
     * filhos dos filhos)
     */
    public void ativar(Territorio territorio, boolean emCascata) {
        //passar ativo = true
        alterarStatus(territorio, true, emCascata);
    }

    /**
     * Muda o status de um orgao
     *
     * @param territorio
     * @param ativo Indica se o status desejado eh o ativo ou nao
     * @param emCascata Indica se os orgaos filhos sera afetadas tambem (e os
     * filhos dos filhos)
     */
    public void alterarStatus(Territorio territorio, boolean ativo, boolean emCascata) {
        territorio.setAtivo(ativo);
        getDAO().merge(territorio);
        if (emCascata == true) {
            List<Territorio> filhos = (List<Territorio>) (Territorio) getDAO().getInitialized(territorio.getFilhos());
            if (filhos != null) {
                for (Territorio filho : filhos) {
                    alterarStatus(filho, ativo, emCascata);
                }
            }
        }
    }

    public List<Territorio> territorioPelosPoligonos(List<Poligono> poligonos) {
        Restrictions restrictions = new Restrictions();

        List<Long> idsPoligonos = new ArrayList<Long>();

        if (poligonos != null) {
            if (poligonos.size() < 1) {
                return null;
            } else {
                for (Poligono poligono : poligonos) {
                    idsPoligonos.add(poligono.getId());
                }
            }
        } else {
            return null;
        }

        if (idsPoligonos.size() > 0) {
            restrictions.in("poligonos.id", idsPoligonos);
        }

        return getDAO().getQueryBuilder().select("territorio").from(Territorio.class, "territorio").leftJoinFetch("territorio.poligonos", "poligonos")
                .add(restrictions).getResultList();
    }
    
    public List<Territorio> territorioPelasCoordenadas(double latitude, double longitude) {

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

        List<Territorio> territorios = territorioPelosPoligonos(poligonosContemPonto);

        if (territorios.size() < 1) {
            return null;
        }



        return territorios;
    }
}

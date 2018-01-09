package br.gov.pi.ati.sisforms.bo.cadastro;

import static br.gov.pi.ati.sisforms.bo.controleacesso.PermissaoBO.ordernar;
import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.OrgaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Perfil;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Permissao;
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
public class OrgaoBO extends AbstractBusinessObject<Orgao> {

    @EJB
    private OrgaoDAO orgaoDAO;

    @Override
    public OrgaoDAO getDAO() {
        return orgaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Orgao orgao) throws BusinessException {
        //Orgao não pode ser pai dele mesmo
        if (orgao.getId() != null && orgao.getOrgaoPai() != null) {
            if (orgao.getId().equals(orgao.getOrgaoPai().getId())) {
                throw new BusinessException("Orgão não pode ser pai dele mesmo!!");
            }
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

    /**
     * Metodo que carrega a arvore para uma lista de orgaos
     *
     * @param root
     * @param orgaos - os orgaos a serem exibidas
     * @param orgaosParaSelecionar - os orgaos que ficarao selecionadas
     * @param orgaosSelecionaveis - os orgaos que se pode selecionar, quando
     * passado null, qualquer um sera selecionavel
     * @return
     */
    public TreeNode criarTreeNode(TreeNode root, List<Orgao> orgaos, List<Orgao> orgaosParaSelecionar, List<Orgao> orgaosSelecionaveis) {

        boolean nullRoot = false;
        if (root == null) {
            root = new DefaultTreeNode();
            root.setExpanded(true);
            nullRoot = true;
        }

        if (orgaos != null) {
            //ordernar permissoes
            ordernar(orgaos);
            for (Orgao orgao : orgaos) {
                TreeNode node = new DefaultTreeNode(orgao, root);
                //expandir apenas os primeiros filhos
                node.setExpanded(nullRoot);
                //se as selecionaveis forem nulas ou 
                if (orgaosSelecionaveis == null || orgaosSelecionaveis.contains(orgao)) {
                    node.setSelectable(true);
                } else {
                    node.setSelectable(false);
                }
                if (orgaosParaSelecionar != null && orgaosParaSelecionar.contains(orgao)) {
                    node.setSelected(true);
                }

                List<Orgao> filhos = orgaoDAO.getInitialized(orgao.getOrgaosFilhos());
                if (filhos != null) {
                    //chamada recursiva para adicionar os filhos
                    criarTreeNode(node, filhos, orgaosParaSelecionar, orgaosParaSelecionar);
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
     * @param orgaos
     */
    public static void ordernar(List<Orgao> orgaos) {
        if (orgaos != null) {
            Comparator<Orgao> comparator = new Comparator<Orgao>() {
                @Override
                public int compare(Orgao o1, Orgao o2) {
                    Integer v1 = o1.getOrdenacao() != null ? o1.getOrdenacao() : 0;
                    Integer v2 = o2.getOrdenacao() != null ? o2.getOrdenacao() : 0;
                    return v1.compareTo(v2);
                }
            };
            Collections.sort(orgaos, comparator);
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
        List<Orgao> orgaos = getOrgaoRaiz();

        //o null eh o root, que nao precisa ser passado
        return criarTreeNode(null, orgaos, null, null);
    }

    /**
     * Retorna as permissoes que ficam na raiz, ou seja, os orgaos "sem pai"
     *
     * @return
     */
    public List<Orgao> getOrgaoRaiz() {
        return orgaoDAO.getQueryBuilder()
                .from(Orgao.class)
                .isNull("orgaoPai")
                .orderBy("nome").getResultList();
    }

    /**
     * salva a ordenacao das permissoes baseado na posicao na arvore
     *
     * @param permissoes
     */
    public void salvarOrdenacao(TreeNode orgaos) {
        atualizarOrdenacao(orgaos.getChildren());
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
                Orgao orgao = (Orgao) node.getData();
                //se o no possuir pai, entao salvar a permissao pai, senao setar nulo
                if (node.getParent() != null) {
                    orgao.setOrgaoPai((Orgao) node.getParent().getData());
                } else {
                    orgao.setOrgaoPai(null);
                }
                orgao.setOrdenacao(count);
                atualizarOrdenacao(node.getChildren());
                count++;
                //atualizar no banco
                orgaoDAO.merge(orgao);
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
    public void inativar(Orgao orgao, boolean emCascata) {
        //passar ativo = false
        alterarStatus(orgao, false, emCascata);
    }

    /**
     * Ativa um orgao
     *
     * @param orgao
     * @param emCascata Indica se os orgao filhas sera ativados tambem (e os
     * filhos dos filhos)
     */
    public void ativar(Orgao orgao, boolean emCascata) {
        //passar ativo = true
        alterarStatus(orgao, true, emCascata);
    }

    /**
     * Muda o status de um orgao
     *
     * @param orgao
     * @param ativo Indica se o status desejado eh o ativo ou nao
     * @param emCascata Indica se os orgaos filhos sera afetadas tambem (e os
     * filhos dos filhos)
     */
    public void alterarStatus(Orgao orgao, boolean ativo, boolean emCascata) {
        orgao.setAtivo(ativo);
        orgaoDAO.merge(orgao);
        if (emCascata == true) {
            List<Orgao> filhos = orgaoDAO.getInitialized(orgao.getOrgaosFilhos());
            if (filhos != null) {
                for (Orgao filho : filhos) {
                    alterarStatus(filho, ativo, emCascata);
                }
            }
        }
    }
}

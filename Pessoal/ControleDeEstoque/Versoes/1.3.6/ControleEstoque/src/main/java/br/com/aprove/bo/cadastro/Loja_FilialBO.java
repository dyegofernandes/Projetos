package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.Loja_FilialDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.vo.FiltroVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * @author juniel
 */
@Stateless
public class Loja_FilialBO extends AbstractBusinessObject<Loja_Filial> {

    @EJB
    private Loja_FilialDAO loja_FilialDAO;

    @Override
    public Loja_FilialDAO getDAO() {
        return loja_FilialDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Loja_Filial loja_Filial) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Loja_Filial> listarLoja_Filial(FiltroVO filtros) {
        List<Loja_Filial> filiais = new ArrayList<Loja_Filial>();
        List<Loja_Filial> listaBusca = new ArrayList<Loja_Filial>();
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        List<Long> ids = new ArrayList<Long>();
        List<Loja_Filial> filiaisMatriz;
        Restrictions restrictions = new Restrictions();

        if (usuario != null) {
            if (!usuario.isSuperUsuario()) {
                if (usuario.getFilial() != null) {
                    Loja_Filial filial = getDAO().getInitialized(usuario.getFilial());
                    ids.add(filial.getId());
                } else {
                    if (usuario.getMatriz() != null) {
                        Loja_Filial matriz = getDAO().getInitialized(usuario.getMatriz());
                        ids.add(matriz.getId());
                        filiaisMatriz = getDAO().list("matriz", matriz);
                        for (Loja_Filial filial : filiaisMatriz) {
                            ids.add(filial.getId());
                        }
                    }
                }
            } else {
                if (filtros.getMatriz() != null && filtros.getLoja() == null) {
                    Loja_Filial matriz = getDAO().getInitialized(filtros.getMatriz());
                    ids.add(matriz.getId());
                    filiaisMatriz = getDAO().list("matriz", matriz);
                    for (Loja_Filial filial : filiaisMatriz) {
                        ids.add(filial.getId());
                    }
                }
                if (filtros.getLoja() != null) {
                    Loja_Filial filial = getDAO().getInitialized(filtros.getLoja());
                    ids.add(filial.getId());
                }
            }
        } else {
            return null;
        }

        if (ids.size() > 0) {
            restrictions.in("empresa.id", ids);
        }
        
        if (filtros.getCodigo1() != null) {
            restrictions.add("empresa.id", filtros.getCodigo1());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("empresa.razaoSocial", filtros.getNome());
        }

        if (filtros.getCnpj() != null && !filtros.getCnpj().equals("")) {
            restrictions.add("empresa.cnpj", filtros.getCnpj());
        }
        
        if (filtros.getAtivo() == null) {
            List<Boolean> lista = new ArrayList<Boolean>();
            lista.add(Boolean.TRUE);
            lista.add(Boolean.FALSE);
            restrictions.in("empresa.ativo", lista);
        } else {
            restrictions.add("empresa.ativo", filtros.getAtivo());
        }

        filiais = getDAO().getQueryBuilder().select("empresa").from(Loja_Filial.class, "empresa").leftJoinFetch("empresa.matriz", "matriz").
                add(restrictions).orderBy("empresa.razaoSocial").getResultList();

        return filiais;

    }

    public List<Loja_Filial> autocompletePorUsuario(Usuario usuarioTemp) {
        List<Loja_Filial> empresas = new ArrayList<Loja_Filial>();
        List<Long> empresasParaConsulta = new ArrayList<Long>();
        Usuario usuario = getDAO().getInitialized(usuarioTemp);
        Loja_Filial empresa = null;
        Restrictions restrictions = new Restrictions();

        if (usuario.getFilial() != null) {
            empresa = getDAO().getInitialized(usuario.getFilial());
            empresasParaConsulta.add(empresa.getId());
        } else {
            if (usuario.getMatriz() != null) {
                empresa = getDAO().getInitialized(usuario.getMatriz());
                empresasParaConsulta.add(empresa.getId());

                List<Loja_Filial> filiaisDessaMatriz = getDAO().list("matriz", empresa);

                for (Loja_Filial filial : filiaisDessaMatriz) {
                    empresasParaConsulta.add(filial.getId());
                }

            }
        }

        if (empresasParaConsulta.size() > 0) {
            restrictions.in("id", empresasParaConsulta);
        }

        empresas = getDAO().getQueryBuilder().select("lojas").from(Loja_Filial.class, "lojas").leftJoinFetch("lojas.matriz", "matriz").
                add(restrictions).orderBy("razaoSocial").getResultList();

        return empresas;
    }

}

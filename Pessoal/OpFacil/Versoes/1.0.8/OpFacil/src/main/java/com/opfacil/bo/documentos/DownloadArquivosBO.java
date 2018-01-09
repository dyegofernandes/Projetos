package com.opfacil.bo.documentos;

import com.opfacil.VOs.FiltroDeBusca;
import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.documento.DownloadArquivosDAO;
import com.opfacil.modelo.documentos.Arquivo;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.documentos.DownloadArquivos;
import com.opfacil.util.SessaoUtils;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
import javax.persistence.Query;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class DownloadArquivosBO extends AbstractBusinessObject<DownloadArquivos> {

    @EJB
    private DownloadArquivosDAO downloadArquivosDAO;

    @Override
    public DownloadArquivosDAO getDAO() {
        return downloadArquivosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DownloadArquivos downloadArquivos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<DownloadArquivos> listarArquivoPorEmpresa(FiltroDeBusca filtros) {
        List<DownloadArquivos> arquivos;
        QueryBuilder builder = downloadArquivosDAO.getQueryBuilder();

        builder.select("d").from(DownloadArquivos.class, "d").leftJoinFetch("d.empresa", "e").leftJoinFetch("d.arquivo", "a");

        Query query;

        Restrictions restrictions = new Restrictions();

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("d.dataPublicao", filtros.getDataInicial());
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("d.dataPublicao", filtros.getDataFinal());
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                restrictions.like("a.nome", filtros.getNome());
            }
        }

        if (filtros.getConteudo() != null) {
            if (!filtros.getConteudo().equals("")) {
                restrictions.like("a.conteudo", filtros.getConteudo());
            }
        }

        if (SessaoUtils.getUser().isSuperUsuario()) {
            if (filtros.getEmpresa() != null) {
                restrictions.add("d.empresa", filtros.getEmpresa());
            } else {
                arquivos = builder.orderBy("e.nomeFantasia ASC, d.dataPublicao DESC").add(restrictions).getResultList();
                return arquivos;
            }
        } else {
            if (filtros.getEmpresa() != null) {
                restrictions.add("d.empresa", filtros.getEmpresa());
            } else {
                restrictions.add("d.empresa", SessaoUtils.getUser().getEmpresa());
            }
        }
        arquivos = builder.orderBy("e.nomeFantasia ASC, d.dataPublicao DESC").add(restrictions).getResultList();

        return arquivos;
    }

    public Arquivo consultarArquivo(Integer cdOp) {
        QueryBuilder queryBuild = downloadArquivosDAO.getQueryBuilder();
        Arquivo arquivo = (Arquivo) queryBuild.select("a").from(DownloadArquivos.class, "d").leftJoin("d.arquivo", "a").equals("d.cdOp", cdOp).getSingleResult();

        if (arquivo != null) {
            return downloadArquivosDAO.getInitialized(arquivo);
        }

        return null;
    }

}

package br.gov.pi.salvemaria.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.denuncia.ArquivoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoBO extends AbstractBusinessObject<Arquivo> {

    @EJB
    private ArquivoDAO arquivoDAO;

    @Override
    public ArquivoDAO getDAO() {
        return arquivoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Arquivo arquivo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Arquivo> listarArquivos(Denuncia denuncia) {
        return arquivoDAO.list("denuncia", denuncia, "nome");
    }

}

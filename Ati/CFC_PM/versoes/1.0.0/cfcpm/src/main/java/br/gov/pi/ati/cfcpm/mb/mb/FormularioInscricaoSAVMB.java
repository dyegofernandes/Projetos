package br.gov.pi.ati.cfcpm.mb.mb;

import br.gov.pi.ati.cfcpm.bo.cadastro.ArquivoBO;
import br.gov.pi.ati.cfcpm.bo.cadastro.CabosAutorizadosBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.cfcpm.bo.cadastro.FormularioInscricaoSAVBO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.cfcpm.modelo.cadastro.CabosAutorizados;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioInscricaoSAV;
import br.gov.pi.ati.cfcpm.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormularioInscricaoSAVMB extends AbstractBaseBean<FormularioInscricaoSAV> implements Serializable {

    @EJB
    private FormularioInscricaoSAVBO formularioInscricaoSAVBO;

    @EJB
    private CabosAutorizadosBO cabosBO;

    @EJB
    private ArquivoBO arquivoBO;

    @Override
    public FormularioInscricaoSAVBO getBO() {
        return formularioInscricaoSAVBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void save() {

        super.save(); //To change body of generated methods, choose Tools | Templates.

    }

    public void gerarPdf(FormularioInscricaoSAV formulario) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_ESTADO", caminhoImg.concat("/brasao.png"));
        params.put("LOGO_PM", caminhoImg.concat("/logo_pm.jpg"));
        params.put("DATA_INSCRICAO", Utils.convertDateToString(formulario.getDataInscricao(), "dd/MM/yyyy HH:mm"));
        params.put("CODIGO", formulario.getId().toString());

        params.put("NOME", formulario.getNome());
        params.put("RG", formulario.getIdentidade());
        params.put("ORGAO", formulario.getOrgao());
        params.put("CPF", Utils.format("###.###.###.##", formulario.getCpf()));
        params.put("NASCIMENTO", Utils.convertDateToString(formulario.getDataDeNascimento(), "dd/MM/yyyy"));
        params.put("SEXO", formulario.getSexo().getDescricao());
        params.put("ESCOLARIDADE", formulario.getEscolaridade());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formularioDeInscricaoSAV.jasper", "Inscricao ".concat(formulario.getId() + "") + ".pdf");

    }

    public StreamedContent download() throws IOException {

        Arquivo arquivo = getDAO().getInitialized(arquivoBO.getDAO().unique("id", 1L));

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (Arquivo) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile(nomeArquivo, extensaoArquivo);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(Base64.decode(arquivo.getConteudo()));
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public void novo() {
        setEntity(new FormularioInscricaoSAV());
    }

    public void buscarCaboAutorizado() {
        if (Utils.isNullOrEmpty(getEntity().getMatricula())) {
            FacesMessageUtils.error("Informe a Matricula!!!");
        } else {
            CabosAutorizados cabo = cabosBO.cabosPelaMatricula(getEntity().getMatricula());

            if (cabo != null) {
                getEntity().setNome(cabo.getNome());
                getEntity().setIdentidade(cabo.getIdentidade());
            } else {
                FacesMessageUtils.error("Servidor com a Matrícula ".concat(getEntity().getMatricula()).concat(" não está autorizada a fazer esse concurso!"));
                getEntity().setMatricula(null);
                getEntity().setNome(null);
                getEntity().setIdentidade(null);
            }
        }
    }
}

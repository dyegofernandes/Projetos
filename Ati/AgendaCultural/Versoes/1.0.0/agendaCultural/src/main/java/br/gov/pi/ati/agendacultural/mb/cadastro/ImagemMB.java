/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.mb.cadastro;

import br.gov.pi.ati.agendacultural.modelo.cadastro.Arquivo;
import br.gov.pi.ati.agendacultural.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Juniel
 */
@ManagedBean(name = "imagemMB")
@RequestScoped
public class ImagemMB implements Serializable {

    private StreamedContent imagem;

    @PostConstruct
    public void init() {

    }

    public StreamedContent getImagem(Arquivo arquivo) throws IOException {

//        if (arquivo == null) {
//            return null;
//        }
//
//        byte[] image = arquivo.getConteudo().getBytes();
//
//        imagem = new DefaultStreamedContent(new ByteArrayInputStream(image), arquivo.getExtensao(), arquivo.getNome());
//
//        return imagem;
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
}

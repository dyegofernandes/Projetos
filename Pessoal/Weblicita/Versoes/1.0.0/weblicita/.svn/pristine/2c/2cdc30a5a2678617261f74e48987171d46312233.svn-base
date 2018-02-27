/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.mb;

import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Juniel
 */
@ManagedBean
@SessionScoped
public class PdfMB implements Serializable {

    private StreamedContent pdf;

    /**
     * Esse método deixa o arquivo pronto para ser exibido na tela.
     *
     * @param arquivo O arquivo pronto para ser apresentado.
     * @param nomeArquivo Nome do arquivo.
     */
    public void gerar(InputStream arquivo, String nomeArquivo) {
        pdf = new DefaultStreamedContent(arquivo, "application/pdf", nomeArquivo);
    }

    public StreamedContent getPdf() {
        try {
            if (pdf != null) {
                pdf.getStream().reset();
            }
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        }
        return pdf;
    }

    public void setPdf(StreamedContent pdf) {
        this.pdf = pdf;
    }

}

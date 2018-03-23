/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.cfcpm.mb.mb;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
public class FileDownloadView {

    private StreamedContent file;

    public FileDownloadView() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/publico/1337.pdf");
        file = new DefaultStreamedContent(stream, "pdf", "Edital");
    }

    public StreamedContent getFile() {
        return file;
    }
}

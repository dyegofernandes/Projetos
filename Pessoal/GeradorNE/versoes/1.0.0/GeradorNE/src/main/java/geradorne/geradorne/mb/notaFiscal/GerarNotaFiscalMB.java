/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorne.geradorne.mb.notaFiscal;

import com.xpert.faces.utils.FacesMessageUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Juniel
 */
@ManagedBean
public class GerarNotaFiscalMB {

    private UploadedFile file;

    private List<String> lista = new ArrayList<String>();

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        UploadedFile uploadedFile = event.getFile();

        converterInputStreamParaString(uploadedFile.getInputstream());
//
//        System.out.println(str);
    }

    private void converterInputStreamParaString(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            int BUFFER_SIZE = 8192;

            br = new BufferedReader(new InputStreamReader(is,
                    "ISO-8859-1"), BUFFER_SIZE);
            while ((line = br.readLine()) != null) {
//                sb.append(line);
//                sb.append(System.getProperty("line.separator"));

                lista.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        return sb.toString();
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

}

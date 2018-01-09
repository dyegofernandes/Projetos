/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {

    NFeConfig config = new NFeConfig() {

        @Override
        public NFAmbiente getAmbiente() {
            return NFAmbiente.HOMOLOGACAO;
        }

        @Override
        public File getCertificado() throws IOException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public File getCadeiaCertificados() throws IOException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getCertificadoSenha() {
            return "";
        }

        @Override
        public NFUnidadeFederativa getCUF() {
            return NFUnidadeFederativa.PI;
        }

        @Override
        public NFTipoEmissao getTipoEmissao() {
            return NFTipoEmissao.EMISSAO_NORMAL;
        }
    };

    public static void main(String[] args) {

    }

}

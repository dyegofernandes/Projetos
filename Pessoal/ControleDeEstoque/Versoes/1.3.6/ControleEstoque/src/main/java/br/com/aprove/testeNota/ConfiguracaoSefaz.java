/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.testeNota;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Juniel
 */
public class ConfiguracaoSefaz implements NFeConfig {

    private final boolean ehAmbienteDeTeste;

    public ConfiguracaoSefaz(final boolean ehAmbienteDeTeste) {
        this.ehAmbienteDeTeste = ehAmbienteDeTeste;
    }

    @Override
    public NFAmbiente getAmbiente() {
        return this.ehAmbienteDeTeste ? NFAmbiente.HOMOLOGACAO : NFAmbiente.PRODUCAO;
    }

    @Override
    public File getCertificado() throws IOException {
        return new File("certificado.pfx");
    }

    @Override
    public File getCadeiaCertificados() throws IOException {
        return new File("cadeia_certificado.jks");
    }

    @Override
    public String getCertificadoSenha() {
        return "senhaDoCertificado";
    }

    @Override
    public NFUnidadeFederativa getCUF() {
        return NFUnidadeFederativa.PI;
    }

    @Override
    public NFTipoEmissao getTipoEmissao() {
        return NFTipoEmissao.EMISSAO_NORMAL;
    }
}

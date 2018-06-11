/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Juniel
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemPedido", sequenceName = "itemPedido_id_seq")
    @GeneratedValue(generator = "ItemPedido")
    private Long id;

    @Size(max = 50)
    private String cpfCnpjTitular;

    @Size(max = 250)
    private String nomeTitular;

    @Size(max = 250)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoCertificado tipoCertificado;

    @Size(max = 250)
    @Email
    private String email;

    private boolean atendido = false;

    @NotAudited
    @OneToMany(mappedBy = "titular")
    private List<Certificado> certificados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpjTitular() {
        return cpfCnpjTitular;
    }

    public void setCpfCnpjTitular(String cpfCnpjTitular) {
        this.cpfCnpjTitular = cpfCnpjTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public TipoCertificado getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(TipoCertificado tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        if (!Utils.isNullOrEmpty(cpfCnpjTitular) && !Utils.isNullOrEmpty(nomeTitular)) {
            String pattern;
            if (cpfCnpjTitular.length() > 11) {
                pattern = "##.###.###/####-##";
            } else {
                pattern = "###.###.###-##";
            }
            return Utils.format(pattern, cpfCnpjTitular).concat(" - ").concat(nomeTitular);
        }
        return nomeTitular;
    }

}

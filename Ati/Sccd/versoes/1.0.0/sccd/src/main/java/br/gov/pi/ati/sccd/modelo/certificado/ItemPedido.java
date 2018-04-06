/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

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

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;

    @Size(max = 50)
    private String cpfCnpjTitular;

    @Size(max = 250)
    private String titular;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoCertificado tipoCertificado;

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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpfCnpjTitular() {
        return cpfCnpjTitular;
    }

    public void setCpfCnpjTitular(String cpfCnpjTitular) {
        this.cpfCnpjTitular = cpfCnpjTitular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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

    @Override
    public String toString() {
        if (!Utils.isNullOrEmpty(cpfCnpjTitular) && !Utils.isNullOrEmpty(titular)) {
            String pattern;
            if (cpfCnpjTitular.length() > 11) {
                pattern = "##.###.###/####-##";
            } else {
                pattern = "###.###.###-##";
            }
            return Utils.format(pattern, cpfCnpjTitular).concat(" - ").concat(titular);
        }
        return titular;
    }

}

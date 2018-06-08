/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.enums.TipoCliente;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(name = "Cliente", sequenceName = "cliente_id_seq")
    @GeneratedValue(generator = "Cliente")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente clientePai;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;

    private Long codigo;

    @Size(max = 50)
    @NotBlank
    private String cpfCnpj;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    private String sigla;

    private boolean isento = false;

    private boolean ativo = true;

//    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<ContratoCliente> contratos;

    @NotAudited
    @OneToMany(mappedBy = "clientePai")
    private List<Cliente> filhos;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @Override
    public String toString() {
        if (!Utils.isNullOrEmpty(cpfCnpj) && !Utils.isNullOrEmpty(nome)) {
            String pattern;
            if (cpfCnpj.length() > 11) {
                pattern = "##.###.###/####-##";
            } else {
                pattern = "###.###.###-##";
            }
            return Utils.format(pattern, cpfCnpj).concat(" - ").concat(nome);
        }
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isIsento() {
        return isento;
    }

    public void setIsento(boolean isento) {
        this.isento = isento;
    }

    public List<ContratoCliente> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoCliente> contratos) {
        this.contratos = contratos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente getClientePai() {
        return clientePai;
    }

    public void setClientePai(Cliente clientePai) {
        this.clientePai = clientePai;
    }

    public List<Cliente> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Cliente> filhos) {
        this.filhos = filhos;
    }

}

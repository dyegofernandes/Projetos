/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.IconeViatura;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Viatura implements Serializable {

    @Id
    @SequenceGenerator(name = "Viatura", sequenceName = "viatura_id_seq")
    @GeneratedValue(generator = "Viatura")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ModeloVeiculo marcaModelo;

    @Size(max = 50)
    @NotBlank
    private String prefixo;

    @Size(max = 50)
    private String placa;

    @Size(max = 50)
    private String ano;

    @Size(max = 50)
    private String renavan;

    @Size(max = 50)
    @NotBlank
    private String chassi;

    private Integer kmPorLitro;

    @NotNull
    private Integer lotacao;

    @Enumerated(EnumType.STRING)
    private IconeViatura icone;

    private boolean ativa = true;

    @ManyToMany(targetEntity = ApelidoViatura.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ApelidoViatura> apelidos = new ArrayList<ApelidoViatura>();

    @Override
    public String toString() {
        return prefixo;
    }

    @NotAudited
    @OneToMany(mappedBy = "viatura")
    private List<Patrulha> patrulhas;

    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Patrulha> getPatrulhas() {
        return patrulhas;
    }

    public void setPatrulhas(List<Patrulha> patrulhas) {
        this.patrulhas = patrulhas;
    }

    public ModeloVeiculo getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(ModeloVeiculo marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getKmPorLitro() {
        return kmPorLitro;
    }

    public void setKmPorLitro(Integer kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    public IconeViatura getIcone() {
        return icone;
    }

    public void setIcone(IconeViatura icone) {
        this.icone = icone;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public List<ApelidoViatura> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<ApelidoViatura> apelidos) {
        this.apelidos = apelidos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Viatura other = (Viatura) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

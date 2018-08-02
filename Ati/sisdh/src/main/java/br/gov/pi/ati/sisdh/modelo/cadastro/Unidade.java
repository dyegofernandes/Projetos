/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.FaixaEtaria;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoUnidade;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Unidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Unidade", sequenceName = "seq_unidade")
    @GeneratedValue(generator = "Unidade")
    private Long id;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    @NotBlank
    private String sigla;

    @NotNull
    private TipoUnidade tipo;

    private FaixaEtaria faixaEtariaVitima = FaixaEtaria.TODAS;

    private FaixaEtaria faixaEtariaAgressor = FaixaEtaria.TODAS;

    private double centroLtdMaps;

    private double centroLgtMaps;

    private int zoomMaps = 7;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private TerritorioCidade territorioCidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private TerritorioBairro territorioBairro;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @NotAudited
    @OneToMany(mappedBy = "unidadeOrigem")
    private List<Denuncia> denunciasOrigem;
    
    @NotAudited
    @OneToMany(mappedBy = "unidadeResponsavel")
    private List<Denuncia> denunciasResponsaveis;

 //   @NotAudited
 //   @OneToMany(mappedBy = "unidade")
 //   private List<Usuario> usuarios;

 

    @NotNull
    private Boolean visualizarDenunciaNormal = true;

    @NotNull
    private Boolean visualizarDenunciaPanico = true;

    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public TipoUnidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoUnidade tipo) {
        this.tipo = tipo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.trim().toUpperCase();
        }
        this.sigla = sigla;
    }

    public List<Denuncia> getDenunciasOrigem() {
        return denunciasOrigem;
    }

    public void setDenunciasOrigem(List<Denuncia> denunciasOrigem) {
        this.denunciasOrigem = denunciasOrigem;
    }

    public List<Denuncia> getDenunciasResponsaveis() {
        return denunciasResponsaveis;
    }

    public void setDenunciasResponsaveis(List<Denuncia> denunciasResponsaveis) {
        this.denunciasResponsaveis = denunciasResponsaveis;
    }


    public TerritorioCidade getTerritorioCidade() {
        return territorioCidade;
    }

    public void setTerritorioCidade(TerritorioCidade circunscricao) {
        this.territorioCidade = circunscricao;
    }

    public TerritorioBairro getTerritorioBairro() {
        return territorioBairro;
    }

    public void setCircunscricaoBairro(TerritorioBairro territorioBairro) {
        this.territorioBairro = territorioBairro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

   

    public FaixaEtaria getFaixaEtariaVitima() {
        return faixaEtariaVitima;
    }

    public void setFaixaEtariaVitima(FaixaEtaria faixaEtariaVitima) {
        this.faixaEtariaVitima = faixaEtariaVitima;
    }

    public FaixaEtaria getFaixaEtariaAgressor() {
        return faixaEtariaAgressor;
    }

    public void setFaixaEtariaAgressor(FaixaEtaria faixaEtariaAgressor) {
        this.faixaEtariaAgressor = faixaEtariaAgressor;
    }

    public Boolean getVisualizarDenunciaNormal() {
        return visualizarDenunciaNormal;
    }

    public void setVisualizarDenunciaNormal(Boolean visualizarDenunciaNormal) {
        this.visualizarDenunciaNormal = visualizarDenunciaNormal;
    }

    public Boolean getVisualizarDenunciaPanico() {
        return visualizarDenunciaPanico;
    }

    public void setVisualizarDenunciaPanico(Boolean visualizarDenunciaPanico) {
        this.visualizarDenunciaPanico = visualizarDenunciaPanico;
    }

    public double getCentroLtdMaps() {
        return centroLtdMaps;
    }

    public void setCentroLtdMaps(double centroLtdMaps) {
        this.centroLtdMaps = centroLtdMaps;
    }

    public double getCentroLgtMaps() {
        return centroLgtMaps;
    }

    public void setCentroLgtMaps(double centroLgtMaps) {
        this.centroLgtMaps = centroLgtMaps;
    }

    public int getZoomMaps() {
        return zoomMaps;
    }

    public void setZoomMaps(int zoomMaps) {
        this.zoomMaps = zoomMaps;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Unidade other = (Unidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import br.com.facilpagar.util.Utils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Entity
public class TokenBB implements Serializable {

    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "TokenBB", sequenceName = "seq_tokenbb_id")
    @GeneratedValue(generator = "TokenBB")
    private Long id;

    @Column(columnDefinition = "Text")
    private String token_BB;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracaoToken;

    private Long tempoValidadeEmSegundos_BB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken_BB() {
        return token_BB;
    }

    public void setToken_BB(String token_BB) {
        this.token_BB = token_BB;
    }

    public Date getDataGeracaoToken() {
        return dataGeracaoToken;
    }

    public void setDataGeracaoToken(Date dataGeracaoToken) {
        this.dataGeracaoToken = dataGeracaoToken;
    }

    public Long getTempoValidadeEmSegundos_BB() {
        return tempoValidadeEmSegundos_BB;
    }

    public void setTempoValidadeEmSegundos_BB(Long tempoValidadeEmSegundos_BB) {
        this.tempoValidadeEmSegundos_BB = tempoValidadeEmSegundos_BB;
    }

    public Long getTempoRestante() {
        if (dataGeracaoToken != null) {
            return Utils.diferencaEntreDadas(new Date(), Utils.somarDataComSegundos(dataGeracaoToken, tempoValidadeEmSegundos_BB));
        }

        return 0L;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TokenBB other = (TokenBB) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

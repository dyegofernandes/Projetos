/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.mensagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class MailBox implements Serializable {

    @Id
    @SequenceGenerator(name = "MailBox", allocationSize = 1, sequenceName = "mailBox_id_seq")
    @GeneratedValue(generator = "MailBox")
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();

    @ManyToMany(targetEntity = Messenger.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Messenger> messenges = new ArrayList<Messenger>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Messenger> getMessenges() {
        return messenges;
    }

    public void setMessenges(List<Messenger> messenges) {
        this.messenges = messenges;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MailBox other = (MailBox) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

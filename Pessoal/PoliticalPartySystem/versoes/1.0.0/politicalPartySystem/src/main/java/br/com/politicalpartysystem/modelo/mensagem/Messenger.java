/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.mensagem;

import br.com.politicalpartysystem.modelo.enums.TypeMessager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Messenger implements Serializable {

    @Id
    @SequenceGenerator(name = "Messenger", allocationSize = 1, sequenceName = "messenger_id_seq")
    @GeneratedValue(generator = "Messenger")
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @Size(max = 250)
    @NotBlank
    private String title;

    @Column(columnDefinition = "Text")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date readingDate;
    
    @NotNull
    private TypeMessager type;
    
    @ManyToMany(targetEntity = MessageBoards.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<MessageBoards> messageBoards = new ArrayList<MessageBoards>();

    @Override
    public String toString() {
        return title; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(Date readingDate) {
        this.readingDate = readingDate;
    }

    public TypeMessager getType() {
        return type;
    }

    public void setType(TypeMessager type) {
        this.type = type;
    }

    public List<MessageBoards> getMessageBoards() {
        return messageBoards;
    }

    public void setMessageBoards(List<MessageBoards> messageBoards) {
        this.messageBoards = messageBoards;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Messenger other = (Messenger) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}

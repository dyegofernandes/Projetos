/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.mensagem;

import br.com.politicalpartysystem.modelo.enums.TypeMessageBoard;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class MessageBoards implements Serializable {

    @Id
    @SequenceGenerator(name = "MessageBoards", allocationSize = 1, sequenceName = "messageBoards_id_seq")
    @GeneratedValue(generator = "MessageBoards")
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private TypeMessageBoard extension;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String document;
    
    private boolean active = true;

    @Override
    public String toString() {
        return title; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public TypeMessageBoard getExtension() {
        return extension;
    }

    public void setExtension(TypeMessageBoard extension) {
        this.extension = extension;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final MessageBoards other = (MessageBoards) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}

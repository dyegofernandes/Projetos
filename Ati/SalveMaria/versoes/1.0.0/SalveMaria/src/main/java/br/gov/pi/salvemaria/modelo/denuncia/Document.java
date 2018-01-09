/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.denuncia;

/**
 *
 * @author Juniel
 */
import java.io.Serializable;
 
public class Document implements Serializable, Comparable<Document> {
 
    private String nome;
     
    private String size;
     
    private String type;
     
    public Document(String nome, String size, String type) {
        this.nome = nome;
        this.size = size;
        this.type = type;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        if(nome!=null){
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }
 
    public String getSize() {
        return size;
    }
 
    public void setSize(String size) {
        this.size = size;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return nome;
    }
 
    @Override
    public int compareTo(Document document) {
        return this.getNome().compareTo(document.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 23 * hash + (this.size != null ? this.size.hashCode() : 0);
        hash = 23 * hash + (this.type != null ? this.type.hashCode() : 0);
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
        final Document other = (Document) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.size == null) ? (other.size != null) : !this.size.equals(other.size)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        return true;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author KillerBeeTwo
 */
public class Livro {
    private int ano;
    private String titulo;
    private String isbn;
    
    private List<Autor> autores = new ArrayList<Autor>();

    public Livro() {
    }

    public Livro(int ano, String titulo, String isbn) {
        this.ano = ano;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}

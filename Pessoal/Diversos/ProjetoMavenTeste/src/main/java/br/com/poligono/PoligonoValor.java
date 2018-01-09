/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poligono;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class PoligonoValor implements Serializable {

    private Long id;

    List<PontoValor> pontosX = new ArrayList<PontoValor>();

    List<PontoValor> pontosY = new ArrayList<PontoValor>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PontoValor> getPontosX() {
        return pontosX;
    }

    public void setPontosX(List<PontoValor> pontosX) {
        this.pontosX = pontosX;
    }

    public List<PontoValor> getPontosY() {
        return pontosY;
    }

    public void setPontosY(List<PontoValor> pontosY) {
        this.pontosY = pontosY;
    }

}

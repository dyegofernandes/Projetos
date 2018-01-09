/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.vos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class PoligonoValorVO implements Serializable {

    private Long id;

    List<PontoValorVO> pontosX = new ArrayList<PontoValorVO>();

    List<PontoValorVO> pontosY = new ArrayList<PontoValorVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PontoValorVO> getPontosX() {
        return pontosX;
    }

    public void setPontosX(List<PontoValorVO> pontosX) {
        this.pontosX = pontosX;
    }

    public List<PontoValorVO> getPontosY() {
        return pontosY;
    }

    public void setPontosY(List<PontoValorVO> pontosY) {
        this.pontosY = pontosY;
    }

}

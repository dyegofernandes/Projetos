/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste;

import dotateste.enums.filtrosDeBusca.Players;

/**
 *
 * @author KillerBee
 *
 */
public class RankingPlayerVO {

    private Players player;
    private Integer numeroPartidas;
    private String field;
    private Integer sum;

    public RankingPlayerVO(Players player, Integer numeroPartidas, Integer sum) {
        this.player = player;
        this.numeroPartidas = numeroPartidas;
        this.sum = sum;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public Integer getNumeroPartidas() {
        return numeroPartidas;
    }

    public void setNumeroPartidas(Integer numeroPartidas) {
        this.numeroPartidas = numeroPartidas;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public double getMedia() {

        if (numeroPartidas == 0) {
            return 0;
        }
        return sum / numeroPartidas;
    }

}

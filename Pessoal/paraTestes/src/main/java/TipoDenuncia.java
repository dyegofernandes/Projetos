/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juniel
 */
public enum TipoDenuncia {

    DENUNCIA(1, "Denúncia Sigilosa"),
    PANICO(2, "Pânico");

    private TipoDenuncia(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
}

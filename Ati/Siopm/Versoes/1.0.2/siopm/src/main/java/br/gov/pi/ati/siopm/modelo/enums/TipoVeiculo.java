/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoVeiculo {

    CICLOMOTOR(1, "Ciclomotor"),
    MOTONETA(2, "Motoneta"),
    MOTOCICLETA(3, "Motocicleta"),
    TRICICLO(4, "Triciclo"),
    AUTOMOVEL(5, "Automóvel"),
    MICROONIBUS(6, "Mircoônibus"),
    ONIBUS(7, "Ônibus"),
    REBOQUE(8, "Reboque"),
    SEMI_REBOQUE(9, "Semi reboque"),
    CAMIONETA(10, "Camioneta"),
    CAMINHAO(11, "Caminhão"),
    CAMINHAO_TRATOR(12, "Caminhão Trator"),
    TR_RODAS(13, "Tr Rodas"),
    TR_ESTEIRAS(14, "Tr Esteiras"),
    TR_MISTO(15, "Tr Misto"),
    QUADRICICLO(16, "Quadriciclo"),
    CHASSI(17, "Chassi");

    private TipoVeiculo(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

}

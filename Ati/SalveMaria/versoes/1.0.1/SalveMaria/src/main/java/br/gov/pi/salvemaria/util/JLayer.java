/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.faces.context.FacesContext;
import javazoom.jl.player.Player;

public class JLayer {

    public static void tocarSom() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/sons/sirene.mp3");
        File mp3File = new File(path);

        // INSTANCIAÇÃO DO OBJETO MP3MUSICA DA CLASS INTERNA
        MP3Musica musica = new MP3Musica();
        musica.tocar(mp3File);

        // CHAMA O METODO QUE TOCA A MUSICA
        musica.start();
    }

    /**
     * ====================================================================
     * CLASS INTERNA MP3 MUSICA QUE EXTENDE DE THREAD PARA TRABALHAR
     * PERFEITAMENTE NA APLICAÇÂO SEM TRAVAMENTO NA EXECUÇÃO
     * ====================================================================
     */
    public static class MP3Musica extends Thread {

        // OBJETO PARA O ARQUIVO MP3 A SER TOCADO
        private File mp3;

        // OBJETO PLAYER DA BIBLIOTECA JLAYER QUE TOCA O ARQUIVO MP3
        private Player player;

        /**
         * CONSTRUTOR RECEBE O OBJETO FILE REFERECIANDO O ARQUIVO MP3 A SER
         * TOCADO E ATRIBUI AO ATRIBUTO DA CLASS
         *
         * @param mp3
         */
        public void tocar(File mp3) {
            this.mp3 = mp3;
        }

        /**
         * ===============================================================
         * ======================================METODO RUN QUE TOCA O MP3
         * ===============================================================
         */
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(mp3);
                BufferedInputStream bis = new BufferedInputStream(fis);

                this.player = new Player(bis);
                System.out.println("Tocando Musica!");

                this.player.play();
                System.out.println("Terminado Musica!");

            } catch (Exception e) {
                System.out.println("Problema ao tocar Musica" + mp3);
                e.printStackTrace();
            }
        }
    }

}

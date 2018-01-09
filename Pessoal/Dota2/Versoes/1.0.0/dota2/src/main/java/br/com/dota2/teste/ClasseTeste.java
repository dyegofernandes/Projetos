/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dota2.teste;

import br.com.dota2.util.Utils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Juniel
 *
 */
public class ClasseTeste {

    public static void main(String[] args) throws InterruptedException, ExecutionException, MalformedURLException, IOException {
        String urlApi = "https://api.opendota.com/api";
        URL url = new URL(urlApi.concat(getPlayerTotals(Players.NIEL.getSteamId(), 20)));

        System.out.println(Utils.pegarRetornoUrlGoogle(url));
    }

    //https://api.opendota.com/api/players/102499026/totals?limit=20
    public static String getPlayerTotals(Integer steamId, Integer limit) {
        return ("/player/".concat(steamId.toString()).concat("totals?limit=").concat(limit.toString()));
    }
}

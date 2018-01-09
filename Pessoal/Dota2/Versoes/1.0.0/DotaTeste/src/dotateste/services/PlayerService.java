/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste.services;

import dotateste.RankingPlayerVO;
import dotateste.Utils;
import dotateste.constantes.ConstantesURL;
import dotateste.enums.FieldRanking;
import dotateste.enums.filtrosDeBusca.Players;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author KillerBee
 */
public class PlayerService {

    private String url = "/players/";

    /**
     * retorna o total por field: kills, deaths, assists, kda, gpm, xpm, lh
     *
     * @param player
     * @param queryParameters limit --> integer Number of matches to limit to
     * offset -> integer Number of matches to offset start by; win --> integer
     * Whether the player won; patch integer Patch ID; game_mode integer Game
     * Mode ID; lobby_type integer Lobby type ID; region integer Region ID; date
     * integer Days previous; lane_role integer Lane Role ID; hero_id integer
     * Hero ID; is_radiant integer Whether the player was radiant;
     * included_account_id integer Account IDs in the match (array);
     * excluded_account_id integer Account IDs not in the match (array);
     * with_hero_id integer Hero IDs on the player's team (array);
     * against_hero_id integer Hero IDs against the player's team (array);
     * significant integer Whether the match was significant for aggregation
     * purposes; sort string The field to return matches sorted by in descending
     * order
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
//    public RankingPlayerVO getTotalsFieldForPlayer(FieldRanking rankingFor, Players player, Map<String, String> queryParameters) throws MalformedURLException, IOException {
//        RankingPlayerVO ranking;
//
//        if (player == null) {
//            return null;
//        }
//
//        String urlApi = ConstantesURL.URL_API.concat(url).concat(player.getSteamId().toString().concat("/totals"));
//
//        if (queryParameters.size() > 0) {
//            urlApi = urlApi.concat(queryParameters.toString().replace("{", "?").replace("}", "")
//                    .replace(",", "&").replace(" ", ""));
//        }
//
//        URL url = new URL(urlApi);
//
//        String json = Utils.pegarRetornoUrlGoogle(url);
//
//        JSONArray jsonArray = new JSONArray(json);
//
//        for (Object jsonArray1 : jsonArray) {
//            JSONObject jsonObject = new JSONObject(jsonArray1.toString());
//
//            if (jsonObject.getString("field").equals(rankingFor.getFilter())) {
//                return new RankingPlayerVO(rankingFor.getDescricao(), player.getDescricao(), jsonObject.getInt("sum"));
//            }
//
//        }
//
//        return null;
//    }

    /**
     * retorna o total por field: kills, deaths, assists, kda, gpm, xpm, lh
     *
     * @param player
     * @param queryParameters limit --> integer Number of matches to limit to
     * offset -> integer Number of matches to offset start by; win --> integer
     * Whether the player won; patch integer Patch ID; game_mode integer Game
     * Mode ID; lobby_type integer Lobby type ID; region integer Region ID; date
     * integer Days previous; lane_role integer Lane Role ID; hero_id integer
     * Hero ID; is_radiant integer Whether the player was radiant;
     * included_account_id integer Account IDs in the match (array);
     * excluded_account_id integer Account IDs not in the match (array);
     * with_hero_id integer Hero IDs on the player's team (array);
     * against_hero_id integer Hero IDs against the player's team (array);
     * significant integer Whether the match was significant for aggregation
     * purposes; sort string The field to return matches sorted by in descending
     * order
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
//    public List<RankingPlayerVO> getTotalsForPlayer(Players player, Map<String, String> queryParameters) throws MalformedURLException, IOException {
//
//        List<RankingPlayerVO> lista = new ArrayList<RankingPlayerVO>();
//        if (player == null) {
//            return null;
//        }
//
//        String urlApi = ConstantesURL.URL_API.concat(url).concat(player.getSteamId().toString().concat("/totals"));
//
//        if (queryParameters.size() > 0) {
//            urlApi = urlApi.concat(queryParameters.toString().replace("{", "?").replace("}", "")
//                    .replace(",", "&").replace(" ", ""));
//        }
//
//        URL url = new URL(urlApi);
//
//        String json = Utils.pegarRetornoUrlGoogle(url);
//
//        JSONArray jsonArray = new JSONArray(json);
//
//        for (Object jsonArray1 : jsonArray) {
//            JSONObject jsonObject = new JSONObject(jsonArray1.toString());
//
//            RankingPlayerVO ranking = new RankingPlayerVO(jsonObject.getString("field"), player.getDescricao(), jsonObject.getInt("sum"));
//
//            lista.add(ranking);
//        }
//
//        return lista;
//    }

    public List<RankingPlayerVO> getRankingForField(FieldRanking rankingFor, Players[] players, Map<String, String> queryParameters) throws MalformedURLException, IOException {

        List<RankingPlayerVO> lista = new ArrayList<RankingPlayerVO>();
        if (players == null) {
            return null;
        }

        for (Players player : players) {
            String urlApi = ConstantesURL.URL_API.concat(url).concat(player.getSteamId().toString().concat("/totals"));

            if (queryParameters.size() > 0) {
                urlApi = urlApi.concat(queryParameters.toString().replace("{", "?").replace("}", "")
                        .replace(",", "&").replace(" ", ""));
            }

            URL url = new URL(urlApi);

            String json = Utils.pegarRetornoUrlGoogle(url);

            JSONArray jsonArray = new JSONArray(json);
            for (Object jsonArray1 : jsonArray) {

                JSONObject jsonObject = new JSONObject(jsonArray1.toString());
                if (jsonObject.getString("field").equals(rankingFor.getFilter())) {
                    double media = 0;

                    if (jsonObject.getInt("n") > 0) {
                        media = jsonObject.getInt("sum") / jsonObject.getInt("n");
                    }

                    RankingPlayerVO ranking = new RankingPlayerVO(player, jsonObject.getInt("n"), jsonObject.getInt("sum"));
                    lista.add(ranking);
                    break;

                }

            }
        }

        Collections.sort(lista, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                RankingPlayerVO u1 = (RankingPlayerVO) o1;
                RankingPlayerVO u2 = (RankingPlayerVO) o2;

                return u1.getMedia() < u2.getMedia() ? +1 : (u1.getMedia() > u2.getMedia() ? -1 : 0);
            }
        });

        return lista;
    }

}

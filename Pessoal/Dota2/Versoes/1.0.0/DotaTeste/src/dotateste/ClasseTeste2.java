/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste;

import dotateste.enums.FieldRanking;
import dotateste.enums.filtrosDeBusca.Date_Enum;
import dotateste.enums.filtrosDeBusca.Lane_Role;
import dotateste.enums.filtrosDeBusca.Lobby_Type;
import dotateste.enums.filtrosDeBusca.Players;
import dotateste.services.PlayerService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author KillerBee
 */
public class ClasseTeste2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, MalformedURLException, IOException {

        PlayerService playerService = new PlayerService();

        Lane_Role lane = Lane_Role.UNKNOWN;

        Map<String, String> map = new HashMap<String, String>();
        map.put("lobby_type", Lobby_Type.RANKED.getNum() + "");
        map.put("date", Date_Enum.LAST_WEEK.getNum() + "");
        map.put("lane_role", lane.getNum() + "");

        List<RankingPlayerVO> rankingKills = playerService.getRankingForField(FieldRanking.KILLS, Players.values(), map);
        List<RankingPlayerVO> rankingDeaths = playerService.getRankingForField(FieldRanking.DEATHS, Players.values(), map);
        List<RankingPlayerVO> rankingAssists = playerService.getRankingForField(FieldRanking.ASSISTS, Players.values(), map);
        List<RankingPlayerVO> rankingKda = playerService.getRankingForField(FieldRanking.KDA, Players.values(), map);
        List<RankingPlayerVO> rankingGoldPerMin = playerService.getRankingForField(FieldRanking.GPM, Players.values(), map);
        List<RankingPlayerVO> rankingXpPerMin = playerService.getRankingForField(FieldRanking.XPM, Players.values(), map);
        List<RankingPlayerVO> rankingLastHists = playerService.getRankingForField(FieldRanking.LH, Players.values(), map);
        List<RankingPlayerVO> rankingDenies = playerService.getRankingForField(FieldRanking.DENIES, Players.values(), map);

        System.out.println("-RANKING LAST WEEK MATCHES RANKED - ".concat(lane.getDescricao().toUpperCase()));
        System.out.println("--------------------------------");
        System.out.println("Ranking Kills");
        System.out.println("--------------------------------");
        int count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingKills) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking Deadhs");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingDeaths) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking Assists");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingAssists) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking KDA");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingKda) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking GPM");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingGoldPerMin) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking XPM");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingXpPerMin) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking LH");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingLastHists) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }

        System.out.println("--------------------------------");
        System.out.println("Ranking Denies");
        System.out.println("--------------------------------");
        count = 1;
        System.out.printf("%-2s%-2s%-16s%s\n", "N.", " ", "Name", "Avg");
        System.out.println("--------------------------------");
        for (RankingPlayerVO ranking : rankingDenies) {
            System.out.printf("%02d%-2s%-16s%07f\n", count, ".", ranking.getPlayer().getDescricao(), ranking.getMedia());
            count++;
        }
    }
}

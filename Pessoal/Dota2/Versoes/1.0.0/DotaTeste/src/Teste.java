
import com.google.gson.Gson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KillerBeeTwo
 */
public class Teste {

    public static void main(String[] args) {
        String json = "{dataInicial: 13-01-17}";
        Gson gson = new Gson();
        Filtros filtros = gson.fromJson(json, Filtros.class);
        
        System.out.println(filtros.getDataInicial());
    }

}

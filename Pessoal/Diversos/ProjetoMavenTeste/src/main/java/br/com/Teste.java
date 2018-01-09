package br.com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Teste {

    public static void main(String[] args) {
//        List<Usuario> listaUsuarios = preencherLista();
//
//        Map<Usuario, List<Usuario>> mapaTotal = new TreeMap<Usuario, List<Usuario>>(new Comparator<Usuario>() {
//            @Override
//            public int compare(Usuario o1, Usuario o2) {
//                return o1.getNome().compareTo(o2.getNome());
//            }
//        });
//
//        List<Usuario> usuarios = new ArrayList<Usuario>();
//
//        for (Usuario usuario : listaUsuarios) {
//            if (!mapaTotal.containsKey(usuario)) {
//                usuarios = new ArrayList<Usuario>();
//                usuarios.add(usuario);
//                mapaTotal.put(usuario, usuarios);
//            } else {
//                mapaTotal.get(usuario).add(usuario);
//            }
//        }
//
//        for (Usuario usuario : mapaTotal.keySet()) {
//
//            List<Usuario> lista = mapaTotal.get(usuario);
//
//            InformacoesUsuario informacoesUsuario = new InformacoesUsuario();
//            informacoesUsuario.setId(usuario.getId());
//            informacoesUsuario.setNome(usuario.getNome());
//            informacoesUsuario.setQtdApareceu(lista.size());
//
//            BigDecimal tempoTotal = BigDecimal.ZERO;
//
//            for (Usuario usuario2 : lista) {
//                tempoTotal = tempoTotal.add(usuario2.getTempo());
//            }
//
//            informacoesUsuario.setTempo(tempoTotal);
//            informacoesUsuario.setObservacao(lista.get(lista.size() - 1).getObservacao());
//
//            System.out.println("Informações do Usuário: " + informacoesUsuario.toString());
//            System.out.println("********************************");
//        }
//        Map<String, String> example = new HashMap<String, String>();

        /*
         * Vamos adicionar alguns valores a nossa lista
         * */
//        example.put("K1", new String("V1"));
//        example.put("K2", new String("V2"));
//        example.put("K3", new String("V3"));
//        example.put("K4", new String("V4"));
//        example.put("K5", new String("V5"));
//
//        String keyToSearch = "K1";
//
//        System.out.println(example.toString());
//        Calendar dataTemp = Calendar.getInstance();
//        dataTemp.setTime(new Date());
//
//        dataTemp.set(Calendar.DAY_OF_MONTH, 2);
//        dataTemp.set(Calendar.MONTH, 10);
//        dataTemp.set(Calendar.YEAR, 2017);
//
//        System.out.println(getTempoAtendimentoEmAnos(dataTemp.getTime(), new Date()));
//
//        System.out.println(verificarDataInscricao(dataTemp.getTime()));
        
    }

   
    private static boolean verificarDataInscricao(Date dataInscricao) {

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(new Date());

        dataFinal.set(Calendar.DAY_OF_MONTH, 2);
        dataFinal.set(Calendar.MONTH, 10);
        dataFinal.set(Calendar.YEAR, 2017);

        dataFinal.set(Calendar.HOUR_OF_DAY, 23);
        dataFinal.set(Calendar.MINUTE, 59);
        dataFinal.set(Calendar.SECOND, 59);

        if (dataInscricao.after(dataFinal.getTime())) {
            return true;
        }

        System.out.println(dataFinal.getTime());

        return false;
    }

    public static Long getTempoAtendimentoEmAnos(Date dataInicial, Date dataFinal) {

        if (dataInicial == null) {
            return 0L;
        }

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        Calendar dataFinalTemp = Calendar.getInstance();

        dataFinalTemp.setTime(dataFinal);

        Long milisegundos = (dataFinalTemp.getTimeInMillis() - dataInicialTemp.getTimeInMillis());

        return (((milisegundos / (1000 * 60 * 60 * 24)) / 30) / 12);
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static List<Usuario> preencherLista() {
        Usuario usuario1 = new Usuario(1, "A", new BigDecimal(1), "Observação 1 hora");
        Usuario usuario8 = new Usuario(3, "C", new BigDecimal(1), "Observação 1 hora");
        Usuario usuario5 = new Usuario(2, "B", new BigDecimal(1), "Observação 1 hora");
        Usuario usuario2 = new Usuario(1, "A", new BigDecimal(1), "Observação 1 hora");
        Usuario usuario10 = new Usuario(4, "D", new BigDecimal(5), "Observação 5 horas");
        Usuario usuario7 = new Usuario(2, "B", new BigDecimal(1), "Observação 1 hora");
        Usuario usuario3 = new Usuario(1, "A", new BigDecimal(2), "Observação 2 horas");
        Usuario usuario6 = new Usuario(2, "B", new BigDecimal(2), "Observação 2 horas");
        Usuario usuario9 = new Usuario(3, "C", new BigDecimal(2), "Observação 2 horas");
        Usuario usuario4 = new Usuario(1, "A", new BigDecimal(3), "Observação 3 horas");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        usuarios.add(usuario7);
        usuarios.add(usuario8);
        usuarios.add(usuario9);
        usuarios.add(usuario10);

        return usuarios;
    }

    public static boolean verificarSeDataEhMaiorQueDataAtual(Date dataVerificada, Date horaVerificada) {
        if (dataVerificada != null && horaVerificada != null) {
            Calendar dataTemp = Calendar.getInstance();
            dataTemp.setTime(dataVerificada);

            Calendar horaTemp = Calendar.getInstance();
            horaTemp.setTime(horaVerificada);

            dataTemp.set(Calendar.HOUR_OF_DAY, horaTemp.get(Calendar.HOUR_OF_DAY));
            dataTemp.set(Calendar.MINUTE, horaTemp.get(Calendar.MINUTE));

            if (dataTemp.getTime().compareTo(new Date()) > 0) {
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

}

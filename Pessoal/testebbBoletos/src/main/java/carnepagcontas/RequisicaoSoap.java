/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnepagcontas;

import carnepagcontas.com.example.xmlns._1466775928160.Erro;
import carnepagcontas.com.example.xmlns._1466775928160.RegistroCobrancaServiceServiceagent;
import carnepagcontas.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema.Requisicao;
import carnepagcontas.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema.Resposta;

/**
 *
 * @author JUniel
 */
public class RequisicaoSoap {

    public static void main(String[] args) throws Erro {
        
        RegistroCobrancaServiceServiceagent service = new RegistroCobrancaServiceServiceagent();
        
        Requisicao requisicao = new Requisicao();

        Resposta resposta = service.getRegistroCobrancaEndpoint().registroTituloCobranca(requisicao);

        System.out.println(">>" + resposta);

    }

}

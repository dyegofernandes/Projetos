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
import java.math.BigDecimal;

/**
 *
 * @author JUniel
 */
public class RequisicaoSoap {

    public static void main(String[] args) throws Erro {
        
        RegistroCobrancaServiceServiceagent service = new RegistroCobrancaServiceServiceagent();
        
        Requisicao requisicao = new Requisicao();
        
        requisicao.setNumeroConvenio(2625444);
        requisicao.setNumeroCarteira(new Short("17"));
        requisicao.setNumeroVariacaoCarteira(new Short("19"));
        requisicao.setCodigoModalidadeTitulo(new Short("1"));
        requisicao.setDataEmissaoTitulo("16-05-2018");
        requisicao.setDataVencimentoTitulo("19-06-2018");
        requisicao.setValorOriginalTitulo(new BigDecimal("300"));
        requisicao.setCodigoTipoDesconto(new Short("1"));
        requisicao.setDataDescontoTitulo("16-05-2018");
        requisicao.setPercentualDescontoTitulo(BigDecimal.ZERO);
        requisicao.setValorDescontoTitulo(BigDecimal.TEN);
        requisicao.setValorAbatimentoTitulo(BigDecimal.ZERO);
        requisicao.setQuantidadeDiaProtesto(new Short("0"));
        requisicao.setCodigoTipoJuroMora(new Short("0"));
        requisicao.setPercentualJuroMoraTitulo(BigDecimal.ZERO);
        requisicao.setValorJuroMoraTitulo(BigDecimal.ZERO);
        requisicao.setCodigoTipoMulta(new Short("2"));
        requisicao.setDataMultaTitulo("20-06-2018");
        requisicao.setPercentualMultaTitulo(BigDecimal.TEN);
        requisicao.setValorMultaTitulo(BigDecimal.ZERO);
        requisicao.setCodigoAceiteTitulo("N");
        requisicao.setCodigoTipoTitulo(new Short("2"));
        requisicao.setTextoDescricaoTipoTitulo("DUPLICATA");
        requisicao.setIndicadorPermissaoRecebimentoParcial("N");
        requisicao.setTextoNumeroTituloBeneficiario("987654321987654");
        requisicao.setTextoCampoUtilizacaoBeneficiario("");
        requisicao.setCodigoTipoContaCaucao(new Short("1"));
        requisicao.setTextoNumeroTituloCliente("00010140510000000000");
        requisicao.setTextoMensagemBloquetoOcorrencia("Pagamento disponível até a data de Vencimento");
        requisicao.setCodigoTipoInscricaoPagador(new Short("2"));
        requisicao.setNumeroInscricaoPagador(92527938523L);
        requisicao.setNomePagador("MERCADO ANDREZA DE MACEDO");
        requisicao.setTextoEnderecoPagador("RUA SEM NOME");
        requisicao.setNumeroCepPagador(64000000);
        requisicao.setNomeMunicipioPagador("TERESINA");
        requisicao.setNomeBairroPagador("CENTRO");
        requisicao.setSiglaUfPagador("PI");
        requisicao.setTextoNumeroTelefonePagador("99999999");
        requisicao.setCodigoTipoInscricaoAvalista(Short.MIN_VALUE);
        requisicao.setNumeroInscricaoAvalista(Long.MIN_VALUE);
        requisicao.setNomeAvalistaTitulo("");
        requisicao.setCodigoChaveUsuario("1");
        requisicao.setCodigoTipoCanalSolicitacao(new Short("5"));

        Resposta resposta = service.getRegistroCobrancaEndpoint().registroTituloCobranca(requisicao);

        System.out.println(">>" + resposta);

    }

}

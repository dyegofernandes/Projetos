package com.ebol.bo.venda;

import com.ebol.dao.cadastro.ClienteDAO;
import com.ebol.dao.cadastro.Padrao_CobrancaDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.BoletoDAO;
import com.ebol.modelo.cadastro.Cidade;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import com.ebol.modelo.cadastro.Uf;
import com.ebol.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.vos.BoletoVO;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.core.validation.UniqueFields;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.persistence.TemporalType;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoBO extends AbstractBusinessObject<Boleto> {

    @EJB
    private BoletoDAO boletoDAO;

    @EJB
    private Padrao_CobrancaDAO padraoDAO;

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public BoletoDAO getDAO() {
        return boletoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "venda", "parcela");
    }

    @Override
    public void validate(Boleto boleto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public void travarTodosBoletos(List<Boleto> boletos) {
        for (Boleto boleto : boletos) {
            boleto.setTravado(true);
            boletoDAO.saveOrMerge(boleto, true);
        }
    }

    public void travarUmBoleto(Boleto boleto) {
        boleto.setTravado(true);
        boletoDAO.saveOrMerge(boleto, true);
    }

    public void gerarBoletosEmLote(List<Boleto> boletos) {

        String codigoDeBarras = "";
        String caminhoLogo;
        caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/pagcontasboleto.png");
        List<BoletoVO> listaBoletosVO = new ArrayList<BoletoVO>();
        int cont = 1;
        HashMap params = new HashMap();

        for (Boleto boleto : boletos) {
            Convenio convenio = boletoDAO.getInitialized(boleto.getConvenio());
            Padrao_Cobranca padrao = padraoDAO.unique("convenio", convenio);
            Cliente cliente = boletoDAO.getInitialized(boleto.getCliente());
            Cidade cidade = boletoDAO.getInitialized(cliente.getCidade());
            codigoDeBarras = gerarCodigoDeBarras(boleto.getValor_cobrado(), boleto.getVencimento(),
                    boleto.getId().toString(), boleto.getNossoNumero().toString());
            Uf uf = null;
            if (cidade != null) {
                if (cidade.getUf() != null) {
                    uf = boletoDAO.getInitialized(cidade.getUf());
                }
            }
            BoletoVO boletoVO = new BoletoVO();
            boletoVO.setNomeConvenio(convenio.getFantasia());
            boletoVO.setCodigoDeBarras(codigoDeBarras);
            boletoVO.setCodigoDeBarrasMask(gerarCodigoBarrasComMask(codigoDeBarras));
            boletoVO.setVencimento(dataParaString(boleto.getVencimento(), 2));
            boletoVO.setNossoNumero(lpadTo(boleto.getNossoNumero().toString(), 13, '0'));
            boletoVO.setValorCobrado(boleto.getValor_cobrado().toString());
            boletoVO.setDesconto(boleto.getDesconto().toString());
            boletoVO.setOutraDeducoes(null);
            boletoVO.setMoraMultaJuros(null);
            boletoVO.setOutrosAcrescimos(null);
            
            boletoVO.setValorCobrado(boleto.getValor_cobrado().toString());
            String nomeFantasia = cliente.getNomeOuFantasia() != null ? cliente.getId().toString().concat(" - ").concat(
                    cliente.getNomeOuFantasia()).toUpperCase() : "";
            
            boletoVO.setApelidoNomeFantasia(nomeFantasia);
      
            boletoVO.setNomeRazaoSocial(cliente.getCompletoOuRsocial() != null ? cliente.getCompletoOuRsocial().toUpperCase() : "");
            boletoVO.setReferenteA(boleto.getReferenteA() != null ? boleto.getReferenteA().toUpperCase() : "");
            boletoVO.setSituacao("SOLUÇÃO (".concat(boleto.getSituacao().getDescricao()).concat(")"));

            String desconto = "ATÉ O VENCIMENTO CONCEDER DESCONTO DE R$ ";
            String multa = "Multa por atraso: R$ ";
            String juros = "Mora: R$ ";

            if (padrao != null) {
                boletoVO.setLocalPagamento(padrao.getLocalPagto() != null ? padrao.getLocalPagto().toUpperCase() : null);
                boletoVO.setMensagem(padrao.getMensagem() != null ? padrao.getMensagem().toUpperCase() : null);
            }

            if (boleto.getMulta() != null) {
                multa = multa.concat(boleto.getMulta().toString()).concat(".");
            }
            if (boleto.getJuros() != null) {
                juros = juros.concat(boleto.getJuros().toString()).concat(".");
            }

            if (boleto.getDesconto() != null) {
                desconto = desconto.concat(boleto.getDesconto().toString()).concat(".");

            }

            boletoVO.setDescontoDescricao(desconto);
            boletoVO.setJurosDescricao(juros);
            boletoVO.setMultaDescricao(multa);

            boletoVO.setInstrucaoExclusiva(boleto.getInstrucao_exclusiva() != null ? boleto.getInstrucao_exclusiva().toUpperCase() : "");

            String cpfCnpj = "CNPJ: ";
                   
            if(cliente.getCpfOrCnpj() != null){
               if(cliente.getCpfOrCnpj().equals("")){
                   cpfCnpj = cpfCnpj.concat("00.000.000/0000-00");
               }else{
                   if(cliente.getCpfOrCnpj().length() == 11){
                       cpfCnpj = cpfCnpj.concat(format("###.###.###-##", cliente.getCpfOrCnpj()));
                   }else{
                       cpfCnpj = cpfCnpj.concat(format("##.###.###/####-##", cliente.getCpfOrCnpj()));
                   }
               }
            }else{
                cpfCnpj = cpfCnpj.concat("00.000.000/0000-00");
            }
            
            boletoVO.setCpfCnpj(cpfCnpj);

            boletoVO.setNomeFantasiaCnpj(nomeFantasia.concat(" ").concat(cpfCnpj));
            
            String endereco = "";

            if (convenio.getEndereco() != null) {
                endereco = endereco.concat(convenio.getEndereco());
            }
            if (convenio.getBairro() != null) {
                endereco = endereco.concat(" ").concat(convenio.getBairro());
            }
            if (convenio.getCep() != null) {
                endereco = endereco.concat(" ").concat(convenio.getCep());
            }
            if (convenio.getCidade() != null) {
                Cidade cidadeConvenio = boletoDAO.getInitialized(convenio.getCidade());
                endereco = endereco.concat(" ").concat(cidadeConvenio.getNome());
                if (cidadeConvenio.getUf() != null) {
                    Uf ufConvenio = boletoDAO.getInitialized(cidadeConvenio.getUf());
                    endereco = endereco.concat(" ").concat(ufConvenio.getSigla());
                }
            }
            if (convenio.getFones() != null) {
                endereco = endereco.concat(" ").concat(convenio.getFones());
            }

            boletoVO.setEndereco(endereco.toUpperCase());

            boletoVO.setParcela(boleto.getParcela().toString().concat("/").concat(boleto.getTotalParcela() != null ? boleto.getTotalParcela().toString()
                    : "1"));

            String cidadeEstado = "";
            
            String cepCliente = "CEP: ";
            
            cepCliente = cepCliente.concat(cliente.getCep() != null ? cliente.getCep() : "00000-000");

            if (cidade != null) {
                cidadeEstado = cidadeEstado.concat(cidade.getNome());
            }
            if (uf != null) {
                cidadeEstado = cidadeEstado.concat(" ").concat(uf.getSigla());
            }
            
            boletoVO.setCidadeEstado(cidadeEstado.toUpperCase());
            
            boletoVO.setCepCliente(cepCliente.concat(" ").concat(cidadeEstado.toUpperCase()));

            boletoVO.setVia("2ª via");

            boletoVO.setUrlImagem(caminhoLogo);

            listaBoletosVO.add(boletoVO);
            cont++;
        }

        FacesJasper.createJasperReport(listaBoletosVO, null,
                "/WEB-INF/report/template/boleto.jasper", "Boleto"
                + ".pdf");
    }

    private String gerarCodigoDeBarras(BigDecimal valor, Date vencimento, String idConvenio, String sequencial) {
        String codigoDeBarras = "";
        String primeira = "867";
        String segunda = lpadTo(valor.setScale(2, RoundingMode.UP).toString().replace(".", ""), 11, '0').concat("03931852")
                .concat(dataParaString(vencimento, 1).concat(lpadTo(idConvenio, 4, '0')).concat(lpadTo(sequencial, 9, '0')));
        String digito = getMod10(primeira.concat(segunda));

        codigoDeBarras = primeira.concat(digito).concat(segunda);

        return codigoDeBarras;
    }

    private String gerarCodigoBarrasComMask(String codigo) {
        String codigoBarras = "";
        String parte1 = codigo.substring(0, 11);
        String parte2 = codigo.substring(11, 22);
        String parte3 = codigo.substring(22, 33);
        String parte4 = codigo.substring(33, 44);

        parte1 = parte1.concat(getMod10(parte1));
        parte2 = parte2.concat(getMod10(parte2));
        parte3 = parte3.concat(getMod10(parte3));
        parte4 = parte4.concat(getMod10(parte4));

        codigoBarras = parte1.concat(parte2).concat(parte3).concat(parte4);

        return format("###########-# ###########-# ###########-# ###########-#", codigoBarras);
    }

    private String dataParaString(Date date, int opcao) {
        SimpleDateFormat formataData = null;
        if (opcao == 1) {
            formataData = new SimpleDateFormat("yyyyMMdd");
        }

        if (opcao == 2) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        String data = formataData.format(date);

        return data;
    }

    private String lpadTo(String input, int width, char ch) {
        String strPad = "";

        StringBuilder sb = new StringBuilder(input.trim());
        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        strPad = sb.toString();

        if (strPad.length() > width) {
            strPad = strPad.substring(0, width);
        }
        return strPad;
    }

    private String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String getMod10(String num) {
        //variáveis de instancia
        int soma = 0;
        int resto = 0;
        int dv = 0;
        String[] numeros = new String[num.length() + 1];
        int multiplicador = 2;
        String aux;
        String aux2;
        String aux3;
        for (int i = num.length(); i > 0; i--) {
            //Multiplica da direita pra esquerda, alternando os algarismos 2 e 1
            if (multiplicador % 2 == 0) {
                // pega cada numero isoladamente  
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * 2);
                multiplicador = 1;
            } else {
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * 1);
                multiplicador = 2;
            }
        }
        // Realiza a soma dos campos de acordo com a regra
        for (int i = (numeros.length - 1); i > 0; i--) {
            aux = String.valueOf(Integer.valueOf(numeros[i]));
            if (aux.length() > 1) {
                aux2 = aux.substring(0, aux.length() - 1);
                aux3 = aux.substring(aux.length() - 1, aux.length());
                numeros[i] = String.valueOf(Integer.valueOf(aux2) + Integer.valueOf(aux3));
            } else {
                numeros[i] = aux;
            }
        }
        //Realiza a soma de todos os elementos do array e calcula o digito verificador
        //na base 10 de acordo com a regra.	    
        for (int i = numeros.length; i > 0; i--) {
            if (numeros[i - 1] != null) {
                soma += Integer.valueOf(numeros[i - 1]);
            }
        }
        resto = soma % 10;
        dv = 10 - resto;
        //retorna o digito verificador
        return String.valueOf(dv);
    }

    public List<Boleto> boletosPorConvenio(FiltroBusca filtro) {
        List<Boleto> lista = new ArrayList<Boleto>();
        Restrictions restrictions = new Restrictions();
        Convenio convenio = new Convenio();

        if (filtro.getConvenio() != null) {
            convenio = boletoDAO.getInitialized(filtro.getConvenio());
            restrictions.add("convenio", convenio);
        } else {
            if (!filtro.getUsuario().isSuperUsuario()) {
                convenio = boletoDAO.getInitialized(filtro.getUsuario().getConvenio());
                restrictions.add("convenio", convenio);
            }
        }

        if (filtro.getCliente() != null) {
            restrictions.add("cliente", filtro.getCliente());
        }

        if (filtro.getVenda() != null) {
            restrictions.add("venda", filtro.getVenda());
        }

        if (filtro.getReferenteA() != null) {
            if (!filtro.getReferenteA().equals("")) {
                restrictions.like("referenteA", filtro.getReferenteA());
            }
        }

        if (filtro.getDescricao() != null) {
            if (!filtro.getDescricao().equals("")) {
                restrictions.like("instrucao_exclusiva", filtro.getDescricao());
            }
        }

        if (filtro.getDataInicial() != null) {
            restrictions.greaterEqualsThan("vencimento", filtro.getDataInicial(), TemporalType.DATE);
        }

        if (filtro.getDataFinal() != null) {
            restrictions.lessEqualsThan("vencimento", filtro.getDataFinal(), TemporalType.DATE);
        }

        if (filtro.getSituacao() != null) {
            restrictions.add("situacao", filtro.getSituacao());
        }

        if (filtro.isTravado() != null) {
            restrictions.add("tradado", filtro.isTravado());
        }

        lista = boletoDAO.list(restrictions, "convenio, vencimento");

        return lista;
    }

    public List<Cliente> clientesPorConvenio(Usuario usuario) {
        Convenio convenio = boletoDAO.getInitialized(usuario.getConvenio());
        List<Cliente> lista;

        if (usuario.isSuperUsuario()) {
            lista = clienteDAO.listAll();
        } else {
            lista = clienteDAO.list("convenio", convenio);
        }

        return lista;
    }
}

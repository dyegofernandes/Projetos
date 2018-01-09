package com.opfacil.dao.cadastro.impl;

import com.opfacil.VOs.EmpresaInforAdicionaisVO;
import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.cadastro.EmpresaDAO;
import com.opfacil.modelo.cadastro.Empresa;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class EmpresaDAOImpl extends BaseDAOImpl<Empresa> implements EmpresaDAO {

    @Override
    public Class getEntityClass() {
        return Empresa.class;
    }

    @Override
    public EmpresaInforAdicionaisVO listarInformacoesAdicEmpresa(Integer cdBanco) {
        List<EmpresaInforAdicionaisVO> empresas = new ArrayList<EmpresaInforAdicionaisVO>();

        String queryString = "select cd_banco, nome, tarifa, cnpj, empresa, endereco, cidade, uf, bairro, cep, tipoop, diretorio, tp_inscricao_empresa,"
                + "banco, nu_agencia, dv_agencia, nu_conta, dv_conta, dv_agencia_conta, iss, email1, email2, email3, email4, email5, contato, "
                + "telefone, codempresa from importa.empresas where cd_banco=" + cdBanco;

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            EmpresaInforAdicionaisVO empresa = new EmpresaInforAdicionaisVO();
            empresa.setCdBanco((Integer) tupla[0]);
            empresa.setNome((String) tupla[1]);
            empresa.setTarifa((BigDecimal) tupla[2]);
            empresa.setCnpj((String) tupla[3]);
            empresa.setEmpresa((String) tupla[4]);
            empresa.setEndereco((String) tupla[5]);
            empresa.setCidade((String) tupla[6]);
            empresa.setUf((String) tupla[7]);
            empresa.setBairro((String) tupla[8]);
            empresa.setCep((String) tupla[9]);
            empresa.setTipoOp((String) tupla[10]);
            empresa.setDiretorio((String) tupla[11]);
            empresa.setTpInscricao((Integer) tupla[12]);
            empresa.setBanco((String) tupla[13]);
            empresa.setNuAgencia((String) tupla[14]);
            empresa.setDvAgencia((String) tupla[15]);
            empresa.setNuConta((String) tupla[16]);
            empresa.setDvConta((String) tupla[17]);
            empresa.setDvAgenciaConta((String) tupla[18]);
            empresa.setIss((BigDecimal) tupla[19]);
            empresa.setEmail1((String) tupla[20]);
            empresa.setEmail2((String) tupla[21]);
            empresa.setEmail3((String) tupla[22]);
            empresa.setEmail4((String) tupla[23]);
            empresa.setEmail5((String) tupla[24]);
            empresa.setContato((String) tupla[25]);
            empresa.setTelefone((String) tupla[26]);
            
            empresa.setCodeEmpresa((Integer) tupla[27]);

            empresas.add(empresa);
        }
        if (empresas.size() > 0) {
            return empresas.get(0);
        }
        return null;

    }

}

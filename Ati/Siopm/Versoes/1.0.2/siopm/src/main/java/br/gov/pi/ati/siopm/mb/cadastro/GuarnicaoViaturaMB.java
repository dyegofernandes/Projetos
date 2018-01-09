package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.GuarnicaoViaturaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;
import br.gov.pi.ati.siopm.webservices.inforfolha.server.ServerWebservices;
import br.gov.pi.ati.siopm.webservices.inforfolha.server.ServerWebservicesPortType;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GuarnicaoViaturaMB extends AbstractBaseBean<GuarnicaoViatura> implements Serializable {

    @EJB
    private GuarnicaoViaturaBO componenteViaturaBO;

    @Override
    public GuarnicaoViaturaBO getBO() {
        return componenteViaturaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new GuarnicaoViatura());
    }

    public void carregarDadosServidor() {
        if (getEntity().getCpf() != null) {
            if (!getEntity().getCpf().equals("")) {

                ServidorVO servidorVO = new ServidorVO();

                XStream xstream = new XStream();
                XStream xstreamJason = new XStream();

                ServerWebservices servicorService = new ServerWebservices();
                ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

                String xmlString = servidor.servidorativoxml((getEntity().getCpf().replace(".", "")
                        .replace("-", "")));

                xstreamJason.alias("servidor", ServidorVO.class);
                servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);

                getEntity().setCargoFuncao(!servidorVO.getFuncao().equals("") ? servidorVO.getFuncao() : servidorVO.getCargo());
                getEntity().setEmail(servidorVO.getEmail());
                getEntity().setMatricula(servidorVO.getMatricula());
                getEntity().setNome(servidorVO.getNome());
                getEntity().setTelefone(servidorVO.getTelefone());

            } else {

            }
        }
    }

}

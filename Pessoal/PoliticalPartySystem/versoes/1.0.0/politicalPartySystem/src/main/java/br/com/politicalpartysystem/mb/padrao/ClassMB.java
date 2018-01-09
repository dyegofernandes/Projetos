package br.com.politicalpartysystem.mb.padrao;

import br.com.politicalpartysystem.modelo.mensagem.MessageBoards;
import br.com.politicalpartysystem.modelo.mensagem.Messenger;
import br.com.politicalpartysystem.modelo.enums.TypeMessageBoard;
import br.com.politicalpartysystem.modelo.enums.TypeMessager;
import br.com.politicalpartysystem.modelo.cadastro.UserPoliticalParty;
import br.com.politicalpartysystem.modelo.cadastro.PoliticalParty;
import br.com.politicalpartysystem.modelo.enums.TypePoliticalParty;
import br.com.politicalpartysystem.modelo.enums.Sex;
import br.com.politicalpartysystem.modelo.mensagem.MailBox;
import br.com.politicalpartysystem.modelo.cadastro.MemberPoliticalParty;
import br.com.politicalpartysystem.modelo.enums.TypePhone;
import br.com.politicalpartysystem.modelo.cadastro.Address;
import br.com.politicalpartysystem.modelo.cadastro.IndividualPerson;
import br.com.politicalpartysystem.modelo.enums.TypeAddress;
import br.com.politicalpartysystem.modelo.cadastro.Country;
import br.com.politicalpartysystem.modelo.cadastro.Neighborhood;
import br.com.politicalpartysystem.modelo.cadastro.Phone;
import br.com.politicalpartysystem.modelo.cadastro.Person;
import br.com.politicalpartysystem.modelo.cadastro.State;
import br.com.politicalpartysystem.modelo.cadastro.City;
import br.com.politicalpartysystem.modelo.cadastro.LegalPerson;
import br.com.politicalpartysystem.modelo.enums.TypePublicpark;
import br.com.politicalpartysystem.modelo.controleacesso.Permissao;
import br.com.politicalpartysystem.modelo.controleacesso.Usuario;
import br.com.politicalpartysystem.modelo.configuracao.ErroSistema;
import br.com.politicalpartysystem.modelo.controleacesso.SituacaoUsuario;
import br.com.politicalpartysystem.modelo.controleacesso.AcessoSistema;
import br.com.politicalpartysystem.modelo.email.ConfiguracaoEmail;
import br.com.politicalpartysystem.modelo.controleacesso.Perfil;
import br.com.politicalpartysystem.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.politicalpartysystem.modelo.email.ModeloEmail;
import br.com.politicalpartysystem.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.politicalpartysystem.modelo.email.TipoAssuntoEmail;
import br.com.politicalpartysystem.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.politicalpartysystem.modelo.enums.TypePerson;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getErroSistema() {
        return ErroSistema.class;
    }

    public Class getHistoricoSituacaoUsuario() {
        return HistoricoSituacaoUsuario.class;
    }

    public Class getPerfil() {
        return Perfil.class;
    }

    public Class getPermissao() {
        return Permissao.class;
    }

    public Class getSituacaoUsuario() {
        return SituacaoUsuario.class;
    }

    public Class getUsuario() {
        return Usuario.class;
    }

    public Class getTipoAssuntoEmail() {
        return TipoAssuntoEmail.class;
    }

    public Class getModeloEmail() {
        return ModeloEmail.class;
    }

    public Class getSolicitacaoRecuperacaoSenha() {
        return SolicitacaoRecuperacaoSenha.class;
    }

    public Class getTipoRecuperacaoSenha() {
        return TipoRecuperacaoSenha.class;
    }

    public Class getConfiguracaoEmail() {
        return ConfiguracaoEmail.class;
    }

    public Class getTypePhone() {
        return TypePhone.class;
    }

    public Class getAddress() {
        return Address.class;
    }

    public Class getIndividualPerson() {
        return IndividualPerson.class;
    }

    public Class getTypeAddress() {
        return TypeAddress.class;
    }

    public Class getCountry() {
        return Country.class;
    }

    public Class getNeighborhood() {
        return Neighborhood.class;
    }

    public Class getPhone() {
        return Phone.class;
    }

    public Class getPerson() {
        return Person.class;
    }

    public Class getState() {
        return State.class;
    }

    public Class getCity() {
        return City.class;
    }

    public Class getLegalPerson() {
        return LegalPerson.class;
    }

    public Class getTypePublicpark() {
        return TypePublicpark.class;
    }

    public Class getUserPoliticalParty() {
        return UserPoliticalParty.class;
    }

    public Class getPoliticalParty() {
        return PoliticalParty.class;
    }

    public Class getTypePoliticalParty() {
        return TypePoliticalParty.class;
    }

    public Class getSex() {
        return Sex.class;
    }

    public Class getMailBox() {
        return MailBox.class;
    }

    public Class getMemberPoliticalParty() {
        return MemberPoliticalParty.class;
    }

    public Class getMessageBoards() {
        return MessageBoards.class;
    }

    public Class getMessenger() {
        return Messenger.class;
    }

    public Class getTypeMessageBoard() {
        return TypeMessageBoard.class;
    }

    public Class getTypeMessager() {
        return TypeMessager.class;
    }

    public Class getTypePerson() {
        return TypePerson.class;
    }
}

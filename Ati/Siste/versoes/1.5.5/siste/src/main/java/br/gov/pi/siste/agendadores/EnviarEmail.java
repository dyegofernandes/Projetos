package br.gov.pi.siste.agendadores;

import br.gov.pi.siste.bo.controleacesso.AcessoSistemaBO;
import br.gov.pi.siste.bo.controleacesso.UsuarioBO;
import br.gov.pi.siste.bo.financeiro.MovimentoBO;
import br.gov.pi.siste.bo.financeiro.ReferenciaBO;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;
import br.gov.pi.siste.modelo.controleacesso.AcessoSistema;
import br.gov.pi.siste.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import com.xpert.persistence.query.Restrictions;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author killerbee
 * @see classe para envio de emails
 */
@Singleton
public class EnviarEmail {

    @EJB
    private AcessoSistemaBO acessoBO;

    @EJB
    private ReferenciaBO referenciaBO;

    @EJB
    private UsuarioBO usuarioBO;
    
    @EJB
    private MovimentoBO movimentoBO;

    @Schedule(dayOfMonth = "Last", hour = "23", minute = "59", second = "59")
    private void fecharCompetencia() throws ParseException {

        Referencia referencia = referenciaBO.getDAO().unique("status", StatusReferencia.ABERTA);

        if (referencia != null) {           
            referencia.setStatus(StatusReferencia.FECHADA);
            referenciaBO.getDAO().saveOrMerge(referencia);
            movimentoBO.travarMovimentos(referencia);
        }
    }

    @Schedule(dayOfMonth = "*", hour = "0", minute = "0", second = "0")
    private void inativarUsuario() throws ParseException {
        
        Restrictions restrictions = new Restrictions();
        restrictions.add("superUsuario", false);
        restrictions.add("situacaoUsuario", SituacaoUsuario.ATIVO);

        List<Usuario> usuarios = usuarioBO.getDAO().list(restrictions);

        for (Usuario usuario : usuarios) {

            restrictions = new Restrictions();

            Date UltimoAcesso;

            restrictions.add("acesso.usuario", usuario);

            UltimoAcesso =  (Date) acessoBO.getDAO().getQueryBuilder().select("acesso.dataHora").from(AcessoSistema.class, "acesso").add(restrictions).
                    max("acesso.dataHora");
            if (diferencaEntreDatas(UltimoAcesso, new Date()) > 89) {
                usuario.setSituacaoUsuario(SituacaoUsuario.INATIVO);
                usuarioBO.getDAO().saveOrMerge(usuario);
            }
        }

    }

    private int diferencaEntreDatas(Date data1, Date data2) throws ParseException {
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(data1);
        fim.setTime(data2);
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        return (int) (((dt2 - dt1) / 86400000) + 1);
    }
}

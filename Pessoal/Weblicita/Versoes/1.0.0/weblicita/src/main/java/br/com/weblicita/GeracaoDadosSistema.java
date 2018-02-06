package br.com.weblicita;

import br.com.weblicita.dao.DAO;
import br.com.weblicita.modelo.cadastro.Cidade;
import br.com.weblicita.modelo.cadastro.Estado;
import br.com.weblicita.modelo.cadastro.Pais;
import br.com.weblicita.modelo.controleacesso.*;
import br.com.weblicita.modelo.vos.CidadeVO;
import br.com.weblicita.modelo.vos.EstadoVO;
import br.com.weblicita.modelo.vos.PaisVO;
import com.xpert.persistence.dao.BaseDAO;
import com.xpert.persistence.query.Restrictions;
import com.xpert.utils.Encryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Classe para geracao inicial dos dados do sistema, como perfil ADMINISTRADOR
 * usuario ADMIN, e outros
 *
 * @author Ayslan
 */
@Stateless
public class GeracaoDadosSistema {
    
    private static final Logger logger = Logger.getLogger(GeracaoDadosSistema.class.getName());
    @EJB
    private DAO dao;
    @EJB
    private GeracaoPermissao geracaoPermissao;
    @EJB
    private GeracaoModeloEmail geracaoModeloEmail;
    
    public <T> BaseDAO<T> getDAO(Class<T> entity) {
        return dao.getDAO(entity);
    }
    
    public void generate() {
        
        try {
            //gerar modelos de email
            geracaoModeloEmail.generate();
            //gerar permissões
            geracaoPermissao.generate();

            //gerar perfil ADMIN
            Perfil perfil = getDAO(Perfil.class).unique("descricao", "ADMINISTRADOR");
            if (perfil == null) {
                perfil = new Perfil();
                perfil.setDescricao("ADMINISTRADOR");
                perfil.setAtivo(true);
            }

            //adicionar todas as permissoes para o admin
            perfil.setPermissoes(getDAO(Permissao.class).listAll());
            if (perfil.getId() == null) {
                BaseDAO<Permissao> permissaoDAO = getDAO(Permissao.class);
                List<Permissao> atalhos = new ArrayList<Permissao>();
                //permissoes padrao para o perfil ADMIN
                atalhos.add(permissaoDAO.unique("key", "usuario.list"));
                atalhos.add(permissaoDAO.unique("key", "usuario.create"));
                atalhos.add(permissaoDAO.unique("key", "acessoSistema.list"));
                atalhos.add(permissaoDAO.unique("key", "usuario.alterarSenha"));
                atalhos.add(permissaoDAO.unique("key", "erroSistema.list"));
                atalhos.add(permissaoDAO.unique("key", "perfil.list"));
                perfil.setPermissoesAtalho(atalhos);
            }
            getDAO(Perfil.class).saveOrMerge(perfil, false);

            //criar usuario ADMIN
            Usuario usuario = getDAO(Usuario.class).unique("userLogin", "ADMIN");

            //se nao encontrou, criar um novo
            if (usuario == null) {
                //usuario
                usuario = new Usuario();
                usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
                usuario.setMatricula("123");
                usuario.setRg("123");
                usuario.setCpf("12345678909");
                usuario.setEmail("admin@xpertsistemas.com.br");
                usuario.setNome("ADMINISTRADOR DO SISTEMA");
                List<Perfil> perfis = new ArrayList<Perfil>();
                perfis.add(perfil);
                usuario.setPerfis(perfis);
                usuario.setUserLogin("ADMIN");

                //definir senha "1" para o usuario
                try {
                    usuario.setUserPassword(Encryption.getSHA256("1"));
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
                usuario.setSuperUsuario(true);
                getDAO(Usuario.class).saveOrMerge(usuario, false);

                //historico como ativo
                HistoricoSituacaoUsuario historicoSituacaoUsuario = new HistoricoSituacaoUsuario();
                historicoSituacaoUsuario.setDataSituacao(new Date());
                historicoSituacaoUsuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
                historicoSituacaoUsuario.setUsuario(usuario);
                getDAO(HistoricoSituacaoUsuario.class).saveOrMerge(historicoSituacaoUsuario, false);
                
            }
            
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            
            FileInputStream arquivo = new FileInputStream(new File(
                    servletContext.getRealPath("/WEB-INF/docs/CEP_IBGE.xls")));
            
            List<PaisVO> paises = new ArrayList<PaisVO>();
            List<EstadoVO> estados = new ArrayList<EstadoVO>();
            List<CidadeVO> cidades = new ArrayList<CidadeVO>();
            
            HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
            
            HSSFSheet sheetPais = workbook.getSheetAt(0);
            
            HSSFSheet sheetEstado = workbook.getSheetAt(1);
            
            HSSFSheet sheetCidade = workbook.getSheetAt(2);

            //Sheet Paises
            Iterator<Row> rowIterator = sheetPais.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                PaisVO pais = new PaisVO();
                paises.add(pais);
                
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            pais.setCodigo(String.valueOf(cell.getNumericCellValue()).replace(".0", ""));
                            break;
                        case 1:
                            pais.setNome(cell.getStringCellValue());
                            break;
                        case 2:
                            pais.setSigla(cell.getStringCellValue());
                            break;
                    }
                }
            }

            //Sheet Estados
            rowIterator = sheetEstado.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                EstadoVO estado = new EstadoVO();
                estados.add(estado);
                
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            estado.setCodigo(String.valueOf(cell.getNumericCellValue()).replace(".0", ""));
                            break;
                        case 1:
                            estado.setNome(cell.getStringCellValue());
                            break;
                        case 2:
                            estado.setSigla(cell.getStringCellValue());
                            break;
                        case 3:
                            estado.setPais(cell.getStringCellValue());
                            break;
                    }
                }
            }

            //Sheet Cidades
            rowIterator = sheetCidade.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                CidadeVO cidade = new CidadeVO();
                cidades.add(cidade);
                
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            cidade.setEstado(cell.getStringCellValue());
                            break;
                        case 1:
                            cidade.setCodigo(String.valueOf(cell.getNumericCellValue()).replace(".0", ""));
                            break;
                        case 2:
                            cidade.setNome(cell.getStringCellValue());
                            break;
                    }
                }
            }
            
            for (PaisVO paisTemp : paises) {
                Restrictions restrictions = new Restrictions();
                restrictions.equals("UPPER(nome)", paisTemp.getNome().toUpperCase());
                Pais pais = getDAO(Pais.class).unique(restrictions);
                
                if (pais == null) {
                    pais = new Pais();
                    pais.setCodigo(paisTemp.getCodigo());
                    pais.setNome(paisTemp.getNome());
                    pais.setSigla(paisTemp.getSigla());
                    getDAO(Pais.class).saveOrMerge(pais);
                }
                
            }
            
            for (EstadoVO estadoTemp : estados) {
                Restrictions restrictions = new Restrictions();
                restrictions.equals("UPPER(nome)", estadoTemp.getPais().toUpperCase());
                Pais pais = getDAO(Pais.class).unique(restrictions);
                
                if (pais != null) {
                    restrictions = new Restrictions();
                    restrictions.equals("UPPER(nome)", estadoTemp.getNome().toUpperCase());
                    restrictions.add("pais", pais);
                    
                    Estado estado = getDAO(Estado.class).unique(restrictions);
                    
                    if (estado == null) {
                        estado = new Estado();
                        estado.setNome(estadoTemp.getNome());
                        estado.setCodigo(estadoTemp.getCodigo());
                        estado.setSigla(estadoTemp.getSigla());
                        estado.setPais(pais);
                        
                        getDAO(Estado.class).saveOrMerge(estado);
                    }
                }
            }
            
            for (CidadeVO cidadeTemp : cidades) {
                Restrictions restrictions = new Restrictions();
                restrictions.equals("UPPER(nome)", cidadeTemp.getEstado().toUpperCase());
                Estado estado = getDAO(Estado.class).unique(restrictions);
                
                if (estado != null) {
                    restrictions = new Restrictions();
                    restrictions.equals("UPPER(nome)", cidadeTemp.getNome().toUpperCase());
                    
                    Cidade cidade = getDAO(Cidade.class).unique(restrictions);
                    
                    if (cidade == null) {
                        cidade = new Cidade();
                        cidade.setNome(cidadeTemp.getNome());
                        cidade.setCodigo(cidadeTemp.getCodigo());
                        cidade.setEstado(estado);
                        
                        getDAO(Cidade.class).saveOrMerge(cidade);
                    }
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
    }
    
}

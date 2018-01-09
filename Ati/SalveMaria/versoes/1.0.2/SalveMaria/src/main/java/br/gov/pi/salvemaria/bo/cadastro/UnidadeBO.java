package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.UnidadeDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.CircunscricaoBairro;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.enums.TipoUnidade;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeBO extends AbstractBusinessObject<Unidade> {

    @EJB
    private UnidadeDAO unidadeDAO;

    @EJB
    private CircunscricaoBO circuPorCidadeBO;

    @EJB
    private Circunscricao_BairroBO circuPorBairroBO;

    @EJB
    private BairroBO bairroBO;

    @Override
    public UnidadeDAO getDAO() {
        return unidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "sigla");
    }

    @Override
    public void validate(Unidade unidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Unidade unidadePeloBairro(Bairro bairro, TipoDenuncia tipo, Integer idadeVitima, Integer idadeAgressor) {

        Restrictions restrictions = new Restrictions();

        if (bairro == null) {
            return null;
        }

        Cidade cidade = unidadeDAO.getInitialized(bairro.getCidade());

        List<Circunscricao> areasCidade = getDAO().getInitialized(cidade.getCircunscricoes());

        List<CircunscricaoBairro> areasDoBairro = getDAO().getInitialized(bairro.getCircunscricoes());

        if (areasDoBairro != null) {
            if (areasDoBairro.size() > 0) {
                restrictions.in("circunscricaoBairro", areasDoBairro);
            }
        }

        restrictions.in("circunscricao", areasCidade);

        if (tipo == TipoDenuncia.DENUNCIA) {
            restrictions.startGroup().add("unidade.tipo", TipoUnidade.DDDM).or().add("unidade.tipo", TipoUnidade.DSPI).
                    or().add("unidade.tipo", TipoUnidade.DPCA).or().add("unidade.tipo", TipoUnidade.DRPC).endGroup();
        } else {
            restrictions.add("unidade.tipo", TipoUnidade.BPM);
        }

        List<Unidade> unidades = getDAO().getQueryBuilder().from(Unidade.class, "unidade")
                .leftJoinFetch("unidade.circunscricao", "circunscricao")
                .leftJoinFetch("unidade.circunscricaoBairro", "circunscricaoBairro")
                .add(restrictions).getResultList();

        Collections.sort(unidades, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Unidade u1 = (Unidade) o1;
                Unidade u2 = (Unidade) o2;

                return u1.getTipo().getNum() < u2.getTipo().getNum() ? +1 : (u1.getTipo().getNum() > u2.getTipo().getNum() ? -1 : 0);
            }
        });

        for (Unidade unidade1 : unidades) {
            if (tipo == TipoDenuncia.DENUNCIA) {
                if (idadeAgressor == null && idadeVitima == null) {
                    if (unidade1.getTipo() == TipoUnidade.DDDM) {
                        return unidade1;
                    } else {
                        if (unidade1.getTipo() == TipoUnidade.DRPC) {
                            return unidade1;
                        }
                    }
                } else {
                    if (idadeAgressor != null) {
                        if (idadeAgressor < 18) {
                            if (unidade1.getTipo() == TipoUnidade.DSPM) {
                                return unidade1;
                            } else {
                                if (idadeVitima == null) {
                                    if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                        return unidade1;
                                    } else {
                                        if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                            return unidade1;
                                        }
                                    }
                                } else {
                                    if (idadeVitima >= 60) {
                                        if (unidade1.getTipo() == TipoUnidade.DSPI) {
                                            return unidade1;
                                        } else {
                                            if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                                return unidade1;
                                            } else {
                                                if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                                    return unidade1;
                                                }
                                            }
                                        }
                                    }
                                    if (idadeVitima < 18) {
                                        if (unidade1.getTipo() == TipoUnidade.DPCA) {
                                            return unidade1;
                                        } else {
                                            if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                                return unidade1;
                                            } else {
                                                if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                                    return unidade1;
                                                }
                                            }
                                        }
                                    }

                                    if (idadeVitima >= 18 && idadeVitima < 60) {
                                        if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                            return unidade1;
                                        } else {
                                            if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                                return unidade1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (idadeVitima == null) {
                            if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                return unidade1;
                            } else {
                                if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                    return unidade1;
                                }
                            }
                        } else {
                            if (idadeVitima >= 60) {
                                if (unidade1.getTipo() == TipoUnidade.DSPI) {
                                    return unidade1;
                                } else {
                                    if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                        return unidade1;
                                    } else {
                                        if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                            return unidade1;
                                        }
                                    }
                                }
                            }
                            if (idadeVitima < 18) {
                                if (unidade1.getTipo() == TipoUnidade.DPCA) {
                                    return unidade1;
                                } else {
                                    if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                        return unidade1;
                                    } else {
                                        if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                            return unidade1;
                                        }
                                    }
                                }
                            }

                            if (idadeVitima >= 18 && idadeVitima < 60) {
                                if (unidade1.getTipo() == TipoUnidade.DDDM) {
                                    return unidade1;
                                } else {
                                    if (unidade1.getTipo() == TipoUnidade.DRPC) {
                                        return unidade1;
                                    }
                                }
                            }
                        }

                    }
                }
            } else {
                if (unidade1.getTipo() == TipoUnidade.BPM) {
                    return unidade1;
                }

            }
        }

        return null;
    }
}

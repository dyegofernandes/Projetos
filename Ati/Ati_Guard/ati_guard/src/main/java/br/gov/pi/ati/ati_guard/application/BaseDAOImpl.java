package br.gov.pi.ati.ati_guard.application;

import br.gov.pi.ati.ati_guard.constante.Constantes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ayslan
 * @param <T>
 */
public class BaseDAOImpl<T> extends com.xpert.persistence.dao.BaseDAOImpl<T> {

    @PersistenceContext(unitName=Constantes.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public BaseDAOImpl() {
    }

    public BaseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}

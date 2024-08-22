/**
 *
 * @author Diego
 */

package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class GenericDAO<T> {

    @PersistenceContext(unitName = "CadastroProdutosPU")
    protected EntityManager em;

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public void save(T entity) {
        em.persist(entity);
    }

    @Transactional
    public void update(T entity) {
        em.merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    public T findById(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }
}

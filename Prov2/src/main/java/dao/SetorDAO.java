/**
 *
 * @author Diego
 */
package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Setor;

import java.util.List;

@RequestScoped
public class SetorDAO {

    @Inject
    private EntityManager em;

    @Transactional
    public void save(Setor setor) {
        em.persist(setor);
    }

    @Transactional
    public void update(Setor setor) {
        em.merge(setor);
    }

    @Transactional
    public void delete(Setor setor) {
        em.remove(em.merge(setor));
    }

    public Setor findById(Long id) {
        return em.find(Setor.class, id);
    }

    public List<Setor> findAll() {
        return em.createQuery("SELECT s FROM Setor s", Setor.class).getResultList();
    }
    
    public Setor find(Long id) {
        return em.find(Setor.class, id);
    }
    
    public void create(Setor setor) {
        em.persist(setor);
    }

}

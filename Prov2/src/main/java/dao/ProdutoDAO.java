/**
 *
 * @author Diego
 */

package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Produto;

import java.util.List;

@RequestScoped
public class ProdutoDAO {

    @Inject
    private EntityManager em;

    @Transactional
    public void save(Produto produto) {
        em.persist(produto);
    }

    @Transactional
    public void update(Produto produto) {
        em.merge(produto);
    }

    @Transactional
    public void delete(Produto produto) {
        em.remove(em.merge(produto));
    }

    
    public List<Produto> findAll() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }


}

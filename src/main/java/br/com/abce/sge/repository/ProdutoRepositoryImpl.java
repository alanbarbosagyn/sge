package br.com.abce.sge.repository;

import br.com.abce.sge.entity.ProdutoEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext(unitName = "sge")
    private EntityManager entityManager;

    public ProdutoRepositoryImpl () {
        super();
    }

    public ProdutoEntity buscar(final Long idProduto) {

        return entityManager.find(ProdutoEntity.class, idProduto);
    }

    public void salvar(final ProdutoEntity produto) {

        entityManager.merge(produto);
    }

    public void remover(final ProdutoEntity produto) {

        entityManager.remove(produto);
    }

    @Override
    public List<ProdutoEntity> listar() {

        return entityManager
                .createQuery("select p from ProdutoEntity p")
                .getResultList();
    }
}

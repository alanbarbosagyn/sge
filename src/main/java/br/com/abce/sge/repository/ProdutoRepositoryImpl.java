package br.com.abce.sge.repository;

import br.com.abce.sge.entity.Produto;

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

    public Produto buscar(final Long idProduto) {

        return entityManager.find(Produto.class, idProduto);
    }

    public void salvar(final Produto produto) {

        entityManager.merge(produto);
    }

    public void remover(final Produto produto) {

        entityManager.remove(produto);
    }

    @Override
    public List<Produto> listar() {

        return entityManager
                .createQuery("select p from Produto p")
                .getResultList();
    }
}

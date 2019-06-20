package br.com.abce.sge.repository.impl;

import br.com.abce.sge.repository.SgeManageFactory;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericRepository<T> extends SgeManageFactory {

    private Class<T> classe;

    public GenericRepository(Class<T> classe) {
        this.classe = classe;
    }

    public T buscar(final Long idEntity) {

        return getEntityManager().find(classe, idEntity);
    }

    public void salvar(final T objeto) {

        getEntityManager().merge(objeto);
    }

    public void remover(final Long idEntity) {

        EntityManager entityManager = getEntityManager();

        T entity = entityManager.getReference(classe, idEntity);

        entityManager.remove(entity);
    }

    public List<T> listar() {
        return getEntityManager()
                .createQuery("from " + classe.getName())
                .getResultList();
    }

}

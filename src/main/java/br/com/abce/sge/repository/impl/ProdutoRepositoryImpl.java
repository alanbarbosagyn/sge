package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.ProdutoEntity;
import br.com.abce.sge.repository.ProdutoRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class ProdutoRepositoryImpl extends GenericRepository<ProdutoEntity> implements ProdutoRepository {

    public ProdutoRepositoryImpl() {
        super(ProdutoEntity.class);
    }


}

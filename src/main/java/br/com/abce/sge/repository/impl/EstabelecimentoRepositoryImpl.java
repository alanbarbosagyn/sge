package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.EstabelecimentoEntity;
import br.com.abce.sge.repository.EstabelecimentoRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class EstabelecimentoRepositoryImpl extends GenericRepository<EstabelecimentoEntity>
        implements EstabelecimentoRepository {

    public EstabelecimentoRepositoryImpl() {
        super(EstabelecimentoEntity.class);
    }
}

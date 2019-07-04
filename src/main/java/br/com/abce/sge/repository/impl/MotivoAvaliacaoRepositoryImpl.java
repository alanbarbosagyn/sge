package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.AvaliacaoMotivoEntity;
import br.com.abce.sge.repository.MotivoAvaliacaoRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by alan-bs on jul, 2019
 */
@Local
@Stateless
public class MotivoAvaliacaoRepositoryImpl extends GenericRepository<AvaliacaoMotivoEntity> implements MotivoAvaliacaoRepository {

    public MotivoAvaliacaoRepositoryImpl() {
        super(AvaliacaoMotivoEntity.class);
    }
}

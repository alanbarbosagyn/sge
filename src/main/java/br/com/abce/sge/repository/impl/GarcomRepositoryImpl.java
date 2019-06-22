package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.GarcomEntity;
import br.com.abce.sge.repository.GarcomRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local
@Stateless
public class GarcomRepositoryImpl extends GenericRepository<GarcomEntity> implements GarcomRepository {

    public GarcomRepositoryImpl() {
        super(GarcomEntity.class);
    }

    @Override
    public List<GarcomEntity> listar(final Long idEstabelecimento) {
        return getEntityManager()
                .createQuery("from GarcomEntity where estabelecimentoByEstabelecimentoId.id = :idEstabelecimento")
                .setParameter("idEstabelecimento", idEstabelecimento)
                .getResultList();
    }
}

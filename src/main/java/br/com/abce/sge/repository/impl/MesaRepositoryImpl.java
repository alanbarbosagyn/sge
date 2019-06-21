package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.MesaEntity;
import br.com.abce.sge.repository.MesaRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local
@Stateless
public class MesaRepositoryImpl extends GenericRepository<MesaEntity> implements MesaRepository {

    public MesaRepositoryImpl() {
        super(MesaEntity.class);
    }

    @Override
    public List<MesaEntity> listar(Long idEstabelecimento) {
        return getEntityManager()
                .createQuery("from MesaEntity where estabelecimentoByEstabelecimentoId.id = :idEstabelecimento")
                .setParameter("idEstabelecimento", idEstabelecimento)
                .getResultList();
    }

    @Override
    public MesaEntity buscar(String identMesa) {
        return (MesaEntity) getEntityManager()
                .createQuery("from MesaEntity where qrcode = :qrcode")
                .setParameter("qrcode", identMesa)
                .getSingleResult();
    }
}

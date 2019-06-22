package br.com.abce.sge.repository.impl;

import br.com.abce.sge.entity.UsuarioEntity;
import br.com.abce.sge.repository.UsuarioRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class UsuarioRepositoryImpl extends GenericRepository<UsuarioEntity> implements UsuarioRepository {

    public UsuarioRepositoryImpl() {
        super(UsuarioEntity.class);
    }
}

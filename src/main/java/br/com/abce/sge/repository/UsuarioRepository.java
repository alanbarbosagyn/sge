package br.com.abce.sge.repository;

import br.com.abce.sge.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository {

    void salvar(final UsuarioEntity entity);

    List<UsuarioEntity> listar();

    void remover(final Long id);

    UsuarioEntity buscar(final Long idUsuario);
}

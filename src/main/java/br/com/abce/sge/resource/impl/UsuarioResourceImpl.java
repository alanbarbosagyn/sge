package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.UsuarioResource;
import br.com.abce.sge.servico.UsuarioService;

import javax.ejb.EJB;
import java.util.List;

public class UsuarioResourceImpl implements UsuarioResource {

    @EJB
    private UsuarioService usuarioService;

    @Override
    public List<UsuarioDto> listarUsuarios() throws RecursoNaoEncontradoException {

        final List<UsuarioDto> listaUsuario = usuarioService.listar();

        if (listaUsuario == null || listaUsuario.isEmpty())

            throw new RecursoNaoEncontradoException("Sem usuários cadastrados");

        return listaUsuario;

    }

    @Override
    public UsuarioDto getUsuario(final Long idUsuario) throws ValidacaoException, RecursoNaoEncontradoException {

        final UsuarioDto usuarioDto = usuarioService.buscar(idUsuario);

        if (usuarioDto == null)

            throw new RecursoNaoEncontradoException("Usuário não cadastrado.");

        return usuarioDto;

    }

    @Override
    public void removeUsuario(final Long idUsuario) throws ValidacaoException, RecursoNaoEncontradoException {

        UsuarioDto usuarioDto = usuarioService.buscar(idUsuario);

        if (usuarioDto == null)

            throw new RecursoNaoEncontradoException("Usuário não cadastrado.");

        usuarioService.remover(usuarioDto);


    }

    @Override
    public void inserirUsuario(final UsuarioDto usuarioDto) throws ValidacaoException {

        usuarioService.salvar(usuarioDto);
    }
}

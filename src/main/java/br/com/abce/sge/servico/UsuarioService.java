package br.com.abce.sge.servico;

import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface UsuarioService {

    void salvar(UsuarioDto usuario) throws ValidacaoException;

    List<UsuarioDto> listar();

    void remover(UsuarioDto usuario) throws ValidacaoException;

    UsuarioDto buscar( final Long idUsuario) throws ValidacaoException;
}

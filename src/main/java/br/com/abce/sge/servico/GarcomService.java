package br.com.abce.sge.servico;

import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface GarcomService {

    void salvar(final GarcomDto garcom) throws ValidacaoException;

    List<GarcomDto> listar(final Long idEstabelecimento) throws ValidacaoException;

    void remover(final GarcomDto garcom) throws ValidacaoException;

    GarcomDto buscar(final Long idGarcom) throws ValidacaoException;
}

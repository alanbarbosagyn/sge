package br.com.abce.sge.servico;

import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface GarcomService {

    void salvar(GarcomDto garcom) throws ValidacaoException;

    List<GarcomDto> listar(Long idEstabelecimento) throws ValidacaoException;

    void remover(GarcomDto garcom) throws ValidacaoException;
}

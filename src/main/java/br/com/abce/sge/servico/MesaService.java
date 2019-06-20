package br.com.abce.sge.servico;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface MesaService {

    List<MesaDto> listar(Long idEstabelecimento) throws ValidacaoException;

    MesaDto buscar(Long idMesa) throws ValidacaoException;

    MesaDto buscarPorIdent(String identMesa) throws ValidacaoException;
}

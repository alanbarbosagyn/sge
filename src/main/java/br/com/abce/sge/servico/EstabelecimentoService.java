package br.com.abce.sge.servico;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface EstabelecimentoService {

    void salvar(EstabelecimentoDto estabelecimento) throws ValidacaoException;

    List<EstabelecimentoDto> listar();

    void remover(EstabelecimentoDto estabelecimento) throws ValidacaoException;

    EstabelecimentoDto buscar(Long idEstabelecimento) throws ValidacaoException;
}

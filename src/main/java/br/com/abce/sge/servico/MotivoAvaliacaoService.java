package br.com.abce.sge.servico;

import br.com.abce.sge.dto.MotivoAvaliacaoDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */
public interface MotivoAvaliacaoService {

    List<MotivoAvaliacaoDto> listar();

    MotivoAvaliacaoDto buscar(Long idMotivoAvaliacao) throws ValidacaoException;

    void salvar(MotivoAvaliacaoDto itemAvaliacao) throws ValidacaoException;
}

package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.EstabelecimentoResource;
import br.com.abce.sge.servico.EstabelecimentoService;

import javax.ejb.EJB;

public class EstabelecimentoResourceImpl implements EstabelecimentoResource {

    @EJB
    private EstabelecimentoService estabelecimentoService;

    @Override
    public EstabelecimentoDto getEstabelecimento(final Long idEstabelecimento) throws ValidacaoException, RecursoNaoEncontradoException {

        final EstabelecimentoDto estabelecimentoDto = estabelecimentoService.buscar(idEstabelecimento);

        if (estabelecimentoDto == null)

            throw new RecursoNaoEncontradoException("Estabelecimento não cadastrado.");

        return estabelecimentoDto;
    }
}

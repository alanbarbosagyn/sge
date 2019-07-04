package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.MotivoAvaliacaoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.MotivoAvaliacaoResource;
import br.com.abce.sge.servico.MotivoAvaliacaoService;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */
public class MotivoAvaliacaoResourceImpl implements MotivoAvaliacaoResource {

    @EJB
    private MotivoAvaliacaoService service;

    @Override
    public List<MotivoAvaliacaoDto> listarMotivosAvaliacao() throws RecursoNaoEncontradoException {

        final List<MotivoAvaliacaoDto> lista = service.listar();

        if (lista.isEmpty())

            throw new RecursoNaoEncontradoException("Motivos de avaliação não cadastrado.");

        return lista;
    }

    @Override
    public MotivoAvaliacaoDto getMotivoAvaliacao(final Long idMotivoAvaliacao) throws ValidacaoException, RecursoNaoEncontradoException {

        final MotivoAvaliacaoDto motivoAvaliacaoDto = service.buscar(idMotivoAvaliacao);

        if (motivoAvaliacaoDto == null)

            throw new RecursoNaoEncontradoException("Motivo de avaliação não cadastrado.");

        return motivoAvaliacaoDto;
    }
}

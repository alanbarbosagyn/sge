package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.GarcomResource;
import br.com.abce.sge.servico.GarcomService;

import javax.ejb.EJB;
import java.util.List;

public class GarcomResourceImpl implements GarcomResource {

    @EJB
    private GarcomService garcomService;

    @Override
    public GarcomDto getGarcom(final Long idGarcom) throws ValidacaoException, RecursoNaoEncontradoException {

        final GarcomDto garcomDto = garcomService.buscar(idGarcom);

        if (garcomDto == null)

            throw new RecursoNaoEncontradoException("Garcom não cadastrado.");

        return garcomDto;
    }

    @Override
    public List<GarcomDto> getGarcomPorEstabelecimento(final Long idEstabelecimento) throws ValidacaoException, RecursoNaoEncontradoException {

        final List<GarcomDto> listaGarcom = garcomService.listar(idEstabelecimento);

        if (listaGarcom == null || listaGarcom.isEmpty())

            throw new RecursoNaoEncontradoException("Garcom(s) não cadastrado no estabelecimento");

        return listaGarcom;

    }
}

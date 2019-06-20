package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.MesaResource;
import br.com.abce.sge.servico.MesaService;

import javax.ejb.EJB;
import java.util.List;

public class MesaResourceImpl implements MesaResource {

    @EJB
    private MesaService mesaService;


    @Override
    public List<MesaDto> listarMesas(Long idEstabelecimento) throws RecursoNaoEncontradoException, ValidacaoException {

        final List<MesaDto> listaMesas = mesaService.listar(idEstabelecimento);

        if(listaMesas == null || listaMesas.isEmpty())

            throw new RecursoNaoEncontradoException("Não há mesas cadastradas no estabelecimento.");

        return listaMesas;
    }

    @Override
    public MesaDto getMesa(Long idMesa) throws ValidacaoException, RecursoNaoEncontradoException {

        final MesaDto mesaDto = mesaService.buscar(idMesa);

        if(mesaDto == null)

            throw new RecursoNaoEncontradoException("Mesa não cadastrada.");

        return mesaDto;
    }

    @Override
    public MesaDto getMesaPorIdentif(String identMesa) throws ValidacaoException, RecursoNaoEncontradoException {

        final MesaDto mesaDto = mesaService.buscarPorIdent(identMesa);

        if(mesaDto == null)

            throw new RecursoNaoEncontradoException("Mesa não cadastrada.");

        return mesaDto;

    }


}

package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.MotivoAvaliacaoDto;
import br.com.abce.sge.entity.AvaliacaoMotivoEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.MotivoAvaliacaoRepository;
import br.com.abce.sge.servico.MotivoAvaliacaoService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */

@Stateless
@Local
public class MotivoAvaliacaoServiceImpl implements MotivoAvaliacaoService {

    @EJB
    private MotivoAvaliacaoRepository repository;

    @Override
    public List<MotivoAvaliacaoDto> listar() {

        final List<AvaliacaoMotivoEntity> listaItens = repository.listar();

        List<MotivoAvaliacaoDto> listaItensAvaliacao = new ArrayList<>();

        for (AvaliacaoMotivoEntity motivo : listaItens) {

            MotivoAvaliacaoDto motivoAvaliacaoDto = getMotivoAvaliacaoDto(motivo);

            listaItensAvaliacao.add(motivoAvaliacaoDto);
        }

        return listaItensAvaliacao;
    }

    @Override
    public MotivoAvaliacaoDto buscar(final Long idMotivoAvaliacao) throws ValidacaoException {

        if (idMotivoAvaliacao == null || idMotivoAvaliacao == 0L)

            throw new ValidacaoException("Id do motivo avaliação não informado.");

        final AvaliacaoMotivoEntity avaliacaoMotivoEntity = repository.buscar(idMotivoAvaliacao);

        MotivoAvaliacaoDto motivoAvaliacao = null;

        if (avaliacaoMotivoEntity != null) {

            motivoAvaliacao = getMotivoAvaliacaoDto(avaliacaoMotivoEntity);

        }

        return motivoAvaliacao;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(final MotivoAvaliacaoDto itemAvaliacao) throws ValidacaoException {

        if (StringUtils.isBlank(itemAvaliacao.getMotivo()))

            throw new ValidacaoException("Motivo do item de avaliação não informada.");

        if (itemAvaliacao.getMotivo().length() > 100)

            throw new ValidacaoException("Motivo do item de avaliação com tamanho inválido.");

        if (StringUtils.isBlank(itemAvaliacao.getTipo()))

            throw new ValidacaoException("Tipo do item de avaliação não informada.");

        if (itemAvaliacao.getTipo().length() > 10)

            throw new ValidacaoException("Tipo do item de avaliação com tamanho inválido.");


        AvaliacaoMotivoEntity entity = new AvaliacaoMotivoEntity();
        entity.setMotivo(itemAvaliacao.getMotivo());
        entity.setTipo(itemAvaliacao.getTipo());

        repository.salvar(entity);
    }

    private MotivoAvaliacaoDto getMotivoAvaliacaoDto(AvaliacaoMotivoEntity motivo) {

        MotivoAvaliacaoDto motivoAvaliacaoDto = new MotivoAvaliacaoDto();

        motivoAvaliacaoDto.setId(motivo.getId());
        motivoAvaliacaoDto.setMotivo(motivo.getMotivo());
        motivoAvaliacaoDto.setTipo(motivo.getTipo());

        return motivoAvaliacaoDto;
    }
}

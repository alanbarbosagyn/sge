package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.entity.EstabelecimentoEntity;
import br.com.abce.sge.entity.MesaEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.EstabelecimentoRepository;
import br.com.abce.sge.repository.MesaRepository;
import br.com.abce.sge.servico.MesaService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class MesaServiceImpl implements MesaService {

    @EJB
    private MesaRepository mesaRepository;

    @EJB
    private EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public List<MesaDto> listar(final Long idEstabelecimento) throws ValidacaoException {

        if (idEstabelecimento == null || idEstabelecimento == 0L)

            throw new ValidacaoException("Id do estabelecimento não informado.");


        final List<MesaEntity> listaMesas = mesaRepository.listar(idEstabelecimento);

        List<MesaDto> listaMesaDto = new ArrayList<>();

        for (MesaEntity mesa : listaMesas) {
            MesaDto mesaDto = getMesaDto(mesa);
            listaMesaDto.add(mesaDto);
        }


        return listaMesaDto;
    }

    @Override
    public MesaDto buscar(final Long idMesa) throws ValidacaoException {

        MesaDto mesaDto = null;

        if (idMesa == null || idMesa == 0L)

            throw new ValidacaoException("Id da mesa não informado.");

        final MesaEntity mesaEntity = mesaRepository.buscar(idMesa);

        if (mesaEntity != null) {
            mesaDto = getMesaDto(mesaEntity);
        }

        return mesaDto;
    }

    @Override
    public MesaDto buscarPorIdent(final String identMesa) throws ValidacaoException {

        MesaDto mesaDto = null;

        if (StringUtils.isBlank(identMesa))

            throw new ValidacaoException("Identificador da mesa não informado.");

        final MesaEntity mesaEntity = mesaRepository.buscar(identMesa);

        if (mesaEntity != null) {
            mesaDto = getMesaDto(mesaEntity);
        }

        return mesaDto;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(MesaDto mesa) throws ValidacaoException {

        if (mesa.getCapacidade() == 0)
            throw new ValidacaoException("Capacidade da mesa não informada.");

        if (mesa.getIdEstabelecimento() == null || mesa.getIdEstabelecimento() == 0L)
            throw new ValidacaoException("Estabelecimento não informado.");

        if (mesa.getNumero() == 0)
            throw new ValidacaoException("Número da mesa não informado.");

        final EstabelecimentoEntity estabelecimento = estabelecimentoRepository
                .buscar(mesa.getIdEstabelecimento());

        if (estabelecimento == null)
            throw new ValidacaoException("Estabelecimento da mesa não encontrato.");

        MesaEntity entity = new MesaEntity();
        entity.setCapacidade(mesa.getCapacidade());
        entity.setNumero(mesa.getNumero());
        entity.setEstabelecimentoByEstabelecimentoId(estabelecimento);

        mesaRepository.salvar(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(final MesaDto mesa) throws ValidacaoException {

        if (mesa == null)

            throw new ValidacaoException("Mesa não informado.");

        mesaRepository.remover(mesa.getId());

    }

    private MesaDto getMesaDto(MesaEntity mesaEntity) {
        MesaDto mesaDto;
        mesaDto = new MesaDto();
        mesaDto.setId(mesaEntity.getId());
        mesaDto.setNumero(mesaEntity.getNumero());
        mesaDto.setIdentificadorQrCode(mesaEntity.getQrcode());
        mesaDto.setIdEstabelecimento(mesaEntity.getEstabelecimentoByEstabelecimentoId().getId());
        return mesaDto;
    }
}

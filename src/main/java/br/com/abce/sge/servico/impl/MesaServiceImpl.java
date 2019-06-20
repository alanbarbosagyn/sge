package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.entity.MesaEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.MesaRepository;
import br.com.abce.sge.servico.MesaService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class MesaServiceImpl implements MesaService {

    @EJB
    private MesaRepository mesaRepository;

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

    private MesaDto getMesaDto(MesaEntity mesaEntity) {
        MesaDto mesaDto;
        mesaDto = new MesaDto();
        mesaDto.setId(mesaEntity.getId());
        mesaDto.setNumero(mesaEntity.getNumero());
        mesaDto.setIdentificadorQrCode(mesaEntity.getQrcode());
        return mesaDto;
    }
}

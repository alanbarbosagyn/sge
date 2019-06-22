package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.entity.EstabelecimentoEntity;
import br.com.abce.sge.entity.GarcomEntity;
import br.com.abce.sge.entity.UsuarioEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.EstabelecimentoRepository;
import br.com.abce.sge.repository.UsuarioRepository;
import br.com.abce.sge.repository.GarcomRepository;
import br.com.abce.sge.servico.GarcomService;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class GarcomServiceImpl implements GarcomService {

    @EJB
    private UsuarioRepository usuarioRepository;

    @EJB
    private EstabelecimentoRepository estabelecimentoRepository;

    @EJB
    private GarcomRepository garcomRepository;

    @Override
    public void salvar(final GarcomDto garcom) throws ValidacaoException {

        if (garcom == null)
            throw new ValidacaoException("Garcom não informado.");

        if (garcom.getIdEstabelecimento() == null)
            throw new ValidacaoException("Id estabelecimento não informado.");

        final EstabelecimentoEntity estabelecimentoEntity = estabelecimentoRepository
                .buscar(garcom.getIdEstabelecimento());

        if (estabelecimentoEntity == null)
            throw new ValidacaoException("Estabelecimento não encontrado.");

        if (garcom.getIdUsuario() == null)
            throw new ValidacaoException("Id usuário não informado.");

        final UsuarioEntity usuarioEntity = usuarioRepository
                .buscar(garcom.getIdUsuario());

        if (usuarioEntity == null)
            throw new ValidacaoException("Usuário não encontrado.");

        GarcomEntity entity = new GarcomEntity();
        entity.setEstabelecimentoByEstabelecimentoId(estabelecimentoEntity);
        entity.setUsuarioByUsuarioId(usuarioEntity);

        garcomRepository.salvar(entity);

    }

    @Override
    public List<GarcomDto> listar(final Long idEstabelecimento) throws ValidacaoException {

        if (idEstabelecimento == null || idEstabelecimento == 0L)
            throw new ValidacaoException("Id do estabelecimento não informado.");

        List<GarcomDto> listaGarcom = new ArrayList<>();

        final List<GarcomEntity> listaEntity = garcomRepository.listar(idEstabelecimento);

        for (GarcomEntity entity : listaEntity) {

            GarcomDto garcomDto = new GarcomDto();

            EstabelecimentoEntity estabelecimento = entity.getEstabelecimentoByEstabelecimentoId();
            garcomDto.setEstabelecimento(estabelecimento.getNome());
            garcomDto.setIdEstabelecimento(estabelecimento.getId());
            garcomDto.setNome(entity.getUsuarioByUsuarioId().getNome());
            garcomDto.setIdUsuario(entity.getUsuarioByUsuarioId().getId());
            garcomDto.setId(entity.getId());

            listaGarcom.add(garcomDto);
        }


        return listaGarcom;
    }

    @Override
    public void remover(GarcomDto garcom) throws ValidacaoException {

        if (garcom == null)
            throw new ValidacaoException("Garcom não informado.");

        garcomRepository.remover(garcom.getId());

    }
}

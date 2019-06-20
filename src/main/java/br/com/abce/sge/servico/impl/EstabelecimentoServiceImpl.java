package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.entity.EstabelecimentoEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.EstabelecimentoRepository;
import br.com.abce.sge.servico.EstabelecimentoService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @EJB
    private EstabelecimentoRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(EstabelecimentoDto estabelecimento) throws ValidacaoException {

        if (StringUtils.isBlank(estabelecimento.getNome()))
            throw new ValidacaoException("Nome não informado.");

        if (StringUtils.length(estabelecimento.getNome()) > 100)
            throw new ValidacaoException("Nome permite apenas 100 caracteres.");

        if (StringUtils.isBlank(estabelecimento.getEndereco()))
            throw new ValidacaoException("Endereço não informado.");

        if (StringUtils.length(estabelecimento.getEndereco()) > 50)
            throw new ValidacaoException("Endereço permite apenas 50 caracteres.");

        if (StringUtils.isBlank(estabelecimento.getCidade()))
            throw new ValidacaoException("Cidade não informado.");

        if (StringUtils.length(estabelecimento.getCidade()) > 50)
            throw new ValidacaoException("Cidade permite apenas 50 caracteres.");

        if (StringUtils.isBlank(estabelecimento.getUf()))
            throw new ValidacaoException("UF não informado.");

        if (StringUtils.length(estabelecimento.getUf()) != 2)
            throw new ValidacaoException("UF inválido.");

        EstabelecimentoEntity entity = new EstabelecimentoEntity();
        entity.setCidade(estabelecimento.getCidade());
        entity.setEndereco(estabelecimento.getEndereco());
        entity.setNome(estabelecimento.getNome());
        entity.setUf(estabelecimento.getUf());
        entity.setId(estabelecimento.getId());

        repository.salvar(entity);

    }

    @Override
    public List<EstabelecimentoDto> listar() {

        final List<EstabelecimentoEntity> lista = repository.listar();

        List<EstabelecimentoDto> estabelecimentoDtoList = new ArrayList<>();

        for (EstabelecimentoEntity entity: lista) {

            EstabelecimentoDto estabelecimento = new EstabelecimentoDto();
            estabelecimento.setCidade(entity.getCidade());
            estabelecimento.setEndereco(entity.getEndereco());
            estabelecimento.setId(entity.getId());
            estabelecimento.setNome(entity.getNome());
            estabelecimento.setUf(entity.getUf());

            estabelecimentoDtoList.add(estabelecimento);
        }

        return estabelecimentoDtoList;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(EstabelecimentoDto estabelecimento) throws ValidacaoException {

        if (estabelecimento == null)

            throw new ValidacaoException("Estabelecimento não informado.");

        repository.remover(estabelecimento.getId());
    }
}

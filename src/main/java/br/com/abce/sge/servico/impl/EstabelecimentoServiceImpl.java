package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.entity.EnderecoEntity;
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

        if (StringUtils.isBlank(estabelecimento.getLogradouro()))
            throw new ValidacaoException("Endereço não informado.");

        if (StringUtils.length(estabelecimento.getLogradouro()) > 100)
            throw new ValidacaoException("Endereço permite apenas 100 caracteres.");

        if (StringUtils.isBlank(estabelecimento.getCidade()))
            throw new ValidacaoException("Cidade não informado.");

        if (StringUtils.length(estabelecimento.getCidade()) > 80)
            throw new ValidacaoException("Cidade permite apenas 80 caracteres.");

        if (StringUtils.isBlank(estabelecimento.getUf()))
            throw new ValidacaoException("UF não informado.");

        if (StringUtils.length(estabelecimento.getUf()) != 2)
            throw new ValidacaoException("UF inválido.");

        if (StringUtils.isBlank(estabelecimento.getCep()))
            throw new ValidacaoException("CEP não informado.");

        if (StringUtils.isBlank(estabelecimento.getBairro()))
            throw new ValidacaoException("Bairro não informado.");

        if (StringUtils.isBlank(estabelecimento.getCnpj()))
            throw new ValidacaoException("CNPJ não informado.");

        if (StringUtils.isBlank(estabelecimento.getComplemento()))
            throw new ValidacaoException("Complemento não informado.");

        EstabelecimentoEntity entity = new EstabelecimentoEntity();
        entity.setNome(estabelecimento.getNome());
        entity.setCnpj(estabelecimento.getCnpj().replaceAll("[^0-9]", ""));

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setUf(estabelecimento.getUf());
        enderecoEntity.setCidade(estabelecimento.getCidade());
        enderecoEntity.setLogradouro(estabelecimento.getLogradouro());
        enderecoEntity.setBairro(estabelecimento.getBairro());
        enderecoEntity.setCep(estabelecimento.getCep().replaceAll("[^0-9]", ""));
        enderecoEntity.setComplemento(estabelecimento.getComplemento());
        enderecoEntity.setNumero(estabelecimento.getNumero());

        entity.setEnderecoByEnderecoId(enderecoEntity);

        repository.salvar(entity);

    }

    @Override
    public List<EstabelecimentoDto> listar() {

        final List<EstabelecimentoEntity> lista = repository.listar();

        List<EstabelecimentoDto> estabelecimentoDtoList = new ArrayList<>();

        for (EstabelecimentoEntity entity: lista) {

            EstabelecimentoDto estabelecimento = new EstabelecimentoDto();
            estabelecimento.setId(entity.getId());
            estabelecimento.setNome(entity.getNome());
            estabelecimento.setUf(entity.getEnderecoByEnderecoId().getUf());
            estabelecimento.setCidade(entity.getEnderecoByEnderecoId().getCidade());
            estabelecimento.setLogradouro(entity.getEnderecoByEnderecoId().getLogradouro());
            estabelecimento.setBairro(entity.getEnderecoByEnderecoId().getBairro());
            estabelecimento.setNumero(entity.getEnderecoByEnderecoId().getNumero());
            estabelecimento.setComplemento(entity.getEnderecoByEnderecoId().getComplemento());
            estabelecimento.setCnpj(entity.getCnpj());
            estabelecimento.setCep(entity.getEnderecoByEnderecoId().getCep());

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

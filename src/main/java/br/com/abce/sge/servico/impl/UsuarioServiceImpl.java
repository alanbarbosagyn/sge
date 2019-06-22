package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.entity.ProdutoEntity;
import br.com.abce.sge.entity.UsuarioEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.UsuarioRepository;
import br.com.abce.sge.servico.UsuarioService;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class UsuarioServiceImpl implements UsuarioService {

    @EJB
    private UsuarioRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(final UsuarioDto usuario) throws ValidacaoException {

        if (StringUtils.isBlank(usuario.getEmail()))
            throw new ValidacaoException("E-mail não informado.");

        if (StringUtils.isBlank(usuario.getNome()))
            throw new ValidacaoException("Nome não informado.");

        if (StringUtils.isBlank(usuario.getUsuario()))
            throw new ValidacaoException("Usuário não informado.");

        if (StringUtils.isBlank(usuario.getSenha()))
            throw new ValidacaoException("Senha não informado.");

        if (usuario.getSenha().length() < 8)
            throw new ValidacaoException("Senha informado menor que 8 dígitos.");

        UsuarioEntity entity = new UsuarioEntity();
        entity.setUsuario(usuario.getUsuario());
        entity.setEmail(usuario.getEmail());
        entity.setNome(usuario.getNome());
        entity.setTelefone(usuario.getTelefone().replaceAll("[^0-9]", ""));
        entity.setSenha(Hashing.sha512().hashString(usuario.getSenha(), Charset.forName("UTF8")).toString());

        repository.salvar(entity);
    }

    @Override
    public List<UsuarioDto> listar() {

        List<UsuarioDto> listaUsuario = new ArrayList<>();

        final List<UsuarioEntity> listaUsuarioEntity = repository.listar();

        for (UsuarioEntity entity : listaUsuarioEntity) {

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setEmail(entity.getEmail());
            usuarioDto.setId(entity.getId());
            usuarioDto.setNome(entity.getNome());
            usuarioDto.setSenha(entity.getSenha());
            usuarioDto.setTelefone(entity.getTelefone());
            usuarioDto.setUsuario(entity.getUsuario());

            listaUsuario.add(usuarioDto);
        }

        return listaUsuario;

    }

    @Override
    public void remover(final UsuarioDto usuario) throws ValidacaoException {

        if (usuario == null)
            throw new ValidacaoException("Usuário não informado.");

        repository.remover(usuario.getId());
    }

    @Override
    public UsuarioDto buscar(final Long idUsuario) throws ValidacaoException {

        if (idUsuario == null || idUsuario == 0L)

            throw new ValidacaoException("Id do Usuário não informado.");

        UsuarioDto usuarioDto = null;

        final UsuarioEntity entity = repository.buscar(idUsuario);

        if (entity != null) {

            usuarioDto = new UsuarioDto();
            usuarioDto.setEmail(entity.getEmail());
            usuarioDto.setId(entity.getId());
            usuarioDto.setNome(entity.getNome());
            usuarioDto.setSenha(entity.getSenha());
            usuarioDto.setTelefone(entity.getTelefone());
            usuarioDto.setUsuario(entity.getUsuario());
        }

        return usuarioDto;
    }
}

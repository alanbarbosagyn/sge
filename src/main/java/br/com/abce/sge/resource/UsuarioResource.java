package br.com.abce.sge.resource;


import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/usuario")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/usuario", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de usuarios")
public interface UsuarioResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Listar Usuarios", tags = "Listar Usuarios cadastrados.")
    List<UsuarioDto> listarUsuarios() throws RecursoNaoEncontradoException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de Usuario", tags = "Consulta de Usuario pelo seu ID.")
    UsuarioDto getUsuario(@PathParam("id") @ApiParam(value = "O código de identificação do Usuario.") final Long idUsuario) throws ValidacaoException, RecursoNaoEncontradoException;

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Remover o Usuario", tags = "Remover o Usuario pelo seu ID.")
    void removeUsuario(@PathParam("id") @ApiParam(value = "O código de identificação do Usuario.") final Long idUsuario) throws ValidacaoException, RecursoNaoEncontradoException;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Cadastrar novo Usuario", tags = "Cadastrar novo Usuario.")
    void inserirUsuario(@BeanParam @ApiParam(value = "Os dados do Usuario.") final UsuarioDto usuarioDto) throws ValidacaoException;
}
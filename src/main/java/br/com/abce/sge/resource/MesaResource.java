package br.com.abce.sge.resource;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/mesa")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/mesa", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de Mesas de um Estabelecimento")
public interface MesaResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Listar mesas", tags = "Listar mesas cadastrados.")
    List<MesaDto> listarMesas(@QueryParam(value = "idEstabelecimento") final Long idEstabelecimento) throws RecursoNaoEncontradoException, ValidacaoException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de mesa", tags = "Consulta de mesa pelo seu ID.")
    MesaDto getMesa(@PathParam("id") @ApiParam(value = "O código de identificação do mesa.") final Long idMesa) throws ValidacaoException, RecursoNaoEncontradoException;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consultar mesa", tags = "Consultar mesa pelo seu identificador (qrcode).")
    MesaDto getMesaPorIdentif(@ApiParam(value = "O identificador da mesa (qrcode)") @QueryParam(value = "identMesa") final String identMesa) throws ValidacaoException, RecursoNaoEncontradoException;
}

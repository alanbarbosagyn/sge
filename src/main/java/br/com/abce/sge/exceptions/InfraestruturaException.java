package br.com.abce.sge.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InfraestruturaException extends Exception implements ExceptionMapper<InfraestruturaException> {

    public InfraestruturaException() {
        super();
    }

    public InfraestruturaException(String message) {
        super(message);
    }

    @Override
    public Response toResponse(InfraestruturaException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
    }
}

package br.com.abce.sge.resource;

import br.com.abce.sge.dto.NovaComandaDto;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;

public interface ComandaResource extends HTTPCodeRestDefinition {

    void novaComanda(final NovaComandaDto comandaDto);
}

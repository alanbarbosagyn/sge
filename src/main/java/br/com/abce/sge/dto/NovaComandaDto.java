package br.com.abce.sge.dto;

import java.io.Serializable;

public class NovaComandaDto implements Serializable {

    private Long idEstabelecimento;
    private Long idUsuario;
    private Long idMesa;

    public NovaComandaDto() {

    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }
}

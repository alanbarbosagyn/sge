package br.com.abce.sge.dto;

import java.io.Serializable;

/**
 * Created by alan-bs on jul, 2019
 */
public class MotivoAvaliacaoDto implements Serializable {

    private Long id;
    private String motivo;
    private String tipo;

    public MotivoAvaliacaoDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

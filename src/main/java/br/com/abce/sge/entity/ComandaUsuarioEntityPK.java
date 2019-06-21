package br.com.abce.sge.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class ComandaUsuarioEntityPK implements Serializable {

    private ComandaEntity comandaByComandaId;
    private UsuarioEntity usuarioByUsuarioId;

    @ManyToOne
    @JoinColumn(name = "comanda_id", referencedColumnName = "id", nullable = false)
    public ComandaEntity getComandaByComandaId() {
        return comandaByComandaId;
    }

    public void setComandaByComandaId(ComandaEntity comandaByComandaId) {
        this.comandaByComandaId = comandaByComandaId;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(UsuarioEntity usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaUsuarioEntityPK that = (ComandaUsuarioEntityPK) o;
        return Objects.equals(comandaByComandaId, that.comandaByComandaId) &&
                Objects.equals(usuarioByUsuarioId, that.usuarioByUsuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comandaByComandaId, usuarioByUsuarioId);
    }
}

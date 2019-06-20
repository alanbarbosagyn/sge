package br.com.abce.sge.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ComandaUsuarioEntityPK implements Serializable {
    private long comandaId;
    private long usuarioId;

    @Column(name = "comanda_id")
    @Id
    public long getComandaId() {
        return comandaId;
    }

    public void setComandaId(long comandaId) {
        this.comandaId = comandaId;
    }

    @Column(name = "usuario_id")
    @Id
    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaUsuarioEntityPK that = (ComandaUsuarioEntityPK) o;
        return comandaId == that.comandaId &&
                usuarioId == that.usuarioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comandaId, usuarioId);
    }
}

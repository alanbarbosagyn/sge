package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comanda_usuario", schema = "public", catalog = "sge")
@IdClass(ComandaUsuarioEntityPK.class)
public class ComandaUsuarioEntity {
    private long comandaId;
    private long usuarioId;
    private Short administrador;

    @Id
    @Column(name = "comanda_id")
    public long getComandaId() {
        return comandaId;
    }

    public void setComandaId(long comandaId) {
        this.comandaId = comandaId;
    }

    @Id
    @Column(name = "usuario_id")
    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "administrador")
    public Short getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Short administrador) {
        this.administrador = administrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaUsuarioEntity that = (ComandaUsuarioEntity) o;
        return comandaId == that.comandaId &&
                usuarioId == that.usuarioId &&
                Objects.equals(administrador, that.administrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comandaId, usuarioId, administrador);
    }
}

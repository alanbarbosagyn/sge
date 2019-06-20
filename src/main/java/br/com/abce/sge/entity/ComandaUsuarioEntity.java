package br.com.abce.sge.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "comanda_usuario", schema = "public", catalog = "sge")
public class ComandaUsuarioEntity {
    private int comandaId;
    private int usuarioId;
    private Short administrador;

    @Basic
    @Column(name = "comanda_id")
    public int getComandaId() {
        return comandaId;
    }

    public void setComandaId(int comandaId) {
        this.comandaId = comandaId;
    }

    @Basic
    @Column(name = "usuario_id")
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
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

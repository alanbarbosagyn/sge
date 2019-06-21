package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comanda_usuario", schema = "public", catalog = "sge")
public class ComandaUsuarioEntity {
    private ComandaUsuarioEntityPK comandaId;
    private Short administrador;
    private ComandaEntity comandaByComandaId;
    private UsuarioEntity usuarioByUsuarioId;

    @Id
    public ComandaUsuarioEntityPK getComandaId() {
        return comandaId;
    }

    public void setComandaId(ComandaUsuarioEntityPK comandaId) {
        this.comandaId = comandaId;
    }

    @Basic
    @Column(name = "administrador", nullable = true)
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
        return Objects.equals(comandaId, that.comandaId) &&
                Objects.equals(administrador, that.administrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comandaId, administrador);
    }

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
}

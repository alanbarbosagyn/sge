package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "garcom", schema = "public", catalog = "sge")
public class GarcomEntity {
    private long id;
    private long estabelecimentoId;
    private long usuarioId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estabelecimento_id")
    public long getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(long estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Basic
    @Column(name = "usuario_id")
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
        GarcomEntity that = (GarcomEntity) o;
        return id == that.id &&
                estabelecimentoId == that.estabelecimentoId &&
                usuarioId == that.usuarioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimentoId, usuarioId);
    }
}

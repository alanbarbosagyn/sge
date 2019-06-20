package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "garcom", schema = "public", catalog = "sge")
public class GarcomEntity {
    private int id;
    private int estabelecimentoId;
    private int usuarioId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estabelecimento_id")
    public int getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(int estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Basic
    @Column(name = "usuario_id")
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
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
